package com.example.portfolio

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var mainCard = findViewById<CardView>(R.id.bigCard)
        val profilepic = findViewById<CardView>(R.id.profilepic)
        val summary_card = findViewById<CardView>(R.id.summary_card)
        val summary_pic = findViewById<CardView>(R.id.summary_pic)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val linkedincard = findViewById<CardView>(R.id.linkedincard)
        val emailcard = findViewById<CardView>(R.id.emailcard)
        val githubcard = findViewById<CardView>(R.id.githubcard)
        val phonecard = findViewById<CardView>(R.id.callcard)
        val fpj = findViewById<CardView>(R.id.projectcard)
        val spj = findViewById<CardView>(R.id.secondprojectcard)
        val tpj = findViewById<CardView>(R.id.thirdproject)
        scrollView.isSmoothScrollingEnabled = true
        mainCard.startAnimation(scaleAnimation)
        profilepic.startAnimation(scaleAnimation)
        summary_pic.startAnimation(scaleAnimation)
        summary_card.startAnimation(scaleAnimation)

        val skillscard = (1..9).map { i ->
            findViewById<CardView>(resources.getIdentifier("skill_$i", "id", packageName))
        }

        for (i in 0..8) {
            skillscard[i].setOnClickListener {
                skillscard[i].animate().apply {
                    duration = 1000
                    rotationYBy(360f)
                }.start()
            }

        }

        emailcard.setOnClickListener{
            var intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("worknshubh@gmail.com"))
            }
            startActivity(intent)
        }
        githubcard.setOnClickListener {
            val url = "https://github.com/worknshubh"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
        linkedincard.setOnClickListener {
            val url = "https://www.linkedin.com/in/shubham-raj-75b871290/"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
        phonecard.setOnClickListener {
            val number = Uri.parse("tel:+91 9470950508")
            val intent = Intent(Intent.ACTION_DIAL,number)
            startActivity(intent)
        }
        fpj.setOnClickListener {
            val url = "https://github.com/worknshubh/hireai"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
        spj.setOnClickListener {
            val url = "https://github.com/worknshubh/ezchat"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
        tpj.setOnClickListener {
            val url = "https://github.com/worknshubh/strechzen"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
    }
}
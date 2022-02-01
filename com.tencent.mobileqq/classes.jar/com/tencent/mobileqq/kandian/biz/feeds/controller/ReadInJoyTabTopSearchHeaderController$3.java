package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.animation.Animator;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ReadInJoyTabTopSearchHeaderController$3
  extends D8SafeAnimatorListener
{
  ReadInJoyTabTopSearchHeaderController$3(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyTabTopSearchHeaderController.a(this.a).setVisibility(8);
    ReadInJoyTabTopSearchHeaderController.b(this.a).setVisibility(0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_hotword_show_lasttime", System.currentTimeMillis()).commit();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController.3
 * JD-Core Version:    0.7.0.1
 */
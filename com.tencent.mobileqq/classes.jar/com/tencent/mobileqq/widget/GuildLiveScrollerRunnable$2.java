package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;

class GuildLiveScrollerRunnable$2
  extends AnimatorListenerAdapter
{
  GuildLiveScrollerRunnable$2(GuildLiveScrollerRunnable paramGuildLiveScrollerRunnable, View paramView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.postDelayed(new GuildLiveScrollerRunnable.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuildLiveScrollerRunnable.2
 * JD-Core Version:    0.7.0.1
 */
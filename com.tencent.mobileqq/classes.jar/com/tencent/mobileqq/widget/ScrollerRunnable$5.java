package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

class ScrollerRunnable$5
  extends D8SafeAnimatorListener
{
  ScrollerRunnable$5(ScrollerRunnable paramScrollerRunnable, View paramView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.postDelayed(new ScrollerRunnable.5.1(this), 500L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.5
 * JD-Core Version:    0.7.0.1
 */
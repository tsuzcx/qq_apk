package com.tencent.mobileqq.profile.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BreatheEffectView$4
  extends AnimatorListenerAdapter
{
  BreatheEffectView$4(BreatheEffectView paramBreatheEffectView, BreatheEffectView.BreatheListener paramBreatheListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.onBreatheShown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView.4
 * JD-Core Version:    0.7.0.1
 */
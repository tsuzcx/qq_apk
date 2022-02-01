package com.tencent.mobileqq.profile.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BreatheEffectView$4
  extends AnimatorListenerAdapter
{
  BreatheEffectView$4(BreatheEffectView paramBreatheEffectView, BreatheEffectView.BreatheListener paramBreatheListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView$BreatheListener.onBreatheShown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView.4
 * JD-Core Version:    0.7.0.1
 */
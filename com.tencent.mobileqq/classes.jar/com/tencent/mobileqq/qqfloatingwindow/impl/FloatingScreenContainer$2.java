package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FloatingScreenContainer$2
  extends D8SafeAnimatorListener
{
  FloatingScreenContainer$2(FloatingScreenContainer paramFloatingScreenContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.removeAllListeners();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.startup.step;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class SetSplash$15
  extends AnimatorListenerAdapter
{
  SetSplash$15(SetSplash.SplashAnimListener paramSplashAnimListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SetSplash.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.15
 * JD-Core Version:    0.7.0.1
 */
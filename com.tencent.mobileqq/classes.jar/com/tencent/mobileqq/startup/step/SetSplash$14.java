package com.tencent.mobileqq.startup.step;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class SetSplash$14
  extends AnimatorListenerAdapter
{
  SetSplash$14(SetSplash.SplashAnimListener paramSplashAnimListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SetSplash.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.14
 * JD-Core Version:    0.7.0.1
 */
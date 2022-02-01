package com.tencent.mobileqq.multicard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class MultiCardFragment$13
  extends AnimatorListenerAdapter
{
  MultiCardFragment$13(MultiCardFragment paramMultiCardFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiCardFragment.c(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiCardFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.13
 * JD-Core Version:    0.7.0.1
 */
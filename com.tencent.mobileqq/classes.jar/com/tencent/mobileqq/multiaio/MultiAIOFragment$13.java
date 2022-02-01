package com.tencent.mobileqq.multiaio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class MultiAIOFragment$13
  extends AnimatorListenerAdapter
{
  MultiAIOFragment$13(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.a(this.b, this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.13
 * JD-Core Version:    0.7.0.1
 */
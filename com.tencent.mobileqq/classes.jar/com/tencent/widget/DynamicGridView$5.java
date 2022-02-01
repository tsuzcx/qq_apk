package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DynamicGridView$5
  extends AnimatorListenerAdapter
{
  DynamicGridView$5(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, false);
    DynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, true);
    DynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.5
 * JD-Core Version:    0.7.0.1
 */
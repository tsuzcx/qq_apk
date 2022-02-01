package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ParticipleView$3
  extends AnimatorListenerAdapter
{
  ParticipleView$3(ParticipleView paramParticipleView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ParticipleView.a(this.a, 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleView.3
 * JD-Core Version:    0.7.0.1
 */
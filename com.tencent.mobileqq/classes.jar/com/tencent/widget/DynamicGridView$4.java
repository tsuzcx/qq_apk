package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class DynamicGridView$4
  extends AnimatorListenerAdapter
{
  DynamicGridView$4(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.a(this.b, false);
    DynamicGridView.b(this.b);
    DynamicGridView.a(this.b, this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.a(this.b, true);
    DynamicGridView.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */
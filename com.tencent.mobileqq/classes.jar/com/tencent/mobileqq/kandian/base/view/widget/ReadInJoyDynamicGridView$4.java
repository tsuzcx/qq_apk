package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ReadInJoyDynamicGridView$4
  extends AnimatorListenerAdapter
{
  ReadInJoyDynamicGridView$4(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.b, false);
    ReadInJoyDynamicGridView.b(this.b);
    ReadInJoyDynamicGridView.a(this.b, this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.b, true);
    ReadInJoyDynamicGridView.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */
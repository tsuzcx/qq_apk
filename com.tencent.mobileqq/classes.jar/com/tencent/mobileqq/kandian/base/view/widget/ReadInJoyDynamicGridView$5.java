package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ReadInJoyDynamicGridView$5
  extends AnimatorListenerAdapter
{
  ReadInJoyDynamicGridView$5(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, false);
    ReadInJoyDynamicGridView.b(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, true);
    ReadInJoyDynamicGridView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.5
 * JD-Core Version:    0.7.0.1
 */
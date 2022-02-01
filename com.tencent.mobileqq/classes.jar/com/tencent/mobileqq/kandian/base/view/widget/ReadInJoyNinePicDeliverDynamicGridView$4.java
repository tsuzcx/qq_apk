package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ReadInJoyNinePicDeliverDynamicGridView$4
  extends AnimatorListenerAdapter
{
  ReadInJoyNinePicDeliverDynamicGridView$4(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, false);
    ReadInJoyNinePicDeliverDynamicGridView.b(this.b);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, true);
    ReadInJoyNinePicDeliverDynamicGridView.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */
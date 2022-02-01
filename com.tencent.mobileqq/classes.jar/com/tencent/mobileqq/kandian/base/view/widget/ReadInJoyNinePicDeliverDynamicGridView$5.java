package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ReadInJoyNinePicDeliverDynamicGridView$5
  extends AnimatorListenerAdapter
{
  ReadInJoyNinePicDeliverDynamicGridView$5(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a, false);
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a, true);
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HippyVerticalScrollView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  HippyVerticalScrollView$1(HippyVerticalScrollView paramHippyVerticalScrollView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.this$0.scrollTo(this.val$x, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView.1
 * JD-Core Version:    0.7.0.1
 */
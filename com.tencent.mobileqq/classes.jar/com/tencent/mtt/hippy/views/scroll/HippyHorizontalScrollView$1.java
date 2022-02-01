package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HippyHorizontalScrollView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  HippyHorizontalScrollView$1(HippyHorizontalScrollView paramHippyHorizontalScrollView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.this$0.scrollTo(i, this.val$y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */
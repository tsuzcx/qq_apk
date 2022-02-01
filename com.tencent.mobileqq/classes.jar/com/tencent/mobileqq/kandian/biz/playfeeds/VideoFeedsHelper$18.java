package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

final class VideoFeedsHelper$18
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoFeedsHelper$18(int paramInt1, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt2, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(paramValueAnimator.getAnimatedFraction() * this.a);
    paramValueAnimator = this.b;
    paramValueAnimator.bottomMargin = (this.c + i);
    this.d.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.18
 * JD-Core Version:    0.7.0.1
 */
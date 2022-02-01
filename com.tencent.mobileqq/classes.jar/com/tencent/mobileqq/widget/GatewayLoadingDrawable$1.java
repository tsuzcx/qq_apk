package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GatewayLoadingDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GatewayLoadingDrawable$1(GatewayLoadingDrawable paramGatewayLoadingDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GatewayLoadingDrawable.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GatewayLoadingDrawable.1
 * JD-Core Version:    0.7.0.1
 */
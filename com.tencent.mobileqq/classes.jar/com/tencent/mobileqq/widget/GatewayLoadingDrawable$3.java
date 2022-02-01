package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GatewayLoadingDrawable$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GatewayLoadingDrawable$3(GatewayLoadingDrawable paramGatewayLoadingDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GatewayLoadingDrawable.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GatewayLoadingDrawable.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

class GatewayLoadingDrawable$2
  implements ValueAnimator.AnimatorUpdateListener
{
  GatewayLoadingDrawable$2(GatewayLoadingDrawable paramGatewayLoadingDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GatewayLoadingDrawable.a(this.a).setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GatewayLoadingDrawable.2
 * JD-Core Version:    0.7.0.1
 */
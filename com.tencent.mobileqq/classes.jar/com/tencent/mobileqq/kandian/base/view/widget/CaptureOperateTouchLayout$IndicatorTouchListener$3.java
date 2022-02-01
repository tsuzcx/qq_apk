package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class CaptureOperateTouchLayout$IndicatorTouchListener$3
  implements ValueAnimator.AnimatorUpdateListener
{
  CaptureOperateTouchLayout$IndicatorTouchListener$3(CaptureOperateTouchLayout.IndicatorTouchListener paramIndicatorTouchListener, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setX(f);
    CaptureOperateTouchLayout.i(this.b.a).setX(f + this.a.getWidth() * 0.32F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.IndicatorTouchListener.3
 * JD-Core Version:    0.7.0.1
 */
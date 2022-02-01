package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class FloatingVideoWrapper$13
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingVideoWrapper$13(FloatingVideoWrapper paramFloatingVideoWrapper, float paramFloat1, float paramFloat2, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    float f1 = this.a;
    float f2 = paramValueAnimator.floatValue();
    float f3 = this.b;
    float f4 = this.a;
    this.c.setAlpha(f1 + f2 * (f3 - f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.13
 * JD-Core Version:    0.7.0.1
 */
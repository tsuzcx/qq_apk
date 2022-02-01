package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class NumberScaleAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  NumberScaleAnimation$1(NumberScaleAnimation paramNumberScaleAnimation, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setScaleX(f);
    this.a.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.NumberScaleAnimation.1
 * JD-Core Version:    0.7.0.1
 */
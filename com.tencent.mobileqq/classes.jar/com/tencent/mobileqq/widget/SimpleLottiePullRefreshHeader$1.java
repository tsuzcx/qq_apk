package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SimpleLottiePullRefreshHeader$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SimpleLottiePullRefreshHeader$1(SimpleLottiePullRefreshHeader paramSimpleLottiePullRefreshHeader) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setScaleY(f);
    this.a.a.setScaleX(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader.1
 * JD-Core Version:    0.7.0.1
 */
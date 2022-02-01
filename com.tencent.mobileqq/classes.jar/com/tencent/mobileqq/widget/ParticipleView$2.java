package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ParticipleView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ParticipleView$2(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ParticipleView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleView.2
 * JD-Core Version:    0.7.0.1
 */
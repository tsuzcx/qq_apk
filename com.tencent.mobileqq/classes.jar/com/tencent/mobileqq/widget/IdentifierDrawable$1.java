package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class IdentifierDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  IdentifierDrawable$1(IdentifierDrawable paramIdentifierDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    IdentifierDrawable.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IdentifierDrawable.1
 * JD-Core Version:    0.7.0.1
 */
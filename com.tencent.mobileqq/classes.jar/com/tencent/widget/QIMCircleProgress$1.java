package com.tencent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCircleProgress$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCircleProgress$1(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.mBlinkAlpha = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.this$0.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.QIMCircleProgress.1
 * JD-Core Version:    0.7.0.1
 */
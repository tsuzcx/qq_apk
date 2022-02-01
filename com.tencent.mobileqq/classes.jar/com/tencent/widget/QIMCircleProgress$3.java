package com.tencent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCircleProgress$3
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCircleProgress$3(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.mBlinkAlpha = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.this$0.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QIMCircleProgress.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress;

class ComboCountDownAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ComboCountDownAnimation$1(ComboCountDownAnimation paramComboCountDownAnimation, int paramInt, QQGiftCircleProgress paramQQGiftCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue() / this.a;
    this.b.setProgress((1.0F - f) * 100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboCountDownAnimation.1
 * JD-Core Version:    0.7.0.1
 */
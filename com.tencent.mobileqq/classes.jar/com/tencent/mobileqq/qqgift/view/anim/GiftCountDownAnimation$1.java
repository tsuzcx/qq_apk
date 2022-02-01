package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress;

class GiftCountDownAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GiftCountDownAnimation$1(GiftCountDownAnimation paramGiftCountDownAnimation, float paramFloat, QQGiftCircleProgress paramQQGiftCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction() + this.a;
    if (f <= 1.0F)
    {
      this.b.setProgress(f * 100.0F);
      return;
    }
    this.c.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.GiftCountDownAnimation.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress;

public class GiftCountDownAnimation
{
  private final ValueAnimator a;
  
  public GiftCountDownAnimation(QQGiftCircleProgress paramQQGiftCircleProgress, long paramLong, float paramFloat)
  {
    paramFloat = paramFloat * 1.0F / 100.0F;
    this.a = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.a.setDuration(paramLong * 1000L);
    this.a.addUpdateListener(new GiftCountDownAnimation.1(this, paramFloat, paramQQGiftCircleProgress));
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.a.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.GiftCountDownAnimation
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress;

public class ComboCountDownAnimation
{
  private final QQGiftCircleProgress a;
  private final ValueAnimator b;
  private CountDownEndListener c;
  private boolean d = true;
  
  public ComboCountDownAnimation(QQGiftCircleProgress paramQQGiftCircleProgress, int paramInt)
  {
    this.a = paramQQGiftCircleProgress;
    this.b = ValueAnimator.ofFloat(new float[] { paramInt });
    this.b.setDuration(paramInt);
    this.b.addUpdateListener(new ComboCountDownAnimation.1(this, paramInt, paramQQGiftCircleProgress));
    this.b.addListener(new ComboCountDownAnimation.2(this));
  }
  
  public void a()
  {
    this.d = false;
    this.b.start();
  }
  
  public void a(CountDownEndListener paramCountDownEndListener)
  {
    this.c = paramCountDownEndListener;
  }
  
  public void b()
  {
    this.d = true;
    this.b.end();
    this.a.setProgress(100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboCountDownAnimation
 * JD-Core Version:    0.7.0.1
 */
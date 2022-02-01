package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class ComboSendBtnAnimation
{
  private final ValueAnimator a = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
  
  public ComboSendBtnAnimation(View paramView)
  {
    this.a.setDuration(100L);
    this.a.setInterpolator(new DecelerateInterpolator());
    this.a.addUpdateListener(new ComboSendBtnAnimation.1(this, paramView));
  }
  
  public void a()
  {
    this.a.cancel();
    this.a.reverse();
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboSendBtnAnimation
 * JD-Core Version:    0.7.0.1
 */
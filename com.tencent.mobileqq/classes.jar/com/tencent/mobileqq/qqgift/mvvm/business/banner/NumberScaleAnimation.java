package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

class NumberScaleAnimation
{
  private final ValueAnimator a;
  
  public NumberScaleAnimation(View paramView, float paramFloat1, float paramFloat2)
  {
    this.a = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    this.a.setDuration(200L);
    this.a.setInterpolator(new DecelerateInterpolator());
    this.a.addUpdateListener(new NumberScaleAnimation.1(this, paramView));
  }
  
  public void a()
  {
    this.a.start();
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    this.a.addListener(paramAnimatorListener);
  }
  
  public void b()
  {
    this.a.cancel();
    this.a.reverse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.NumberScaleAnimation
 * JD-Core Version:    0.7.0.1
 */
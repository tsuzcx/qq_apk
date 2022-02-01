package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class ComboStimulateEnterAnimation
{
  private final ValueAnimator a = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
  
  public ComboStimulateEnterAnimation(View paramView)
  {
    this.a.setDuration(200L);
    this.a.setInterpolator(new DecelerateInterpolator());
    this.a.addUpdateListener(new ComboStimulateEnterAnimation.1(this, paramView));
  }
  
  public void a()
  {
    this.a.start();
  }
  
  public void b()
  {
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboStimulateEnterAnimation
 * JD-Core Version:    0.7.0.1
 */
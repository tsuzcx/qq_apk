package com.tencent.mobileqq.widget.bounce;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager.widget.PagerAdapter;

public class OverScrollEffect
{
  protected float a;
  private Animator b;
  private int c = 200;
  private BounceViewPager d;
  
  public OverScrollEffect(BounceViewPager paramBounceViewPager)
  {
    this.d = paramBounceViewPager;
  }
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
    this.d.a();
  }
  
  protected boolean a()
  {
    if ((this.d.a == 0) && (this.a < 0.0F)) {
      return true;
    }
    int i;
    if (this.d.getAdapter().getCount() - 1 == this.d.getCurrentItem()) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (this.a > 0.0F);
  }
  
  protected void b()
  {
    this.b = ObjectAnimator.ofFloat(this.d, "Pull", new float[] { this.a, 0.0F });
    this.b.setInterpolator(new DecelerateInterpolator());
    float f = Math.abs(-this.a);
    this.b.setDuration((this.c * f));
    this.b.addListener(new OverScrollEffect.1(this));
    this.b.start();
  }
  
  protected void c()
  {
    Animator localAnimator = this.b;
    if ((localAnimator != null) && (localAnimator.isRunning()))
    {
      this.b.addListener(new OverScrollEffect.2(this));
      this.b.cancel();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.OverScrollEffect
 * JD-Core Version:    0.7.0.1
 */
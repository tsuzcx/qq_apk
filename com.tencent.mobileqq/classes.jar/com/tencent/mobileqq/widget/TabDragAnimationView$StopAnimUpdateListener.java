package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TabDragAnimationView$StopAnimUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  float a = 0.0F;
  float b = 0.0F;
  private final TabDragAnimationView c;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  
  TabDragAnimationView$StopAnimUpdateListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.c = paramTabDragAnimationView;
  }
  
  void a()
  {
    this.d = this.c.h;
    this.e = this.c.i;
    this.f = (this.d - this.a);
    this.g = (this.e - this.b);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((f2 < 0.1F) && (this.a == 0.0F) && (this.b == 0.0F))
    {
      TabDragAnimationView localTabDragAnimationView = this.c;
      localTabDragAnimationView.j = 1;
      localTabDragAnimationView.c();
      paramValueAnimator.cancel();
      paramValueAnimator.removeUpdateListener(this);
      this.c.m = null;
      return;
    }
    float f1;
    if (f2 < 0.1F) {
      f1 = this.f;
    } else {
      f1 = this.f * (1.0F - f2);
    }
    if (f2 < 0.1F) {
      f2 = this.g;
    } else {
      f2 = (1.0F - f2) * this.g;
    }
    this.c.a(this.d - f1, this.e - f2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView.StopAnimUpdateListener
 * JD-Core Version:    0.7.0.1
 */
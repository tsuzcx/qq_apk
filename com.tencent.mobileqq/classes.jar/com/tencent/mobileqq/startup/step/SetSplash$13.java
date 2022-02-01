package com.tencent.mobileqq.startup.step;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;

final class SetSplash$13
  implements ValueAnimator.AnimatorUpdateListener
{
  SetSplash$13(int paramInt1, int paramInt2, int paramInt3, View paramView, SetSplash.SplashAnimListener paramSplashAnimListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = this.a;
    if (i > 0) {
      i = (int)(i * f);
    } else {
      i = 0;
    }
    int j = this.b;
    int k = (int)((j - this.c) * f);
    paramValueAnimator = new Rect(0, i, this.d.getRight(), j - k + i);
    ViewCompat.setClipBounds(this.d, paramValueAnimator);
    if ((f > 0.6D) && (!SetSplash.g()))
    {
      SetSplash.a(true);
      SetSplash.b(this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.13
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;

final class CommonAnimationUtil$4
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    f1 = new AccelerateInterpolator().getInterpolation(f1);
    int m = this.a;
    float f2 = m;
    float f3 = this.b - m;
    m = this.c;
    float f4 = m;
    float f5 = this.d - m;
    m = this.e;
    float f6 = m;
    float f7 = this.f - m;
    m = this.g;
    float f8 = m;
    float f9 = this.h - m;
    this.i.setMargins((int)(f2 + f3 * f1), (int)(f4 + f5 * f1), (int)(f6 + f7 * f1), (int)(f8 + f9 * f1));
    this.j.setLayoutParams(this.i);
    paramValueAnimator = this.k;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.a(this.j, f1);
      if (f1 >= 1.0F) {
        this.k.b(this.j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

final class CommonAnimationUtil$5
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    f1 = new AccelerateInterpolator().getInterpolation(f1);
    float f2 = this.a;
    float f3 = this.b;
    this.c.setRotation(f2 + (f3 - f2) * f1);
    paramValueAnimator = this.d;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.a(this.c, f1);
      if (f1 >= 1.0F) {
        this.d.b(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil.5
 * JD-Core Version:    0.7.0.1
 */
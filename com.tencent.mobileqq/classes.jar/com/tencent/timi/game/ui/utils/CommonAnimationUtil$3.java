package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class CommonAnimationUtil$3
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.a;
    f2 += (this.b - f2) * f1;
    this.c.setScaleX(f2);
    this.c.setScaleY(f2);
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
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil.3
 * JD-Core Version:    0.7.0.1
 */
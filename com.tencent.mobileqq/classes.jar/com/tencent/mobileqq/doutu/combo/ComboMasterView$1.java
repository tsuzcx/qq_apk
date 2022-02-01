package com.tencent.mobileqq.doutu.combo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PathMeasure;

class ComboMasterView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ComboMasterView$1(ComboMasterView paramComboMasterView, PathMeasure paramPathMeasure, float[] paramArrayOfFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.getPosTan(f, this.b, null);
    this.c.setTranslationX(this.b[0]);
    this.c.setTranslationY(this.b[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboMasterView.1
 * JD-Core Version:    0.7.0.1
 */
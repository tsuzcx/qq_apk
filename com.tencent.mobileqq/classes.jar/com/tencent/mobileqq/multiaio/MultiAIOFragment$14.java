package com.tencent.mobileqq.multiaio;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;

class MultiAIOFragment$14
  implements ValueAnimator.AnimatorUpdateListener
{
  MultiAIOFragment$14(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    int j = this.b;
    paramValueAnimator.leftMargin = (j + Math.round((0.0F - j) * f1));
    j = this.c;
    paramValueAnimator.topMargin = (j + Math.round((this.d - j) * f1));
    j = this.e;
    paramValueAnimator.width = (j + Math.round((this.f - j) * f1));
    j = this.g;
    paramValueAnimator.height = (j + Math.round((this.h - j) * f1));
    this.a.setLayoutParams(paramValueAnimator);
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.14
 * JD-Core Version:    0.7.0.1
 */
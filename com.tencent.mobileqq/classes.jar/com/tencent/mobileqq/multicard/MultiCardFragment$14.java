package com.tencent.mobileqq.multicard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MultiCardFragment$14
  implements ValueAnimator.AnimatorUpdateListener
{
  MultiCardFragment$14(MultiCardFragment paramMultiCardFragment, MultiCardFragment.ZoomParam paramZoomParam, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = this.a;
    if (paramValueAnimator == null) {
      return;
    }
    float f2 = this.b;
    f2 += (1.0F - f2) * f1;
    paramValueAnimator.f.setScaleX(f2);
    this.a.f.setScaleY(f2);
    this.a.f.setTranslationX(0.0F);
    this.a.f.setTranslationY(this.c * (1.0F - f1));
    paramValueAnimator = this.a.f.getLayoutParams();
    float f3 = this.d;
    float f4 = this.e;
    paramValueAnimator.height = ((int)(f3 * ((f4 + (1.0F - f4) * f1) / f2)));
    this.a.f.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.14
 * JD-Core Version:    0.7.0.1
 */
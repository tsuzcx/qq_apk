package com.tencent.mobileqq.multicard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MultiCardFragment$12
  implements ValueAnimator.AnimatorUpdateListener
{
  MultiCardFragment$12(MultiCardFragment paramMultiCardFragment, MultiCardFragment.ZoomParam paramZoomParam, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = this.a;
    if (paramValueAnimator == null) {
      return;
    }
    float f2 = 1.0F - (1.0F - this.b) * f1;
    paramValueAnimator.f.setScaleX(f2);
    this.a.f.setScaleY(f2);
    this.a.f.setTranslationX(0.0F);
    this.a.f.setTranslationY(this.c * f1);
    this.a.f.getLayoutParams().height = ((int)(this.d * ((1.0F - (1.0F - this.e) * f1) / f2)));
    this.a.f.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.12
 * JD-Core Version:    0.7.0.1
 */
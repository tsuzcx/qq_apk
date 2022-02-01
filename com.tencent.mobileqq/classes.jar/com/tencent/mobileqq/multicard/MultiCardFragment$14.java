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
    paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam;
    if (paramValueAnimator == null) {
      return;
    }
    float f2 = this.jdField_a_of_type_Float;
    f2 += (1.0F - f2) * f1;
    paramValueAnimator.a.setScaleX(f2);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setScaleY(f2);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setTranslationX(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setTranslationY(this.b * (1.0F - f1));
    paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.getLayoutParams();
    float f3 = this.c;
    float f4 = this.d;
    paramValueAnimator.height = ((int)(f3 * ((f4 + (1.0F - f4) * f1) / f2)));
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.14
 * JD-Core Version:    0.7.0.1
 */
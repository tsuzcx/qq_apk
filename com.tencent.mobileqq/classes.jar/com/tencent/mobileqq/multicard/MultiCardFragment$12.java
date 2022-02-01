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
    paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam;
    if (paramValueAnimator == null) {
      return;
    }
    float f2 = 1.0F - (1.0F - this.jdField_a_of_type_Float) * f1;
    paramValueAnimator.a.setScaleX(f2);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setScaleY(f2);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setTranslationX(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.setTranslationY(this.b * f1);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.getLayoutParams().height = ((int)(this.c * ((1.0F - (1.0F - this.d) * f1) / f2)));
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ZoomParam.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.12
 * JD-Core Version:    0.7.0.1
 */
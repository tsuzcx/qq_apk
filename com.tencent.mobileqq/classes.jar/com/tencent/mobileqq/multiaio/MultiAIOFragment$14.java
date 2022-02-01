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
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.leftMargin = (i + Math.round((0.0F - i) * f1));
    i = this.b;
    paramValueAnimator.topMargin = (i + Math.round((this.c - i) * f1));
    i = this.d;
    paramValueAnimator.width = (i + Math.round((this.e - i) * f1));
    i = this.f;
    paramValueAnimator.height = (i + Math.round((this.g - i) * f1));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.14
 * JD-Core Version:    0.7.0.1
 */
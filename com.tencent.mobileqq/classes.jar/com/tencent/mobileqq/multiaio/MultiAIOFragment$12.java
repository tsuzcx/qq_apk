package com.tencent.mobileqq.multiaio;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

class MultiAIOFragment$12
  implements ValueAnimator.AnimatorUpdateListener
{
  MultiAIOFragment$12(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.leftMargin = (i + Math.round((this.b - i) * f1));
    i = this.c;
    paramValueAnimator.topMargin = (i + Math.round((this.d - i) * f1));
    i = this.e;
    paramValueAnimator.width = (i + Math.round((this.f - i) * f1));
    i = this.g;
    int j = MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getHeight() - MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getPaddingTop() - MultiAIOFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment).getPaddingBottom();
    if (j > 0) {
      i = j;
    }
    j = this.h;
    paramValueAnimator.height = (j + Math.round((i - j) * f1));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.12
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class BezierSideBarView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BezierSideBarView$1(BezierSideBarView paramBezierSideBarView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BezierSideBarView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView.invalidate();
    ValueAnimator.AnimatorUpdateListener localAnimatorUpdateListener = this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
    if (localAnimatorUpdateListener != null) {
      localAnimatorUpdateListener.onAnimationUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView.1
 * JD-Core Version:    0.7.0.1
 */
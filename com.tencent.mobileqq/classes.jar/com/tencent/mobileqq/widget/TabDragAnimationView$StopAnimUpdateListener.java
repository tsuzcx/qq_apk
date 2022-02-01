package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TabDragAnimationView$StopAnimUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  float jdField_a_of_type_Float = 0.0F;
  private final TabDragAnimationView jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView;
  float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  
  TabDragAnimationView$StopAnimUpdateListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = paramTabDragAnimationView;
  }
  
  void a()
  {
    this.c = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c;
    this.d = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.d;
    this.e = (this.c - this.jdField_a_of_type_Float);
    this.f = (this.d - this.b);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((f2 < 0.1F) && (this.jdField_a_of_type_Float == 0.0F) && (this.b == 0.0F))
    {
      TabDragAnimationView localTabDragAnimationView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView;
      localTabDragAnimationView.e = 1;
      localTabDragAnimationView.c();
      paramValueAnimator.cancel();
      paramValueAnimator.removeUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a = null;
      return;
    }
    float f1;
    if (f2 < 0.1F) {
      f1 = this.e;
    } else {
      f1 = this.e * (1.0F - f2);
    }
    if (f2 < 0.1F) {
      f2 = this.f;
    } else {
      f2 = (1.0F - f2) * this.f;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a(this.c - f1, this.d - f2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView.StopAnimUpdateListener
 * JD-Core Version:    0.7.0.1
 */
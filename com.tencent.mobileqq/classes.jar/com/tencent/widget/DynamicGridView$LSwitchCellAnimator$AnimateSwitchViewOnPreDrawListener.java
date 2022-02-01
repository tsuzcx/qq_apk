package com.tencent.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class DynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  DynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(DynamicGridView.LSwitchCellAnimator paramLSwitchCellAnimator, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a, DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a) + DynamicGridView.LSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator));
    DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a, DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a) + DynamicGridView.LSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator));
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a.a(DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$LSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
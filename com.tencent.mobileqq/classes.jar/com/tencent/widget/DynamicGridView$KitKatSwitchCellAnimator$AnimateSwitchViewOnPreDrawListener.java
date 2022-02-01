package com.tencent.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class DynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  DynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(DynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a, DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a) + DynamicGridView.KitKatSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator));
    DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a, DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a) + DynamicGridView.KitKatSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator));
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a.a(DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
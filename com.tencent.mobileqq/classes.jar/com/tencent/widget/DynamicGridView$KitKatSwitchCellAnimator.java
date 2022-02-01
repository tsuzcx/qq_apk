package com.tencent.widget;

import android.view.ViewTreeObserver;

class DynamicGridView$KitKatSwitchCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public DynamicGridView$KitKatSwitchCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView), paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.KitKatSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */
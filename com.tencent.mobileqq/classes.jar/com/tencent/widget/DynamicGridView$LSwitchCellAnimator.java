package com.tencent.widget;

import android.view.ViewTreeObserver;

class DynamicGridView$LSwitchCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public DynamicGridView$LSwitchCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.LSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */
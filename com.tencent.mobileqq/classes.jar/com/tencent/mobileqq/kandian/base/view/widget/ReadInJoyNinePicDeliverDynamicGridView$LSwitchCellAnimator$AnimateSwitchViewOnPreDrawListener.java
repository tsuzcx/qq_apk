package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  ReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator paramLSwitchCellAnimator, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator));
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
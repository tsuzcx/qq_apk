package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  ReadInJoyDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyDynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator));
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
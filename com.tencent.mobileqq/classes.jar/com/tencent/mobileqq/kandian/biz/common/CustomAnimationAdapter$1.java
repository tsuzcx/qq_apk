package com.tencent.mobileqq.kandian.biz.common;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class CustomAnimationAdapter$1
  implements ViewTreeObserver.OnPreDrawListener
{
  CustomAnimationAdapter$1(CustomAnimationAdapter paramCustomAnimationAdapter, View paramView) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    CustomAnimationAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonCustomAnimationAdapter, this.jdField_a_of_type_AndroidViewView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter.1
 * JD-Core Version:    0.7.0.1
 */
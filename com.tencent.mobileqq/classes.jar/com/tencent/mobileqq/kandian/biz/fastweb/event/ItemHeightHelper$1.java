package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ItemHeightHelper$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ItemHeightHelper$1(ItemHeightHelper paramItemHeightHelper, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" position : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("   height:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewView.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemHeightHelper.1
 * JD-Core Version:    0.7.0.1
 */
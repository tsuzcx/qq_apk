package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogThreeBtns$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public QQCustomDialogThreeBtns$CustomDialogItemOnClickListener(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a;
      QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns;
      localOnClickListener.onClick(localQQCustomDialogThreeBtns, localQQCustomDialogThreeBtns.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */
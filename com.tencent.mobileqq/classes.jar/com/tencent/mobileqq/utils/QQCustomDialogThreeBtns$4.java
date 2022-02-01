package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogThreeBtns$4
  implements View.OnClickListener
{
  QQCustomDialogThreeBtns$4(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns.4
 * JD-Core Version:    0.7.0.1
 */
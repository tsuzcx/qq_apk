package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihInputAndChoose$7
  implements View.OnClickListener
{
  QQCustomDialogWtihInputAndChoose$7(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.dismiss();
      }
      label44:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.7
 * JD-Core Version:    0.7.0.1
 */
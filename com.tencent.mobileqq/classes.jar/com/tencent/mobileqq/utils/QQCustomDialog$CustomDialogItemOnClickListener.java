package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public QQCustomDialog$CustomDialogItemOnClickListener(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.onArrayItemClick != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.onArrayItemClick;
      QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      localOnClickListener.onClick(localQQCustomDialog, localQQCustomDialog.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      label55:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */
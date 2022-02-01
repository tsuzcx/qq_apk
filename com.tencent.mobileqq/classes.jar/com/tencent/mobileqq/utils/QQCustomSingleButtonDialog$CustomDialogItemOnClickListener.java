package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomSingleButtonDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public QQCustomSingleButtonDialog$CustomDialogItemOnClickListener(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a;
      QQCustomSingleButtonDialog localQQCustomSingleButtonDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog;
      localOnClickListener.onClick(localQQCustomSingleButtonDialog, localQQCustomSingleButtonDialog.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */
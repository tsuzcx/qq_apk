package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$3
  implements CompoundButton.OnCheckedChangeListener
{
  QQCustomDialog$3(QQCustomDialog paramQQCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener;
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localQQCustomDialog, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.3
 * JD-Core Version:    0.7.0.1
 */
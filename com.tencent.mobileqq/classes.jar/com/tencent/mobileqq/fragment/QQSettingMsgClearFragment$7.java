package com.tencent.mobileqq.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QQSettingMsgClearFragment$7
  implements DialogInterface.OnClickListener
{
  QQSettingMsgClearFragment$7(QQSettingMsgClearFragment paramQQSettingMsgClearFragment, DialogInterface.OnClickListener paramOnClickListener, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.7
 * JD-Core Version:    0.7.0.1
 */
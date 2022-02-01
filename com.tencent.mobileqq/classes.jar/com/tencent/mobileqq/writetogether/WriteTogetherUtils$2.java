package com.tencent.mobileqq.writetogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class WriteTogetherUtils$2
  implements DialogInterface.OnClickListener
{
  WriteTogetherUtils$2(QQCustomDialog paramQQCustomDialog, WriteTogetherUtils.OnDialogConfirmButtonClickListener paramOnDialogConfirmButtonClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherUtils$OnDialogConfirmButtonClickListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherUtils.2
 * JD-Core Version:    0.7.0.1
 */
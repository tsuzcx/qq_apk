package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ReciteRecordLayout$1
  implements DialogInterface.OnClickListener
{
  ReciteRecordLayout$1(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (!NetworkUtil.g(this.a.jdField_a_of_type_AndroidContentContext)) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    do
    {
      return;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    } while (ReciteRecordLayout.a(this.a) == null);
    ReciteRecordLayout.a(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.1
 * JD-Core Version:    0.7.0.1
 */
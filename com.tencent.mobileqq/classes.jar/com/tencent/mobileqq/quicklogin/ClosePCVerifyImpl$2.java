package com.tencent.mobileqq.quicklogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ClosePCVerifyImpl$2
  implements DialogInterface.OnClickListener
{
  ClosePCVerifyImpl$2(ClosePCVerifyImpl paramClosePCVerifyImpl, QQAppInterface paramQQAppInterface, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE05", "0X800AE05", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl.a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

final class PwdSetUtil$1
  implements DialogInterface.OnClickListener
{
  PwdSetUtil$1(String paramString, Activity paramActivity, AppInterface paramAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      PwdSetUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: dismiss exception. " + paramDialogInterface.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.PwdSetUtil.1
 * JD-Core Version:    0.7.0.1
 */
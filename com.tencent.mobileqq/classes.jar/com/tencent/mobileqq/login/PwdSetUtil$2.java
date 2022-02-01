package com.tencent.mobileqq.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class PwdSetUtil$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: dismiss exception. " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.PwdSetUtil.2
 * JD-Core Version:    0.7.0.1
 */
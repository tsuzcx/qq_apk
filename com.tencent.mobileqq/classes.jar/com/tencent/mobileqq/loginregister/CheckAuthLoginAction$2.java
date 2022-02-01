package com.tencent.mobileqq.loginregister;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class CheckAuthLoginAction$2
  implements DialogInterface.OnClickListener
{
  CheckAuthLoginAction$2(CheckAuthLoginAction paramCheckAuthLoginAction, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8006797", "0X8006797", 0, 0, "", "", "", "");
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.CheckAuthLoginAction.2
 * JD-Core Version:    0.7.0.1
 */
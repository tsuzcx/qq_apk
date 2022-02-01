package com.tencent.mobileqq.loginregister;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

class CheckAuthLoginAction$1
  implements DialogInterface.OnClickListener
{
  CheckAuthLoginAction$1(CheckAuthLoginAction paramCheckAuthLoginAction, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8006796", "0X8006796", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new CheckAuthLoginAction.1.1(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.CheckAuthLoginAction.1
 * JD-Core Version:    0.7.0.1
 */
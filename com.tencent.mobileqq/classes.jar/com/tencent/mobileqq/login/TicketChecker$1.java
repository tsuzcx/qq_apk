package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.logincallback.TicketCheckDialogCallback;
import mqq.app.AppRuntime;

class TicketChecker$1
  implements DialogInterface.OnClickListener
{
  TicketChecker$1(TicketChecker paramTicketChecker, Activity paramActivity, AppRuntime paramAppRuntime, String paramString, TicketCheckDialogCallback paramTicketCheckDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.e.a(this.a, this.b.getCurrentUin(), "cancel", this.c);
    paramDialogInterface = this.d;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.TicketChecker.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.logincallback.TicketCheckDialogCallback;
import mqq.app.AppRuntime;

class TicketChecker$2
  implements DialogInterface.OnClickListener
{
  TicketChecker$2(TicketChecker paramTicketChecker, TicketCheckDialogCallback paramTicketCheckDialogCallback, Activity paramActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    this.e.a(this.b, this.c.getCurrentUin(), "logout", this.d);
    this.e.b(this.c);
    this.e.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.TicketChecker.2
 * JD-Core Version:    0.7.0.1
 */
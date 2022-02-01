package com.tencent.mobileqq.pushdialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class AIOPushDialogHelper$4
  implements DialogInterface.OnClickListener
{
  AIOPushDialogHelper$4(AIOPushDialogHelper paramAIOPushDialogHelper, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new HttpMqqJumper(AIOPushDialogHelper.a(this.b).e, AIOPushDialogHelper.a(this.b).i()).a(this.a).a(AIOPushDialogHelper.a(this.b).ah).a(AIOPushDialogHelper.a(this.b)).a();
    AIOPushDialogHelper.b(this.b);
    ReportController.b(AIOPushDialogHelper.c(this.b), "dc00898", "", "", "0X800B9A3", "0X800B9A3", 0, 0, "", "", "", "");
    ReportController.b(AIOPushDialogHelper.a(this.b).i(), "dc00898", "", "", "0X800A4BD", "0X800A4BD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper.4
 * JD-Core Version:    0.7.0.1
 */
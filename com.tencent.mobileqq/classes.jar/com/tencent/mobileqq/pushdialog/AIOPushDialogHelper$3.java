package com.tencent.mobileqq.pushdialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class AIOPushDialogHelper$3
  implements DialogInterface.OnClickListener
{
  AIOPushDialogHelper$3(AIOPushDialogHelper paramAIOPushDialogHelper, String paramString, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new HttpMqqJumper(AIOPushDialogHelper.a(this.c).e, AIOPushDialogHelper.a(this.c).i()).a(this.a).a(AIOPushDialogHelper.a(this.c).ah).a(AIOPushDialogHelper.a(this.c)).a();
    if (this.b.isFriendBanned())
    {
      ReportController.b(AIOPushDialogHelper.a(this.c).i(), "dc00898", "", "", "0X800A4BE", "0X800A4BE", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(AIOPushDialogHelper.a(this.c).i(), "dc00898", "", "", "0X800A4BC", "0X800A4BC", 0, 0, "", "", "", "");
    ReportController.b(AIOPushDialogHelper.c(this.c), "dc00898", "", "", "0X800B9A2", "0X800B9A2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper.3
 * JD-Core Version:    0.7.0.1
 */
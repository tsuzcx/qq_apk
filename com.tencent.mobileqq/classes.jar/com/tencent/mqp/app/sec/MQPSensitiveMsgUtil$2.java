package com.tencent.mqp.app.sec;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class MQPSensitiveMsgUtil$2
  implements DialogInterface.OnClickListener
{
  MQPSensitiveMsgUtil$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Safe_SensMsg", this.a, "Alert_Dialog", "Cancel", this.b, this.c, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.2
 * JD-Core Version:    0.7.0.1
 */
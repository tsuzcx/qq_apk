package com.tencent.mobileqq.managers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class TimJumpLoginManager$2
  implements DialogInterface.OnClickListener
{
  TimJumpLoginManager$2(TimJumpLoginManager paramTimJumpLoginManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(TimJumpLoginManager.a(this.a), "dc00898", "", "", "0X80085DB", "0X80085DB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TimJumpLoginManager.2
 * JD-Core Version:    0.7.0.1
 */
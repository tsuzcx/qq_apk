package com.tencent.mobileqq.haoliyou;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.statistics.ReportController;

class JefsClass$5$2
  implements DialogInterface.OnClickListener
{
  JefsClass$5$2(JefsClass.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TeleScreen.a().a(this.a.c, -1);
    if (this.a.d == null) {
      paramDialogInterface = "";
    } else {
      paramDialogInterface = this.a.d;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramDialogInterface, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.5.2
 * JD-Core Version:    0.7.0.1
 */
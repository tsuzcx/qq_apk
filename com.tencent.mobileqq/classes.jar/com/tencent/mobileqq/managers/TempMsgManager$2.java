package com.tencent.mobileqq.managers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class TempMsgManager$2
  implements DialogInterface.OnClickListener
{
  TempMsgManager$2(TempMsgManager paramTempMsgManager, BaseChatPie paramBaseChatPie, short paramShort) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.f(1);
    }
    else if (paramInt == 1)
    {
      this.c.a(this.b, true, true);
      ReportController.b(TempMsgManager.a(this.c), "dc00898", "", "", "0X8009978", "0X8009978", this.c.d(this.b), this.c.d(this.b), "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.2
 * JD-Core Version:    0.7.0.1
 */
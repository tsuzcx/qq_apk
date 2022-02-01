package com.tencent.mobileqq.msgforward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class AIOShareActionSheet$9
  implements DialogInterface.OnClickListener
{
  AIOShareActionSheet$9(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.l()) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
    ReportController.b(this.a.a, "CliOper", "", "", AIOShareActionSheet.e, AIOShareActionSheet.e, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.9
 * JD-Core Version:    0.7.0.1
 */
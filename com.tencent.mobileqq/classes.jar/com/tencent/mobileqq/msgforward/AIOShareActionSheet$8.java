package com.tencent.mobileqq.msgforward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class AIOShareActionSheet$8
  implements DialogInterface.OnClickListener
{
  AIOShareActionSheet$8(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a.a, "CliOper", "", "", AIOShareActionSheet.e, AIOShareActionSheet.e, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.8
 * JD-Core Version:    0.7.0.1
 */
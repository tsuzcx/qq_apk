package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;

class TroopFileItemOperation$7
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$7(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (TroopFileItemOperation.a(this.b) != 0) {
        TroopFileManager.a(this.b.c, this.b.b).b(this.a);
      }
      paramDialogInterface = this.b.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.b);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "Grp", "Cancel_pause_upload", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.7
 * JD-Core Version:    0.7.0.1
 */
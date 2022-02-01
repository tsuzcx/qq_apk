package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;

class TroopFileItemOperation$8
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$8(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      TroopFileTransferManager.a(this.b.c, this.b.b).a(this.a.b);
      paramDialogInterface = (TroopFileInfo)TroopFileManager.a(this.b.c, this.b.b).f.get(this.a.o);
      if (paramDialogInterface != null) {
        paramDialogInterface.D.remove(this.a.c);
      }
      paramDialogInterface = this.b.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.b);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.8
 * JD-Core Version:    0.7.0.1
 */
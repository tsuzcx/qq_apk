package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class TroopFileItemOperation$11
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$11(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (TroopFileItemOperation.a(this.b) != 0) {
        TroopFileTransferManager.a(this.b.c, this.b.b).d(this.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.11
 * JD-Core Version:    0.7.0.1
 */
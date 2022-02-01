package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class TroopFileItemOperation$10$1$1
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$10$1$1(TroopFileItemOperation.10.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (TroopFileItemOperation.a(this.a.a.c) != 0) {
        TroopFileTransferManager.a(this.a.a.c.c, this.a.a.c.b).c(this.a.a.b.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1.1
 * JD-Core Version:    0.7.0.1
 */
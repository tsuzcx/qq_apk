package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileManager;

class TroopFileItemOperation$13
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$13(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopFileManager.a(this.b.c, this.b.b).b(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.13
 * JD-Core Version:    0.7.0.1
 */
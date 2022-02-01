package com.tencent.mobileqq.troop.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class TroopFileError$2
  implements DialogInterface.OnClickListener
{
  TroopFileError$2(long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        TroopFileTransferManager.a(this.a);
      }
    }
    else {
      TroopFileTransferManager.i();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError.2
 * JD-Core Version:    0.7.0.1
 */
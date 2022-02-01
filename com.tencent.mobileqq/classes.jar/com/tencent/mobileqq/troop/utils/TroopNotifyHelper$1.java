package com.tencent.mobileqq.troop.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class TroopNotifyHelper$1
  implements DialogInterface.OnClickListener
{
  TroopNotifyHelper$1(TroopNotifyHelper.OnTroopSafeDialogClickConfirm paramOnTroopSafeDialogClickConfirm, Object[] paramArrayOfObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNotifyHelper.1
 * JD-Core Version:    0.7.0.1
 */
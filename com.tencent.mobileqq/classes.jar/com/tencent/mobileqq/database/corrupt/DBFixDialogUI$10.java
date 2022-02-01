package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class DBFixDialogUI$10
  implements DialogInterface.OnClickListener
{
  DBFixDialogUI$10(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    paramDialogInterface = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.10
 * JD-Core Version:    0.7.0.1
 */
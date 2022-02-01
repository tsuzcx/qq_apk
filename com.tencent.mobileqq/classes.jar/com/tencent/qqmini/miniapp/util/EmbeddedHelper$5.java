package com.tencent.qqmini.miniapp.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class EmbeddedHelper$5
  implements DialogInterface.OnClickListener
{
  EmbeddedHelper$5(String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EmbeddedHelper.access$400().edit().putInt(this.val$version + this.val$uin, 1).commit();
    paramDialogInterface.dismiss();
    EmbeddedHelper.setIsRunning(Boolean.valueOf(false));
    EmbeddedHelper.access$300(781, "cancel download");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.5
 * JD-Core Version:    0.7.0.1
 */
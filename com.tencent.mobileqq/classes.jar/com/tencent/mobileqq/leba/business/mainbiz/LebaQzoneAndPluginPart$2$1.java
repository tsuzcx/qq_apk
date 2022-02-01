package com.tencent.mobileqq.leba.business.mainbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class LebaQzoneAndPluginPart$2$1
  implements DialogInterface.OnClickListener
{
  LebaQzoneAndPluginPart$2$1(LebaQzoneAndPluginPart.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c.edit().putBoolean(this.a.d, true).apply();
    this.a.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.2.1
 * JD-Core Version:    0.7.0.1
 */
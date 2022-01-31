package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ShortcutUtils$4$1
  implements DialogInterface.OnClickListener
{
  ShortcutUtils$4$1(ShortcutUtils.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("Shortcut", 2, "confirm");
    ShortcutUtils.openPermissionActivity(this.this$0.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.4.1
 * JD-Core Version:    0.7.0.1
 */
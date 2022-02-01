package com.tencent.qqmini.proxyimpl;

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
    ShortcutUtils.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.4.1
 * JD-Core Version:    0.7.0.1
 */
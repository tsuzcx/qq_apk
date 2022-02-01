package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class X5UpdateGuard$2
  implements DialogInterface.OnClickListener
{
  X5UpdateGuard$2(X5UpdateGuard paramX5UpdateGuard) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "cancel");
    X5UpdateGuard.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.2
 * JD-Core Version:    0.7.0.1
 */
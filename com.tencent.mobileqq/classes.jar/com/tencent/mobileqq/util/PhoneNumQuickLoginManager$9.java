package com.tencent.mobileqq.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

final class PhoneNumQuickLoginManager$9
  implements DialogInterface.OnDismissListener
{
  PhoneNumQuickLoginManager$9(Boolean paramBoolean) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int i = 1;
    if (this.a == null)
    {
      QLog.d("PhoneNumQuickLoginManager", 1, "mask dialog dismiss, user click is null");
      return;
    }
    if (this.a.booleanValue()) {
      i = 2;
    }
    PhoneNumQuickLoginManager.c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.9
 * JD-Core Version:    0.7.0.1
 */
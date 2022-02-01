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
    paramDialogInterface = this.a;
    int i = 1;
    if (paramDialogInterface == null)
    {
      QLog.d("PhoneNumQuickLoginManager", 1, "mask dialog dismiss, user click is null");
      return;
    }
    if (paramDialogInterface.booleanValue()) {
      i = 2;
    }
    PhoneNumQuickLoginManager.d(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.9
 * JD-Core Version:    0.7.0.1
 */
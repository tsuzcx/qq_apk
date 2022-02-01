package com.tencent.mobileqq.theme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class DarkModeManager$4
  implements DialogInterface.OnClickListener
{
  DarkModeManager$4(DarkModeManager.ActionResult paramActionResult) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DarkModeManager.b("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    DarkModeManager.a(false);
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager.4
 * JD-Core Version:    0.7.0.1
 */
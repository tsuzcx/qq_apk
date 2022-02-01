package com.tencent.mobileqq.theme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class DarkModeManager$1
  implements DialogInterface.OnClickListener
{
  DarkModeManager$1(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DarkModeManager.a("0X800A5B5");
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("showDarkModeTips systemDarMode  = ");
      paramDialogInterface.append(this.a);
      QLog.d("DarkModeManager", 2, paramDialogInterface.toString());
    }
    DarkModeManager.a(true);
    DarkModeManager.a(this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager.1
 * JD-Core Version:    0.7.0.1
 */
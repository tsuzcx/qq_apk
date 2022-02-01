package com.tencent.mobileqq.theme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class DarkModeManager$5
  implements DialogInterface.OnClickListener
{
  DarkModeManager$5(DarkModeManager.ActionResult paramActionResult) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DarkModeManager.a("0X800A5CA");
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.onCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager.5
 * JD-Core Version:    0.7.0.1
 */
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
    if (this.a != null) {
      this.a.onCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager.5
 * JD-Core Version:    0.7.0.1
 */
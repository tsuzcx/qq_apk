package com.tencent.mobileqq.theme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;

final class DarkModeManager$2
  implements DialogInterface.OnClickListener
{
  DarkModeManager$2(String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = DarkModeManager.a();
    if (paramDialogInterface != null) {
      ((ThemeHandler)paramDialogInterface.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).a(this.a, this.b);
    }
    DarkModeManager.a("0X800A5B6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager.2
 * JD-Core Version:    0.7.0.1
 */
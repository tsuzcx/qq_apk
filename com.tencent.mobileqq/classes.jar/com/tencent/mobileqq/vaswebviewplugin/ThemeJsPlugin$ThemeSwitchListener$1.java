package com.tencent.mobileqq.vaswebviewplugin;

import baoq;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.theme.SkinEngine;

class ThemeJsPlugin$ThemeSwitchListener$1
  implements Runnable
{
  ThemeJsPlugin$ThemeSwitchListener$1(ThemeJsPlugin.ThemeSwitchListener paramThemeSwitchListener, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$1.this$0.mThemeSwitchManager.a();
    SkinEngine.getInstances().setSkinRootPath(this.this$1.this$0.app.getApp(), this.val$themeUnzipPath);
    ThemeUtil.setCurrentThemeIdVersion(this.this$1.this$0.app, this.val$newThemeId, "20000000");
    this.this$1.postSwitch(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.ThemeSwitchListener.1
 * JD-Core Version:    0.7.0.1
 */
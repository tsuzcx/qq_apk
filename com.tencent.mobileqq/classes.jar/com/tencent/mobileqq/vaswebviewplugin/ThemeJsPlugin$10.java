package com.tencent.mobileqq.vaswebviewplugin;

import behm;
import beih;
import beio;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeDiyModule;

class ThemeJsPlugin$10
  implements behm
{
  ThemeJsPlugin$10(ThemeJsPlugin paramThemeJsPlugin, String paramString) {}
  
  public void onCancel()
  {
    if (!ThemeUtil.isFixTheme(this.val$themeId)) {
      beio.a(this.this$0.app, this.val$themeId, "20000000");
    }
    new ThemeJsPlugin.ThemeSwitchListener(this.this$0, this.val$themeId, false).postSwitch(0);
  }
  
  public void onConfirm()
  {
    ThemeJsPlugin.access$300(this.this$0).setSpThemeBackground();
    beih.a(this.val$themeId, new ThemeJsPlugin.ThemeSwitchListener(this.this$0, this.val$themeId, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */
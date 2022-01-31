package com.tencent.mobileqq.theme;

import axmb;
import bcdp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ThemeSwitcher$1
  implements Runnable
{
  ThemeSwitcher$1(ThemeSwitcher paramThemeSwitcher) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.a();
    if (localQQAppInterface == null) {
      return;
    }
    int i;
    if (!ThemeSwitcher.a(this.this$0).a().b())
    {
      QLog.e("ThemeSwitcher", 1, "unzip diy: " + ThemeSwitcher.a(this.this$0).d());
      bcdp.a(localQQAppInterface.getApp(), "999_540", ThemeSwitcher.a(this.this$0).d());
      i = ThemeUtil.getFileNumInFile(new File(ThemeSwitcher.a(this.this$0).d()));
      ThemeUtil.ThemeInfo localThemeInfo = new ThemeUtil.ThemeInfo();
      if (i <= 0) {
        break label161;
      }
      localThemeInfo.status = "5";
      localThemeInfo.fileNum = i;
      localThemeInfo.themeId = "999";
      localThemeInfo.zipVer = 20000000;
      localThemeInfo.version = "20000000";
      ThemeUtil.setThemeInfo(localQQAppInterface.getApp(), localThemeInfo);
    }
    for (;;)
    {
      ThemeSwitcher.a(this.this$0);
      return;
      label161:
      QLog.e("ThemeSwitcher", 1, "error diy fileNum: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitcher.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.util.VasFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class ThemeSwitcher$1
  implements Runnable
{
  ThemeSwitcher$1(ThemeSwitcher paramThemeSwitcher) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a();
    if (localObject1 == null) {
      return;
    }
    if (!ThemeSwitcher.a(this.this$0).a().i())
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unzip diy: ");
      ((StringBuilder)localObject2).append(ThemeSwitcher.a(this.this$0).g());
      QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject2).toString());
      VasFileUtils.a(((AppRuntime)localObject1).getApp(), "999_540", ThemeSwitcher.a(this.this$0).g());
      int i = ThemeUtil.getFileNumInFile(new File(ThemeSwitcher.a(this.this$0).g()));
      localObject2 = new ThemeUtil.ThemeInfo();
      if (i > 0)
      {
        ((ThemeUtil.ThemeInfo)localObject2).status = "5";
        ((ThemeUtil.ThemeInfo)localObject2).fileNum = i;
        ((ThemeUtil.ThemeInfo)localObject2).themeId = "999";
        ((ThemeUtil.ThemeInfo)localObject2).zipVer = 20000000;
        ((ThemeUtil.ThemeInfo)localObject2).version = "20000000";
        ThemeUtil.setThemeInfo(((AppRuntime)localObject1).getApp(), (ThemeUtil.ThemeInfo)localObject2);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("error diy fileNum: ");
        ((StringBuilder)localObject1).append(i);
        QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject1).toString());
      }
    }
    ThemeSwitcher.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeSwitcher.1
 * JD-Core Version:    0.7.0.1
 */
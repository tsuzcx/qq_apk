package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.theme.DarkModeManager.ActionResult;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;

class VasThemeHippyHelper$2
  implements DarkModeManager.ActionResult
{
  VasThemeHippyHelper$2(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString, VasThemeHippyHelper.ThemeSwitchListener paramThemeSwitchListener) {}
  
  public void onCancel()
  {
    if (!ThemeUtil.isFixTheme(this.a)) {
      ThemeSwitchUtil.a(this.c.d, this.a, "20000000");
    }
    this.b.postSwitch(0);
  }
  
  public void onConfirm()
  {
    VasThemeHippyHelper.a(this.c).b();
    ThemeSwitcher.a(this.a, "200", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.2
 * JD-Core Version:    0.7.0.1
 */
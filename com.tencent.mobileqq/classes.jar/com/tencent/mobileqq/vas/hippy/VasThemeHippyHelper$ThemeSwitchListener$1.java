package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.theme.SkinEngine;

class VasThemeHippyHelper$ThemeSwitchListener$1
  implements Runnable
{
  VasThemeHippyHelper$ThemeSwitchListener$1(VasThemeHippyHelper.ThemeSwitchListener paramThemeSwitchListener, ThemeLocator paramThemeLocator) {}
  
  public void run()
  {
    VasUtil.a().getThemeSwitchManager().doScreenShot();
    SkinEngine.getInstances().setSkinRootPath(this.b.this$0.c, this.a.g());
    ThemeUtil.setCurrentThemeIdVersion(this.b.this$0.d, this.a.d(), "20000000");
    this.b.postSwitch(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.ThemeSwitchListener.1
 * JD-Core Version:    0.7.0.1
 */
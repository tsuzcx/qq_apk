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
    SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper$ThemeSwitchListener.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.d());
    ThemeUtil.setCurrentThemeIdVersion(this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper$ThemeSwitchListener.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(), "20000000");
    this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper$ThemeSwitchListener.postSwitch(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.ThemeSwitchListener.1
 * JD-Core Version:    0.7.0.1
 */
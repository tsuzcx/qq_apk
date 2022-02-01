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
    if (!ThemeUtil.isFixTheme(this.jdField_a_of_type_JavaLangString)) {
      ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper.a, this.jdField_a_of_type_JavaLangString, "20000000");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper$ThemeSwitchListener.postSwitch(0);
  }
  
  public void onConfirm()
  {
    VasThemeHippyHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper).a();
    ThemeSwitcher.a(this.jdField_a_of_type_JavaLangString, "200", this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper$ThemeSwitchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.2
 * JD-Core Version:    0.7.0.1
 */
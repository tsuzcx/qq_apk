package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mtt.hippy.modules.Promise;

class VasThemeHippyHelper$VasThemeStyleCallBack
  implements ThemeDiyStyleLogic.StyleCallBack
{
  ThemeUtil.ThemeInfo jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeUtil$ThemeInfo;
  Promise jdField_a_of_type_ComTencentMttHippyModulesPromise;
  String jdField_a_of_type_JavaLangString;
  
  public VasThemeHippyHelper$VasThemeStyleCallBack(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString1, boolean paramBoolean, String paramString2, ThemeUtil.ThemeInfo paramThemeInfo, Promise paramPromise)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeUtil$ThemeInfo = paramThemeInfo;
    this.jdField_a_of_type_ComTencentMttHippyModulesPromise = paramPromise;
  }
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = new Bundle();
    paramResData.putString("themeId", paramBundle.getString("themeId"));
    if (paramInt2 == 4) {
      paramInt1 = 0;
    } else {
      paramInt1 = -2;
    }
    paramResData.putInt("themeStatus", paramInt1);
    paramBundle.putBundle("response", paramResData);
    this.jdField_a_of_type_ComTencentMobileqqVasHippyVasThemeHippyHelper.a(paramBundle, this.jdField_a_of_type_ComTencentMttHippyModulesPromise, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeUtil$ThemeInfo);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.VasThemeStyleCallBack
 * JD-Core Version:    0.7.0.1
 */
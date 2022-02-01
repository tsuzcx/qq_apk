package com.tencent.mobileqq.vas.theme.diy;

import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import org.json.JSONObject;

class ThemeDiyModule$1
  implements QueryCallback<ThemeLocator>
{
  ThemeDiyModule$1(ThemeDiyModule paramThemeDiyModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a(ThemeLocator paramThemeLocator)
  {
    if ((paramThemeLocator != null) && (paramThemeLocator.b()))
    {
      if (ThemeDiyModule.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule) != null) {
        ThemeDiyModule.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule).diyThemeSetup(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_JavaLangString);
      }
    }
    else if (ThemeDiyModule.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule) != null) {
      ThemeDiyModule.a(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule).startDownload(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.1
 * JD-Core Version:    0.7.0.1
 */
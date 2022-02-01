package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.VasApngUtil;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;

final class ThemeBackground$1
  implements Function0<Drawable>
{
  ThemeBackground$1(Context paramContext, AppRuntime paramAppRuntime, ThemeBackground paramThemeBackground, String paramString) {}
  
  public Drawable a()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846235);
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    return VasApngUtil.getApngDrawable(localAppRuntime, str1, "-setting-", localDrawable, new int[] { 1 }, str2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.1
 * JD-Core Version:    0.7.0.1
 */
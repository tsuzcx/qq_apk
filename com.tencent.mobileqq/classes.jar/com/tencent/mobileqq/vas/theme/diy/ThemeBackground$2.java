package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.vas.VasApngUtil;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;

final class ThemeBackground$2
  implements Function0<Drawable>
{
  ThemeBackground$2(boolean paramBoolean, Context paramContext, AppRuntime paramAppRuntime, ThemeBackground paramThemeBackground, String paramString) {}
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_Boolean) {
      ThemeBackground.b.c();
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_rect", true);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838740);
    return VasApngUtil.getApngDrawable(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_JavaLangString, "-conversation-", localDrawable, VasApngUtil.converstionTag, this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.2
 * JD-Core Version:    0.7.0.1
 */
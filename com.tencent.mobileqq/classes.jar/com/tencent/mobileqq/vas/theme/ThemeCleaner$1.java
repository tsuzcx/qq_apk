package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import java.io.File;
import mqq.app.AppRuntime;

final class ThemeCleaner$1
  implements Runnable
{
  ThemeCleaner$1(String paramString, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ThemeCleaner.a(new File(new ThemeLocator().a(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeCleaner.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRoute;

class ThemeUtil$2$1
  implements Runnable
{
  ThemeUtil$2$1(ThemeUtil.2 param2) {}
  
  public void run()
  {
    ThemeUtil.c();
    ((IThemeHandler)QRoute.api(IThemeHandler.class)).sendThemeAuth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil.2.1
 * JD-Core Version:    0.7.0.1
 */
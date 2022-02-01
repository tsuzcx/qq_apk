package com.tencent.mobileqq.theme;

import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.Window;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class ThemeNavigationBarUtil
{
  private static int a = 2147483647;
  
  public static void a(@NonNull Window paramWindow)
  {
    for (;;)
    {
      boolean bool2;
      int i;
      try
      {
        boolean bool1 = TripleGraySwitchUtil.b(MobileQQ.getMobileQQ(), "KEY_DISABLE_NAVIGATION_BAR", true);
        QLog.d("ThemeNavigationBarUtil", 2, new Object[] { "[NavigationBar] enableNavigationBarColor =", Boolean.valueOf(bool1) });
        if (bool1) {
          return;
        }
        if ((!ImmersiveUtils.isVivoAndLOLLIPOP()) && (!SystemUtil.g()))
        {
          if ((a == 2147483647) && (Build.VERSION.SDK_INT >= 21)) {
            a = paramWindow.getNavigationBarColor();
          }
          bool1 = QQTheme.isLastThemeIsNight();
          bool2 = QQTheme.isNowThemeIsNight();
          QLog.d("ThemeNavigationBarUtil", 2, new Object[] { "[NavigationBar] setNavigationBarColor sLightThemeNavigationBarColor=", Integer.valueOf(a), " isCurNightMode=", Boolean.valueOf(bool2), " isLastNightMode=", Boolean.valueOf(bool1) });
          if (bool2) {
            break label173;
          }
          if (bool1)
          {
            break label173;
            i = a;
            a(paramWindow, i);
          }
        }
        else
        {
          QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] not support machine");
          return;
        }
      }
      catch (Throwable paramWindow)
      {
        QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] setNavigationBarColor throwable=", paramWindow);
      }
      return;
      label173:
      if (bool2) {
        i = -16777216;
      }
    }
  }
  
  public static void a(@NonNull Window paramWindow, @ColorInt int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      QLog.d("ThemeNavigationBarUtil", 1, new Object[] { "[NavigationBar] setImmersiveNavigationBarColor activity=", paramWindow, " color=", Integer.valueOf(paramInt) });
      try
      {
        paramWindow.addFlags(-2147483648);
        paramWindow.setNavigationBarColor(paramInt);
        return;
      }
      catch (Throwable paramWindow)
      {
        QLog.d("ThemeNavigationBarUtil", 1, "[NavigationBar] setNavigationBarColor =", paramWindow);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeNavigationBarUtil
 * JD-Core Version:    0.7.0.1
 */
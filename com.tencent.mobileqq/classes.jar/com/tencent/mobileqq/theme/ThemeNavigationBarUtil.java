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
    try
    {
      bool1 = TripleGraySwitchUtil.b(MobileQQ.getMobileQQ(), "KEY_DISABLE_NAVIGATION_BAR", true);
      QLog.d("ThemeNavigationBarUtil", 2, new Object[] { "[NavigationBar] enableNavigationBarColor =", Boolean.valueOf(bool1) });
      if (bool1) {
        return;
      }
      if ((ImmersiveUtils.isVivoAndLOLLIPOP()) || (SystemUtil.d()))
      {
        QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] not support machine");
        return;
      }
    }
    catch (Throwable paramWindow)
    {
      QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] setNavigationBarColor throwable=", paramWindow);
      return;
    }
    if ((a == 2147483647) && (Build.VERSION.SDK_INT >= 21)) {
      a = paramWindow.getNavigationBarColor();
    }
    boolean bool1 = QQTheme.c();
    boolean bool2 = QQTheme.a();
    QLog.d("ThemeNavigationBarUtil", 2, new Object[] { "[NavigationBar] setNavigationBarColor sLightThemeNavigationBarColor=", Integer.valueOf(a), " isCurNightMode=", Boolean.valueOf(bool2), " isLastNightMode=", Boolean.valueOf(bool1) });
    if (!bool2) {
      if (bool1) {
        break label174;
      }
    }
    for (;;)
    {
      a(paramWindow, i);
      return;
      label174:
      do
      {
        i = a;
        break;
        return;
      } while (!bool2);
      int i = -16777216;
    }
  }
  
  public static void a(@NonNull Window paramWindow, @ColorInt int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      QLog.d("ThemeNavigationBarUtil", 1, new Object[] { "[NavigationBar] setImmersiveNavigationBarColor activity=", paramWindow, " color=", Integer.valueOf(paramInt) });
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeNavigationBarUtil
 * JD-Core Version:    0.7.0.1
 */
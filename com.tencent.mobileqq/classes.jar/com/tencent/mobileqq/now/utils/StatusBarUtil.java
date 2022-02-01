package com.tencent.mobileqq.now.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class StatusBarUtil
{
  public static int a(Activity paramActivity)
  {
    return ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity = new SystemBarCompact(paramActivity, true, -1);
    paramActivity.init();
    paramActivity.setStatusBarColor(paramInt);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if (ThemeUtil.isCustomTheme(false))
    {
      a(paramActivity, 0);
      return;
    }
    if (paramBoolean)
    {
      a(paramActivity, -16777216);
      a(paramActivity, false);
      return;
    }
    if (a(paramActivity, true))
    {
      a(paramActivity, -1);
      return;
    }
    a(paramActivity, -2368549);
  }
  
  public static boolean a()
  {
    return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public static boolean a(Activity paramActivity, boolean paramBoolean)
  {
    int i = 9216;
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.b())) {
      if (paramBoolean) {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      }
    }
    do
    {
      return paramBoolean;
      i = 1280;
      break;
      if (!ImmersiveUtils.supportStatusBarDarkMode()) {
        break label101;
      }
      ImmersiveUtils.setStatusBarDarkMode(paramActivity.getWindow(), paramBoolean);
    } while ((Build.VERSION.SDK_INT < 23) || (!SystemUtil.b()));
    if (paramBoolean) {}
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return paramBoolean;
      i = 1280;
    }
    label101:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.utils.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil
{
  public static boolean FlymeSetStatusBarLightMode(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null) {}
    try
    {
      localLayoutParams = paramWindow.getAttributes();
      Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
      localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
      localField1.setAccessible(true);
      localField2.setAccessible(true);
      i = localField1.getInt(null);
      j = localField2.getInt(localLayoutParams);
      if (!paramBoolean) {
        break label88;
      }
      i = j | i;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams;
        Field localField2;
        int j;
        continue;
        int i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    localField2.setInt(localLayoutParams, i);
    paramWindow.setAttributes(localLayoutParams);
    return true;
    return false;
  }
  
  public static boolean MIUISetStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    Window localWindow = paramActivity.getWindow();
    boolean bool = true;
    Object localObject;
    if (localWindow != null) {
      localObject = localWindow.getClass();
    }
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (paramBoolean) {
        ((Method)localObject).invoke(localWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      } else {
        ((Method)localObject).invoke(localWindow, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (paramBoolean) {
              return true;
            }
            paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
            return true;
            bool = false;
          }
          return bool;
        }
        catch (Exception paramActivity) {}
        paramActivity = paramActivity;
      }
    }
  }
  
  public static int StatusBarDarkMode(Activity paramActivity)
  {
    int k = Build.VERSION.SDK_INT;
    int j = 0;
    int i = j;
    if (k >= 19)
    {
      if (MIUISetStatusBarLightMode(paramActivity, false)) {
        return 1;
      }
      if (FlymeSetStatusBarLightMode(paramActivity.getWindow(), false)) {
        return 2;
      }
      i = j;
      if (Build.VERSION.SDK_INT >= 23) {
        i = 3;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */
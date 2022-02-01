package com.tencent.timi.game.utils;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil
{
  public static void a(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
      WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
      if (Build.VERSION.SDK_INT >= 28) {
        localLayoutParams.layoutInDisplayCutoutMode = 1;
      }
      paramWindow.setAttributes(localLayoutParams);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramWindow.addFlags(67108864);
    }
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null) {}
    for (;;)
    {
      int j;
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        i = localField1.getInt(null);
        j = localField2.getInt(localLayoutParams);
        if (!paramBoolean) {
          break label93;
        }
        i = j | i;
        localField2.setInt(localLayoutParams, i);
        paramWindow.setAttributes(localLayoutParams);
        return true;
      }
      catch (Exception paramWindow)
      {
        Logger.b("StatusBarUtil_", "", paramWindow);
      }
      return false;
      label93:
      int i = (i ^ 0xFFFFFFFF) & j;
    }
  }
  
  public static int b(Window paramWindow)
  {
    int k = Build.VERSION.SDK_INT;
    int i = 0;
    int j = 0;
    if (k >= 19)
    {
      if (b(paramWindow, true))
      {
        i = 1;
      }
      else
      {
        i = j;
        if (a(paramWindow, true)) {
          i = 2;
        }
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWindow.getDecorView().setSystemUiVisibility(9216);
        i = 3;
      }
    }
    return i;
  }
  
  public static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      Object localObject = paramWindow.getClass();
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return true;
        }
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        return true;
      }
      catch (Exception paramWindow)
      {
        Logger.b("StatusBarUtil_", "", paramWindow);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */
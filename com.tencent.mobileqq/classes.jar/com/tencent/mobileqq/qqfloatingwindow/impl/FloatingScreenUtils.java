package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FloatingScreenUtils
{
  public static int a = 480;
  private static int b;
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static boolean a(Context paramContext)
  {
    if (b == 0) {
      if ((Build.VERSION.SDK_INT >= 26) && (Build.VERSION.SDK_INT < 28) && (LiuHaiUtils.c(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
        }
        b = 1;
      }
      else
      {
        b = 2;
      }
    }
    return b == 1;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool1 = false;
    int i;
    label156:
    do
    {
      Object localObject;
      try
      {
        localObject = paramContext.getResources();
        i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
        boolean bool2;
        if (i > 0)
        {
          bool2 = ((Resources)localObject).getBoolean(i);
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
        }
        try
        {
          i = Build.VERSION.SDK_INT;
          if (i < 21) {
            i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
          } else {
            i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
          }
        }
        catch (Exception paramContext)
        {
          break label156;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
        {
          paramContext = Class.forName("android.os.SystemProperties");
          paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
          if ("1".equals(paramContext)) {
            return false;
          }
          bool2 = "0".equals(paramContext);
          if (bool2) {
            return true;
          }
        }
        return bool1;
      }
      catch (Exception paramContext) {}
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkNavigationBarShow error: ");
        ((StringBuilder)localObject).append(paramContext.toString());
        QLog.e("FloatingScreenUtils", 2, ((StringBuilder)localObject).toString());
      }
      return bool1;
    } while (i != 1);
    return false;
  }
  
  public static int c(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i;
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
      }
      else
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        try
        {
          i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        }
        catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
        QLog.e("FloatingScreenUtils", 2, paramContext.getMessage());
        return -1;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      QLog.e("FloatingScreenUtils", 2, paramContext.getMessage());
      return -1;
    }
    return i;
  }
  
  @TargetApi(13)
  public static int d(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      a = localPoint.y;
    }
    else
    {
      a = paramContext.getDefaultDisplay().getHeight();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class ScreenUtil
{
  private static float DENSITY = 0.0F;
  public static int SCREEN_HIGHT = 0;
  public static int SCREEN_WIDTH = 0;
  private static final String TAG = "ScreenUtil";
  private static Context context = MobileQQ.sMobileQQ.getApplicationContext();
  
  static
  {
    SCREEN_WIDTH = 320;
    SCREEN_HIGHT = 480;
    Display localDisplay = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    if (localDisplay != null)
    {
      SCREEN_WIDTH = localDisplay.getWidth();
      SCREEN_HIGHT = localDisplay.getHeight();
    }
  }
  
  public static boolean checkDeviceHasNavigationBar(Context paramContext)
  {
    if ((Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")) || (Build.MODEL.contains("Redmi K20 Pro"))) && (Build.VERSION.SDK_INT >= 21)) {
      if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return true;
        return false;
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
      } while (getInstantScreenHeight(paramContext) != getRealHeight(paramContext));
      return false;
      bool1 = ViewConfiguration.get(paramContext).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean checkNavigationBarShow(Context paramContext)
  {
    boolean bool2;
    for (;;)
    {
      try
      {
        Resources localResources = paramContext.getResources();
        i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (i <= 0) {
          continue;
        }
        bool1 = localResources.getBoolean(i);
      }
      catch (Exception paramContext)
      {
        int i;
        boolean bool1 = false;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          return bool2;
        }
        QLog.e("ScreenUtil", 2, "checkNavigationBarShow error: " + paramContext.toString());
        return bool1;
        return bool1;
        bool1 = false;
        continue;
        if (i != 1) {
          continue;
        }
        bool2 = false;
      }
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
        } else {
          i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
        }
      }
      catch (Exception paramContext) {}
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
    return bool2;
  }
  
  public static int dip2px(float paramFloat)
  {
    if (DENSITY == 0.0F) {
      DENSITY = context.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + DENSITY);
    }
    return (int)(DENSITY * paramFloat + 0.5F);
  }
  
  public static float getDensity()
  {
    if (DENSITY == 0.0F) {
      DENSITY = context.getResources().getDisplayMetrics().density;
    }
    return DENSITY;
  }
  
  @TargetApi(13)
  public static int getInstantScreenHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (SCREEN_HIGHT = localPoint.y;; SCREEN_HIGHT = paramContext.getDefaultDisplay().getHeight()) {
      return SCREEN_HIGHT;
    }
  }
  
  public static int getInstantScreenWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    paramContext.getDefaultDisplay().getSize(localPoint);
    SCREEN_WIDTH = localPoint.x;
    return SCREEN_WIDTH;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i != 0) {
      return paramContext.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int getRealHeight(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static int getRealWidth(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).widthPixels;
      }
      localObject = Display.class.getMethod("getRawWidth", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        SLog.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        SLog.f("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static boolean isNavigationBarExist(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return false;
      ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        int j = localViewGroup.getChildAt(i).getId();
        if ((j != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(j)))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void updateCache()
  {
    WindowManager localWindowManager = (WindowManager)context.getSystemService("window");
    SCREEN_WIDTH = localWindowManager.getDefaultDisplay().getWidth();
    SCREEN_HIGHT = localWindowManager.getDefaultDisplay().getHeight();
    DENSITY = context.getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("systemDpiChanged", 2, "mofity width:" + SCREEN_WIDTH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */
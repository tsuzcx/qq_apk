package com.tencent.mobileqq.flashshow.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FSDisplayUtils
{
  private static boolean a = true;
  private static int b = -1;
  private static String c;
  
  public static int a(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      int i;
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
        catch (InvocationTargetException paramContext)
        {
          QLog.e("FSDisplayUtils", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalAccessException paramContext)
        {
          QLog.e("FSDisplayUtils", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalArgumentException paramContext)
        {
          QLog.e("FSDisplayUtils", 2, paramContext.getMessage());
          return -1;
        }
      }
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      QLog.e("FSDisplayUtils", 2, paramContext.getMessage());
      return -1;
    }
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier(paramString, "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static boolean a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()))) && (localViewGroup.getChildAt(i).getHeight() != 0)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if ((Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")) || (Build.MODEL.contains("Redmi K20 Pro"))) && (Build.VERSION.SDK_INT >= 21)) {
      return Settings.Global.getInt(FSTransUtils.f().getContentResolver(), "force_fsg_nav_bar", 0) == 0;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return d(paramContext) != a(paramContext);
    }
    boolean bool1 = ViewConfiguration.get(paramContext).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    return (!bool1) && (!bool2);
  }
  
  public static int c(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (a) {
        paramContext = "navigation_bar_height";
      } else {
        paramContext = "navigation_bar_height_landscape";
      }
      return a(localResources, paramContext);
    }
    return 0;
  }
  
  @TargetApi(13)
  public static int d(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    paramContext.getDefaultDisplay().getSize(localPoint);
    return localPoint.y;
  }
  
  public static boolean e(Context paramContext)
  {
    int i = b;
    if (i != -1) {
      return i == 1;
    }
    Resources localResources = paramContext.getResources();
    i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if (!"1".equals(c))
      {
        if (!"0".equals(c)) {
          break label99;
        }
        bool = true;
        break label99;
      }
    }
    else if (Build.VERSION.SDK_INT >= 14)
    {
      bool = ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
      break label99;
    }
    boolean bool = false;
    label99:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasNavbar=");
      paramContext.append(bool);
      QLog.d("XPanelContainer", 2, paramContext.toString());
    }
    if (bool)
    {
      b = 1;
      return bool;
    }
    b = 0;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSDisplayUtils
 * JD-Core Version:    0.7.0.1
 */
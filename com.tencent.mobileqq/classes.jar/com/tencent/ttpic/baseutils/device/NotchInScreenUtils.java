package com.tencent.ttpic.baseutils.device;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NotchInScreenUtils
{
  public static final int NOTCH_IN_SCREEN_VIVO = 32;
  public static final int ROUNDED_IN_SCREEN_VIVO = 8;
  
  public static int getNotchHeightHw(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    paramContext = paramContext.getClassLoader();
    try
    {
      paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext[1];
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static String getSystemProperties(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (NoSuchMethodException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (InvocationTargetException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static boolean hasNotchInScreen(Context paramContext)
  {
    boolean bool2 = false;
    if ((hasNotchInScreenHw(paramContext)) || (hasNotchInScreenAtOppo(paramContext)) || (hasNotchInScreenAtVivo(paramContext)) || (hasNotchInScreenAtXM())) {}
    for (boolean bool1 = true; Build.VERSION.SDK_INT >= 28; bool1 = false)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!hasNotchInScreenForP(paramContext)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    return bool1;
  }
  
  public static boolean hasNotchInScreenAtOppo(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static boolean hasNotchInScreenAtVivo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      LogUtils.e(paramContext);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      LogUtils.e(paramContext);
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      LogUtils.e(paramContext);
      return false;
    }
    finally {}
    return false;
  }
  
  public static boolean hasNotchInScreenAtXM()
  {
    return "1".equals(getSystemProperties("ro.miui.notch"));
  }
  
  @RequiresApi(api=28)
  public static boolean hasNotchInScreenForP(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getWindow().getDecorView().getRootWindowInsets();
      if (paramContext != null) {
        break label27;
      }
    }
    label27:
    do
    {
      return false;
      paramContext = paramContext.getDisplayCutout();
    } while ((paramContext == null) || (paramContext.getBoundingRects() == null));
    return true;
  }
  
  public static boolean hasNotchInScreenHw(Context paramContext)
  {
    paramContext = paramContext.getClassLoader();
    try
    {
      paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      LogUtils.e(paramContext);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      LogUtils.e(paramContext);
      return false;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return false;
  }
  
  public static void setSystemProperties(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      localClass.getMethod("set", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  @RequiresApi(api=28)
  public int getNotchHeightForP(Window paramWindow)
  {
    paramWindow = paramWindow.getDecorView().getRootWindowInsets();
    if (paramWindow == null) {}
    do
    {
      return 0;
      paramWindow = paramWindow.getDisplayCutout();
    } while ((paramWindow == null) || (paramWindow.getBoundingRects() == null));
    return paramWindow.getSafeInsetTop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.NotchInScreenUtils
 * JD-Core Version:    0.7.0.1
 */
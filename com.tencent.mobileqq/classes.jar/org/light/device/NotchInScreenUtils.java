package org.light.device;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.light.utils.LightLogUtil;

public class NotchInScreenUtils
{
  public static final int NOTCH_IN_SCREEN_VIVO = 32;
  public static final int ROUNDED_IN_SCREEN_VIVO = 8;
  
  public static int getNotchHeightHw(Context paramContext)
  {
    paramContext = paramContext.getClassLoader();
    try
    {
      paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    paramContext = new int[] { 0, 0 };
    return paramContext[1];
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static String getSystemProperties(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
      return paramString;
    }
    catch (InvocationTargetException paramString)
    {
      paramString.printStackTrace();
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    catch (NoSuchMethodException paramString)
    {
      paramString.printStackTrace();
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static boolean hasNotchInScreen(Context paramContext)
  {
    boolean bool1;
    if ((!hasNotchInScreenHw(paramContext)) && (!hasNotchInScreenAtOppo(paramContext)) && (!hasNotchInScreenAtVivo(paramContext)) && (!hasNotchInScreenAtXM())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!bool1) && (!hasNotchInScreenForP(paramContext))) {
        return false;
      }
      bool2 = true;
    }
    return bool2;
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
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      LightLogUtil.e(paramContext);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      LightLogUtil.e(paramContext);
      return false;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      LightLogUtil.e(paramContext);
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
    boolean bool3 = paramContext instanceof Activity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramContext = ((Activity)paramContext).getWindow().getDecorView().getRootWindowInsets();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getDisplayCutout();
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.getBoundingRects() != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      LightLogUtil.e(paramContext);
      return false;
    }
    catch (ClassNotFoundException paramContext)
    {
      LightLogUtil.e(paramContext);
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
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  @RequiresApi(api=28)
  public int getNotchHeightForP(Window paramWindow)
  {
    paramWindow = paramWindow.getDecorView().getRootWindowInsets();
    if (paramWindow == null) {
      return 0;
    }
    paramWindow = paramWindow.getDisplayCutout();
    if (paramWindow != null)
    {
      if (paramWindow.getBoundingRects() == null) {
        return 0;
      }
      return paramWindow.getSafeInsetTop();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.device.NotchInScreenUtils
 * JD-Core Version:    0.7.0.1
 */
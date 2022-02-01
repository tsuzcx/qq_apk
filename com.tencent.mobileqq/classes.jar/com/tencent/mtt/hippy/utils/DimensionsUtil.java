package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DimensionsUtil
{
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  private static int STATUS_BAR_HEIGHT = -1;
  private static int hasNavigationBar = -1;
  
  private static boolean checkNavigationBarShow(@NonNull Context paramContext)
  {
    int i = hasNavigationBar;
    int j = 1;
    if (i != -1) {
      return i == 1;
    }
    Object localObject = paramContext.getResources();
    i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1;
    if (i > 0) {
      bool1 = ((Resources)localObject).getBoolean(i);
    } else {
      bool1 = false;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
      if (Build.VERSION.SDK_INT < 21) {
        i = Settings.System.getInt(paramContext.getContentResolver(), getNavigationBarIsMinKeyName(), 0);
      } else {
        i = Settings.Global.getInt(paramContext.getContentResolver(), getNavigationBarIsMinKeyName(), 0);
      }
      if ((!"1".equals(localObject)) && (1 != i))
      {
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          bool1 = true;
        }
      }
      else
      {
        bool1 = false;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    if (bool1) {
      i = j;
    } else {
      i = 0;
    }
    hasNavigationBar = i;
    return bool1;
  }
  
  public static HippyMap getDimensions(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return null;
    }
    DisplayMetrics localDisplayMetrics2 = paramContext.getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    localDisplayMetrics1.setTo(localDisplayMetrics2);
    Object localObject1 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    if (Build.VERSION.SDK_INT >= 17) {
      ((Display)localObject1).getRealMetrics(localDisplayMetrics1);
    } else {
      j = 0;
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject2 = Display.class.getMethod("getRawHeight", new Class[0]);
        localObject3 = Display.class.getMethod("getRawWidth", new Class[0]).invoke(localObject1, new Object[0]);
        if (localObject3 == null) {
          break label640;
        }
        i = ((Integer)localObject3).intValue();
        localDisplayMetrics1.widthPixels = i;
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        i = j;
        if (localObject1 != null) {
          i = ((Integer)localObject1).intValue();
        }
        localDisplayMetrics1.heightPixels = i;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      HippyMap localHippyMap = new HippyMap();
      if (STATUS_BAR_HEIGHT < 0)
      {
        try
        {
          localObject2 = Class.forName("com.android.internal.R$dimen");
          localObject3 = ((Class)localObject2).newInstance();
          i = Integer.parseInt(((Class)localObject2).getField("status_bar_height").get(localObject3).toString());
          STATUS_BAR_HEIGHT = paramContext.getResources().getDimensionPixelSize(i);
        }
        catch (Exception localException)
        {
          STATUS_BAR_HEIGHT = -1;
          localException.printStackTrace();
        }
        if (STATUS_BAR_HEIGHT < 1) {
          try
          {
            i = paramContext.getResources().getIdentifier("statebar_height", "dimen", paramContext.getPackageName());
            STATUS_BAR_HEIGHT = Math.round(paramContext.getResources().getDimension(i));
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getDimensions: ");
            ((StringBuilder)localObject3).append(localNotFoundException.getMessage());
            LogUtils.d("DimensionsUtil", ((StringBuilder)localObject3).toString());
          }
        }
      }
      int i = getNavigationBarHeight(paramContext);
      paramContext = new HippyMap();
      if (paramBoolean)
      {
        if (paramInt1 < 0) {
          paramInt1 = localDisplayMetrics1.widthPixels;
        }
        paramContext.pushInt("width", paramInt1);
        if (paramInt2 < 0) {
          paramInt2 = localDisplayMetrics1.heightPixels;
        }
        paramContext.pushInt("height", paramInt2);
        paramContext.pushDouble("scale", localDisplayMetrics1.density);
        paramContext.pushDouble("fontScale", localDisplayMetrics1.scaledDensity);
        paramInt1 = localDisplayMetrics1.densityDpi;
      }
      else
      {
        if (paramInt1 < 0) {
          paramInt1 = localDisplayMetrics2.widthPixels;
        }
        paramContext.pushInt("width", paramInt1);
        if (paramInt2 < 0) {
          paramInt2 = localDisplayMetrics2.heightPixels;
        }
        paramContext.pushInt("height", paramInt2);
        paramContext.pushDouble("scale", localDisplayMetrics2.density);
        paramContext.pushDouble("fontScale", localDisplayMetrics2.scaledDensity);
        paramInt1 = localDisplayMetrics2.densityDpi;
      }
      paramContext.pushDouble("densityDpi", paramInt1);
      paramContext.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
      double d = i;
      paramContext.pushDouble("navigationBarHeight", d);
      localHippyMap.pushMap("windowPhysicalPixels", paramContext);
      paramContext = new HippyMap();
      paramContext.pushInt("width", localDisplayMetrics1.widthPixels);
      paramContext.pushInt("height", localDisplayMetrics1.heightPixels);
      paramContext.pushDouble("scale", localDisplayMetrics1.density);
      paramContext.pushDouble("fontScale", localDisplayMetrics1.scaledDensity);
      paramContext.pushDouble("densityDpi", localDisplayMetrics1.densityDpi);
      paramContext.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
      paramContext.pushDouble("navigationBarHeight", d);
      localHippyMap.pushMap("screenPhysicalPixels", paramContext);
      return localHippyMap;
      label640:
      i = 0;
    }
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!checkNavigationBarShow(paramContext)) {
        return 0;
      }
      Object localObject;
      if (paramContext.getResources().getConfiguration().orientation != 2) {
        localObject = "navigation_bar_height";
      } else {
        localObject = "navigation_bar_height_landscape";
      }
      try
      {
        int i = paramContext.getResources().getIdentifier((String)localObject, "dimen", "android");
        i = paramContext.getResources().getDimensionPixelSize(i);
        return i;
      }
      catch (Resources.NotFoundException paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNavigationBarHeight: ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        LogUtils.d("DimensionsUtil", ((StringBuilder)localObject).toString());
      }
    }
    return 0;
  }
  
  private static String getNavigationBarIsMinKeyName()
  {
    String str = Build.BRAND;
    if (TextUtils.isEmpty(str)) {
      return "navigationbar_is_min";
    }
    if (str.equalsIgnoreCase("HUAWEI")) {
      return "navigationbar_is_min";
    }
    if (str.equalsIgnoreCase("XIAOMI")) {
      return "force_fsg_nav_bar";
    }
    if (str.equalsIgnoreCase("VIVO")) {
      return "navigation_gesture_on";
    }
    if (str.equalsIgnoreCase("OPPO")) {
      return "navigation_gesture_on";
    }
    return "navigationbar_is_min";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.DimensionsUtil
 * JD-Core Version:    0.7.0.1
 */
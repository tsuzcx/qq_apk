package com.tencent.mobileqq.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class DisplayUtils
{
  private static int a = -1;
  private static String b;
  private static boolean c = true;
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramFloat * (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    } else {
      i = 0;
    }
    int j = (int)paramContext.getResources().getDimension(17104896);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("launcher icon size = ");
      paramContext.append(i);
      paramContext.append(" , app icon size = ");
      paramContext.append(j);
      QLog.d("DisplayUtils", 2, paramContext.toString());
    }
    return Math.max(i, j);
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier(paramString, "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView != null) && (paramTextView.getText() != null) && (paramInt > 0))
    {
      TextPaint localTextPaint = paramTextView.getPaint();
      return new StaticLayout(paramTextView.getText().toString(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount();
    }
    return -1;
  }
  
  public static boolean b(Context paramContext)
  {
    int i = a;
    if (i != -1) {
      return i == 1;
    }
    Resources localResources = paramContext.getResources();
    i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if (!"1".equals(b))
      {
        if (!"0".equals(b)) {
          break label97;
        }
        bool = true;
        break label97;
      }
    }
    else if (Build.VERSION.SDK_INT >= 14)
    {
      bool = ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
      break label97;
    }
    boolean bool = false;
    label97:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasNavbar=");
      paramContext.append(bool);
      QLog.d("XPanelContainer", 2, paramContext.toString());
    }
    if (bool)
    {
      a = 1;
      return bool;
    }
    a = 0;
    return bool;
  }
  
  public static boolean c(@NonNull Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
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
      i = Build.VERSION.SDK_INT;
      if (i < 21) {
        i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      } else {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      }
      if ((!"1".equals(localObject)) && (1 != i))
      {
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
  
  public static int d(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (c) {
        paramContext = "navigation_bar_height";
      } else {
        paramContext = "navigation_bar_height_landscape";
      }
      return a(localResources, paramContext);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */
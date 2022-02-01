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
  private static int jdField_a_of_type_Int = -1;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = true;
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    }
    int j = (int)paramContext.getResources().getDimension(17104896);
    if (QLog.isColorLevel()) {
      QLog.d("DisplayUtils", 2, "launcher icon size = " + i + " , app icon size = " + j);
    }
    return Math.max(i, j);
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
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
  
  public static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(jdField_a_of_type_JavaLangString)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "hasNavbar=" + bool);
      }
      if (bool) {}
      for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
      {
        return bool;
        if (!"0".equals(jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label149;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label149:
      bool = false;
    }
  }
  
  public static int b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!jdField_a_of_type_Boolean) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = a(localResources, paramContext);
      return i;
    }
  }
  
  public static boolean b(@NonNull Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {}
    for (boolean bool1 = ((Resources)localObject).getBoolean(i);; bool1 = false)
    {
      try
      {
        localObject = Class.forName("android.os.SystemProperties");
        localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
        if (Build.VERSION.SDK_INT < 21) {}
        for (i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);; i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0))
        {
          if ("1".equals(localObject)) {
            break label146;
          }
          if (1 != i) {
            break;
          }
          break label146;
        }
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return bool1;
      }
      return bool1;
    }
    label146:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */
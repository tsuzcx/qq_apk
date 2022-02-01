package com.tencent.qqmini.sdk.launcher.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class OSUtils
{
  private static final String KEY_DISPLAY = "ro.build.display.id";
  private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
  private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
  
  public static String getEMUIVersion()
  {
    boolean bool = isEMUI();
    String str = "";
    if (bool) {
      str = getSystemProperty("ro.build.version.emui", "");
    }
    return str;
  }
  
  private static String getFlymeOSFlag()
  {
    return getSystemProperty("ro.build.display.id", "");
  }
  
  public static String getFlymeOSVersion()
  {
    boolean bool = isFlymeOS();
    String str = "";
    if (bool) {
      str = getSystemProperty("ro.build.display.id", "");
    }
    return str;
  }
  
  public static String getMIUIVersion()
  {
    boolean bool = isMIUI();
    String str = "";
    if (bool) {
      str = getSystemProperty("ro.miui.ui.version.name", "");
    }
    return str;
  }
  
  public static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean isEMUI()
  {
    return TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", "")) ^ true;
  }
  
  public static boolean isEMUI3_1()
  {
    String str = getEMUIVersion();
    return ("EmotionUI 3".equals(str)) || (str.contains("EmotionUI_3.1"));
  }
  
  public static boolean isFlymeOS()
  {
    return getFlymeOSFlag().toLowerCase().contains("flyme");
  }
  
  public static boolean isFlymeOS4More()
  {
    String str = getFlymeOSVersion();
    try
    {
      if (!str.isEmpty())
      {
        int i;
        if (str.toLowerCase().contains("os")) {
          i = Integer.valueOf(str.substring(9, 10)).intValue();
        } else {
          i = Integer.valueOf(str.substring(6, 7)).intValue();
        }
        if (i >= 4) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean isMIUI()
  {
    return TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", "")) ^ true;
  }
  
  public static boolean isMIUI6More()
  {
    String str = getMIUIVersion();
    try
    {
      if (!str.isEmpty())
      {
        int i = Integer.valueOf(str.substring(1)).intValue();
        if (i >= 6) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.OSUtils
 * JD-Core Version:    0.7.0.1
 */
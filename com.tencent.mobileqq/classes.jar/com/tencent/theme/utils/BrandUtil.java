package com.tencent.theme.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class BrandUtil
{
  public static boolean isEmui()
  {
    return (!TextUtils.isEmpty(PropertyUtils.getQuickly("ro.build.version.emui", null))) || (Build.BRAND.toLowerCase().contains("huawei")) || (Build.BRAND.toLowerCase().contains("honor"));
  }
  
  public static boolean isFlyme()
  {
    try
    {
      Build.class.getMethod("hasSmartBar", new Class[0]);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isGionee()
  {
    try
    {
      boolean bool = Build.BRAND.toLowerCase().contains("gionee");
      return bool;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  public static boolean isMiui()
  {
    String str = PropertyUtils.getQuickly("ro.miui.ui.version.name", null);
    return (!TextUtils.isEmpty(str)) && (str.contains("V"));
  }
  
  public static boolean isNubia()
  {
    try
    {
      boolean bool = Build.BRAND.toLowerCase().contains("nubia");
      return bool;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  public static boolean isOppo()
  {
    try
    {
      boolean bool = Build.BRAND.toLowerCase(Locale.US).contains("oppo");
      return bool;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public static boolean isVivo()
  {
    try
    {
      boolean bool = Build.BRAND.toLowerCase().contains("vivo");
      return bool;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.utils.BrandUtil
 * JD-Core Version:    0.7.0.1
 */
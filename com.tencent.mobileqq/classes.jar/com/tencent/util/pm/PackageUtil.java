package com.tencent.util.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class PackageUtil
{
  public static int a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString).versionCode;
  }
  
  public static PackageInfo b(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageInfo(paramString, 0);
  }
  
  @Nullable
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramString = paramContext.getApplicationInfo(paramString, 128);
      return (String)paramContext.getApplicationLabel(paramString);
    }
    catch (Exception paramContext)
    {
      QLog.e("PackageUtil", 1, "getApplicationName: failed. ", paramContext);
    }
    return null;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    try
    {
      b(paramContext, paramString);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label8:
      break label8;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.pm.PackageUtil
 * JD-Core Version:    0.7.0.1
 */
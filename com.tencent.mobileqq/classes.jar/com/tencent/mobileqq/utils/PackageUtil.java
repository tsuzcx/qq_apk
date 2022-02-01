package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class PackageUtil
{
  private static String a = "PackageUtil";
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString.trim(), 0);
      return paramContext != null;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, null, 0);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<--startAppWithPkgName pkgName=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",openid=");
        localStringBuilder.append(paramString2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      paramString1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1.trim());
      paramString1.setFlags(268435456);
      if ((paramString2 != null) && (paramString2.length() > 4)) {
        paramString1.putExtra("current_uin", paramString2);
      }
      paramString1.putExtra("platformId", "qq_m");
      paramString1.putExtra("big_brother_source_key", paramString3);
      paramString1.putExtra("key_callback_id", paramInt);
      paramContext.startActivity(paramString1);
      return true;
    }
    catch (Exception paramContext)
    {
      label133:
      break label133;
    }
    return false;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString.trim(), 0);
      if (paramContext == null) {
        return "0";
      }
      paramContext = paramContext.versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "0";
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString1, 64);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    if (paramContext == null) {
      return false;
    }
    if ((paramContext.signatures != null) && (paramContext.signatures.length > 0))
    {
      paramContext = paramContext.signatures;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        if (paramString2.equals(MD5.toMD5(paramContext[i].toByteArray()))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageInfo(paramString[i].trim(), 0);
        if (localPackageInfo == null) {
          localStringBuffer.append(0);
        } else {
          localStringBuffer.append(localPackageInfo.versionName);
        }
      }
      catch (Exception localException)
      {
        label86:
        break label86;
      }
      localStringBuffer.append(0);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String d(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      try
      {
        if (paramContext.getPackageInfo(paramString[i].trim(), 0) == null) {
          localStringBuffer.append(0);
        } else {
          localStringBuffer.append(1);
        }
      }
      catch (Exception localException)
      {
        label78:
        break label78;
      }
      localStringBuffer.append(0);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String e(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageInfo(paramString[i].trim(), 0);
        if (localPackageInfo == null) {
          localStringBuffer.append(0);
        } else {
          localStringBuffer.append(localPackageInfo.versionCode);
        }
      }
      catch (Exception localException)
      {
        label86:
        break label86;
      }
      localStringBuffer.append(0);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PackageUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import java.io.File;

public class a
{
  public static final String a = a.class.getSimpleName();
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        r.d(a, "localAPKPath is empty, return false");
        return false;
      }
      if (!new File(paramString).exists())
      {
        r.d(a, "file not exist, return false");
        return false;
      }
    }
    catch (Exception paramString)
    {
      r.c(a, "installApp>>>", paramString);
      return false;
    }
    if (TextUtils.isEmpty(b(paramString)))
    {
      r.d(a, "package invaild del file, return false");
      paramString = new File(paramString);
      if (paramString.exists())
      {
        paramString.delete();
        return false;
      }
    }
    else
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      GlobalUtil.getInstance().getContext().startActivity(localIntent);
      r.c(a, "sdk installApp success");
      bool = true;
    }
    return bool;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = GlobalUtil.getInstance().getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          paramString = paramString.applicationInfo.packageName;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        r.c(a, "getApkPackageName>>>", paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.a
 * JD-Core Version:    0.7.0.1
 */
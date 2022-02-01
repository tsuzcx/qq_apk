package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.w;
import java.io.File;

public class a
{
  public static boolean a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        ab.d("AppUtils", "localAPKPath is empty, return false");
        return false;
      }
      if (!new File(paramString).exists())
      {
        ab.d("AppUtils", "file not exist, return false");
        return false;
      }
      if (TextUtils.isEmpty(b(paramString)))
      {
        ab.d("AppUtils", "package invaild del file, return false");
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
        Object localObject2 = null;
        int i = GlobalUtil.getInstance().getContext().getApplicationInfo().targetSdkVersion;
        Object localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject1 = localObject2;
          if (i >= 24)
          {
            localObject1 = (Uri)w.a("android.support.v4.content.FileProvider").a("getUriForFile", new Object[] { GlobalUtil.getInstance().getContext(), "com.tencent.mobileqq.fileprovider", new File(paramString) }).a();
            localIntent.addFlags(1);
            localIntent.addFlags(2);
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = Uri.fromFile(new File(paramString));
        }
        paramString = new StringBuilder();
        paramString.append("uri:");
        paramString.append(localObject2);
        ab.c("AppUtils", paramString.toString());
        localIntent.setDataAndType((Uri)localObject2, "application/vnd.android.package-archive");
        localIntent.addFlags(268435456);
        GlobalUtil.getInstance().getContext().startActivity(localIntent);
        ab.c("AppUtils", "sdk installApp success");
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.c("AppUtils", "installApp>>>", paramString);
      return false;
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {}
    try
    {
      int i = GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(paramString, 0).versionCode;
      bool1 = bool2;
      if (i >= paramInt) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
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
      ab.c("AppUtils", "getApkPackageName>>>", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.a
 * JD-Core Version:    0.7.0.1
 */
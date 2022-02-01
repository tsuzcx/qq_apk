package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q
{
  public static String a(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null)
    {
      ab.d("PackageUtils", ">> getAppNameByPackageInfo getAppNameByPackageInfo is null");
      return null;
    }
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getAppNameByPackageInfo context is null");
      return null;
    }
    localObject = ((Context)localObject).getPackageManager();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getAppNameByPackageInfo packageManager is null");
      return null;
    }
    return paramPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    paramString = c(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.versionCode >= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static PackageInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">> getPackageInfo filePath is ");
      ((StringBuilder)localObject).append(paramString);
      ab.d("PackageUtils", ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getPackageInfo context is null");
      return null;
    }
    localObject = ((Context)localObject).getPackageManager();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getPackageInfo packageManager is null");
      return null;
    }
    return ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
  }
  
  public static PackageInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">> getInstalledPackageInfo packageName is ");
      ((StringBuilder)localObject).append(paramString);
      ab.d("PackageUtils", ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getInstalledPackageInfo context is null");
      return null;
    }
    localObject = ((Context)localObject).getPackageManager();
    if (localObject == null)
    {
      ab.d("PackageUtils", ">> getInstalledPackageInfo packageManager is null");
      return null;
    }
    try
    {
      paramString = ((PackageManager)localObject).getPackageInfo(paramString, 0);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static List<PackageInfo> d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(">> getInstalledPackageInfoByAppName appName is ");
      ((StringBuilder)localObject1).append(paramString);
      ab.d("PackageUtils", ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject2 = GlobalUtil.getInstance().getContext();
    if (localObject2 == null)
    {
      ab.d("PackageUtils", ">> getInstalledPackageInfoByAppName context is null");
      return null;
    }
    PackageManager localPackageManager = ((Context)localObject2).getPackageManager();
    if (localPackageManager == null)
    {
      ab.d("PackageUtils", ">> getInstalledPackageInfoByAppName packageManager is null");
      return null;
    }
    Object localObject3 = localPackageManager.getInstalledPackages(0);
    if (localObject3 != null)
    {
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (PackageInfo)((Iterator)localObject3).next();
        if ((((PackageInfo)localObject1).applicationInfo.flags & 0x1) == 0)
        {
          ((PackageInfo)localObject1).applicationInfo.publicSourceDir = ((PackageInfo)localObject1).applicationInfo.sourceDir;
          if (paramString.equals(((PackageInfo)localObject1).applicationInfo.loadLabel(localPackageManager).toString())) {
            ((List)localObject2).add(localObject1);
          }
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.q
 * JD-Core Version:    0.7.0.1
 */
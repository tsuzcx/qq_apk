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
    boolean bool2 = false;
    paramString = c(paramString);
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
      ab.d("PackageUtils", ">> getPackageInfo filePath is " + paramString);
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
      ab.d("PackageUtils", ">> getInstalledPackageInfo packageName is " + paramString);
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
    if (TextUtils.isEmpty(paramString)) {
      ab.d("PackageUtils", ">> getInstalledPackageInfoByAppName appName is " + paramString);
    }
    Object localObject1;
    do
    {
      return null;
      localObject1 = GlobalUtil.getInstance().getContext();
      if (localObject1 == null)
      {
        ab.d("PackageUtils", ">> getInstalledPackageInfoByAppName context is null");
        return null;
      }
      localObject1 = ((Context)localObject1).getPackageManager();
      if (localObject1 == null)
      {
        ab.d("PackageUtils", ">> getInstalledPackageInfoByAppName packageManager is null");
        return null;
      }
      localObject2 = ((PackageManager)localObject1).getInstalledPackages(0);
    } while (localObject2 == null);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
      if ((localPackageInfo.applicationInfo.flags & 0x1) == 0)
      {
        localPackageInfo.applicationInfo.publicSourceDir = localPackageInfo.applicationInfo.sourceDir;
        if (paramString.equals(localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject1).toString())) {
          localArrayList.add(localPackageInfo);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.q
 * JD-Core Version:    0.7.0.1
 */
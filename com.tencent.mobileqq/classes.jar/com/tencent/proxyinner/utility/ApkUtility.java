package com.tencent.proxyinner.utility;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class ApkUtility
{
  public static String getApkName(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf("/"));
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static boolean isBackground(Context paramContext)
  {
    if (paramContext == null) {
      break label24;
    }
    label24:
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return false;
        localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      } while (!localIterator.hasNext());
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
        break;
      }
    } while (localRunningAppProcessInfo.importance != 400);
    return true;
  }
  
  public static boolean isExistPluginInAssert(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramString = "plugin/" + paramString;
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isProcessExist(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
    } while (paramString.compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) != 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.ApkUtility
 * JD-Core Version:    0.7.0.1
 */
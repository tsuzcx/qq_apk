package com.tencent.tfm.metrics.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class AppInfo
{
  private static String appVersion;
  private static String channel = "";
  private static String networkType = "unknown";
  private static String processName;
  
  public static String getAppVersion(Context paramContext)
  {
    if (appVersion == null) {
      appVersion = getVersionName(paramContext);
    }
    return appVersion;
  }
  
  public static String getChannel()
  {
    return channel;
  }
  
  public static String getCurrentProcess(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return "";
    }
    Object localObject = processName;
    if (localObject == null)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == Process.myPid())
          {
            processName = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
            paramContext = processName;
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        ELog.printStackTrace(paramContext);
      }
      return "UNKNOW";
    }
    return localObject;
  }
  
  public static String getNetWorkType()
  {
    return networkType;
  }
  
  private static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    String str = paramContext.getPackageName();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private static String getVersionName(Context paramContext)
  {
    String str = getPackageName(paramContext);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
        str = paramContext.versionName;
        int m = paramContext.versionCode;
        if ((str != null) && (str.trim().length() > 0))
        {
          str = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
          paramContext = str.toCharArray();
          i = 0;
          j = 0;
          if (i < paramContext.length)
          {
            k = j;
            if (paramContext[i] == '.') {
              k = j + 1;
            }
          }
          else
          {
            paramContext = str;
            if (j < 3)
            {
              ELog.debug("[AppInfo] add versionCode: %s", new Object[] { Integer.valueOf(m) });
              paramContext = new StringBuilder();
              paramContext.append(str);
              paramContext.append(".");
              paramContext.append(m);
              paramContext = paramContext.toString();
            }
            ELog.debug("[AppInfo] final Version: %s", new Object[] { paramContext });
            return paramContext;
          }
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          paramContext.append(m);
          paramContext = paramContext.toString();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        ELog.printStackTrace(paramContext);
        ELog.error(paramContext.toString(), new Object[0]);
        return "";
      }
      i += 1;
      int j = k;
    }
  }
  
  public static void setChannel(String paramString)
  {
    channel = paramString;
  }
  
  public static void updateNetWorkType(Context paramContext)
  {
    networkType = updateNetWorkTypeInternal(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("[AppInfo] NetWork Type:");
    paramContext.append(networkType);
    ELog.debug(paramContext.toString(), new Object[0]);
  }
  
  private static String updateNetWorkTypeInternal(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return "unknown";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return "unknown";
      }
      if (paramContext.getType() == 1) {
        paramContext = "wifi";
      } else if (paramContext.getType() == 0) {
        paramContext = paramContext.getSubtypeName();
      }
    }
    catch (Exception paramContext)
    {
      ELog.printStackTrace(paramContext);
    }
    return "unknown";
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.utils.AppInfo
 * JD-Core Version:    0.7.0.1
 */
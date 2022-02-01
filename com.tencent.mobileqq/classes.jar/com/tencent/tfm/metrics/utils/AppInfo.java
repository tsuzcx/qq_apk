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
  private static String appVersion = null;
  private static String channel = "";
  private static String networkType = "unknown";
  private static String processName = null;
  
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
    if (processName == null)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == Process.myPid())
          {
            processName = localRunningAppProcessInfo.processName;
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
    return processName;
  }
  
  public static String getNetWorkType()
  {
    return networkType;
  }
  
  private static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      str = paramContext.getPackageName();
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  private static String getVersionName(Context paramContext)
  {
    Object localObject = getPackageName(paramContext);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        int m = paramContext.versionCode;
        if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
          return "" + m;
        }
        paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
        localObject = paramContext.toCharArray();
        i = 0;
        j = 0;
        if (i < localObject.length)
        {
          k = j;
          if (localObject[i] != '.') {
            break label222;
          }
          k = j + 1;
          break label222;
        }
        if (j < 3)
        {
          ELog.debug("[AppInfo] add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
          ELog.debug("[AppInfo] final Version: %s", new Object[] { paramContext });
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        ELog.printStackTrace(paramContext);
        ELog.error(paramContext.toString(), new Object[0]);
        return "";
      }
      continue;
      label222:
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
    ELog.debug("[AppInfo] NetWork Type:" + networkType, new Object[0]);
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
      if (paramContext != null) {
        if (paramContext.getType() == 1) {
          paramContext = "wifi";
        } else if (paramContext.getType() == 0) {
          paramContext = paramContext.getSubtypeName();
        }
      }
    }
    catch (Exception paramContext)
    {
      ELog.printStackTrace(paramContext);
      paramContext = "unknown";
    }
    return "unknown";
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.utils.AppInfo
 * JD-Core Version:    0.7.0.1
 */
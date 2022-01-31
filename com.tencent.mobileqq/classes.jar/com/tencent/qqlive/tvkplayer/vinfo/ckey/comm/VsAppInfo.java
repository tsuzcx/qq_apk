package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class VsAppInfo
{
  public static int PID = 0;
  public static int SPMODE = 0;
  private static Boolean isReadLog;
  private static Boolean isReadPhoneState;
  private static Boolean isWriteSdcard;
  private static String mAPPVersion = null;
  private static String mAppProcessName = null;
  
  static
  {
    isReadLog = null;
    isWriteSdcard = null;
    isReadPhoneState = null;
  }
  
  public static String getAPPVersion(Context paramContext)
  {
    if (mAPPVersion == null) {
      mAPPVersion = getVersionName(paramContext);
    }
    return mAPPVersion;
  }
  
  public static String getCurrentProcess(Context paramContext)
  {
    if (mAppProcessName != null) {
      return mAppProcessName;
    }
    try
    {
      if (PID == 0) {
        PID = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == PID)
        {
          mAppProcessName = localRunningAppProcessInfo.processName;
          paramContext = mAppProcessName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      VsLog.printStackTrace(paramContext);
    }
    return "";
  }
  
  public static String getPackageName(Context paramContext)
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
    } while (!VsAppInfo.VsStringUtil.isEmpty(str));
    return "";
  }
  
  protected static String getVersionName(Context paramContext)
  {
    int j = 0;
    label76:
    try
    {
      localObject = getPackageName(paramContext);
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        m = paramContext.versionCode;
        if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
          break label76;
        }
        paramContext = "" + m;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int m;
          VsLog.printStackTrace(paramContext);
          VsLog.error(paramContext.toString(), new Object[0]);
          paramContext = "";
        }
      }
      return paramContext;
    }
    finally {}
    paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
    Object localObject = paramContext.toCharArray();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < localObject.length)
      {
        k = j;
        if (localObject[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3)
        {
          VsLog.debug("[core] add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
        }
        for (;;)
        {
          VsLog.debug("[core] final Version: %s", new Object[] { paramContext });
          break;
        }
      }
      i += 1;
      j = k;
    }
  }
  
  public static boolean isContainPermission(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label156:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label156;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label156;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          VsLog.debug("[core] end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        VsLog.printStackTrace(paramContext);
        return bool1;
      }
      finally
      {
        VsLog.debug("[core] end", new Object[0]);
      }
      return false;
    }
  }
  
  public static boolean isContainReadPhoneStatePermission(Context paramContext)
  {
    try
    {
      if (isReadPhoneState == null) {
        isReadPhoneState = Boolean.valueOf(isContainPermission(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      VsLog.debug("[core] Read phone state permission: " + isReadPhoneState, new Object[0]);
      boolean bool = isReadPhoneState.booleanValue();
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppInfo
 * JD-Core Version:    0.7.0.1
 */
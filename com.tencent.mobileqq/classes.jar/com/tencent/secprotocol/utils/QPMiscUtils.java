package com.tencent.secprotocol.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

public class QPMiscUtils
{
  public static volatile int QSEC_FRAMEWORK_NATIVER_VER = -1;
  
  public static String IntVer2DotString(int paramInt)
  {
    return String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24), Integer.valueOf((0xFF0000 & paramInt) >> 16), Integer.valueOf((0xFF00 & paramInt) >> 8) });
  }
  
  public static int getApkSize(Context paramContext)
  {
    int i = 0;
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).packageName;
      paramContext = paramContext.getApplicationInfo();
      if (paramContext.packageName.equals(localObject)) {
        i = Integer.valueOf((int)new File(paramContext.publicSourceDir).length()).intValue();
      }
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getAppVersionWithCode(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext.versionName;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
  }
  
  public static String getProcessName(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getSignatureDigest(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext.signatures.length <= 0) {
        return "";
      }
      Signature localSignature = paramContext.signatures[0];
      try
      {
        paramContext = MessageDigest.getInstance("MD5");
        return HexUtil.bytes2HexStr(paramContext.digest(localSignature.toByteArray()));
      }
      catch (NoSuchAlgorithmException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int getVersionInt(Context paramContext)
  {
    paramContext = getAppVersionWithCode(paramContext);
    try
    {
      paramContext = paramContext.split("\\.");
      int i;
      if (paramContext.length == 2)
      {
        i = Integer.parseInt(paramContext[0]);
        return Integer.parseInt(paramContext[1]) << 8 | i << 16 | 0x0;
      }
      if (paramContext.length == 3)
      {
        i = Integer.parseInt(paramContext[0]);
        int j = Integer.parseInt(paramContext[1]);
        int k = Integer.parseInt(paramContext[2]);
        return k << 8 | i << 24 | 0x0 | j << 16;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static boolean is64()
  {
    String str = System.getProperty("os.arch");
    return (str != null) && (str.contains("64"));
  }
  
  public static String md5sum(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.utils.QPMiscUtils
 * JD-Core Version:    0.7.0.1
 */
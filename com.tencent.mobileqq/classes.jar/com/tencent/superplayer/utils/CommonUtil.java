package com.tencent.superplayer.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonUtil
{
  public static final String a = "CommonUtil";
  private static AtomicInteger b = new AtomicInteger(1000);
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static String a()
  {
    return String.valueOf(b.getAndAdd(1));
  }
  
  public static String a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId())) {
      return paramSuperPlayerVideoInfo.getFileId();
    }
    if ((!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getVid())) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramSuperPlayerVideoInfo.getVid());
      localStringBuilder.append(paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn());
      return localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
      return a(paramSuperPlayerVideoInfo.getPlayUrl());
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    String str;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if (!"".equals(paramString))
      {
        try
        {
          localObject1 = MessageDigest.getInstance("MD5");
          ((MessageDigest)localObject1).update(paramString.getBytes());
          paramString = new BigInteger(1, ((MessageDigest)localObject1).digest()).toString(16);
          try
          {
            while (paramString.length() < 32)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("0");
              ((StringBuilder)localObject1).append(paramString);
              localObject1 = ((StringBuilder)localObject1).toString();
              paramString = (String)localObject1;
            }
            localObject1 = paramString.toUpperCase();
            return localObject1;
          }
          catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
          LogUtil.e(a, "calculateMD5ForInput error", localNoSuchAlgorithmException2);
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
        {
          paramString = localObject2;
        }
        str = paramString;
      }
    }
    return str;
  }
  
  public static boolean a(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(SuperPlayerSDKMgr.getDataCacheFolder());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists())
      {
        ((File)localObject2).mkdirs();
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("业务缓存目录创建成功，path = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        LogUtil.d((String)localObject2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("业务缓存目录已存在，path = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        LogUtil.d((String)localObject2, ((StringBuilder)localObject3).toString());
      }
      b(SuperPlayerSDKMgr.getDataCacheFolder());
      TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, (String)localObject1, (String)localObject1, TPPlayerConfig.getProxyConfigStr());
      return true;
    }
    catch (Exception localException)
    {
      Object localObject3 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("业务缓存目录创建失败，path = ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", error = ");
      localStringBuilder.append(localException.getMessage());
      LogUtil.d((String)localObject3, localStringBuilder.toString());
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    if (SuperPlayerSDKMgr.getPlatform() <= 0) {
      return 0;
    }
    String str = String.valueOf(SuperPlayerSDKMgr.getPlatform());
    Object localObject = str;
    if (paramInt >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      localObject = ((StringBuilder)localObject).toString();
    }
    return Integer.valueOf((String)localObject).intValue();
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString, ".nomedia");
    if (!paramString.exists()) {}
    try
    {
      boolean bool = paramString.createNewFile();
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".nomedia file create result:");
      localStringBuilder.append(bool);
      LogUtil.d(paramString, localStringBuilder.toString());
      return;
    }
    catch (IOException paramString)
    {
      label57:
      break label57;
    }
    LogUtil.w(a, ".nomedia file create failed.");
    return;
    LogUtil.d(a, ".nomedia file exists");
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = SuperPlayerSDKMgr.getContext().getPackageName().equals(c());
      return bool;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(a, "isMainProcess happen error.", localThrowable);
    }
    return false;
  }
  
  public static String c()
  {
    if (SuperPlayerSDKMgr.getContext() == null) {
      return "unknown";
    }
    int i = Process.myPid();
    Iterator localIterator = ((ActivityManager)SuperPlayerSDKMgr.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid == i) {
        str = localRunningAppProcessInfo.processName;
      }
    }
    return str;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403) || (paramInt == 201) || (paramInt == 202) || (paramInt == 203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.utils.CommonUtil
 * JD-Core Version:    0.7.0.1
 */
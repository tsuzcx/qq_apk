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
  public static final String a;
  private static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaLangString = CommonUtil.class.getSimpleName();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
  }
  
  public static int a(int paramInt)
  {
    if (SuperPlayerSDKMgr.getPlatform() <= 0) {
      return 0;
    }
    String str2 = String.valueOf(SuperPlayerSDKMgr.getPlatform());
    String str1 = str2;
    if (paramInt >= 0) {
      str1 = str2 + String.valueOf(paramInt);
    }
    return Integer.valueOf(str1).intValue();
  }
  
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
    return String.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1));
  }
  
  public static String a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId())) {
      return paramSuperPlayerVideoInfo.getFileId();
    }
    if ((!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getVid())) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null)) {
      return paramSuperPlayerVideoInfo.getVid() + paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn();
    }
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
      return a(paramSuperPlayerVideoInfo.getPlayUrl());
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if ("".equals(paramString)) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString.getBytes());
      paramString = new BigInteger(1, ((MessageDigest)localObject1).digest()).toString(16);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        while (paramString.length() < 32)
        {
          localObject1 = "0" + paramString;
          paramString = (String)localObject1;
        }
        localObject1 = paramString.toUpperCase();
        return localObject1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        break label97;
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = localObject2;
    }
    label97:
    LogUtil.e(jdField_a_of_type_JavaLangString, "calculateMD5ForInput error", localNoSuchAlgorithmException1);
    return paramString;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString, ".nomedia");
    if (!paramString.exists()) {
      try
      {
        boolean bool = paramString.createNewFile();
        LogUtil.d(jdField_a_of_type_JavaLangString, ".nomedia file create result:" + bool);
        return;
      }
      catch (IOException paramString)
      {
        LogUtil.w(jdField_a_of_type_JavaLangString, ".nomedia file create failed.");
        return;
      }
    }
    LogUtil.d(jdField_a_of_type_JavaLangString, ".nomedia file exists");
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = SuperPlayerSDKMgr.getContext().getPackageName().equals(b());
      return bool;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(jdField_a_of_type_JavaLangString, "isMainProcess happen error.", localThrowable);
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
      return false;
    }
    String str = SuperPlayerSDKMgr.getDataCacheFolder() + File.separator + paramInt;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        LogUtil.d(jdField_a_of_type_JavaLangString, "业务缓存目录创建成功，path = " + str);
      }
      for (;;)
      {
        a(SuperPlayerSDKMgr.getDataCacheFolder());
        TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, str, str, TPPlayerConfig.getProxyConfigStr());
        return true;
        LogUtil.d(jdField_a_of_type_JavaLangString, "业务缓存目录已存在，path = " + str);
      }
      return false;
    }
    catch (Exception localException)
    {
      LogUtil.d(jdField_a_of_type_JavaLangString, "业务缓存目录创建失败，path = " + str + ", error = " + localException.getMessage());
    }
  }
  
  public static String b()
  {
    if (SuperPlayerSDKMgr.getContext() == null) {
      localObject = "unknown";
    }
    int i;
    String str;
    Iterator localIterator;
    do
    {
      return localObject;
      i = Process.myPid();
      str = "";
      localIterator = ((ActivityManager)SuperPlayerSDKMgr.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      localObject = str;
    } while (!localIterator.hasNext());
    Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
      str = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
    }
    for (;;)
    {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.utils.CommonUtil
 * JD-Core Version:    0.7.0.1
 */
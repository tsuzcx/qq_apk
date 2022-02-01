package com.tencent.mtt.abtestsdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class ABTestUtil
{
  public static String encryptPostBodyByRSA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      PublicKey localPublicKey = RSAUtil.getPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4G854SsPwzbBec9BTkDLHhpeiTI5mTZs4hJj6oe4/XzWULar+z5dc2VlU5wInSnHHEzzEJma8r5c4ON46iYkBCVs8EFabZ9TVnpzwrWlG3UhEWkM3FA/xIm4pSXvfX79IJy93sAy+H/ZfiCP8w72y4YwyCBdSwA5K5HOngCWDCQIDAQAB");
      paramString = RSAUtil.encrypt(paramString.getBytes("UTF-8"), localPublicKey);
      return paramString;
    }
    catch (Exception paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static String getABTestSDKAppId(Context paramContext, ABTestConfig paramABTestConfig)
  {
    Object localObject1 = "";
    if ((paramContext != null) && (paramABTestConfig != null))
    {
      if (!TextUtils.isEmpty(paramABTestConfig.getAppId())) {
        return paramABTestConfig.getAppId();
      }
      Object localObject2;
      try
      {
        paramContext = String.valueOf(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getInt("ABTestSDK_appId"));
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject1 = paramContext;
          paramABTestConfig.setAppId(paramContext);
          localObject1 = paramContext;
          paramABTestConfig = new StringBuilder();
          localObject1 = paramContext;
          paramABTestConfig.append("SDKAppId: ");
          localObject1 = paramContext;
          paramABTestConfig.append(paramContext);
          localObject1 = paramContext;
          ABTestLog.debug(paramABTestConfig.toString(), new Object[0]);
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ABTestLog.error(paramContext.getMessage(), new Object[0]);
        localObject2 = localObject1;
      }
      return localObject2;
    }
    ABTestLog.error("please use init method firstly", new Object[0]);
    return "";
  }
  
  public static String getABTestSDKAppKey(Context paramContext, ABTestConfig paramABTestConfig)
  {
    Object localObject1 = "";
    if ((paramContext != null) && (paramABTestConfig != null))
    {
      if (!TextUtils.isEmpty(paramABTestConfig.getAppKey())) {
        return paramABTestConfig.getAppKey();
      }
      Object localObject2;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getString("ABTestSDK_appKey");
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject1 = paramContext;
          paramABTestConfig.setAppKey(paramContext);
          localObject1 = paramContext;
          paramABTestConfig = new StringBuilder();
          localObject1 = paramContext;
          paramABTestConfig.append("SDKAppKey: ");
          localObject1 = paramContext;
          paramABTestConfig.append(paramContext);
          localObject1 = paramContext;
          ABTestLog.debug(paramABTestConfig.toString(), new Object[0]);
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ABTestLog.error(paramContext.getMessage(), new Object[0]);
        localObject2 = localObject1;
      }
      return localObject2;
    }
    ABTestLog.error("please use init method firstly", new Object[0]);
    return "";
  }
  
  public static void getRequest(String paramString, int paramInt, Callback paramCallback, OkHttpClient.Builder paramBuilder)
  {
    long l = paramInt;
    try
    {
      paramBuilder.connectTimeout(l, TimeUnit.MINUTES);
      paramBuilder.writeTimeout(l, TimeUnit.MINUTES);
      paramBuilder.readTimeout(l, TimeUnit.MINUTES);
      paramBuilder.build().newCall(new Request.Builder().url(paramString).build()).enqueue(paramCallback);
      return;
    }
    catch (Exception paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
  }
  
  public static boolean isSDCardMounted()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      ABTestLog.warn(localException.getMessage(), new Object[0]);
    }
    return false;
  }
  
  public static int maxMemCacheSize()
  {
    return (int)(Runtime.getRuntime().totalMemory() / 1024L / 8L);
  }
  
  private static void onCall(String paramString, int paramInt, Callback paramCallback, OkHttpClient.Builder paramBuilder, RequestBody paramRequestBody)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    long l = i;
    try
    {
      paramBuilder.connectTimeout(l, TimeUnit.SECONDS);
      paramBuilder.writeTimeout(l, TimeUnit.SECONDS);
      paramBuilder.readTimeout(l, TimeUnit.SECONDS);
      paramBuilder.build().newCall(new Request.Builder().url(paramString).post(paramRequestBody).build()).enqueue(paramCallback);
      return;
    }
    catch (Exception paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
  }
  
  public static void postRequestWithFormBody(String paramString, Map<String, String> paramMap, int paramInt, Callback paramCallback, OkHttpClient.Builder paramBuilder)
  {
    if (paramMap != null) {
      try
      {
        if (paramMap.isEmpty()) {
          return;
        }
        FormBody.Builder localBuilder = new FormBody.Builder();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localBuilder.add((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        onCall(paramString, paramInt, paramCallback, paramBuilder, localBuilder.build());
        return;
      }
      catch (Exception paramString)
      {
        ABTestLog.error(paramString.getMessage(), new Object[0]);
      }
    }
  }
  
  public static void postRequestWithJSONBody(String paramString1, String paramString2, int paramInt, Callback paramCallback, OkHttpClient.Builder paramBuilder)
  {
    try
    {
      onCall(paramString1, paramInt, paramCallback, paramBuilder, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      ABTestLog.error(paramString1.getMessage(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ABTestUtil
 * JD-Core Version:    0.7.0.1
 */
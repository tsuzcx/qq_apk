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
  private static final String TAG = "ABTestUtils";
  
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
    Object localObject = "";
    if ((paramContext == null) || (paramABTestConfig == null))
    {
      ABTestLog.error("please use init method firstly", new Object[0]);
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      if (!TextUtils.isEmpty(paramABTestConfig.getAppId())) {
        return paramABTestConfig.getAppId();
      }
      try
      {
        String str = String.valueOf(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getInt("ABTestSDK_appId"));
        paramContext = str;
        localObject = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
          paramABTestConfig.setAppId(str);
          localObject = str;
          ABTestLog.debug("SDKAppId: " + str, new Object[0]);
          return str;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ABTestLog.error(paramContext.getMessage(), new Object[0]);
      }
    }
    return localObject;
  }
  
  public static String getABTestSDKAppKey(Context paramContext, ABTestConfig paramABTestConfig)
  {
    Object localObject = "";
    if ((paramContext == null) || (paramABTestConfig == null))
    {
      ABTestLog.error("please use init method firstly", new Object[0]);
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      if (!TextUtils.isEmpty(paramABTestConfig.getAppKey())) {
        return paramABTestConfig.getAppKey();
      }
      try
      {
        String str = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getString("ABTestSDK_appKey");
        paramContext = str;
        localObject = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
          paramABTestConfig.setAppKey(str);
          localObject = str;
          ABTestLog.debug("SDKAppKey: " + str, new Object[0]);
          return str;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ABTestLog.error(paramContext.getMessage(), new Object[0]);
      }
    }
    return localObject;
  }
  
  public static void getRequest(String paramString, int paramInt, Callback paramCallback, OkHttpClient.Builder paramBuilder)
  {
    try
    {
      paramString = new Request.Builder().url(paramString).build();
      paramBuilder.connectTimeout(paramInt, TimeUnit.MINUTES);
      paramBuilder.writeTimeout(paramInt, TimeUnit.MINUTES);
      paramBuilder.readTimeout(paramInt, TimeUnit.MINUTES);
      paramBuilder.build().newCall(paramString).enqueue(paramCallback);
      return;
    }
    catch (Exception paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
  }
  
  public static boolean isAppKeyValid(Context paramContext, ABTestConfig paramABTestConfig)
  {
    return !TextUtils.isEmpty(getABTestSDKAppKey(paramContext, paramABTestConfig));
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
    try
    {
      paramString = new Request.Builder().url(paramString).post(paramRequestBody).build();
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramBuilder.connectTimeout(i, TimeUnit.SECONDS);
      paramBuilder.writeTimeout(i, TimeUnit.SECONDS);
      paramBuilder.readTimeout(i, TimeUnit.SECONDS);
      paramBuilder.build().newCall(paramString).enqueue(paramCallback);
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
      }
      catch (Exception paramString)
      {
        ABTestLog.error(paramString.getMessage(), new Object[0]);
        return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ABTestUtil
 * JD-Core Version:    0.7.0.1
 */
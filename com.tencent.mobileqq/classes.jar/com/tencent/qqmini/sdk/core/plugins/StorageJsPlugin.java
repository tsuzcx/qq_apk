package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import behq;
import beix;
import bejn;
import bekp;
import bekr;
import belz;
import betc;
import beut;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import org.json.JSONObject;

public class StorageJsPlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  private static final String TAG = "StorageJsPlugin";
  private MiniAppProxy mProxy;
  private SharedPreferences mSharedPref;
  private beix mStorage;
  
  public static String execStorageTask(String paramString, StorageJsPlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    bejn.a(new StorageJsPlugin.8(paramStorageTask), 16, null, true);
    return "";
  }
  
  public String handleClearStorage(bekr parambekr)
  {
    return execStorageTask(parambekr.a, new StorageJsPlugin.5(this, parambekr));
  }
  
  public String handleGetGlobalStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      localObject = belz.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambekr.a, new StorageJsPlugin.6(this, (String)localObject, parambekr));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  public String handleGetStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      localObject = belz.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambekr.a, new StorageJsPlugin.2(this, (String)localObject, parambekr));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  public String handleGetStorageInfo(bekr parambekr)
  {
    return execStorageTask(parambekr.a, new StorageJsPlugin.3(this, parambekr));
  }
  
  public String handleRemoveStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      localObject = belz.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambekr.a, new StorageJsPlugin.4(this, (String)localObject, parambekr));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  public String handleSetGlobalStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      String str = belz.a(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(parambekr.a, new StorageJsPlugin.7(this, str, (String)localObject, parambekr));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  public String handleSetStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return parambekr.a("key is empty");
      }
      str1 = belz.a(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(parambekr.a)) {
        bejn.a(new StorageJsPlugin.1(this, str1, str2, (String)localObject, parambekr), 16, null, true);
      }
      if ("setStorageSync".equals(parambekr.a))
      {
        if (this.mStorage.a(str1, (String)localObject, str2)) {
          return parambekr.a();
        }
        parambekr = parambekr.a("size limit reached");
        return parambekr;
      }
    }
    catch (Exception parambekr)
    {
      betc.d("StorageJsPlugin", parambekr.getMessage(), parambekr);
    }
    return "";
  }
  
  public void onCreate(behq parambehq)
  {
    super.onCreate(parambehq);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (beut.a().a() != null) {}
    for (parambehq = beut.a().a();; parambehq = "")
    {
      String str = this.mApkgInfo.d;
      this.mStorage = beix.a(this.mContext, parambehq, str);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
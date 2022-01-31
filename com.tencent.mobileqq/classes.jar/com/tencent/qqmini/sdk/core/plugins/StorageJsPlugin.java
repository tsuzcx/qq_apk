package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import begz;
import beig;
import beiw;
import bejy;
import beka;
import beli;
import besl;
import beuc;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import org.json.JSONObject;

public class StorageJsPlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  private static final String TAG = "StorageJsPlugin";
  private MiniAppProxy mProxy;
  private SharedPreferences mSharedPref;
  private beig mStorage;
  
  public static String execStorageTask(String paramString, StorageJsPlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    beiw.a(new StorageJsPlugin.8(paramStorageTask), 16, null, true);
    return "";
  }
  
  public String handleClearStorage(beka parambeka)
  {
    return execStorageTask(parambeka.a, new StorageJsPlugin.5(this, parambeka));
  }
  
  public String handleGetGlobalStorage(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      localObject = beli.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambeka.a, new StorageJsPlugin.6(this, (String)localObject, parambeka));
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
  
  public String handleGetStorage(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      localObject = beli.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambeka.a, new StorageJsPlugin.2(this, (String)localObject, parambeka));
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
  
  public String handleGetStorageInfo(beka parambeka)
  {
    return execStorageTask(parambeka.a, new StorageJsPlugin.3(this, parambeka));
  }
  
  public String handleRemoveStorage(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      localObject = beli.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambeka.a, new StorageJsPlugin.4(this, (String)localObject, parambeka));
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
  
  public String handleSetGlobalStorage(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      String str = beli.a(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(parambeka.a, new StorageJsPlugin.7(this, str, (String)localObject, parambeka));
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
  
  public String handleSetStorage(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return parambeka.a("key is empty");
      }
      str1 = beli.a(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(parambeka.a)) {
        beiw.a(new StorageJsPlugin.1(this, str1, str2, (String)localObject, parambeka), 16, null, true);
      }
      if ("setStorageSync".equals(parambeka.a))
      {
        if (this.mStorage.a(str1, (String)localObject, str2)) {
          return parambeka.a();
        }
        parambeka = parambeka.a("size limit reached");
        return parambeka;
      }
    }
    catch (Exception parambeka)
    {
      besl.d("StorageJsPlugin", parambeka.getMessage(), parambeka);
    }
    return "";
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (beuc.a().a() != null) {}
    for (parambegz = beuc.a().a();; parambegz = "")
    {
      String str = this.mApkgInfo.d;
      this.mStorage = beig.a(this.mContext, parambegz, str);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
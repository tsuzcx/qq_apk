package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bdcz;
import bdeg;
import bdew;
import bdfx;
import bdfz;
import bdhf;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import org.json.JSONObject;

public class StorageJsPlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  private static final String TAG = "StorageJsPlugin";
  private MiniAppProxy mProxy;
  private SharedPreferences mSharedPref;
  private bdeg mStorage;
  
  public static String execStorageTask(String paramString, StorageJsPlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    bdew.a(new StorageJsPlugin.8(paramStorageTask), 16, null, true);
    return "";
  }
  
  public String handleClearStorage(bdfz parambdfz)
  {
    return execStorageTask(parambdfz.a, new StorageJsPlugin.5(this, parambdfz));
  }
  
  public String handleGetGlobalStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      localObject = bdhf.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambdfz.a, new StorageJsPlugin.6(this, (String)localObject, parambdfz));
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
  
  public String handleGetStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      localObject = bdhf.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambdfz.a, new StorageJsPlugin.2(this, (String)localObject, parambdfz));
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
  
  public String handleGetStorageInfo(bdfz parambdfz)
  {
    return execStorageTask(parambdfz.a, new StorageJsPlugin.3(this, parambdfz));
  }
  
  public String handleRemoveStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      localObject = bdhf.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambdfz.a, new StorageJsPlugin.4(this, (String)localObject, parambdfz));
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
  
  public String handleSetGlobalStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      String str = bdhf.a(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(parambdfz.a, new StorageJsPlugin.7(this, str, (String)localObject, parambdfz));
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
  
  public String handleSetStorage(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return parambdfz.a("key is empty");
      }
      str1 = bdhf.a(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(parambdfz.a)) {
        bdew.a(new StorageJsPlugin.1(this, str1, str2, (String)localObject, parambdfz), 16, null, true);
      }
      if ("setStorageSync".equals(parambdfz.a))
      {
        if (this.mStorage.a(str1, (String)localObject, str2)) {
          return parambdfz.a();
        }
        parambdfz = parambdfz.a("size limit reached");
        return parambdfz;
      }
    }
    catch (Exception parambdfz)
    {
      bdnw.d("StorageJsPlugin", parambdfz.getMessage(), parambdfz);
    }
    return "";
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (this.mProxy != null) {}
    for (parambdcz = this.mProxy.getAccount();; parambdcz = "")
    {
      String str = this.mApkgInfo.d;
      this.mStorage = bdeg.a(this.mContext, parambdcz, str);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
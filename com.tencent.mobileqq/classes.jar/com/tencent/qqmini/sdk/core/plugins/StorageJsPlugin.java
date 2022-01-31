package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bgho;
import bgiy;
import bgjw;
import bgkd;
import bglp;
import bgte;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class StorageJsPlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  private static final String TAG = "StorageJsPlugin";
  private MiniAppProxy mProxy;
  private SharedPreferences mSharedPref;
  private bgiy mStorage;
  
  public static String execStorageTask(String paramString, StorageJsPlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    ThreadManager.a(new StorageJsPlugin.8(paramStorageTask), 16, null, true);
    return "";
  }
  
  public String handleClearStorage(bgkd parambgkd)
  {
    return execStorageTask(parambgkd.a, new StorageJsPlugin.5(this, parambgkd));
  }
  
  public String handleGetGlobalStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      localObject = bglp.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgkd.a, new StorageJsPlugin.6(this, (String)localObject, parambgkd));
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
  
  public String handleGetStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      localObject = bglp.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgkd.a, new StorageJsPlugin.2(this, (String)localObject, parambgkd));
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
  
  public String handleGetStorageInfo(bgkd parambgkd)
  {
    return execStorageTask(parambgkd.a, new StorageJsPlugin.3(this, parambgkd));
  }
  
  public String handleRemoveStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      localObject = bglp.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgkd.a, new StorageJsPlugin.4(this, (String)localObject, parambgkd));
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
  
  public String handleSetGlobalStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      String str = bglp.a(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(parambgkd.a, new StorageJsPlugin.7(this, str, (String)localObject, parambgkd));
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
  
  public String handleSetStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return parambgkd.a("key is empty");
      }
      str1 = bglp.a(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(parambgkd.a)) {
        ThreadManager.a(new StorageJsPlugin.1(this, str1, str2, (String)localObject, parambgkd), 16, null, true);
      }
      if ("setStorageSync".equals(parambgkd.a))
      {
        if (this.mStorage.a(str1, (String)localObject, str2)) {
          return parambgkd.a();
        }
        parambgkd = parambgkd.a("size limit reached");
        return parambgkd;
      }
    }
    catch (Exception parambgkd)
    {
      QMLog.e("StorageJsPlugin", parambgkd.getMessage(), parambgkd);
    }
    return "";
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (bgte.a().a() != null) {}
    for (parambgho = bgte.a().a();; parambgho = "")
    {
      String str = this.mApkgInfo.appId;
      this.mStorage = bgiy.a(this.mContext, parambgho, str);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
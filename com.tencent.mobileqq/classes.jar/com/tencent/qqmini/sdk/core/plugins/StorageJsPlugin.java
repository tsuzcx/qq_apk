package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bglv;
import bgnf;
import bgod;
import bgok;
import bgpw;
import bgxl;
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
  private bgnf mStorage;
  
  public static String execStorageTask(String paramString, StorageJsPlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    ThreadManager.a(new StorageJsPlugin.8(paramStorageTask), 16, null, true);
    return "";
  }
  
  public String handleClearStorage(bgok parambgok)
  {
    return execStorageTask(parambgok.a, new StorageJsPlugin.5(this, parambgok));
  }
  
  public String handleGetGlobalStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      localObject = bgpw.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgok.a, new StorageJsPlugin.6(this, (String)localObject, parambgok));
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
  
  public String handleGetStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      localObject = bgpw.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgok.a, new StorageJsPlugin.2(this, (String)localObject, parambgok));
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
  
  public String handleGetStorageInfo(bgok parambgok)
  {
    return execStorageTask(parambgok.a, new StorageJsPlugin.3(this, parambgok));
  }
  
  public String handleRemoveStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      localObject = bgpw.a(((JSONObject)localObject).optString("key"));
      return execStorageTask(parambgok.a, new StorageJsPlugin.4(this, (String)localObject, parambgok));
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
  
  public String handleSetGlobalStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      String str = bgpw.a(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(parambgok.a, new StorageJsPlugin.7(this, str, (String)localObject, parambgok));
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
  
  public String handleSetStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return parambgok.a("key is empty");
      }
      str1 = bgpw.a(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(parambgok.a)) {
        ThreadManager.a(new StorageJsPlugin.1(this, str1, str2, (String)localObject, parambgok), 16, null, true);
      }
      if ("setStorageSync".equals(parambgok.a))
      {
        if (this.mStorage.a(str1, (String)localObject, str2)) {
          return parambgok.a();
        }
        parambgok = parambgok.a("size limit reached");
        return parambgok;
      }
    }
    catch (Exception parambgok)
    {
      QMLog.e("StorageJsPlugin", parambgok.getMessage(), parambgok);
    }
    return "";
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (bgxl.a().a() != null) {}
    for (parambglv = bgxl.a().a();; parambglv = "")
    {
      String str = this.mApkgInfo.appId;
      this.mStorage = bgnf.a(this.mContext, parambglv, str);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
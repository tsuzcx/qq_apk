package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import bjnd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class StoragePlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  public static final String EVENT_CLEAR_STORAGE = "clearStorage";
  public static final String EVENT_CLEAR_STORAGE_SYNC = "clearStorageSync";
  public static final String EVENT_GET_GLOBAL_STORAGE = "getGlobalStorage";
  public static final String EVENT_GET_STORAGE = "getStorage";
  public static final String EVENT_GET_STORAGE_INFO = "getStorageInfo";
  public static final String EVENT_GET_STORAGE_INFO_SYNC = "getStorageInfoSync";
  public static final String EVENT_GET_STORAGE_SYNC = "getStorageSync";
  public static final String EVENT_REMOVE_STORAGE = "removeStorage";
  public static final String EVENT_REMOVE_STORAGE_SYNC = "removeStorageSync";
  public static final String EVENT_SET_GLOBAL_STORAGE = "setGlobalStorage";
  public static final String EVENT_SET_STORAGE = "setStorage";
  public static final String EVENT_SET_STORAGE_SYNC = "setStorageSync";
  private static final Set<String> S_EVENT_MAP = new StoragePlugin.1();
  private static final String TAG = "[mini] StoragePlugin";
  private Storage mStorage;
  
  private String execStorageTask(String paramString, StoragePlugin.StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    ThreadManagerV2.excute(new StoragePlugin.9(this, paramStorageTask), 16, null, false);
    return "";
  }
  
  private String handleCallbackFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (!paramString1.endsWith("Sync"))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, paramJSONObject, paramString2, paramInt);
      return "";
    }
    return ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2).toString();
  }
  
  private String handleCallbackOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramString.endsWith("Sync"))
    {
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, paramJSONObject, paramInt);
      return "";
    }
    return ApiUtil.wrapCallbackOk(paramString, paramJSONObject).toString();
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] StoragePlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    if (("setStorage".equals(paramString1)) || ("setStorageSync".equals(paramString1)))
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        String str1 = paramString2.optString("key");
        if (TextUtils.isEmpty(str1)) {
          return handleCallbackFail(paramJsRuntime, paramString1, null, "key is empty", paramInt);
        }
        str1 = bjnd.a(str1);
        String str2 = paramString2.optString("data");
        paramString2 = paramString2.optString("dataType", "String");
        if ("setStorage".equals(paramString1)) {
          ThreadManagerV2.excute(new StoragePlugin.2(this, str1, str2, paramString2, paramJsRuntime, paramString1, paramInt), 16, null, true);
        }
        if ("setStorageSync".equals(paramString1))
        {
          if (this.mStorage.writeSync(str1, paramString2, str2)) {
            return handleCallbackOK(paramJsRuntime, paramString1, null, paramInt);
          }
          paramString1 = handleCallbackFail(paramJsRuntime, paramString1, null, "size limit reached", paramInt);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[mini] StoragePlugin", 1, paramString1, new Object[0]);
      }
      return "";
    }
    if (("getStorage".equals(paramString1)) || ("getStorageSync".equals(paramString1))) {
      try
      {
        paramString2 = new JSONObject(paramString2);
        return execStorageTask(paramString1, new StoragePlugin.3(this, bjnd.a(paramString2.optString("key")), paramJsRuntime, paramString1, paramInt));
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          paramString2 = new JSONObject();
        }
      }
    }
    if (("getStorageInfo".equals(paramString1)) || ("getStorageInfoSync".equals(paramString1))) {
      return execStorageTask(paramString1, new StoragePlugin.4(this, paramJsRuntime, paramString1, paramInt));
    }
    if (("removeStorage".equals(paramString1)) || ("removeStorageSync".equals(paramString1))) {
      try
      {
        paramString2 = new JSONObject(paramString2);
        return execStorageTask(paramString1, new StoragePlugin.5(this, bjnd.a(paramString2.optString("key")), paramJsRuntime, paramString1, paramInt));
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          paramString2 = new JSONObject();
        }
      }
    }
    if (("clearStorage".equals(paramString1)) || ("clearStorageSync".equals(paramString1))) {
      return execStorageTask(paramString1, new StoragePlugin.6(this, paramJsRuntime, paramString1, paramInt));
    }
    if ("getGlobalStorage".equals(paramString1)) {
      try
      {
        paramString2 = new JSONObject(paramString2);
        return execStorageTask(paramString1, new StoragePlugin.7(this, bjnd.a(paramString2.optString("key")), paramJsRuntime, paramString1, paramInt));
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          paramString2 = new JSONObject();
        }
      }
    }
    if ("setGlobalStorage".equals(paramString1)) {
      try
      {
        paramString2 = new JSONObject(paramString2);
        return execStorageTask(paramString1, new StoragePlugin.8(this, bjnd.a(paramString2.optString("key")), paramString2.optString("data"), paramJsRuntime, paramString1, paramInt));
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          paramString2 = new JSONObject();
        }
      }
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    this.mStorage = Storage.open(paramBaseJsPluginEngine.getActivityContext(), String.valueOf(BaseApplicationImpl.getApplication().waitAppRuntime(null).getLongAccountUin()), paramBaseJsPluginEngine.appBrandRuntime.appId);
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin
 * JD-Core Version:    0.7.0.1
 */
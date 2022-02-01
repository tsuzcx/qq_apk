package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateManagerPlugin
  extends BaseJsPlugin
{
  public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
  public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
  private static final String TAG = "UpdateManagerPlugin";
  private JsRuntime cacheJsRuntime;
  private Boolean mHasUpdateCache;
  private Boolean mUpdateResultCache;
  
  private void notifyUpdateCheckResult(boolean paramBoolean)
  {
    if (this.cacheJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hasUpdate", paramBoolean);
      this.cacheJsRuntime.evaluateSubcribeJS("onUpdateCheckResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void notifyUpdateDownloadResult(boolean paramBoolean)
  {
    if (this.cacheJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("updateResult", paramBoolean);
      this.cacheJsRuntime.evaluateSubcribeJS("onUpdateDownloadResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    boolean bool = false;
    QLog.d("UpdateManagerPlugin", 1, new Object[] { "handleNativeRequest for ", paramString1 });
    if (this.cacheJsRuntime == null) {
      this.cacheJsRuntime = paramJsRuntime;
    }
    if ("getUpdateManager".equals(paramString1))
    {
      if (this.mHasUpdateCache != null) {
        bool = this.mHasUpdateCache.booleanValue();
      }
      QLog.i("UpdateManagerPlugin", 1, "handleNativeRequest getUpdateManager, hasUpdate:" + bool);
      notifyUpdateCheckResult(bool);
      return "";
    }
    if ("onUpdateCheckResult".equals(paramString1)) {
      QLog.w("UpdateManagerPlugin", 2, "handleNativeRequest " + paramString1 + " should not send from JS");
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("onUpdateDownloadResult".equals(paramString1))
      {
        QLog.w("UpdateManagerPlugin", 2, "handleNativeRequest " + paramString1 + " should not send from JS");
      }
      else if ("updateApp".equals(paramString1))
      {
        JsApiUpdateManager.handleUpdateApp();
        QLog.d("UpdateManagerPlugin", 2, new Object[] { "handleNativeRequest ", paramString1 });
      }
    }
  }
  
  public void setUpdateCheckResult(boolean paramBoolean)
  {
    this.mHasUpdateCache = Boolean.valueOf(paramBoolean);
    notifyUpdateCheckResult(paramBoolean);
  }
  
  public void setUpdateDownloadResult(boolean paramBoolean)
  {
    this.mUpdateResultCache = Boolean.valueOf(paramBoolean);
    notifyUpdateDownloadResult(paramBoolean);
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return new HashSet(Arrays.asList(new String[] { "getUpdateManager", "onUpdateCheckResult", "onUpdateDownloadResult", "updateApp" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.UpdateManagerPlugin
 * JD-Core Version:    0.7.0.1
 */
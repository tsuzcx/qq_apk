package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class UpdateManagerPlugin
  extends BaseJsPlugin
{
  public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
  public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
  private static final String TAG = "UpdateManagerPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    GameJsPluginEngine localGameJsPluginEngine = (GameJsPluginEngine)this.jsPluginEngine;
    if ("getUpdateManager".equals(paramString1))
    {
      QLog.d("UpdateManagerPlugin", 1, new Object[] { "handleNativeRequest do nothing for ", paramString1 });
      ApiUtil.wrapCallbackOk(paramString1, new JSONObject());
      JsApiUpdateManager.handleUpdateCheckResult(localGameJsPluginEngine, false);
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
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return new HashSet(Arrays.asList(new String[] { "getUpdateManager", "onUpdateCheckResult", "onUpdateDownloadResult", "updateApp" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.UpdateManagerPlugin
 * JD-Core Version:    0.7.0.1
 */
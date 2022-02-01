package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
public class UpdateManagerJsPlugin
  extends BaseJsPlugin
{
  public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
  public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
  private static final String TAG = "UpdateManagerJsPlugin";
  private Boolean mHasUpdateCache = null;
  private IJsService mJsService;
  private AppRuntimeEventCenter.RuntimeStateObserver mObserver;
  private Boolean mUpdateResultCache = null;
  
  private void registerUpdateObserver()
  {
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if (localBaseRuntimeLoader == null) {
      return;
    }
    this.mObserver = new UpdateManagerJsPlugin.1(this);
    localBaseRuntimeLoader.addRuntimeStateObserver(this.mObserver);
    QMLog.d("UpdateManagerJsPlugin", "addAppEventObserver " + this.mObserver);
  }
  
  @JsEvent({"getUpdateManager"})
  public void getUpdateManager(RequestEvent paramRequestEvent)
  {
    boolean bool2 = false;
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest for " + paramRequestEvent.event);
    this.mJsService = paramRequestEvent.jsService;
    paramRequestEvent.ok();
    try
    {
      Object localObject = new StringBuilder().append("handleUpdateCheckResult() called with:  hasUpdate = [");
      if (this.mHasUpdateCache != null) {}
      for (boolean bool1 = this.mHasUpdateCache.booleanValue();; bool1 = false)
      {
        QMLog.d("UpdateManagerJsPlugin", bool1 + "]");
        localObject = new JSONObject();
        bool1 = bool2;
        if (this.mHasUpdateCache != null) {
          bool1 = this.mHasUpdateCache.booleanValue();
        }
        ((JSONObject)localObject).put("hasUpdate", bool1);
        paramRequestEvent.jsService.evaluateSubscribeJS("onUpdateCheckResult", ((JSONObject)localObject).toString(), 0);
        return;
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("UpdateManagerJsPlugin", "handleNativeRequest", paramRequestEvent);
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    registerUpdateObserver();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if ((localBaseRuntimeLoader != null) && (this.mObserver != null)) {
      localBaseRuntimeLoader.removeRuntimeStateObserver(this.mObserver);
    }
  }
  
  @JsEvent({"onUpdateCheckResult"})
  public void onUpdateCheckResult(RequestEvent paramRequestEvent)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event + " should not send from JS");
  }
  
  @JsEvent({"onUpdateDownloadResult"})
  public void onUpdateDownloadResult(RequestEvent paramRequestEvent)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event + " should not send from JS");
  }
  
  @JsEvent({"updateApp"})
  public void updateApp(RequestEvent paramRequestEvent)
  {
    JsApiUpdateManager.handleUpdateApp();
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */
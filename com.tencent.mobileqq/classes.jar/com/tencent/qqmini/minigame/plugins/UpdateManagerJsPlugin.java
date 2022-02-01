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
    Object localObject = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if (localObject == null) {
      return;
    }
    this.mObserver = new UpdateManagerJsPlugin.1(this);
    ((BaseRuntimeLoader)localObject).addRuntimeStateObserver(this.mObserver);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addAppEventObserver ");
    ((StringBuilder)localObject).append(this.mObserver);
    QMLog.d("UpdateManagerJsPlugin", ((StringBuilder)localObject).toString());
  }
  
  @JsEvent({"getUpdateManager"})
  public void getUpdateManager(RequestEvent paramRequestEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleNativeRequest for ");
    ((StringBuilder)localObject).append(paramRequestEvent.event);
    QMLog.d("UpdateManagerJsPlugin", ((StringBuilder)localObject).toString());
    this.mJsService = paramRequestEvent.jsService;
    paramRequestEvent.ok();
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleUpdateCheckResult() called with:  hasUpdate = [");
        if (this.mHasUpdateCache != null)
        {
          bool = this.mHasUpdateCache.booleanValue();
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("]");
          QMLog.d("UpdateManagerJsPlugin", ((StringBuilder)localObject).toString());
          localObject = new JSONObject();
          if (this.mHasUpdateCache == null) {
            break label167;
          }
          bool = this.mHasUpdateCache.booleanValue();
          ((JSONObject)localObject).put("hasUpdate", bool);
          paramRequestEvent.jsService.evaluateSubscribeJS("onUpdateCheckResult", ((JSONObject)localObject).toString(), 0);
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("UpdateManagerJsPlugin", "handleNativeRequest", paramRequestEvent);
        return;
      }
      boolean bool = false;
      continue;
      label167:
      bool = false;
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
    if (localBaseRuntimeLoader != null)
    {
      AppRuntimeEventCenter.RuntimeStateObserver localRuntimeStateObserver = this.mObserver;
      if (localRuntimeStateObserver != null) {
        localBaseRuntimeLoader.removeRuntimeStateObserver(localRuntimeStateObserver);
      }
    }
  }
  
  @JsEvent({"onUpdateCheckResult"})
  public void onUpdateCheckResult(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeRequest ");
    localStringBuilder.append(paramRequestEvent.event);
    localStringBuilder.append(" should not send from JS");
    QMLog.w("UpdateManagerJsPlugin", localStringBuilder.toString());
  }
  
  @JsEvent({"onUpdateDownloadResult"})
  public void onUpdateDownloadResult(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeRequest ");
    localStringBuilder.append(paramRequestEvent.event);
    localStringBuilder.append(" should not send from JS");
    QMLog.w("UpdateManagerJsPlugin", localStringBuilder.toString());
  }
  
  @JsEvent({"updateApp"})
  public void updateApp(RequestEvent paramRequestEvent)
  {
    JsApiUpdateManager.handleUpdateApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeRequest ");
    localStringBuilder.append(paramRequestEvent.event);
    QMLog.d("UpdateManagerJsPlugin", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */
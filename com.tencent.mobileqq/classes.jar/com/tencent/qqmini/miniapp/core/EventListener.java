package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.PageEventListener;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent.Builder;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import org.json.JSONObject;

public class EventListener
  implements PageEventListener, ServiceEventListener
{
  public static final String APPLAUNCH = "appLaunch";
  public static final String EXIT_MINIPROGRAM = "exitMiniProgram";
  public static final String FLUTTER_LAUNCH = "flutter_launch";
  public static final String KEY_APPID = "appId";
  public static final String KEY_DELTA = "delta";
  public static final String KEY_SCENE = "scene";
  public static final String KEY_URL = "url";
  public static final String NAVIGATE_BACK = "navigateBack";
  public static final String NAVIGATE_TO = "navigateTo";
  public static final String ON_UPDATE_STATUS_CHANGE = "onUpdateStatusChange";
  public static final String REDIRECT_TO = "redirectTo";
  public static final String RELAUNCH = "reLaunch";
  public static final String SWITCH_TAB = "switchTab";
  private static final String TAG = "EventListener";
  public static final String UPDATE_APP = "updateApp";
  private boolean isFirstDomReady = false;
  protected BaseAppBrandRuntime mRuntime;
  protected boolean mWeixinJSBridgeFinished = false;
  private MiniAppInfo newVersionMiniAppInfo;
  
  public EventListener(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.mRuntime = paramBaseAppBrandRuntime;
  }
  
  private void checkUpdate()
  {
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((BaseAppBrandRuntime)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QMLog.i("EventListener", "checkUpdate -- miniapp is null, return.");
      return;
    }
    if (((MiniAppInfo)localObject).verType != 3)
    {
      QMLog.i("EventListener", "checkUpdate -- miniapp is not online, return.");
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", "noUpdate");
        this.mRuntime.appBrandService.evaluateSubscribeJS("onUpdateStatusChange", ((JSONObject)localObject).toString(), 0);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateJSONObject error.");
        localStringBuilder.append(localException);
        QMLog.e("EventListener", localStringBuilder.toString());
        return;
      }
    }
    ThreadManager.executeOnNetworkIOThreadPool(new EventListener.1(this, localException));
  }
  
  private void doDownloadNewVersion(MiniAppInfo paramMiniAppInfo)
  {
    ApkgManager.getInstance().getApkgInfoByConfig(paramMiniAppInfo, false, new EventListener.3(this, paramMiniAppInfo));
  }
  
  private void doUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new EventListener.2(this, paramMiniAppInfo));
  }
  
  private String handleNavigateBack(String paramString1, String paramString2, IAppBrandPageContainer paramIAppBrandPageContainer, RequestEvent paramRequestEvent)
  {
    int i = new JSONObject(paramString2).optInt("delta", 0);
    if (i > 0) {
      AppBrandTask.runTaskOnUiThread(new EventListener.9(this, paramIAppBrandPageContainer, i, paramRequestEvent));
    }
    return ApiUtil.wrapCallbackOk(paramString1, null).toString();
  }
  
  private String handleNavigateTo(String paramString1, String paramString2, IAppBrandPageContainer paramIAppBrandPageContainer, ApkgInfo paramApkgInfo, RequestEvent paramRequestEvent)
  {
    paramString2 = new JSONObject(paramString2).optString("url", "");
    if (!TextUtils.isEmpty(paramString2))
    {
      int i;
      if ((paramApkgInfo != null) && (paramApkgInfo.isTabBarPage(paramString2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return ApiUtil.wrapCallbackFail(paramString1, null).toString();
      }
      AppBrandTask.runTaskOnUiThread(new EventListener.10(this, paramIAppBrandPageContainer, paramString2, paramRequestEvent));
    }
    return ApiUtil.wrapCallbackOk(paramString1, null).toString();
  }
  
  private String handleRedirectTo(String paramString1, String paramString2, IAppBrandPageContainer paramIAppBrandPageContainer, ApkgInfo paramApkgInfo, RequestEvent paramRequestEvent)
  {
    paramString2 = new JSONObject(paramString2).optString("url", "");
    if (!TextUtils.isEmpty(paramString2))
    {
      int i;
      if ((paramApkgInfo != null) && (paramApkgInfo.isTabBarPage(paramString2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramRequestEvent.fail();
      }
      AppBrandTask.runTaskOnUiThread(new EventListener.11(this, paramIAppBrandPageContainer, paramString2, paramRequestEvent));
    }
    return ApiUtil.wrapCallbackOk(paramString1, null).toString();
  }
  
  private String handleRelaunch(String paramString1, String paramString2, RequestEvent paramRequestEvent)
  {
    paramString2 = new JSONObject(paramString2).optString("url", "");
    if (!TextUtils.isEmpty(paramString2)) {
      AppBrandTask.runTaskOnUiThread(new EventListener.7(this, paramString2, paramRequestEvent));
    }
    return ApiUtil.wrapCallbackOk(paramString1, null).toString();
  }
  
  private String handleSwitchTab(String paramString1, String paramString2, IAppBrandPageContainer paramIAppBrandPageContainer, RequestEvent paramRequestEvent)
  {
    paramString2 = new JSONObject(paramString2).optString("url", "");
    if (!TextUtils.isEmpty(paramString2)) {
      AppBrandTask.runTaskOnUiThread(new EventListener.8(this, paramIAppBrandPageContainer, paramString2, paramRequestEvent));
    }
    return ApiUtil.wrapCallbackOk(paramString1, null).toString();
  }
  
  public String interruptOnServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    return null;
  }
  
  public boolean isFirstDomReady()
  {
    return this.isFirstDomReady;
  }
  
  public void moveAppBrandToBack()
  {
    if (this.mRuntime.getAttachedActivity() != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveAppBrandToBack. | ");
      localStringBuilder.append(this);
      QMLog.d("EventListener", localStringBuilder.toString());
      if (!this.mRuntime.getAttachedActivity().moveTaskToBack(false))
      {
        QMLog.e("EventListener", "moveTaskToBack failed, finish the activity.");
        this.mRuntime.getAttachedActivity().finish();
      }
    }
  }
  
  public void onAppRoute(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = AppBrandUtil.getPageLoadInfo(paramString2, paramString1, this.mRuntime.getMiniAppInfo());
    this.mRuntime.appBrandService.evaluateSubscribeJS("onAppRoute", paramString1.toString(), paramInt);
  }
  
  public void onAppRouteDone(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = AppBrandUtil.getPageLoadInfo(paramString2, paramString1, this.mRuntime.getMiniAppInfo());
    this.mRuntime.appBrandService.evaluateSubscribeJS("onAppRouteDone", paramString1.toString(), paramInt);
  }
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("custom_event_onAppRouteDone".equals(paramString1)) {
      this.mRuntime.performAction(AppStateEvent.obtain(10));
    }
    if (this.mRuntime.pageContainer != null) {
      this.mRuntime.pageContainer.dispatchEventToWebView(paramString1, paramString2, paramArrayOfInt);
    }
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.mWeixinJSBridgeFinished = true;
      QMLog.i("EventListener", "WeixinJSBridge finished.");
      return ApiUtil.wrapCallbackOk(paramString1, null).toString();
    }
    IAppBrandService localIAppBrandService = this.mRuntime.appBrandService;
    IAppBrandPageContainer localIAppBrandPageContainer = this.mRuntime.pageContainer;
    JsPluginEngine localJsPluginEngine = this.mRuntime.jsPluginEngine;
    ApkgInfo localApkgInfo = this.mRuntime.mApkgInfo;
    RequestEvent localRequestEvent = new RequestEvent.Builder().setEvent(paramString1).setJsonParams(paramString2).setCallbackId(paramInt).setJsService(localIAppBrandService).build();
    String str = interruptOnServiceNativeRequest(paramString1, paramString2, paramInt);
    if (str != null) {
      return str;
    }
    try
    {
      if ("redirectTo".equals(paramString1)) {
        return handleRedirectTo(paramString1, paramString2, localIAppBrandPageContainer, localApkgInfo, localRequestEvent);
      }
      if ("navigateTo".equals(paramString1)) {
        return handleNavigateTo(paramString1, paramString2, localIAppBrandPageContainer, localApkgInfo, localRequestEvent);
      }
      if ("navigateBack".equals(paramString1)) {
        return handleNavigateBack(paramString1, paramString2, localIAppBrandPageContainer, localRequestEvent);
      }
      if ("switchTab".equals(paramString1)) {
        return handleSwitchTab(paramString1, paramString2, localIAppBrandPageContainer, localRequestEvent);
      }
      if ("reLaunch".equals(paramString1)) {
        return handleRelaunch(paramString1, paramString2, localRequestEvent);
      }
      if ("exitMiniProgram".equals(paramString1)) {
        AppBrandTask.runTaskOnUiThread(new EventListener.4(this));
      } else if ("updateApp".equals(paramString1))
      {
        if (this.newVersionMiniAppInfo != null) {
          AppBrandTask.runTaskOnUiThread(new EventListener.5(this));
        }
      }
      else if ("flutter_launch".equals(paramString1)) {
        AppBrandTask.runTaskOnUiThread(new EventListener.6(this, localIAppBrandPageContainer, paramString1, paramString2, localRequestEvent));
      }
      if (localJsPluginEngine != null) {
        return localJsPluginEngine.handleNativeRequest(paramString1, paramString2, localIAppBrandService, paramInt);
      }
      return "";
    }
    catch (Throwable paramString1)
    {
      QMLog.e("EventListener", "", paramString1);
    }
    return "";
  }
  
  public void onWebViewEvent(String paramString1, String paramString2, int paramInt)
  {
    if (this.mRuntime.appBrandService == null) {
      return;
    }
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventListener  onWebViewEvent eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",pageWebviewId=");
      localStringBuilder.append(paramInt);
      QMLog.d("EventListener", localStringBuilder.toString());
    }
    if ((paramString2 != null) && (paramString2.contains("__DOMReady")))
    {
      if (!this.isFirstDomReady) {
        checkUpdate();
      }
      this.isFirstDomReady = true;
    }
    this.mRuntime.appBrandService.evaluateSubscribeJS(paramString1, paramString2, paramInt);
  }
  
  public String onWebViewNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append("onWebViewNativeRequest eventName=");
      paramString2.append(paramString1);
      paramString2.append(",callbackId=");
      paramString2.append(paramInt);
      QMLog.d("EventListener", paramString2.toString());
      return "";
    }
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventListener onWebViewNativeRequest eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",callbackId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  (");
      localStringBuilder.append(paramIJsService);
      localStringBuilder.append(")");
      QMLog.d("EventListener", localStringBuilder.toString());
    }
    if ((paramString1.equals("remoteDebugInfo")) && ((this.mRuntime.appBrandService instanceof AppBrandRemoteService)))
    {
      ((AppBrandRemoteService)this.mRuntime.appBrandService).sendDomEvent(paramString2, paramInt);
      return "";
    }
    if (this.mRuntime.jsPluginEngine == null) {
      return "";
    }
    return this.mRuntime.jsPluginEngine.handleNativeRequest(paramString1, paramString2, paramIJsService, paramInt);
  }
  
  public void onWebViewReady(String paramString1, String paramString2, int paramInt)
  {
    MiniReportManager.reportEventType(this.mRuntime.getMiniAppInfo(), 120, paramString2, null, null, 0);
    onAppRoute(paramString1, paramString2, paramInt);
    onAppRouteDone(paramString1, paramString2, paramInt);
  }
  
  public final void reload(String paramString)
  {
    if (this.mRuntime.pageContainer != null) {
      this.mRuntime.pageContainer.cleanup(false);
    }
    BaseAppBrandRuntime localBaseAppBrandRuntime = this.mRuntime;
    localBaseAppBrandRuntime.onLoadMiniAppInfo(localBaseAppBrandRuntime.getMiniAppInfo(), true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener
 * JD-Core Version:    0.7.0.1
 */
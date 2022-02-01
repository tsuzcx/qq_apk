package com.tencent.qqmini.miniapp.core.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.miniapp.util.AdReportInfoUtil;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandService
  extends AbsAppBrandService
{
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  private static boolean JscoreInited = false;
  protected static final String TAG = "AppBrandService";
  protected static HandlerThread mHandlerThread;
  protected static Handler mThreadHandler;
  private ServiceEventListener mAppBrandEventInterface;
  private EmbeddedState mEmbeddedState = null;
  protected JsContext mJsContext;
  protected JsVirtualMachine mVM;
  protected String threadName = "mini_service_thread";
  
  public AppBrandService(IMiniAppContext paramIMiniAppContext, ServiceEventListener paramServiceEventListener)
  {
    super(paramIMiniAppContext);
    setAppBrandEventInterface(paramServiceEventListener);
    try
    {
      if (mHandlerThread == null)
      {
        mHandlerThread = new HandlerThread(this.threadName);
        mHandlerThread.start();
        mThreadHandler = new Handler(mHandlerThread.getLooper());
      }
      return;
    }
    finally {}
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label63:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label63;
      }
    }
  }
  
  private void reportEmbeddedStatus(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new AppBrandService.4(this, paramInt, paramString));
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    evaluateJs(paramString, paramValueCallback, null);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if (Thread.currentThread() == mHandlerThread)
    {
      paramString2 = this.mJsContext;
      if (paramString2 != null) {
        paramString2.evaluateJavascript(paramString1, paramValueCallback);
      }
    }
    else
    {
      mThreadHandler.post(new AppBrandService.3(this, paramString1, paramValueCallback));
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateSubscribeJS  eventName=");
    localStringBuilder.append(paramString1);
    QMLog.d("AppBrandService", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(0);
    localStringBuilder.append(")");
    paramString1 = localStringBuilder.toString();
    if (!isStateSucc())
    {
      QMLog.e("AppBrandService", "Service is not completd! Add to waiting list");
      addWaitEvaluateJs(paramString1);
      return;
    }
    evaluateJs(paramString1, null);
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("appId", paramApkgInfo.appId);
      ((JSONObject)localObject3).put("icon", paramApkgInfo.iconUrl);
      ((JSONObject)localObject3).put("nickname", paramApkgInfo.apkgName);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (paramApkgInfo.mMiniAppInfo != null)
    {
      localObject1 = paramApkgInfo.mMiniAppInfo.getVerTypeStr();
      localObject2 = paramApkgInfo.mMiniAppInfo.version;
    }
    else
    {
      localObject2 = "";
      localObject1 = "release";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("'; __qqConfig.deviceinfo='");
    localStringBuilder.append(QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()));
    localStringBuilder.append("'; __qqConfig.miniapp_version='");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("';");
    Object localObject2 = String.format(localStringBuilder.toString(), new Object[] { paramApkgInfo.mConfigStr, ((JSONObject)localObject3).toString() });
    localObject3 = StorageUtil.getPreference();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramApkgInfo.appId);
    localStringBuilder.append("_debug");
    Object localObject1 = localObject2;
    if (((SharedPreferences)localObject3).getBoolean(localStringBuilder.toString(), false))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("__qqConfig.debug=true;");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (this.mEmbeddedState != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("__qqConfig.useXWebVideo=");
      ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedVideo());
      ((StringBuilder)localObject2).append(";");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("__qqConfig.useXWebLive=");
      ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedLive());
      ((StringBuilder)localObject2).append(";");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("__qqConfig.useXWebElement=");
      ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedElement());
      ((StringBuilder)localObject2).append(";");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("x5 service enableEmbeddedVideo : ");
      ((StringBuilder)localObject1).append(this.mEmbeddedState.isEnableEmbeddedVideo());
      QMLog.d("miniapp-embedded", ((StringBuilder)localObject1).toString());
      if (this.mEmbeddedState.isEnableEmbeddedVideo()) {
        localObject1 = "x5_embedded_video";
      } else {
        localObject1 = "x5_native_video";
      }
      reportEmbeddedStatus(770, (String)localObject1);
      if (this.mEmbeddedState.isEnableEmbeddedLive()) {
        localObject1 = "x5_embedded_live";
      } else {
        localObject1 = "x5_native_live";
      }
      reportEmbeddedStatus(771, (String)localObject1);
      if (this.mEmbeddedState.isEnableEmbeddedElement()) {
        localObject1 = "x5_embedded_element";
      } else {
        localObject1 = "x5_native_element";
      }
      reportEmbeddedStatus(772, (String)localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(String.format("__qqConfig.adReportInfo=%1$s;", new Object[] { AdReportInfoUtil.getAdReportInfo(paramApkgInfo).toString() }));
    paramApkgInfo = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramApkgInfo);
    ((StringBuilder)localObject1).append("if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};");
    return ((StringBuilder)localObject1).toString();
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("USER_DATA_PATH", "qqfile://usr");
        ((JSONObject)localObject2).put("env", localObject1);
        ((JSONObject)localObject2).put("preload", paramBoolean);
        int i = WnsConfig.getConfig("qqminiapp", "xprof_api_report", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='");
        localStringBuilder.append(QUAUtil.getPlatformQUA());
        localStringBuilder.append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
        if (i == 0)
        {
          localObject1 = "false";
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(";");
          localObject1 = String.format(localStringBuilder.toString(), new Object[] { localObject2 });
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getJsDefaultConfig ServiceWebview String: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QMLog.d("minisdk-start", ((StringBuilder)localObject2).toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getJsDefaultConfig failed: ");
        ((StringBuilder)localObject2).append(localException);
        QMLog.d("minisdk-start", ((StringBuilder)localObject2).toString());
        return "";
      }
      String str = "true";
    }
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  protected void init(Context paramContext)
  {
    Log.e("AppBrandService", "ServiceWebview init ... ");
    this.mVM = new JsVirtualMachine(paramContext, mThreadHandler.getLooper());
    this.mJsContext = new JsContext(this.mVM);
    this.mJsContext.setExceptionHandler(new AppBrandService.2(this));
    onAddingJsInterface();
    sendEvent(Integer.valueOf(3));
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    setDefaultConfigJs(getJsDefaultConfig(true));
    setWaServiceJS(paramBaselibContent.waServiceJsStr, paramBaselibContent.waServicePath);
  }
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState)
  {
    this.mEmbeddedState = paramEmbeddedState;
  }
  
  public void initFramework(Context paramContext, StateMachine.OnStateChangeListener paramOnStateChangeListener)
  {
    if (paramOnStateChangeListener != null) {
      addStateChangeListener(paramOnStateChangeListener);
    }
    TbsLog.initIfNeed(paramContext);
    paramOnStateChangeListener = new AppBrandService.1(this, paramContext);
    QbSdk.preInit(this.miniAppContext.getContext(), paramOnStateChangeListener);
    if (JscoreInited) {
      init(paramContext);
    }
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invokeHandler|service: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" |id:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("AppBrandService", ((StringBuilder)localObject).toString());
    localObject = this.mAppBrandEventInterface;
    if (localObject != null) {
      return ((ServiceEventListener)localObject).onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  protected void onAddingJsInterface()
  {
    this.mJsContext.addJavascriptInterface(this, "WeixinJSCore");
    this.mJsContext.addJavascriptInterface(new MiniWorkerInterface(this.miniAppContext), "WeixinWorker");
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishHandler|service: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" |webviewIds:");
    ((StringBuilder)localObject).append(paramString3);
    QMLog.d("AppBrandService", ((StringBuilder)localObject).toString());
    localObject = paramString3;
    if ("[]".equals(paramString3)) {
      localObject = "";
    }
    paramString3 = this.mAppBrandEventInterface;
    if (paramString3 != null) {
      paramString3.onServiceEvent(paramString1, paramString2, jsStringToJavaIntArray((String)localObject));
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return;
    }
    setGlobalConfigJs(getJSGlobalConfig(paramApkgInfo));
    setAppServiceJs(paramApkgInfo.getAppServiceJsContent());
  }
  
  public void setAppBrandEventInterface(ServiceEventListener paramServiceEventListener)
  {
    this.mAppBrandEventInterface = paramServiceEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService
 * JD-Core Version:    0.7.0.1
 */
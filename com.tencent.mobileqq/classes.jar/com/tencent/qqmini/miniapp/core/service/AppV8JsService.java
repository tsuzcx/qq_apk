package com.tencent.qqmini.miniapp.core.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
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
import com.tencent.qqmini.v8rt.engine.Engine;
import com.tencent.qqmini.v8rt.engine.Logger;
import com.tencent.qqmini.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.qqmini.v8rt.engine.V8JsContext;
import com.tencent.qqmini.v8rt.engine.V8JsRuntime;
import com.tencent.qqmini.v8rt.engine.WorkerHandlerProvider;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class AppV8JsService
  extends AbsAppBrandService
{
  public static final String TAG = "V8ServiceRuntime";
  private Context context;
  private Engine engine = Engine.getInstance();
  private boolean injectFlutterFlag = false;
  private V8JsRuntime jsRuntime;
  private EmbeddedState mEmbeddedState = null;
  
  static
  {
    Logger.init(new V8LogImpl());
  }
  
  public AppV8JsService(IMiniAppContext paramIMiniAppContext)
  {
    this(paramIMiniAppContext, false);
  }
  
  public AppV8JsService(IMiniAppContext paramIMiniAppContext, boolean paramBoolean)
  {
    super(paramIMiniAppContext);
    if (WnsConfig.getConfig("qqminiapp", "mini_app_enable_v8_service_debug", 0) > 0) {
      this.engine.setDebuggerOption(true, false);
    }
    this.engine.setLibLoader(new V8rtSoLoader());
    this.engine.initEngine(paramIMiniAppContext.getContext());
    this.injectFlutterFlag = paramBoolean;
    this.context = paramIMiniAppContext.getContext();
    if (this.engine.getStatus() == 0)
    {
      try
      {
        this.jsRuntime = this.engine.createJsRuntime();
        this.jsRuntime.getDefaultContext().injectAll();
        initWorker();
        sendEvent(Integer.valueOf(3));
        paramIMiniAppContext = new StringBuilder();
        paramIMiniAppContext.append("create jsruntime success ");
        paramIMiniAppContext.append(this.jsRuntime);
        Logger.i("TV8ENG", paramIMiniAppContext.toString());
      }
      finally {}
    }
    else
    {
      paramIMiniAppContext = new StringBuilder();
      paramIMiniAppContext.append("create jsruntime failed, engine status:");
      paramIMiniAppContext.append(this.engine.getStatus());
      Logger.e("TV8ENG", paramIMiniAppContext.toString());
    }
    setJsStateListener(new AppV8JsService.1(this));
  }
  
  private void reportEmbeddedStatus(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new AppV8JsService.7(this, paramInt, paramString));
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.jsRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateCallbackJs  callbackId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",result=");
      localStringBuilder.append(paramString);
      Logger.d("V8ServiceRuntime", localStringBuilder.toString());
      evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateCallbackJs failed jsRuntime null");
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    evaluateJs(paramString, paramValueCallback, null);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ((paramString2.endsWith("QLogic.js")) && (paramString2.startsWith("/")))
      {
        if (paramString2.startsWith("assets://"))
        {
          localObject1 = new File(paramString2.substring(9));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.context.getCacheDir().getPath());
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("cc_assets");
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(((File)localObject1).getParentFile().getPath());
          localObject1 = new File(((StringBuilder)localObject2).toString());
          ((File)localObject1).mkdirs();
        }
        else
        {
          localObject1 = new File(paramString2).getParentFile();
          ((File)localObject1).mkdirs();
        }
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          paramString2 = new File(paramString2).getName();
          localObject1 = new File((File)localObject1, paramString2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          ((StringBuilder)localObject2).append(".cc");
          localObject1 = ((StringBuilder)localObject2).toString();
          break label248;
        }
      }
      else
      {
        localObject1 = "";
        break label248;
      }
    }
    paramString2 = null;
    Object localObject1 = paramString2;
    label248:
    boolean bool = TextUtils.isEmpty(paramString2) ^ true;
    Object localObject2 = this.jsRuntime;
    if (localObject2 != null)
    {
      if (paramValueCallback == null)
      {
        if (bool)
        {
          ((V8JsRuntime)localObject2).getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.2(this), paramString2, (String)localObject1);
          return;
        }
        ((V8JsRuntime)localObject2).getDefaultContext().evaluateJsAsync(paramString1, null);
        return;
      }
      if (bool)
      {
        ((V8JsRuntime)localObject2).getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.3(this, paramValueCallback), paramString2, (String)localObject1);
        return;
      }
      ((V8JsRuntime)localObject2).getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new AppV8JsService.4(this, paramValueCallback));
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
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
    paramString2 = new StringBuilder();
    paramString2.append("evaluateSubscribeJS: ");
    paramString2.append(paramString1);
    Logger.d("V8ServiceRuntime", paramString2.toString());
    if (!isStateSucc())
    {
      QMLog.e("V8ServiceRuntime", "Service is not completd! Add to waiting list");
      addWaitEvaluateJs(paramString1);
      return;
    }
    paramString2 = this.jsRuntime;
    if (paramString2 != null)
    {
      paramString2.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public int getEngineId()
  {
    V8JsRuntime localV8JsRuntime = this.jsRuntime;
    if (localV8JsRuntime != null) {
      return localV8JsRuntime.getId();
    }
    return -1;
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
          if (!this.injectFlutterFlag) {
            break label246;
          }
          localObject1 = "__qqConfig.useFlutter = true";
          localStringBuilder.append((String)localObject1);
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
      continue;
      label246:
      str = "";
    }
  }
  
  public int getStatus()
  {
    return this.engine.getStatus();
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
  
  public void initWorker()
  {
    MiniWorkerInterface localMiniWorkerInterface = new MiniWorkerInterface(this.miniAppContext);
    WorkerHandlerProvider.getInstance().setWorkerHandler(this.jsRuntime, new AppV8JsService.6(this, localMiniWorkerInterface));
  }
  
  public void release()
  {
    V8JsRuntime localV8JsRuntime = this.jsRuntime;
    if (localV8JsRuntime != null)
    {
      localV8JsRuntime.release();
      ServiceEventHandlerProvider.getInstance().removeServiceEventHandler(this.jsRuntime);
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
    ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jsRuntime, new AppV8JsService.5(this, paramServiceEventListener));
  }
  
  public void setAppServiceJs(String paramString)
  {
    this.stateAppServiceJsLoading.setJsContent(paramString, "app_service.js");
    appendEvent(Integer.valueOf(7));
  }
  
  public void setDefaultConfigJs(String paramString)
  {
    this.stateDefaulConfigJsLoading.setJsContent(paramString, "default_config.js");
    appendEvent(Integer.valueOf(4));
  }
  
  public void setGlobalConfigJs(String paramString)
  {
    this.stateGlobalConfigJsLoading.setJsContent(paramString, "global_config.js");
    appendEvent(Integer.valueOf(6));
  }
  
  public void setWaServiceJS(String paramString1, String paramString2)
  {
    this.stateWaJsLoading.setJsContent(paramString1, paramString2);
    appendEvent(Integer.valueOf(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppV8JsService
 * JD-Core Version:    0.7.0.1
 */
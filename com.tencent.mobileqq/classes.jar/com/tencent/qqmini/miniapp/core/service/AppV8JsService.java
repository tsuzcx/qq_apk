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
    if (this.engine.getStatus() == 0) {}
    for (;;)
    {
      try
      {
        this.jsRuntime = this.engine.createJsRuntime();
        this.jsRuntime.getDefaultContext().injectAll();
        initWorker();
        sendEvent(Integer.valueOf(3));
        Logger.i("TV8ENG", "create jsruntime success " + this.jsRuntime);
        setJsStateListener(new AppV8JsService.1(this));
        return;
      }
      finally {}
      Logger.e("TV8ENG", "create jsruntime failed, engine status:" + this.engine.getStatus());
    }
  }
  
  private void reportEmbeddedStatus(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new AppV8JsService.7(this, paramInt, paramString));
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.jsRuntime != null)
    {
      Logger.d("V8ServiceRuntime", "evaluateCallbackJs  callbackId=" + paramInt + ",result=" + paramString);
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
    Object localObject;
    if (!TextUtils.isEmpty(paramString2)) {
      if ((paramString2.endsWith("QLogic.js")) && (paramString2.startsWith("/"))) {
        if (paramString2.startsWith("assets://"))
        {
          localObject = new File(paramString2.substring("assets://".length()));
          localObject = new File(this.context.getCacheDir().getPath() + File.separator + "cc_assets" + File.separator + ((File)localObject).getParentFile().getPath());
          ((File)localObject).mkdirs();
          if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
            break label332;
          }
          paramString2 = new File(paramString2).getName();
          localObject = new File((File)localObject, paramString2);
          localObject = ((File)localObject).getAbsolutePath() + ".cc";
        }
      }
    }
    for (;;)
    {
      label184:
      if (!TextUtils.isEmpty(paramString2)) {}
      for (int i = 1;; i = 0)
      {
        if (this.jsRuntime != null)
        {
          if (paramValueCallback != null) {
            break label282;
          }
          if (i == 0) {
            break label269;
          }
          this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.2(this), paramString2, (String)localObject);
        }
        return;
        localObject = new File(paramString2).getParentFile();
        ((File)localObject).mkdirs();
        break;
        localObject = "";
        break label184;
      }
      label269:
      this.jsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
      label282:
      if (i != 0)
      {
        this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.3(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new AppV8JsService.4(this, paramValueCallback));
      return;
      label332:
      paramString2 = null;
      localObject = null;
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    Logger.d("V8ServiceRuntime", "evaluateSubscribeJS: " + paramString1);
    if (!isStateSucc())
    {
      QMLog.e("V8ServiceRuntime", "Service is not completd! Add to waiting list");
      addWaitEvaluateJs(paramString1);
      return;
    }
    if (this.jsRuntime != null)
    {
      this.jsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public int getEngineId()
  {
    if (this.jsRuntime != null) {
      return this.jsRuntime.getId();
    }
    return -1;
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", paramApkgInfo.appId);
      localJSONObject.put("icon", paramApkgInfo.iconUrl);
      localJSONObject.put("nickname", paramApkgInfo.apkgName);
      Object localObject2 = "release";
      Object localObject1 = "";
      if (paramApkgInfo.mMiniAppInfo != null)
      {
        localObject2 = paramApkgInfo.mMiniAppInfo.getVerTypeStr();
        localObject1 = paramApkgInfo.mMiniAppInfo.version;
      }
      localObject2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + (String)localObject2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "'; __qqConfig.miniapp_version='" + (String)localObject1 + "';", new Object[] { paramApkgInfo.mConfigStr, localJSONObject.toString() });
      localObject1 = localObject2;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        localObject1 = (String)localObject2 + "__qqConfig.debug=true;";
      }
      localObject2 = localObject1;
      if (this.mEmbeddedState != null)
      {
        localObject1 = (String)localObject1 + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";";
        localObject2 = (String)localObject1 + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";";
        QMLog.d("miniapp-embedded", "x5 service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
        if (this.mEmbeddedState.isEnableEmbeddedVideo())
        {
          localObject1 = "x5_embedded_video";
          reportEmbeddedStatus(770, (String)localObject1);
          if (!this.mEmbeddedState.isEnableEmbeddedLive()) {
            break label455;
          }
          localObject1 = "x5_embedded_live";
          reportEmbeddedStatus(771, (String)localObject1);
        }
      }
      else
      {
        paramApkgInfo = (String)localObject2 + String.format("__qqConfig.adReportInfo=%1$s;", new Object[] { AdReportInfoUtil.getAdReportInfo(paramApkgInfo).toString() });
        return paramApkgInfo + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        String str = "x5_native_video";
        continue;
        label455:
        str = "x5_native_live";
      }
    }
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("USER_DATA_PATH", "qqfile://usr");
        localJSONObject.put("env", localObject);
        localJSONObject.put("preload", paramBoolean);
        int i = WnsConfig.getConfig("qqminiapp", "xprof_api_report", 0);
        StringBuilder localStringBuilder = new StringBuilder().append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='").append(QUAUtil.getPlatformQUA()).append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
        if (i == 0)
        {
          localObject = "false";
          localStringBuilder = localStringBuilder.append((String)localObject).append(";");
          if (this.injectFlutterFlag)
          {
            localObject = "__qqConfig.useFlutter = true";
            localObject = String.format((String)localObject, new Object[] { localJSONObject });
            QMLog.d("minisdk-start", "getJsDefaultConfig ServiceWebview String: " + (String)localObject);
            return localObject;
          }
          localObject = "";
          continue;
        }
        String str = "true";
      }
      catch (Exception localException)
      {
        QMLog.d("minisdk-start", "getJsDefaultConfig failed: " + localException);
        return "";
      }
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
    if (this.jsRuntime != null)
    {
      this.jsRuntime.release();
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
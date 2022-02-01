package com.tencent.qqmini.flutter.core.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class AppV8JsService
  extends AbsAppBrandService
{
  public static final String TAG = "V8ServiceRuntime";
  private Context context;
  private Engine engine = Engine.getInstance();
  private V8JsRuntime jsRuntime;
  
  static
  {
    Logger.init(new V8LogImpl());
  }
  
  public AppV8JsService(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext);
    this.engine.setLibLoader(new V8AsyncLibLoader());
    this.engine.initEngine(paramIMiniAppContext.getContext());
    this.context = paramIMiniAppContext.getContext();
    if (this.engine.getStatus() == 0) {}
    for (;;)
    {
      try
      {
        this.jsRuntime = this.engine.createJsRuntime();
        this.jsRuntime.getDefaultContext().injectAll();
        sendEvent(Integer.valueOf(3));
        Logger.i("TV8ENG", "create jsruntime success " + this.jsRuntime);
        setJsStateListener(new AppV8JsService.1(this));
        return;
      }
      finally {}
      Logger.e("TV8ENG", "create jsruntime failed, engine status:" + this.engine.getStatus());
    }
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
            break label330;
          }
          paramString2 = new File(paramString2).getName();
          localObject = new File((File)localObject, paramString2);
          localObject = ((File)localObject).getAbsolutePath() + ".cc";
        }
      }
    }
    for (;;)
    {
      label183:
      if (!TextUtils.isEmpty(paramString2)) {}
      for (int i = 1;; i = 0)
      {
        if (this.jsRuntime != null)
        {
          if (paramValueCallback != null) {
            break label280;
          }
          if (i == 0) {
            break label267;
          }
          this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.2(this), paramString2, (String)localObject);
        }
        return;
        localObject = new File(paramString2).getParentFile();
        ((File)localObject).mkdirs();
        break;
        localObject = "";
        break label183;
      }
      label267:
      this.jsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
      label280:
      if (i != 0)
      {
        this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new AppV8JsService.3(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new AppV8JsService.4(this, paramValueCallback));
      return;
      label330:
      paramString2 = null;
      localObject = null;
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    Logger.d("V8ServiceRuntime", "evaluateSubscribeJS: " + paramString1);
    if (this.jsRuntime != null)
    {
      this.jsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appId", paramApkgInfo.appId);
      ((JSONObject)localObject).put("icon", paramApkgInfo.iconUrl);
      ((JSONObject)localObject).put("nickname", paramApkgInfo.apkgName);
      String str = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { paramApkgInfo.mConfigStr, ((JSONObject)localObject).toString() });
      localObject = str;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        localObject = str + "__qqConfig.debug=true;";
      }
      return (String)localObject + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject).put("env", localJSONObject);
      ((JSONObject)localObject).put("preload", paramBoolean);
      ((JSONObject)localObject).put("useFlutter", true);
      ((JSONObject)localObject).put("platform", "android");
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.e("V8ServiceRuntime", "getJsDefaultConfig failed: " + localException);
    }
    return "";
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
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState) {}
  
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
    String str = "";
    try
    {
      paramApkgInfo = FileUtils.readFileToString(new File(paramApkgInfo.getAppServiceJsPath()));
      setAppServiceJs(paramApkgInfo);
      return;
    }
    catch (IOException paramApkgInfo)
    {
      for (;;)
      {
        paramApkgInfo.printStackTrace();
        paramApkgInfo = str;
      }
    }
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
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.AppV8JsService
 * JD-Core Version:    0.7.0.1
 */
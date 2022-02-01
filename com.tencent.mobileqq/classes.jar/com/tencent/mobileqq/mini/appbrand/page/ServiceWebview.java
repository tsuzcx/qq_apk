package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsErrorListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.utils.TbsLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceWebview
  extends AbstactJsRuntime
{
  private static final boolean DEBUG_TBS = true;
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  protected static final String JS_INTERFACE_WORKER = "WeixinWorker";
  private static boolean JscoreInited = false;
  public static final String TAG = "miniapp-start";
  boolean AppServiceJsLoaded = false;
  public AppBrandServiceEventInterface appBrandEventInterface;
  private HashMap<String, Boolean> appServiceJsLoadFlagMap;
  protected boolean enableEmbeddedLive;
  protected boolean enableEmbeddedVideo;
  protected AppBrandRuntime mAppBrandRuntime;
  private ServiceWebview.Callback mCallback;
  private boolean mEnableNativeBuffer = true;
  protected JsContext mJsContext;
  public AppBrandRuntime.JsErrorListener mJsErrorListener;
  private AppBrandRuntime.OnLoadServiceWebvieJsListener mListener;
  protected JsVirtualMachine mVM;
  public int pageWebviewId;
  boolean waServiceJSLoaded = false;
  
  public ServiceWebview(Context paramContext)
  {
    this(paramContext, "");
  }
  
  public ServiceWebview(Context paramContext, String paramString)
  {
    this(paramContext, "", null);
  }
  
  public ServiceWebview(Context paramContext, String paramString, ServiceWebview.Callback paramCallback)
  {
    super(paramContext, paramString);
    setCallback(paramCallback);
    if (shouldInitFramework()) {
      initFramework(paramContext);
    }
  }
  
  private void initAppServiceJs(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    QLog.i("miniapp-start", 1, "---begin initAppServiceJs----：apkgInfo:" + paramApkgInfo);
    if (paramApkgInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", paramApkgInfo.appId);
      localJSONObject.put("icon", paramApkgInfo.iconUrl);
      localJSONObject.put("nickname", paramApkgInfo.apkgName);
      MiniReportManager.reportEventType(paramApkgInfo.appConfig, 104, getUrl(), null, null, 0);
      String str1 = "release";
      String str2 = "";
      Object localObject2 = str2;
      Object localObject1 = str1;
      if (paramApkgInfo != null)
      {
        localObject2 = str2;
        localObject1 = str1;
        if (paramApkgInfo.appConfig != null)
        {
          localObject2 = str2;
          localObject1 = str1;
          if (paramApkgInfo.appConfig.config != null)
          {
            localObject1 = paramApkgInfo.appConfig.config.getVerTypeStr();
            localObject2 = paramApkgInfo.appConfig.config.version;
          }
        }
      }
      localObject2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; __qqConfig = extend(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.envVersion='" + (String)localObject1 + "'; __qqConfig.deviceinfo='" + PlatformInfor.g().getSimpleDeviceInfor() + "'; __qqConfig.miniapp_version='" + (String)localObject2 + "';", new Object[] { paramApkgInfo.mConfigStr, localJSONObject.toString() });
      localObject1 = localObject2;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        localObject1 = (String)localObject2 + "__qqConfig.debug=true;";
      }
      localObject2 = localObject1;
      if (paramApkgInfo != null)
      {
        localObject2 = localObject1;
        if (paramApkgInfo.appConfig != null)
        {
          localObject2 = localObject1;
          if (paramApkgInfo.appConfig.launchParam == null) {}
        }
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fromAppid", paramApkgInfo.appConfig.launchParam.fromMiniAppId);
        if (paramApkgInfo.appConfig.launchParam.entryModel != null)
        {
          if (paramApkgInfo.appConfig.launchParam.entryModel.type == 0) {
            ((JSONObject)localObject2).put("fromQQ", paramApkgInfo.appConfig.launchParam.entryModel.uin);
          }
          if (paramApkgInfo.appConfig.launchParam.entryModel.type == 1) {
            ((JSONObject)localObject2).put("fromGroupId", paramApkgInfo.appConfig.launchParam.entryModel.uin);
          }
        }
        ((JSONObject)localObject2).put("appStartTime", MiniReportManager.getLaunchStartTime(paramApkgInfo.appId));
        localObject2 = (String)localObject1 + String.format("__qqConfig.adReportInfo=%1$s;", new Object[] { ((JSONObject)localObject2).toString() });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("miniapp-start", 1, "adReportInfo error,", localThrowable);
          Object localObject3 = localJSONException;
        }
      }
      evaluteJs((String)localObject2 + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};", new ServiceWebview.3(this, paramString, paramApkgInfo, paramOnLoadServiceWebvieJsListener));
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
  
  private static Message obtainMessage(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    return localMessage;
  }
  
  public void clearUp()
  {
    setCallback(null);
    if (this.mJsContext != null)
    {
      this.mJsContext.removeJavascriptInterface("WeixinJSCore");
      this.mJsContext.destroy();
      this.mJsContext = null;
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    QLog.i("miniapp-JS", 2, "evaluateCallbackJs");
    evaluteJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    this.mThreadHandler.post(new ServiceWebview.7(this, paramString1, paramString2, paramInt));
  }
  
  public void evaluteJs(String paramString, ValueCallback paramValueCallback)
  {
    this.mThreadHandler.post(new ServiceWebview.6(this, paramString, paramValueCallback));
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("USER_DATA_PATH", MiniAppGlobal.STR_WXFILE + "usr");
        localJSONObject.put("env", localObject);
        localJSONObject.put("preload", paramBoolean);
        int i = QzoneConfig.getInstance().getConfig("qqminiapp", "xprof_api_report", 0);
        StringBuilder localStringBuilder = new StringBuilder().append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};");
        if (this.mEnableNativeBuffer)
        {
          localObject = "__qqConfig.nativeBufferEnabled = true;";
          localStringBuilder = localStringBuilder.append((String)localObject).append("__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='").append(QUA.getQUA3()).append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
          if (i == 0)
          {
            localObject = "false";
            localObject = String.format((String)localObject + ";", new Object[] { localJSONObject });
            localObject = (String)localObject + "__qqConfig.useXWebVideo=" + this.enableEmbeddedVideo + ";";
            localObject = (String)localObject + "__qqConfig.useXWebLive=" + this.enableEmbeddedLive + ";";
            QLog.d("miniapp-embedded", 1, "service enableEmbeddedVideo : " + this.enableEmbeddedVideo);
            QLog.d("miniapp-embedded", 1, "service useXWebLive : " + this.enableEmbeddedLive);
            QLog.d("miniapp-start", 2, "getJsDefaultConfig ServiceWebview String: " + (String)localObject);
            return localObject;
          }
          localObject = "true";
          continue;
        }
        String str = "";
      }
      catch (Exception localException)
      {
        QLog.e("miniapp-start", 2, "getJsDefaultConfig failed: " + localException);
        return "";
      }
    }
  }
  
  public int getPageWebViewId()
  {
    return 0;
  }
  
  public String getUrl()
  {
    return "";
  }
  
  protected void init(Context paramContext)
  {
    Log.e("miniapp-start", "ServiceWebview init ... ");
    this.mVM = new JsVirtualMachine(paramContext, this.mThreadHandler.getLooper());
    this.mJsContext = new JsContext(this.mVM);
    this.mJsContext.setExceptionHandler(new ServiceWebview.2(this));
    this.appServiceJsLoadFlagMap = new HashMap();
    onAddingJsInterface();
    onInitOver();
  }
  
  public void initFramework(Context paramContext)
  {
    TbsLog.initIfNeed(paramContext);
    ServiceWebview.1 local1 = new ServiceWebview.1(this);
    QbSdk.preInit(this.mContext, local1);
    if (JscoreInited) {
      init(paramContext);
    }
  }
  
  public void initJSDefaultConfig(ValueCallback paramValueCallback)
  {
    evaluteJs(getJsDefaultConfig(true), paramValueCallback);
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    QLog.e("miniapp-start", 1, "initService  ... waServiceJSLoaded:" + this.waServiceJSLoaded + "  AppServiceJsLoaded:" + this.AppServiceJsLoaded);
    this.apkgInfo = paramApkgInfo;
    this.mListener = paramOnLoadServiceWebvieJsListener;
    if (this.waServiceJSLoaded)
    {
      if (this.AppServiceJsLoaded) {
        break label79;
      }
      this.AppServiceJsLoaded = true;
      initAppServiceJs(paramApkgInfo, null, paramOnLoadServiceWebvieJsListener);
    }
    label79:
    while (paramOnLoadServiceWebvieJsListener == null) {
      return;
    }
    paramOnLoadServiceWebvieJsListener.onLoadFinish();
  }
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    QLog.e("miniapp-start", 1, "initService  ... waServiceJSLoaded:" + this.waServiceJSLoaded + "  AppServiceJsLoaded:" + this.AppServiceJsLoaded);
    this.apkgInfo = paramApkgInfo;
    this.mListener = paramOnLoadServiceWebvieJsListener;
    if (this.waServiceJSLoaded)
    {
      if (this.AppServiceJsLoaded) {
        break label79;
      }
      this.AppServiceJsLoaded = true;
      initAppServiceJs(paramApkgInfo, paramString, paramOnLoadServiceWebvieJsListener);
    }
    label79:
    while (paramOnLoadServiceWebvieJsListener == null) {
      return;
    }
    paramOnLoadServiceWebvieJsListener.onLoadFinish();
  }
  
  public void initWAServiceJS(String paramString)
  {
    QLog.i("miniapp-start", 1, "---begin initWAServiceJS---- waServiceJSLoaded: " + this.waServiceJSLoaded);
    if (this.waServiceJSLoaded)
    {
      if (this.appServiceJsCallback != null) {
        this.appServiceJsCallback.onReceiveValue(new Object());
      }
      return;
    }
    if (this.apkgInfo != null) {
      MiniReportManager.reportEventType(this.apkgInfo.appConfig, 14, getUrl(), null, null, 0);
    }
    for (;;)
    {
      QLog.i("miniapp-start", 1, "---begin service default config----");
      initJSDefaultConfig(new ServiceWebview.4(this, paramString));
      paramString = AppBrandProxy.g().getMiniAppConfig();
      if ((paramString == null) || (paramString.config == null) || (TextUtils.isEmpty(paramString.config.appId))) {
        break;
      }
      MiniAppStartState.setBaseLibLoad(paramString.config.appId, false);
      return;
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 14, getUrl(), null, null, 0);
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mJsContext == null;
  }
  
  public void loadAppServiceJs(String paramString)
  {
    QLog.i("miniapp-start", 1, "loadAppServiceJs  begin ");
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.apkgInfo == null);
        paramString = this.apkgInfo.getRootPath(paramString);
      } while ((TextUtils.isEmpty(paramString)) || ((this.appServiceJsLoadFlagMap.get(paramString) != null) && (((Boolean)this.appServiceJsLoadFlagMap.get(paramString)).booleanValue())));
      str = this.apkgInfo.getAppServiceJsContent(paramString);
    } while (TextUtils.isEmpty(str));
    evaluteJs(str, new ServiceWebview.5(this, paramString));
    QLog.i("miniapp-start", 2, "loadAppServiceJs  end ");
  }
  
  protected void onAddingJsInterface()
  {
    this.mJsContext.addJavascriptInterface(new ServiceWebview.ServiceInterface(this, null), "WeixinJSCore");
    this.mJsContext.addJavascriptInterface(new ServiceWebview.MainWorkerInterface(this, null), "WeixinWorker");
  }
  
  protected void onInitOver()
  {
    AppLoaderFactory.getAppLoaderManager().notifyMessage(obtainMessage(320));
    if (this.mCallback != null) {
      this.mCallback.onJscoreInited();
    }
  }
  
  public void postMessageToMainThread(String paramString)
  {
    paramString = String.format("WeixinWorker.workerMsgHandler('" + Integer.valueOf(1) + "',%s)", new Object[] { paramString });
    QLog.i("miniapp-JS", 2, "[postMessageToMain] jsScript:" + paramString);
    evaluteJs(paramString, new ServiceWebview.8(this));
  }
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface)
  {
    this.appBrandEventInterface = paramAppBrandServiceEventInterface;
  }
  
  public void setCallback(ServiceWebview.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setEnableEmbeddedLive(boolean paramBoolean)
  {
    this.enableEmbeddedLive = paramBoolean;
  }
  
  public void setEnableEmbeddedVideo(boolean paramBoolean)
  {
    this.enableEmbeddedVideo = paramBoolean;
  }
  
  public void setEnableNativeBuffer(boolean paramBoolean)
  {
    this.mEnableNativeBuffer = paramBoolean;
  }
  
  public void setJsErrorListener(AppBrandRuntime.JsErrorListener paramJsErrorListener)
  {
    this.mJsErrorListener = paramJsErrorListener;
  }
  
  protected boolean shouldInitFramework()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview
 * JD-Core Version:    0.7.0.1
 */
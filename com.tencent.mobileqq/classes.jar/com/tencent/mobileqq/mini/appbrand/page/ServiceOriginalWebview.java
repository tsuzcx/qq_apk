package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import bjdl;
import bjdm;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsConsoleMessageListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsErrorListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.JSUtil;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceOriginalWebview
  extends BaseAppBrandWebview
{
  public static final String TAG = "ServiceOriginalWebview";
  boolean AppServiceJsLoaded = false;
  public AppBrandServiceEventInterface appBrandEventInterface;
  protected ValueCallback appServiceJsCallback;
  private HashMap<String, Boolean> appServiceJsLoadFlagMap = new HashMap();
  public AppBrandRuntime.JsConsoleMessageListener mJsConsoleMessageListener;
  public AppBrandRuntime.JsErrorListener mJsErrorListener;
  private AppBrandRuntime.OnLoadServiceWebvieJsListener mListener;
  boolean waServiceJSLoaded = false;
  
  public ServiceOriginalWebview(Context paramContext)
  {
    super(paramContext);
    addJavascriptInterface(this, "WeixinJSCore");
  }
  
  private void initAppServiceJs(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    if (paramApkgInfo == null) {}
    do
    {
      return;
      QLog.i("ServiceOriginalWebview", 2, "---begin initAppServiceJs----");
    } while (paramApkgInfo == null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", paramApkgInfo.appId);
      localJSONObject.put("icon", paramApkgInfo.iconUrl);
      localJSONObject.put("nickname", "testuser");
      MiniReportManager.reportEventType(paramApkgInfo.appConfig, 104, getUrl(), null, null, 0);
      String str3 = "release";
      String str4 = "";
      String str2 = str4;
      String str1 = str3;
      if (paramApkgInfo != null)
      {
        str2 = str4;
        str1 = str3;
        if (paramApkgInfo.appConfig != null)
        {
          str2 = str4;
          str1 = str3;
          if (paramApkgInfo.appConfig.config != null)
          {
            str1 = paramApkgInfo.appConfig.config.getVerTypeStr();
            str2 = paramApkgInfo.appConfig.config.version;
          }
        }
      }
      str2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str1 + "'; __qqConfig.deviceinfo='" + bjdl.a().f() + "'; __qqConfig.miniapp_version='" + str2 + "';", new Object[] { paramApkgInfo.mConfigStr, localJSONObject.toString() });
      str1 = str2;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        str1 = str2 + "__qqConfig.debug=true;";
      }
      evaluteJs(str1 + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};", new ServiceOriginalWebview.2(this, paramString, paramApkgInfo, paramOnLoadServiceWebvieJsListener));
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
  
  public void clearUp()
  {
    removeJavascriptInterface("WeixinJSCore");
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("USER_DATA_PATH", MiniAppGlobal.STR_WXFILE + "usr");
      localJSONObject.put("env", localObject);
      localJSONObject.put("preload", paramBoolean);
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "xprof_api_report", 0);
      StringBuilder localStringBuilder = new StringBuilder().append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='").append(bjdm.a()).append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
      if (i == 0) {}
      for (localObject = "false";; localObject = "true")
      {
        localObject = String.format((String)localObject + ";", new Object[] { localJSONObject });
        QLog.d("miniapp-start", 2, "getJsDefaultConfig BaseAppBrandWebview String: " + (String)localObject);
        return localObject;
      }
      return "";
    }
    catch (Exception localException)
    {
      QLog.e("miniapp-start", 2, "getJsDefaultConfig failed: " + localException);
    }
  }
  
  public String getUrl()
  {
    return "";
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    initService(paramApkgInfo, null, paramOnLoadServiceWebvieJsListener);
  }
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    this.apkgInfo = paramApkgInfo;
    this.mListener = paramOnLoadServiceWebvieJsListener;
    setWebChromeClient(new ServiceOriginalWebview.1(this));
    if (QLog.isColorLevel()) {
      QLog.i("ServiceOriginalWebview", 2, "---start getWAServiceJSStr----");
    }
    if (this.waServiceJSLoaded)
    {
      if (this.AppServiceJsLoaded) {
        break label64;
      }
      this.AppServiceJsLoaded = true;
      initAppServiceJs(paramApkgInfo, paramString, paramOnLoadServiceWebvieJsListener);
    }
    label64:
    while (paramOnLoadServiceWebvieJsListener == null) {
      return;
    }
    paramOnLoadServiceWebvieJsListener.onLoadFinish();
  }
  
  public void initWAServiceJS(String paramString)
  {
    QLog.i("ServiceOriginalWebview", 1, "---begin initWAServiceJS---- waServiceJSLoaded=" + this.waServiceJSLoaded);
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
      QLog.i("ServiceOriginalWebview", 1, "---begin service default config----");
      initJSDefaultConfig(new ServiceOriginalWebview.3(this, paramString));
      paramString = AppBrandProxy.g().getMiniAppConfig();
      if ((paramString == null) || (paramString.config == null) || (TextUtils.isEmpty(paramString.config.appId))) {
        break;
      }
      MiniAppStartState.setBaseLibLoad(paramString.config.appId, false);
      return;
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 14, getUrl(), null, null, 0);
    }
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    QLog.d("ServiceOriginalWebview", 1, "invokeHandler|service: " + paramString1 + " |id:" + paramInt);
    if (this.appBrandEventInterface != null) {
      return this.appBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  public void loadAppServiceJs(String paramString)
  {
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
    evaluteJs(str, new ServiceOriginalWebview.4(this, paramString));
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ServiceOriginalWebview", 1, "publishHandler|service: " + paramString1 + " |str3:" + paramString3);
    if ("[]".equals(paramString3))
    {
      paramString3 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.apkgInfo.appId, this.apkgInfo.appConfig.config.verType);
      if ((paramString3 != null) && (paramString3.pageContainer != null))
      {
        paramString3 = paramString3.pageContainer.pageLinkedList;
        if (paramString3 != null)
        {
          paramString3 = paramString3.iterator();
          while (paramString3.hasNext())
          {
            Object localObject = (AbsAppBrandPage)paramString3.next();
            if (localObject != null)
            {
              localObject = ((AbsAppBrandPage)localObject).getCurrentPageWebview();
              if (localObject != null) {
                ((PageWebview)localObject).evaluateSubcribeJSInService(paramString1, paramString2, ((PageWebview)localObject).getPageWebViewId());
              }
            }
          }
        }
      }
    }
    else if (this.appBrandEventInterface != null)
    {
      this.appBrandEventInterface.onServiceEvent(paramString1, paramString2, JSUtil.jsStringToJavaIntArray(paramString3));
    }
  }
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface)
  {
    this.appBrandEventInterface = paramAppBrandServiceEventInterface;
  }
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback)
  {
    this.appServiceJsCallback = paramValueCallback;
  }
  
  public void setJsConsoleMessageListener(AppBrandRuntime.JsConsoleMessageListener paramJsConsoleMessageListener)
  {
    this.mJsConsoleMessageListener = paramJsConsoleMessageListener;
  }
  
  public void setJsErrorListener(AppBrandRuntime.JsErrorListener paramJsErrorListener)
  {
    this.mJsErrorListener = paramJsErrorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview
 * JD-Core Version:    0.7.0.1
 */
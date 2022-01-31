package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class NavigationPlugin
  extends BaseJsPlugin
{
  public static final String API_EXIT_MINI_PROGRAM = "exitMiniProgram";
  public static final String API_NAVIGATE_BACK_MINI_PROGRAM = "navigateBackMiniProgram";
  public static final String API_NAVIGATE_TO_MINI_PROGRAM = "navigateToMiniProgram";
  private static final String HIDE_NAVBAR_LOADING = "hideNavigationBarLoading";
  private static final String SET_NAV_BAR_BG_COLOR = "setNavigationBarColor";
  private static final String SET_NAV_BAR_TITLE = "setNavigationBarTitle";
  private static final String SHOW_NAVBAR_LOADING = "showNavigationBarLoading";
  private static final Set<String> S_EVENT_MAP = new NavigationPlugin.1();
  private static final String TAG = "[mini] NavigationPlugin";
  private static final int navigateBackByAPPInfo = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  
  private void callback(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2)
  {
    if ((paramJsRuntime != null) && (paramJSONObject != null)) {
      paramJsRuntime.evaluateCallbackJs(paramInt, JSONUtil.append(paramJSONObject, "errMsg", paramString1 + ":" + paramString2).toString());
    }
  }
  
  private void callbackComplete(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "complete");
  }
  
  private void callbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "fail");
  }
  
  private void callbackOK(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "ok");
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramMiniAppInfo.appId;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString;
    localLaunchParam.fromBackToMiniApp = 1;
    localLaunchParam.fromMiniAppId = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.miniAppId;
    paramMiniAppInfo = new MiniAppConfig(paramMiniAppInfo);
    paramMiniAppInfo.launchParam = localLaunchParam;
    MiniAppController.startApp(this.jsPluginEngine.getActivityContext(), paramMiniAppInfo, new NavigationPlugin.9(this, new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
  }
  
  private boolean navigateBackMiniApp(JsRuntime paramJsRuntime, String paramString1, String paramString2)
  {
    paramJsRuntime = new LaunchParam();
    paramJsRuntime.miniAppId = paramString1;
    paramJsRuntime.scene = 1038;
    paramJsRuntime.navigateExtData = paramString2;
    paramJsRuntime.fromMiniAppId = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.miniAppId;
    MiniAppController.navigateBackMiniApp(this.jsPluginEngine.getActivityContext(), paramString1, paramJsRuntime, new NavigationPlugin.8(this));
    return true;
  }
  
  private void savaShowInfoToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationPlugin.10(this, paramMiniAppInfo), 32, null, true);
  }
  
  public NavigationBar getNavigationBar()
  {
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList != null))
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.peek();
      if (localAbsAppBrandPage != null) {
        return localAbsAppBrandPage.getNavBar();
      }
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    Object localObject3 = getNavigationBar();
    Object localObject5 = new JSONObject();
    int i;
    for (;;)
    {
      Object localObject2;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      try
      {
        Object localObject1 = new JSONObject(paramString2);
        if ("setNavigationBarTitle".equals(paramString1)) {
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optString("title");
            if (localObject3 != null)
            {
              AppBrandTask.runTaskOnUiThread(new NavigationPlugin.2(this, (NavigationBar)localObject3, (String)localObject1, paramJsRuntime, (JSONObject)localObject5, paramInt));
              return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] NavigationPlugin", 1, localThrowable, new Object[0]);
        localObject2 = null;
        continue;
        callbackFail(paramJsRuntime, (JSONObject)localObject5, paramInt, "setNavigationBarTitle");
        continue;
        callbackFail(paramJsRuntime, (JSONObject)localObject5, paramInt, "setNavigationBarTitle");
        continue;
        if ("showNavigationBarLoading".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new NavigationPlugin.3(this, (NavigationBar)localObject3, paramJsRuntime, paramString1, paramInt));
          continue;
        }
        if ("hideNavigationBarLoading".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new NavigationPlugin.4(this, (NavigationBar)localObject3, paramJsRuntime, paramString1, paramInt));
          continue;
        }
        if ("setNavigationBarColor".equals(paramString1))
        {
          if (localObject2 == null) {
            continue;
          }
          localObject6 = ((JSONObject)localObject2).optString("frontColor");
          localObject7 = ((JSONObject)localObject2).optString("backgroundColor");
          localObject8 = ((JSONObject)localObject2).optJSONObject("animation");
          localObject2 = null;
          long l = 0L;
          if (localObject8 != null)
          {
            l = ((JSONObject)localObject8).optLong("duration");
            localObject2 = ((JSONObject)localObject8).optString("timingFunc");
          }
          if (localObject3 != null)
          {
            AppBrandTask.runTaskOnUiThread(new NavigationPlugin.5(this, (String)localObject6, (NavigationBar)localObject3, (String)localObject2, (String)localObject7, l, paramJsRuntime, paramString1, paramInt));
            continue;
          }
          callbackFail(paramJsRuntime, (JSONObject)localObject5, paramInt, "setNavigationBarColor");
          continue;
        }
        if (!"navigateToMiniProgram".equals(paramString1)) {
          break label1133;
        }
      }
      MiniAppStateManager.getInstance().notifyChange("hideInput");
      if (localObject2 != null)
      {
        localObject5 = ((JSONObject)localObject2).optString("reportData");
        localObject6 = MiniAppInfo.createMiniAppInfo((JSONObject)localObject2);
        localObject7 = this.jsPluginEngine.getEntryModel();
        if (localObject6 != null) {
          try
          {
            localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappsearchappid", "1109875297");
            if ((this.jsPluginEngine.getAppInfo() != null) && (((String)localObject3).equals(this.jsPluginEngine.getAppInfo().appId)))
            {
              i = 2077;
              localObject3 = ((JSONObject)localObject2).optJSONObject("extraData");
              if (localObject3 == null) {
                break label595;
              }
            }
            label595:
            for (localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
            {
              localObject8 = new LaunchParam();
              ((LaunchParam)localObject8).scene = i;
              ((LaunchParam)localObject8).fromMiniAppId = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.miniAppId;
              ((LaunchParam)localObject8).navigateExtData = ((String)localObject3);
              if (localObject7 != null) {
                ((LaunchParam)localObject8).entryModel = ((EntryModel)localObject7);
              }
              MiniAppController.launchMiniAppByAppInfo(this.jsPluginEngine.activityContext, (MiniAppInfo)localObject6, (LaunchParam)localObject8);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              QLog.d("[mini] NavigationPlugin", 2, "navigateToMiniProgram, open miniApp from appInfo, appInfo: " + ((MiniAppInfo)localObject6).toString());
              if (((MiniAppInfo)localObject6).verType == 3) {
                savaShowInfoToDB((MiniAppInfo)localObject6);
              }
              return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
              if (!this.jsPluginEngine.isMiniAppStore()) {
                break label1342;
              }
              i = 2001;
              break;
            }
            i = ((JSONObject)localObject2).optInt("openType");
          }
          catch (MiniAppException localMiniAppException)
          {
            QLog.e("[mini] NavigationPlugin", 1, "navigateToMiniProgram, " + Log.getStackTraceString(localMiniAppException));
          }
        }
        Object localObject4 = ((JSONObject)localObject2).optString("appId");
        if (i == 0)
        {
          localObject6 = ((JSONObject)localObject2).optString("path");
          localObject7 = ((JSONObject)localObject2).optString("envVersion");
          localObject2 = ((JSONObject)localObject2).optJSONObject("extraData");
          if (localObject2 != null)
          {
            localObject2 = ((JSONObject)localObject2).toString();
            localObject8 = new LaunchParam();
            if (!this.jsPluginEngine.isMiniAppStore()) {
              break label1011;
            }
          }
          for (i = 2001;; i = 1037) {
            for (;;)
            {
              ((LaunchParam)localObject8).scene = i;
              ((LaunchParam)localObject8).entryPath = ((String)localObject6);
              ((LaunchParam)localObject8).navigateExtData = ((String)localObject2);
              ((LaunchParam)localObject8).fromMiniAppId = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.miniAppId;
              ((LaunchParam)localObject8).entryModel = this.jsPluginEngine.getEntryModel();
              ((LaunchParam)localObject8).envVersion = ((String)localObject7);
              if ((!this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.isSpecialMiniApp()) && (navigateBackByAPPInfo == 1))
              {
                ((LaunchParam)localObject8).fromEnvVersion = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.getVerTypeStr();
                ((LaunchParam)localObject8).fromMiniAppInfo = MiniAppInfo.copy(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config);
              }
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                break label1032;
              }
              try
              {
                ((LaunchParam)localObject8).reportData = new HashMap();
                localObject2 = ((String)localObject5).split("&");
                int j = localObject2.length;
                i = 0;
                while (i < j)
                {
                  String str2 = localObject2[i];
                  int k = str2.indexOf("=");
                  if ((k > 0) && (k < str2.length() - 1))
                  {
                    localObject5 = URLDecoder.decode(str2.substring(0, k), "UTF-8");
                    str2 = URLDecoder.decode(str2.substring(k + 1), "UTF-8");
                    ((LaunchParam)localObject8).reportData.put(localObject5, str2);
                  }
                  i += 1;
                }
                localObject2 = "";
              }
              catch (Exception localException)
              {
                label1011:
                QLog.e("[mini] NavigationPlugin", 1, "reportData error.", localException);
              }
            }
          }
          label1032:
          MiniAppController.startAppByAppid(this.jsPluginEngine.activityContext, (String)localObject4, (String)localObject6, (String)localObject7, (LaunchParam)localObject8, new NavigationPlugin.6(this, paramJsRuntime, paramString1, paramInt));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        else if (i == 1)
        {
          if (GameProxy.startGameByMiniApp(this.jsPluginEngine.appBrandRuntime.activity, (String)localObject4, localException))
          {
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
          else
          {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            continue;
            label1133:
            if ("navigateBackMiniProgram".equals(paramString1))
            {
              String str1;
              if (navigateBackByAPPInfo == 0)
              {
                if (localException != null)
                {
                  str1 = localException.optString("extraData");
                  localObject4 = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.fromMiniAppId;
                  if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (navigateBackMiniApp(paramJsRuntime, (String)localObject4, str1))) {
                    this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
                  } else {
                    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
                  }
                }
              }
              else if ((navigateBackByAPPInfo == 1) && (str1 != null))
              {
                str1 = str1.optString("extraData");
                localObject4 = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.fromMiniAppInfo;
                if (localObject4 != null) {
                  navigateBackMiniApp((MiniAppInfo)localObject4, str1, new NavigationPlugin.7(this, paramJsRuntime, paramString1, paramInt));
                }
              }
            }
            else if ("exitMiniProgram".equals(paramString1))
            {
              this.jsPluginEngine.appBrandRuntime.moveAppBrandToBack();
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      label1342:
      i = 1037;
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin
 * JD-Core Version:    0.7.0.1
 */
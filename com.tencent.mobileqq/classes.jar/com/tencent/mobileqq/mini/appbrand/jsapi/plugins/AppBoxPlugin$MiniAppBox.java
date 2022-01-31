package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import aanh;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class AppBoxPlugin$MiniAppBox
{
  private static final String ADUNIT_ID = "adUnitId";
  private static final String APP_BOX_ID = "id";
  private static final String COMP_ID = "compId";
  private static final String OPERATION_TYPE = "type";
  private static final String TAG = "[minigame] MiniAppBox";
  private aanh adBox;
  private String adUnitId;
  private int appBoxId;
  private BaseJsPluginEngine jsPluginEngine;
  private JsRuntime jsRuntime;
  private volatile boolean mIsRequestingAd;
  
  AppBoxPlugin$MiniAppBox(int paramInt, String paramString, BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime)
  {
    this.appBoxId = paramInt;
    this.adUnitId = paramString;
    this.jsPluginEngine = paramBaseJsPluginEngine;
    this.jsRuntime = paramJsRuntime;
  }
  
  private void callbackJs(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jsRuntime != null) {
      if (!paramBoolean) {
        break label76;
      }
    }
    label76:
    for (paramString = ApiUtil.wrapCallbackOk(paramString, getResultObj(paramInt1, paramInt2));; paramString = ApiUtil.wrapCallbackFail(paramString, getResultObj(paramInt1, paramInt2), (String)AppBoxPlugin.S_CodeMsg_Map.get(Integer.valueOf(paramInt2))))
    {
      paramString = paramString.toString();
      QLog.i("[minigame] MiniAppBox", 1, "evaluateCallbackJs callbackId: " + paramInt3 + " content:" + paramString);
      this.jsRuntime.evaluateCallbackJs(paramInt3, paramString);
      return;
    }
  }
  
  private MiniAppAd.StGetAdReq generateAdReq()
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null)) {
      return null;
    }
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = null;
    if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
      localObject1 = ((GameActivity)this.jsPluginEngine.activityContext).getMiniGameAppId();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jsPluginEngine.appBrandRuntime != null) {
        localObject2 = this.jsPluginEngine.appBrandRuntime.appId;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("[minigame] MiniAppBox", 1, "TextUtils.isEmpty(appid)");
      return null;
    }
    boolean bool;
    int i;
    label150:
    ApkgInfo localApkgInfo;
    if ((this.jsPluginEngine.activityContext instanceof GameActivity))
    {
      bool = ((GameActivity)this.jsPluginEngine.activityContext).getIsOrientationLandscape();
      if (!bool) {
        break label535;
      }
      i = 90;
      QLog.i("[minigame] MiniAppBox", 1, "handle initAdParam appId = " + (String)localObject2 + "， deviceOrient = " + i);
      localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      if ((localApkgInfo == null) || (!localApkgInfo.isEngineTypeMiniApp())) {
        break label540;
      }
      j = 0;
      label212:
      if (j != 0) {
        break label545;
      }
    }
    label535:
    label540:
    label545:
    for (int j = 7;; j = 8)
    {
      Object localObject3 = "";
      Object localObject5 = "";
      String str2 = "";
      String str1 = "";
      localObject1 = localObject3;
      if (localApkgInfo != null)
      {
        localObject1 = localObject3;
        if (localApkgInfo.appConfig != null)
        {
          localObject1 = localObject3;
          if (localApkgInfo.appConfig.launchParam != null)
          {
            localObject1 = localObject3;
            if (localApkgInfo.appConfig.launchParam.entryPath != null) {
              localObject1 = localApkgInfo.appConfig.launchParam.entryPath;
            }
          }
        }
      }
      Object localObject4 = localObject5;
      localObject3 = str2;
      if (localApkgInfo != null)
      {
        localObject4 = localObject5;
        localObject3 = str2;
        if (localApkgInfo.appConfig != null)
        {
          localObject4 = localObject5;
          localObject3 = str2;
          if (localApkgInfo.appConfig.launchParam != null)
          {
            localObject4 = localApkgInfo.appConfig.launchParam.reportData;
            localObject3 = String.valueOf(localApkgInfo.appConfig.launchParam.scene);
          }
        }
      }
      localObject5 = str1;
      if (localApkgInfo != null)
      {
        localObject5 = str1;
        if (localApkgInfo.appConfig != null)
        {
          localObject5 = str1;
          if (localApkgInfo.appConfig.config != null) {
            localObject5 = localApkgInfo.appConfig.config.via;
          }
        }
      }
      str1 = AdUtils.getSpAdGdtCookie(j);
      int k = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniGameShareRate", 53);
      localObject1 = AdUtils.createAdRequest(this.jsPluginEngine.activityContext, Long.parseLong(str3), this.adUnitId, (String)localObject2, k, j, i, str1, (String)localObject1, (String)localObject4, (String)localObject3, (String)localObject5);
      QLog.i("[minigame] MiniAppBox", 1, "generateAdReq account= " + str3 + " adUnitId=" + this.adUnitId);
      return localObject1;
      bool = isOrientationLandscape();
      break;
      i = 0;
      break label150;
      j = 1;
      break label212;
    }
  }
  
  private JSONObject getResultObj(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.appBoxId);
      localJSONObject.put("compId", paramInt1);
      localJSONObject.put("adUnitId", this.adUnitId);
      localJSONObject.put("errCode", paramInt2);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      QLog.e("[minigame] MiniAppBox", 2, "getResultObj e:", localThrowable);
      return localJSONObject;
    }
    finally {}
    return localJSONObject;
  }
  
  private boolean initAdParam(int paramInt1, int paramInt2)
  {
    MiniAppAd.StGetAdReq localStGetAdReq = generateAdReq();
    if (localStGetAdReq == null) {
      return false;
    }
    getAppBoxADInfo(this.jsPluginEngine.activityContext, localStGetAdReq, paramInt1, paramInt2);
    return true;
  }
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private boolean isOrientationLandscape()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return (localResources != null) && (localResources.getConfiguration().orientation == 2);
  }
  
  private void saveAdCookie(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("gdt_cookie"))
      {
        localObject = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        AdUtils.putSpAdGdtCookie(paramInt, (String)localObject);
        QLog.i("[minigame] MiniAppBox", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[minigame] MiniAppBox", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  boolean destroy()
  {
    if (this.adBox != null)
    {
      this.adBox.b();
      this.adBox = null;
    }
    return true;
  }
  
  public void getAppBoxADInfo(Activity paramActivity, MiniAppAd.StGetAdReq paramStGetAdReq, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new AppBoxPlugin.MiniAppBox.2(this, paramInt1, paramInt2, paramActivity, paramStGetAdReq));
  }
  
  boolean load(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!this.mIsRequestingAd)
    {
      this.mIsRequestingAd = true;
      bool = initAdParam(paramInt1, paramInt2);
    }
    return bool;
  }
  
  boolean show(int paramInt1, int paramInt2)
  {
    if (this.adBox == null) {
      return false;
    }
    AppBrandTask.runTaskOnUiThread(new AppBoxPlugin.MiniAppBox.1(this, paramInt1, paramInt2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin.MiniAppBox
 * JD-Core Version:    0.7.0.1
 */
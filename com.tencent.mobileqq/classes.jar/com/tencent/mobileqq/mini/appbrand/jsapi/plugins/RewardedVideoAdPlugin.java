package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import yst;
import yxo;

public class RewardedVideoAdPlugin
  extends BaseJsPlugin
{
  public static final String API_AD_CREATE_REWARDED_VIDEO_AD = "createRewardedVideoAd";
  public static final String API_AD_OPERATE_REWARDED_VIDEO_AD = "operateRewardedAd";
  public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
  public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  private static final Set<String> S_EVENT_MAP = new RewardedVideoAdPlugin.1();
  private static final String TAG = "[minigame] RewardedVideoAdPlugin";
  private static final HashMap<Integer, String> errCodeMsgMap = PluginConst.AdConst.CodeMsgMap;
  private GdtAd ad;
  private qq_ad_get.QQAdGetRsp.AdInfo adInfo;
  private GdtMotiveVideoPageData gdtMotiveVideoPageData;
  private JsRuntime mBaseAppBrandWebview;
  private boolean mIsOrientationLandscape;
  private boolean mIsRequestingAd;
  private String posID = "";
  private int shareRate = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniGameShareRate", 53);
  
  private void handleErrorAndInformJs(int paramInt, String paramString)
  {
    String str = (String)errCodeMsgMap.get(Integer.valueOf(paramInt));
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "handleErrorAndInformJs errCode= " + paramInt + " errMsg=" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", str);
      localJSONObject.put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(int paramInt, String paramString)
  {
    handleErrorAndInformJs(paramInt, paramString);
    handleShowAndInformJs(false, paramString);
    handleLoadAndInformJs(false, paramString);
  }
  
  private void handleLoadAndInformJs(boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.5(this, paramString, paramBoolean), 300L);
  }
  
  private void handleOnLoadAndInformJs(boolean paramBoolean, String paramString)
  {
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "handleOnLoadAndInformJs isSucc= " + paramBoolean);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "load");
        if (TextUtils.isEmpty(paramString)) {
          break label90;
        }
        localJSONObject.put("compId", paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label90:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.6(this, paramString, paramBoolean), 300L);
  }
  
  private void informJs(JSONObject paramJSONObject, String paramString)
  {
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    if (this.mBaseAppBrandWebview != null) {
      this.mBaseAppBrandWebview.evaluateSubcribeJS(paramString, paramJSONObject.toString(), 0);
    }
  }
  
  private void initAdInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.adInfo = null;
      return;
    }
    try
    {
      this.adInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString))));
      return;
    }
    catch (Throwable paramString)
    {
      this.adInfo = null;
    }
  }
  
  private void initAdParam(Activity paramActivity, String paramString1, String paramString2, String paramString3, JsRuntime paramJsRuntime, int paramInt)
  {
    this.ad = null;
    this.adInfo = null;
    this.gdtMotiveVideoPageData = null;
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
    if (this.mIsOrientationLandscape) {}
    for (int j = 90;; j = 0)
    {
      QLog.d("[minigame] RewardedVideoAdPlugin", 1, "handle initAdParam appId = " + (String)localObject2 + "， deviceOrient = " + j);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      QLog.e("[minigame] RewardedVideoAdPlugin", 1, "TextUtils.isEmpty(appid)");
      handleGetAdFailed(1003, paramString3);
      return;
    }
    int k = 0;
    int i = k;
    if (this.jsPluginEngine.appBrandRuntime != null)
    {
      localObject1 = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      i = k;
      if (localObject1 != null)
      {
        if (!((ApkgInfo)localObject1).isEngineTypeMiniApp()) {
          break label559;
        }
        i = 0;
      }
    }
    this.mIsRequestingAd = true;
    if (i == 0) {}
    for (i = 3;; i = 1)
    {
      String str4 = AdUtils.getSpAdGdtCookie(i);
      ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
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
            localObject4 = MiniAppInfo.getReportDataString(localApkgInfo.appConfig.launchParam.reportData);
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
      localObject1 = AdUtils.createAdRequest(this.jsPluginEngine.activityContext, Long.parseLong(str3), paramString1, (String)localObject2, this.shareRate, i, j, str4, (String)localObject1, (String)localObject4, (String)localObject3, (String)localObject5);
      QLog.d("[minigame] RewardedVideoAdPlugin", 1, "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
      getRewardedVideoADInfo(paramActivity, (MiniAppAd.StGetAdReq)localObject1, paramString2, paramString3, paramJsRuntime, paramInt, i);
      return;
      label559:
      i = 1;
      break;
    }
  }
  
  private boolean isOrientationLandscape()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return (localResources != null) && (localResources.getConfiguration().orientation == 2);
  }
  
  private String mockAdJson(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      int i = paramString1.optInt("ret", -1);
      if ((i != 0) && (i == 102006))
      {
        QLog.e("[minigame] RewardedVideoAdPlugin", 1, "mockAdJson failed ret == 102006");
        handleErrorAndInformJs(1004, paramString2);
        return null;
      }
      paramString1 = ((JSONObject)((JSONObject)paramString1.getJSONArray("pos_ads_info").get(0)).getJSONArray("ads_info").get(0)).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("[minigame] RewardedVideoAdPlugin", 1, "mockAdJson failed e:", paramString1);
      handleErrorAndInformJs(1003, paramString2);
    }
    return null;
  }
  
  public static GdtMotiveVideoPageData mockMVPageData(GdtAd paramGdtAd, String paramString, int paramInt)
  {
    Object localObject = null;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData;
    if (paramGdtAd != null)
    {
      localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = paramGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = paramGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = paramGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = paramGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = paramGdtAd.getVideoUrl();
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      if (paramGdtAd.getImageData() != null) {
        break label399;
      }
    }
    label399:
    for (localObject = "";; localObject = paramGdtAd.getImageData().a)
    {
      localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject);
      localGdtMotiveVideoPageData.bannerImgName = paramGdtAd.getAdvertiser_corporate_image_name();
      localGdtMotiveVideoPageData.bannerBaseInfoText = paramGdtAd.getText();
      localGdtMotiveVideoPageData.bannerLogo = paramGdtAd.getAdvertiser_corporate_logo();
      localGdtMotiveVideoPageData.exposureUrl = paramGdtAd.getUrlForImpression();
      localGdtMotiveVideoPageData.appScore = Double.valueOf(paramGdtAd.getAppScore()).doubleValue();
      localGdtMotiveVideoPageData.downloadNum = paramGdtAd.getAppDownloadNum();
      localGdtMotiveVideoPageData.style = paramGdtAd.getStyle();
      localGdtMotiveVideoPageData.adsContent = paramString;
      localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
      QLog.d("[minigame] RewardedVideoAdPlugin", 2, "mockMVPageData productType= " + localGdtMotiveVideoPageData.productType + " vSize=" + localGdtMotiveVideoPageData.vSize + " adId=" + localGdtMotiveVideoPageData.adId + " vid=" + localGdtMotiveVideoPageData.vid + " url=" + localGdtMotiveVideoPageData.url + " previewImgUrl=" + localGdtMotiveVideoPageData.previewImgUrl + " bannerImgName=" + localGdtMotiveVideoPageData.bannerImgName + " bannerBaseInfoText=" + localGdtMotiveVideoPageData.bannerBaseInfoText + " bannerLogo=" + localGdtMotiveVideoPageData.bannerLogo + " exposureUrl=" + localGdtMotiveVideoPageData.exposureUrl + " appScore=" + localGdtMotiveVideoPageData.appScore + " downloadNum=" + localGdtMotiveVideoPageData.downloadNum);
      localObject = localGdtMotiveVideoPageData;
      return localObject;
    }
  }
  
  private void onCloseAd(int paramInt1, Bundle paramBundle, String paramString1, Activity paramActivity, String paramString2, JsRuntime paramJsRuntime, int paramInt2)
  {
    if (paramInt1 != -1) {
      return;
    }
    long l1 = paramBundle.getLong("duration_time");
    long l2 = paramBundle.getLong("elapsed_time");
    boolean bool = paramBundle.getBoolean("profitable_flag", false);
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, new Object[] { "RewardedAd ActivityResultListener receive durationTime= " + l1 + " elaspedTime=" + l2, " profitable=" + bool });
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("state", "close");
      paramBundle.put("isEnded", bool);
      if (!TextUtils.isEmpty(paramString1)) {
        paramBundle.put("compId", paramString1);
      }
      informJs(paramBundle, "onRewardedVideoStateChange");
      ThreadManagerV2.excute(new RewardedVideoAdPlugin.3(this, paramActivity, paramString2, paramString1, paramJsRuntime, paramInt2), 16, null, false);
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("[minigame] RewardedVideoAdPlugin", 1, "doOnActivityResult failed e:", paramBundle);
      handleErrorAndInformJs(1003, paramString1);
    }
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
        QLog.i("[minigame] RewardedVideoAdPlugin", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[minigame] RewardedVideoAdPlugin", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void setOnCloseListener(Activity paramActivity, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "setOnCloseListener");
    MiniAppController.getInstance().setActivityResultListener(new RewardedVideoAdPlugin.2(this, paramString2, paramActivity, paramString1, paramJsRuntime, paramInt));
  }
  
  public void getRewardedVideoADInfo(Activity paramActivity, MiniAppAd.StGetAdReq paramStGetAdReq, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new RewardedVideoAdPlugin.4(this, paramString2, paramJsRuntime, paramString1, paramInt1, paramInt2));
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    Object localObject3 = this.jsPluginEngine.appBrandRuntime.activity;
    boolean bool1;
    if ((localObject3 instanceof GameActivity))
    {
      this.mIsOrientationLandscape = ((GameActivity)localObject3).getIsOrientationLandscape();
      bool1 = true;
      if (!"createRewardedVideoAd".equals(paramString1)) {
        break label307;
      }
      this.mBaseAppBrandWebview = paramJsRuntime;
      if ((this.ad != null) && (this.gdtMotiveVideoPageData != null)) {
        break label228;
      }
    }
    Object localObject4;
    label228:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject1 = new JSONObject(paramString2);
          localObject4 = ((JSONObject)localObject1).optString("adUnitId");
          String str = ((JSONObject)localObject1).optString("compId");
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            handleErrorAndInformJs(1002, str);
            JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramString1, null);
            if (localJSONObject != null)
            {
              localObject1 = localJSONObject.toString();
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, localJSONObject, paramInt);
              if (localObject1 == null) {
                continue;
              }
              return localObject1;
              this.mIsOrientationLandscape = isOrientationLandscape();
              bool1 = false;
              break;
            }
            localObject1 = "";
            continue;
          }
          this.posID = ((String)localObject4);
          initAdParam((Activity)localObject3, this.posID, paramString1, str, paramJsRuntime, paramInt);
          return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        }
        catch (Exception localException)
        {
          QLog.e("[minigame] RewardedVideoAdPlugin", 1, "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
          localObject3 = ApiUtil.wrapCallbackFail(paramString1, null);
          if (localObject3 == null) {}
        }
        for (Object localObject2 = ((JSONObject)localObject3).toString();; localObject2 = "")
        {
          handleErrorAndInformJs(1003, "");
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, (JSONObject)localObject3, paramInt);
          if (localObject2 == null) {
            break;
          }
          return localObject2;
        }
        if ("operateRewardedAd".equals(paramString1))
        {
          try
          {
            localObject2 = new JSONObject(paramString2);
            localObject4 = this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
            if (localObject4 != null) {
              ((WebviewContainer)localObject4).callbackJsEventOK(paramString1, null, paramInt);
            }
            localObject4 = ((JSONObject)localObject2).optString("type");
            localObject2 = ((JSONObject)localObject2).optString("compId");
            if (!"load".equals(localObject4)) {
              break label473;
            }
            if ((this.ad == null) || (this.gdtMotiveVideoPageData == null)) {
              break label447;
            }
            handleLoadAndInformJs(true, (String)localObject2);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("[minigame] RewardedVideoAdPlugin", 1, "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
            handleErrorAndInformJs(1003, "");
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null), paramInt);
          }
          continue;
          if (!this.mIsRequestingAd) {
            initAdParam((Activity)localObject3, this.posID, paramString1, localJSONException, paramJsRuntime, paramInt);
          }
        }
      }
    } while (!"show".equals(localObject4));
    label307:
    label447:
    label473:
    if (this.ad != null) {
      if (this.gdtMotiveVideoPageData == null) {
        break label635;
      }
    }
    label635:
    for (boolean bool2 = true;; bool2 = false)
    {
      handleShowAndInformJs(bool2, localJSONException);
      if (bool2)
      {
        this.gdtMotiveVideoPageData.refId = "biz_src_miniapp";
        this.gdtMotiveVideoPageData.containerType = 1;
        this.gdtMotiveVideoPageData.resultReceiver = new RewardedVideoAdPlugin.AdResultReceiver(new Handler(Looper.getMainLooper()), this, localJSONException, (Activity)localObject3, paramString1, paramJsRuntime, paramInt, bool1);
        if ((bool1) && (GameLoadManager.g().getGameEngine() != null)) {
          GameLoadManager.g().getGameEngine().handleFocusLoss();
        }
        GdtMotiveVideoFragment.a((Activity)localObject3, GdtMotiveVideoFragment.class, this.gdtMotiveVideoPageData);
        AdFrequencyLimit.setRewardVideoAdShowing(true);
      }
      this.ad = null;
      this.adInfo = null;
      this.gdtMotiveVideoPageData = null;
      break;
      handleShowAndInformJs(false, localJSONException);
      break;
    }
  }
  
  public void onReceiveVideoClose(int paramInt1, Bundle paramBundle, String paramString1, Activity paramActivity, String paramString2, JsRuntime paramJsRuntime, int paramInt2, boolean paramBoolean)
  {
    onCloseAd(paramInt1, paramBundle, paramString1, paramActivity, paramString2, paramJsRuntime, paramInt2);
    if ((paramBoolean) && (GameLoadManager.g().getGameEngine() != null)) {
      GameLoadManager.g().getGameEngine().handleFocusGain();
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */
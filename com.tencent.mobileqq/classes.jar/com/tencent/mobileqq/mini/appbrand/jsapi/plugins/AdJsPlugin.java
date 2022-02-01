package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import acvb;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameBannerAdFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class AdJsPlugin
  extends BaseJsPlugin
{
  public static final String AD_REF_ID = "biz_src_miniappD";
  public static final String API_NAME_ADVERT_TAP = "advert_tap";
  public static final String API_NAME_BANNER_AD = "getBannerAd";
  public static final String API_NAME_BLOCK_AD = "getBlockAd";
  public static final String API_NAME_CARD_AD = "getCardAd";
  public static final String API_NAME_FEEDS_AD = "getFeedsAd";
  public static final String API_NAME_INTERSTITIAL_AD = "getInterstitialAd";
  public static final String API_OPERATE_APP_AD_DATA = "operateAppAdData";
  private static final Set<String> S_EVENT_MAP = new AdJsPlugin.1();
  private static final String TAG = "AdJsPlugin";
  protected GdtAppReceiver mGgtAppReceiver;
  
  private qq_ad_get.QQAdGetRsp.AdInfo getBannerAdInfo(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).getJSONArray("pos_ads_info").getJSONObject(0);
      int i = Integer.valueOf(((JSONObject)localObject).getString("ret")).intValue();
      ((JSONObject)localObject).getString("msg");
      if (i == 0)
      {
        localObject = ((JSONObject)localObject).getJSONArray("ads_info").getJSONObject(0);
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.i("AdJsPlugin", 2, "getBannerAdInfo error" + paramString, localException);
      return null;
    }
    return null;
  }
  
  private void handleAdApi(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    String str3 = paramJSONObject.optJSONObject("data").optString("pos_id");
    if (paramJSONObject.optJSONObject("data").has("adType")) {
      paramInt2 = paramJSONObject.optJSONObject("data").optInt("adType");
    }
    for (;;)
    {
      int i = 1;
      if (paramJSONObject.optJSONObject("data").has("size")) {
        i = paramJSONObject.optJSONObject("data").optInt("size");
      }
      long l = Long.valueOf(this.jsPluginEngine.activityContext.getCurrentAccountUin()).longValue();
      paramJSONObject = null;
      if (this.jsPluginEngine.appBrandRuntime != null) {
        paramJSONObject = this.jsPluginEngine.appBrandRuntime.appId;
      }
      QLog.d("AdJsPlugin", 2, "getBlockAd appid = " + paramJSONObject);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        String str4 = AdUtils.getSpAdGdtCookie(paramInt2);
        ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
        Object localObject2 = "";
        Object localObject4 = "";
        String str2 = "";
        String str1 = "";
        Object localObject1 = localObject2;
        if (localApkgInfo != null)
        {
          localObject1 = localObject2;
          if (localApkgInfo.appConfig != null)
          {
            localObject1 = localObject2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject1 = localObject2;
              if (localApkgInfo.appConfig.launchParam.entryPath != null) {
                localObject1 = localApkgInfo.appConfig.launchParam.entryPath;
              }
            }
          }
        }
        Object localObject3 = localObject4;
        localObject2 = str2;
        if (localApkgInfo != null)
        {
          localObject3 = localObject4;
          localObject2 = str2;
          if (localApkgInfo.appConfig != null)
          {
            localObject3 = localObject4;
            localObject2 = str2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject3 = localApkgInfo.appConfig.launchParam.reportData;
              localObject2 = String.valueOf(localApkgInfo.appConfig.launchParam.scene);
            }
          }
        }
        localObject4 = str1;
        if (localApkgInfo != null)
        {
          localObject4 = str1;
          if (localApkgInfo.appConfig != null)
          {
            localObject4 = str1;
            if (localApkgInfo.appConfig.config != null) {
              localObject4 = localApkgInfo.appConfig.config.via;
            }
          }
        }
        sendAdRequest(AdUtils.createAdRequest(this.jsPluginEngine.activityContext, l, str3, paramJSONObject, 53, paramInt2, 0, str4, (String)localObject1, (String)localObject3, (String)localObject2, (String)localObject4, i), paramJsRuntime, paramString, paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void handleAdvertTapEvent(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    Object localObject3 = new JSONObject(paramString2);
    Object localObject1 = "";
    paramString2 = new JSONObject();
    Object localObject2 = new JSONObject();
    if ((localObject3 != null) && (((JSONObject)localObject3).has("data")))
    {
      JSONObject localJSONObject = ((JSONObject)localObject3).optJSONObject("data");
      if (localJSONObject != null)
      {
        if (localJSONObject.has("ads_info")) {
          localObject1 = localJSONObject.optString("ads_info");
        }
        if (localJSONObject.has("antiSpamParamsForClick")) {
          paramString2 = localJSONObject.optJSONObject("antiSpamParamsForClick");
        }
        if (localJSONObject.has("antiSpamParams"))
        {
          localObject3 = ((JSONObject)localObject3).optJSONObject("antiSpamParams");
          localObject2 = paramString2;
          paramString2 = (String)localObject3;
        }
      }
    }
    for (;;)
    {
      localObject1 = new JSONObject((String)localObject1);
      localObject3 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject1));
      if ((this.mGgtAppReceiver == null) && (this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null))
      {
        this.mGgtAppReceiver = new GdtAppReceiver();
        this.mGgtAppReceiver.register(this.jsPluginEngine.getActivityContext());
      }
      localObject1 = new GdtHandler.Params();
      ((GdtHandler.Params)localObject1).c = 11;
      ((GdtHandler.Params)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jsPluginEngine.activityContext);
      ((GdtHandler.Params)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject3);
      ((GdtHandler.Params)localObject1).jdField_a_of_type_Boolean = true;
      ((GdtHandler.Params)localObject1).jdField_b_of_type_Boolean = true;
      ((GdtHandler.Params)localObject1).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGgtAppReceiver);
      ((GdtHandler.Params)localObject1).jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("big_brother_ref_source_key", "biz_src_miniappD");
      ((GdtHandler.Params)localObject1).jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject3);
      ((GdtHandler.Params)localObject1).jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject2);
      ((GdtHandler.Params)localObject1).jdField_a_of_type_JavaLangString = paramString2.toString();
      GdtHandler.a((GdtHandler.Params)localObject1);
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
      return;
      localObject3 = paramString2;
      paramString2 = (String)localObject2;
      localObject2 = localObject3;
      continue;
      localObject3 = paramString2;
      paramString2 = (String)localObject2;
      localObject2 = localObject3;
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
        QLog.i("AdJsPlugin", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("AdJsPlugin", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void sendAdRequest(MiniAppAd.StGetAdReq paramStGetAdReq, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new AdJsPlugin.2(this, paramJsRuntime, paramString, paramInt1, paramInt2));
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("AdJsPlugin", 2, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    if ("operateAppAdData".equals(paramString1)) {}
    try
    {
      localJSONObject = new JSONObject(paramString2);
      str = localJSONObject.optString("api_name");
      if ("getBannerAd".equals(str)) {
        handleAdApi(localJSONObject, paramJsRuntime, paramString1, paramInt, 2);
      }
      for (;;)
      {
        return "";
        if (!"getBlockAd".equals(str)) {
          break;
        }
        handleAdApi(localJSONObject, paramJsRuntime, paramString1, paramInt, 12);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str;
        QLog.e("AdJsPlugin", 1, "handleNativeRequest, exception: " + Log.getStackTraceString(paramString1));
        continue;
        if ("getCardAd".equals(str)) {
          handleAdApi(localJSONObject, paramJsRuntime, paramString1, paramInt, 5);
        } else if ("getFeedsAd".equals(str)) {
          handleAdApi(localJSONObject, paramJsRuntime, paramString1, paramInt, 6);
        } else if ("getInterstitialAd".equals(str)) {
          handleAdApi(localJSONObject, paramJsRuntime, paramString1, paramInt, 10);
        } else if ("advert_tap".equals(str)) {
          handleAdvertTapEvent(paramString1, paramString2, paramJsRuntime, paramInt);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mGgtAppReceiver != null) && (this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null))
    {
      this.mGgtAppReceiver.unregister(this.jsPluginEngine.getActivityContext());
      this.mGgtAppReceiver = null;
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AdJsPlugin
 * JD-Core Version:    0.7.0.1
 */
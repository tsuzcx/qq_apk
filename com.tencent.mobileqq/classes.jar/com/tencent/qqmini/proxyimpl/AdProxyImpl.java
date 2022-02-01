package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

@ProxyService(proxy=AdProxy.class)
public class AdProxyImpl
  extends AdProxy
{
  private static HashMap<String, AdProxyImpl.CallbackData> jdField_a_of_type_JavaUtilHashMap;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private RewardedBrowsingCallbackReceiver jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver;
  
  public AdProxyImpl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "AdProxyImpl constructor");
    }
    a();
  }
  
  private MiniAppAd.StGetAdReq a(Bundle paramBundle)
  {
    int i = paramBundle.getInt(AdProxy.KEY_AD_TYPE);
    int j = paramBundle.getInt(AdProxy.KEY_MODE);
    int k = paramBundle.getInt(AdProxy.KEY_SHARE_RATE);
    int m = paramBundle.getInt(AdProxy.KEY_ADCOUNT);
    String str1 = paramBundle.getString(AdProxy.KEY_POSID);
    String str2 = paramBundle.getString(AdProxy.KEY_APPID);
    String str3 = paramBundle.getString(AdProxy.KEY_ACCOUNT);
    String str4 = AdUtils.getSpAdGdtCookie(i);
    String str5 = paramBundle.getString(AdProxy.KEY_ENTRY_PATH);
    String str6 = paramBundle.getString(AdProxy.KEY_REPORT_DATA);
    String str7 = paramBundle.getString(AdProxy.KEY_REFER);
    paramBundle = paramBundle.getString(AdProxy.KEY_VIA);
    try
    {
      long l;
      if (TextUtils.isEmpty(str3)) {
        l = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
      } else {
        l = Long.parseLong(str3);
      }
      if (j == 0) {
        return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), l, str1, str2, k, i, 0, str4, str5, str6, str7, paramBundle, m, 2, MiniLoadingAdManager.getCurCachedAdsList(str3, str2));
      }
      if (j == 1) {
        return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), l, str1, str2, k, i, 0, str4, str5, str6, str7, paramBundle, m, 1, null);
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      QLog.e("AdProxyImpl", 1, "uin format error!", paramBundle);
    }
    return null;
  }
  
  private GdtHandler.Params a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if ((paramActivity != null) && (paramAdInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(paramActivity);
      }
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.c = 11;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      if (paramAdInfo.report_info != null) {
        localParams.jdField_a_of_type_OrgJsonJSONObject = MiniAdAntiSpamReportUtil.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get(), paramString);
      }
      return localParams;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("ret", -1);
      if ((i != 0) && (i == 102006))
      {
        QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
        return null;
      }
      paramString = ((JSONObject)((JSONObject)paramString.getJSONArray("pos_ads_info").get(0)).getJSONArray("ads_info").get(0)).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("AdProxyImpl", 1, "mockAdJson failed e:", paramString);
    }
    return null;
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo a(String paramString)
  {
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)));
      return localAdInfo;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJson2AdInfo error");
      localStringBuilder.append(paramString);
      QLog.i("AdProxyImpl", 2, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AD_PROXY_ACTION_MOTIVE_BROWSING_END");
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "onCreate registerReceiver mRewardedBrowsingCallbackReceiver");
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver = new RewardedBrowsingCallbackReceiver(null, this);
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver, localIntentFilter);
  }
  
  private void a(IMiniAppContext paramIMiniAppContext, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString)
  {
    if (paramAdInfo != null)
    {
      if (paramAdInfo.report_info == null) {
        return;
      }
      MiniAdAntiSpamReportUtil.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get(), paramString);
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportBannerAd/BlockAd reportUrl = ");
    localStringBuilder.append(paramString);
    QLog.i("AdProxyImpl", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetWorkThread(new AdProxyImpl.7(paramString));
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).has("gdt_cookie"))
      {
        localObject2 = ((JSONObject)localObject1).getString("gdt_cookie");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject1 = "";
        Object localObject3 = (MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
        if ((localObject3 != null) && (((MiniAppProxy)localObject3).getAccount() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
          localObject1 = AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
        } else if (localObject3 != null) {
          localObject1 = ((MiniAppProxy)localObject3).getAccount();
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("gdt_cookie_");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(paramInt);
        localObject1 = ((StringBuilder)localObject3).toString();
        StorageUtil.getPreference().edit().putString((String)localObject1, (String)localObject2).apply();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseAndSaveCookie save key success, adType = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", value = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseAndSaveCookie error");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject2).toString(), localException);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str = paramIntent.getStringExtra("KEY_MOTIVE_BROWSING");
      Object localObject = (AdProxyImpl.CallbackData)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localObject != null)
      {
        localObject = AdProxyImpl.CallbackData.a((AdProxyImpl.CallbackData)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mvBrowing dataKey = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", data =");
        localStringBuilder.append(localObject);
        QLog.i("AdProxyImpl", 1, localStringBuilder.toString());
        jdField_a_of_type_JavaUtilHashMap.remove(str);
        if (localObject != null) {
          ((AdProxyImpl.SDKRewardedVideoAdView)localObject).a(-1, paramIntent.getExtras());
        }
      }
    }
  }
  
  public boolean adClick(Context paramContext, String paramString1, String paramString2)
  {
    Activity localActivity;
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      localActivity = (Activity)paramContext;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(paramString1);
        Object localObject1 = "";
        Object localObject2 = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        paramString2 = (String)localObject2;
        paramString1 = localJSONObject1;
        paramContext = (Context)localObject1;
        if (!((JSONObject)localObject3).has("data")) {
          break label597;
        }
        JSONObject localJSONObject2 = ((JSONObject)localObject3).optJSONObject("data");
        if ((localJSONObject2 != null) && ((localJSONObject2.has("ads_info")) || (localJSONObject2.has("antiSpamParamsForClick")) || (localJSONObject2.has("antiSpamParams"))))
        {
          localObject3 = localJSONObject2.optString("ads_info");
          localObject1 = localObject2;
          if (localJSONObject2.has("antiSpamParamsForClick")) {
            localObject1 = localJSONObject2.optJSONObject("antiSpamParamsForClick");
          }
          localObject2 = localJSONObject1;
          if (localJSONObject2.has("antiSpamParams")) {
            localObject2 = localJSONObject2.optJSONObject("antiSpamParams");
          }
          paramString2 = (String)localObject1;
          paramString1 = (String)localObject2;
          paramContext = (Context)localObject3;
          if (!localJSONObject2.has("appAutoDownload")) {
            break label597;
          }
          bool = localJSONObject2.getBoolean("appAutoDownload");
          paramString2 = (String)localObject1;
          paramString1 = (String)localObject2;
          paramContext = (Context)localObject3;
        }
        else
        {
          paramString2 = (String)localObject2;
          paramString1 = localJSONObject1;
          paramContext = (Context)localObject1;
          if (localJSONObject2 == null) {
            break label597;
          }
          paramString2 = (String)localObject2;
          paramString1 = localJSONObject1;
          paramContext = (Context)localObject1;
          if (!localJSONObject2.has("data")) {
            break label597;
          }
          localObject3 = localJSONObject2.optJSONObject("data");
          paramString2 = (String)localObject2;
          paramString1 = localJSONObject1;
          paramContext = (Context)localObject1;
          if (localObject3 == null) {
            break label597;
          }
          if (((JSONObject)localObject3).has("ads_info")) {
            localObject1 = ((JSONObject)localObject3).optString("ads_info");
          }
          if (((JSONObject)localObject3).has("antiSpamParamsForClick")) {
            localObject2 = ((JSONObject)localObject3).optJSONObject("antiSpamParamsForClick");
          }
          if (localJSONObject2.has("antiSpamParams")) {
            localJSONObject1 = localJSONObject2.optJSONObject("antiSpamParams");
          }
          paramString2 = (String)localObject2;
          paramString1 = localJSONObject1;
          paramContext = (Context)localObject1;
          if (!((JSONObject)localObject3).has("appAutoDownload")) {
            break label597;
          }
          bool = localJSONObject2.getBoolean("appAutoDownload");
          paramString2 = (String)localObject2;
          paramString1 = localJSONObject1;
          paramContext = (Context)localObject1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("adClick, appAutoDownload=");
        ((StringBuilder)localObject1).append(bool);
        QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject1).toString());
        paramContext = new JSONObject(paramContext);
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramContext));
        if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
        {
          this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
          this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(localActivity);
        }
        paramContext = new GdtHandler.Params();
        paramContext.c = 11;
        paramContext.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        paramContext.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        paramContext.jdField_a_of_type_Boolean = true;
        paramContext.jdField_b_of_type_Boolean = bool;
        paramContext.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("big_brother_ref_source_key", "biz_src_miniappD");
        paramContext.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject1);
        paramContext.jdField_a_of_type_OrgJsonJSONObject = paramString2;
        paramContext.jdField_a_of_type_JavaLangString = paramString1.toString();
        GdtHandler.a(paramContext);
        return true;
      }
      catch (JSONException paramContext)
      {
        return false;
      }
      return false;
      label597:
      boolean bool = false;
    }
  }
  
  public boolean adExposure(Context paramContext, String paramString1, String paramString2)
  {
    return super.adExposure(paramContext, paramString1, paramString2);
  }
  
  public AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext, IGetAdPosInfo paramIGetAdPosInfo)
  {
    if ((paramActivity != null) && (paramBundle != null)) {
      return new AdProxyImpl.SDKBannerAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInt1, paramInt2, paramIBannerAdListener, paramIMiniAppContext, paramIGetAdPosInfo);
    }
    return null;
  }
  
  public AdProxy.AbsBlockAdView createBlockAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AdProxy.IBlockAdListener paramIBlockAdListener, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null)) {
      return new AdProxyImpl.SDKBlockAdView(this, paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBlockAdListener);
    }
    return null;
  }
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null)) {
      return new AdProxyImpl.SDKBoxAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBoxADLisener);
    }
    return null;
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramActivity != null) && (paramBundle != null)) {
      return new AdProxyImpl.SDKInterstitialAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInterstitialADLisener, paramIMiniAppContext);
    }
    return null;
  }
  
  public AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Context paramContext, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramContext != null) && (paramBundle != null)) {
      return new AdProxyImpl.SDKRewardedVideoAdView(this, paramContext, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIRewardVideoAdListener, paramIMiniAppContext);
    }
    return null;
  }
  
  public void destroy(Activity paramActivity)
  {
    GdtAppReceiver localGdtAppReceiver = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localGdtAppReceiver != null) {}
    try
    {
      localGdtAppReceiver.unregister(paramActivity);
      label14:
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver != null)
      {
        try
        {
          BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver);
        }
        catch (Throwable paramActivity)
        {
          QLog.e("AdProxyImpl", 1, "unregisterReceiver exception.", paramActivity);
        }
        this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver = null;
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      break label14;
    }
  }
  
  public void downloadRealTimeAdPic(String paramString1, String paramString2, String paramString3, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if (paramILoadingAdListener == null) {
      return;
    }
    Object localObject = AdUtils.convertJson2GdtAds(paramString1);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = (GdtAd)((List)localObject).get(0);
      if (localObject == null) {
        return;
      }
      long l2 = -1L;
      long l1 = l2;
      if (((GdtAd)localObject).info != null)
      {
        l1 = l2;
        if (((GdtAd)localObject).info.report_info != null)
        {
          l1 = l2;
          if (((GdtAd)localObject).info.report_info.trace_info != null) {
            l1 = ((GdtAd)localObject).info.report_info.trace_info.aid.get();
          }
        }
      }
      paramString2 = new MiniLoadingAdManager.CachedAdInfo((GdtAd)localObject, paramString2, paramString3);
      paramString3 = new AdProxyImpl.5(this, paramILoadingAdListener, paramString1, l1, paramString2);
      if (new File(paramString2.filePath).exists())
      {
        QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd 之前的实时广告下载过 因实时广告不落地 导致的本地有图片但是没信息的情况 直接回调");
        paramILoadingAdListener.onDownloadAdEnd(paramString1, l1, paramString2.filePath);
        return;
      }
      ThreadPools.getNetworkIOThreadPool().execute(new AdProxyImpl.6(this, paramString2, paramString3));
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    MiniAdAntiSpamReportUtil.b();
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    MiniAdAntiSpamReportUtil.c();
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    MiniAdAntiSpamReportUtil.a();
  }
  
  public void preloadLoadingAd(Context paramContext, Bundle paramBundle, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if (paramBundle == null) {
      return;
    }
    paramContext = a(paramBundle);
    String str = paramBundle.getString(AdProxy.KEY_APPID);
    paramBundle = paramBundle.getString(AdProxy.KEY_ACCOUNT);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramContext, new AdProxyImpl.3(this, paramBundle, str, paramILoadingAdListener));
  }
  
  public void requestAdInfo(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, AdProxy.ICmdListener paramICmdListener)
  {
    if (paramContext == null)
    {
      QLog.i("AdProxyImpl", 1, "context is null");
      if (paramICmdListener != null) {
        paramICmdListener.onCmdListener(true, null);
      }
      return;
    }
    ThreadManagerV2.excute(new AdProxyImpl.1(this, paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt4, paramICmdListener), 16, null, false);
  }
  
  public void selectLoadingAd(Context paramContext, Bundle paramBundle, String paramString, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    paramContext = a(paramBundle);
    if (paramILoadingAdListener != null)
    {
      if (paramContext == null) {
        return;
      }
      MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramContext, new AdProxyImpl.2(this, paramILoadingAdListener));
    }
  }
  
  public void updateLoadingAdLayoutAndShow(Context paramContext, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    paramContext = new MiniLoadingAdLayout(paramContext);
    if (paramContext.setupUIForSDK(paramMiniAppInfo, paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramLong1, paramLong2, paramILoadingAdListener))
    {
      paramContext.show(new AdProxyImpl.4(this, paramILoadingAdListener));
      if (paramILoadingAdListener != null) {
        paramILoadingAdListener.onAdShow(paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("getLoadingAdLayout filePath ");
      paramContext.append(paramString5);
      QLog.d("MiniLoadingAdManager", 1, paramContext.toString());
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "getLoadingAdLayout setup fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl
 * JD-Core Version:    0.7.0.1
 */
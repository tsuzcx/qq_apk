package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import achn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bkmt;
import bkmu;
import bkmv;
import bkmw;
import bkmx;
import bkmy;
import bknc;
import bkne;
import bknh;
import bknj;
import bkpa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.minigame.ui.GameBannerAdFragment;
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
  private static HashMap<String, bkmx> jdField_a_of_type_JavaUtilHashMap;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private RewardedBrowsingCallbackReceiver jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver;
  private final String jdField_a_of_type_JavaLangString = "AdProxyImpl";
  
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
    if (j == 0) {
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(str3), str1, str2, k, i, 0, str4, str5, str6, str7, paramBundle, m, 2, MiniLoadingAdManager.getCurCachedAdsList(str3, str2));
    }
    if (j == 1) {
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(str3), str1, str2, k, i, 0, str4, str5, str6, str7, paramBundle, m, 1, null);
    }
    return null;
  }
  
  private GdtHandler.Params a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if ((paramActivity == null) || (paramAdInfo == null)) {
      paramActivity = null;
    }
    GdtHandler.Params localParams;
    do
    {
      return paramActivity;
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(paramActivity);
      }
      localParams = new GdtHandler.Params();
      localParams.c = 11;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      paramActivity = localParams;
    } while (paramAdInfo.report_info == null);
    localParams.jdField_a_of_type_OrgJsonJSONObject = bkpa.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get(), paramString);
    return localParams;
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
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)));
      return localAdInfo;
    }
    catch (Exception localException)
    {
      QLog.i("AdProxyImpl", 2, "parseJson2AdInfo error" + paramString, localException);
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
    if ((paramAdInfo == null) || (paramAdInfo.report_info == null)) {
      return;
    }
    bkpa.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get(), paramString);
  }
  
  public static void a(String paramString)
  {
    QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new AdProxyImpl.7(paramString));
  }
  
  private void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("gdt_cookie")) {
          break;
        }
        String str2 = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty(str2)) {
          return;
        }
        localObject = (MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
        if ((localObject != null) && (((MiniAppProxy)localObject).getAccount() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null))
        {
          localObject = AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
          localObject = "gdt_cookie_" + (String)localObject + "_" + paramInt;
          StorageUtil.getPreference().edit().putString((String)localObject, str2).apply();
          QLog.i("AdProxyImpl", 1, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + str2);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("AdProxyImpl", 1, "parseAndSaveCookie error" + paramString, localException);
        return;
      }
      String str1;
      if (localException != null) {
        str1 = localException.getAccount();
      } else {
        str1 = "";
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str = paramIntent.getStringExtra("KEY_MOTIVE_BROWSING");
      Object localObject = (bkmx)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localObject != null)
      {
        localObject = bkmx.a((bkmx)localObject);
        QLog.i("AdProxyImpl", 1, "mvBrowing dataKey = " + str + ", data =" + localObject);
        jdField_a_of_type_JavaUtilHashMap.remove(str);
        if (localObject != null) {
          ((bknj)localObject).a(-1, paramIntent.getExtras());
        }
      }
    }
  }
  
  public boolean adClick(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    Activity localActivity = (Activity)paramContext;
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        paramString2 = new JSONObject(paramString1);
        paramContext = "";
        paramString1 = new JSONObject();
        localJSONObject1 = new JSONObject();
        if (!paramString2.has("data")) {
          break label461;
        }
        JSONObject localJSONObject2 = paramString2.optJSONObject("data");
        if ((localJSONObject2 != null) && ((localJSONObject2.has("ads_info")) || (localJSONObject2.has("antiSpamParamsForClick")) || (localJSONObject2.has("antiSpamParams"))))
        {
          String str = localJSONObject2.optString("ads_info");
          paramContext = paramString1;
          if (localJSONObject2.has("antiSpamParamsForClick")) {
            paramContext = localJSONObject2.optJSONObject("antiSpamParamsForClick");
          }
          paramString2 = paramContext;
          localObject = str;
          if (localJSONObject2.has("antiSpamParams"))
          {
            localObject = localJSONObject2.optJSONObject("antiSpamParams");
            paramString1 = str;
            paramString2 = paramContext;
            paramContext = (Context)localObject;
            paramString1 = new JSONObject(paramString1);
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString1));
            if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
            {
              this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
              this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(localActivity);
            }
            paramString1 = new GdtHandler.Params();
            paramString1.c = 11;
            paramString1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
            paramString1.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
            paramString1.jdField_a_of_type_Boolean = true;
            paramString1.jdField_b_of_type_Boolean = true;
            paramString1.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
            paramString1.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
            localObject = new Bundle();
            ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniappD");
            paramString1.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
            paramString1.jdField_a_of_type_OrgJsonJSONObject = paramString2;
            paramString1.jdField_a_of_type_JavaLangString = paramContext.toString();
            GdtHandler.a(paramString1);
            return true;
          }
        }
        else
        {
          if ((localJSONObject2 == null) || (!localJSONObject2.has("data"))) {
            break label461;
          }
          paramString2 = localJSONObject2.optJSONObject("data");
          if (paramString2 == null) {
            break label461;
          }
          if (paramString2.has("ads_info")) {
            paramContext = paramString2.optString("ads_info");
          }
          if (paramString2.has("antiSpamParamsForClick")) {
            paramString1 = paramString2.optJSONObject("antiSpamParamsForClick");
          }
          paramString2 = paramString1;
          localObject = paramContext;
          if (localJSONObject2.has("antiSpamParams"))
          {
            localObject = localJSONObject2.optJSONObject("antiSpamParams");
            paramString2 = paramString1;
            paramString1 = paramContext;
            paramContext = (Context)localObject;
            continue;
          }
        }
        paramString1 = (String)localObject;
      }
      catch (JSONException paramContext)
      {
        return false;
      }
      paramContext = localJSONObject1;
      continue;
      label461:
      Object localObject = "";
      paramString2 = paramString1;
      paramContext = localJSONObject1;
      paramString1 = (String)localObject;
    }
  }
  
  public boolean adExposure(Context paramContext, String paramString1, String paramString2)
  {
    return super.adExposure(paramContext, paramString1, paramString2);
  }
  
  public AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext, IGetAdPosInfo paramIGetAdPosInfo)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new bkmy(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInt1, paramInt2, paramIBannerAdListener, paramIMiniAppContext, paramIGetAdPosInfo);
  }
  
  public AdProxy.AbsBlockAdView createBlockAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AdProxy.IBlockAdListener paramIBlockAdListener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new bknc(this, paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBlockAdListener);
  }
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new bkne(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBoxADLisener);
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new bknh(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInterstitialADLisener, paramIMiniAppContext);
  }
  
  public AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Context paramContext, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return null;
    }
    return new bknj(this, paramContext, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIRewardVideoAdListener, paramIMiniAppContext);
  }
  
  public void destroy(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(paramActivity);
      label15:
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver != null) {}
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver);
        this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver = null;
        return;
      }
      catch (Throwable paramActivity)
      {
        for (;;)
        {
          QLog.e("AdProxyImpl", 1, "unregisterReceiver exception.", paramActivity);
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label15;
    }
  }
  
  public void downloadRealTimeAdPic(String paramString1, String paramString2, String paramString3, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if (paramILoadingAdListener == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = AdUtils.convertJson2GdtAds(paramString1);
      } while ((localObject == null) || (((List)localObject).isEmpty()));
      localObject = (GdtAd)((List)localObject).get(0);
    } while (localObject == null);
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
    paramString3 = new bkmw(this, paramILoadingAdListener, paramString1, l1, paramString2);
    if (new File(paramString2.filePath).exists())
    {
      QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd 之前的实时广告下载过 因实时广告不落地 导致的本地有图片但是没信息的情况 直接回调");
      paramILoadingAdListener.onDownloadAdEnd(paramString1, l1, paramString2.filePath);
      return;
    }
    ThreadPools.getNetworkIOThreadPool().execute(new AdProxyImpl.6(this, paramString2, paramString3));
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    bkpa.b();
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    bkpa.c();
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    bkpa.a();
  }
  
  public void preloadLoadingAd(Context paramContext, Bundle paramBundle, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    if (paramBundle == null) {
      return;
    }
    paramContext = a(paramBundle);
    String str = paramBundle.getString(AdProxy.KEY_APPID);
    paramBundle = paramBundle.getString(AdProxy.KEY_ACCOUNT);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramContext, new bkmu(this, paramBundle, str, paramILoadingAdListener));
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
    if ((paramILoadingAdListener == null) || (paramContext == null)) {
      return;
    }
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramContext, new bkmt(this, paramILoadingAdListener));
  }
  
  public void updateLoadingAdLayoutAndShow(Context paramContext, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, AdProxy.ILoadingAdListener paramILoadingAdListener)
  {
    paramContext = new MiniLoadingAdLayout(paramContext);
    if (paramContext.setupUIForSDK(paramMiniAppInfo, paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramLong1, paramLong2, paramILoadingAdListener))
    {
      paramContext.show(new bkmv(this, paramILoadingAdListener));
      if (paramILoadingAdListener != null) {
        paramILoadingAdListener.onAdShow(paramContext);
      }
      QLog.d("MiniLoadingAdManager", 1, "getLoadingAdLayout filePath " + paramString5);
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "getLoadingAdLayout setup fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl
 * JD-Core Version:    0.7.0.1
 */
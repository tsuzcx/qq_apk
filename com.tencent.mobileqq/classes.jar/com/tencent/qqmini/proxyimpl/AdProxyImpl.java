package com.tencent.qqmini.proxyimpl;

import aanx;
import aany;
import aanz;
import aasd;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.ui.GameBannerAdFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class AdProxyImpl
  extends AdProxy
{
  private final String TAG = "AdProxyImpl";
  private GdtAppReceiver mGgtAppReceiver;
  
  private aany createGdtBannerView(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2)
  {
    QLog.i("AdProxyImpl", 1, "createBannerAdView width = " + paramInt1 + ", height = " + paramInt2);
    if (paramAdInfo == null) {
      return null;
    }
    try
    {
      QLog.i("AdProxyImpl", 1, "createBannerAd");
      aanx localaanx = new aanx();
      localaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = getBannerClickParams(paramActivity, paramAdInfo);
      localaanx.jdField_a_of_type_Int = 0;
      localaanx.b = paramInt1;
      localaanx.c = paramInt2;
      paramActivity = aanz.a(localaanx);
      if (paramActivity != null) {
        localaanx.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(new GdtAd(paramAdInfo), new WeakReference(paramActivity.a()));
      } else {
        QLog.e("AdProxyImpl", 1, "build Ad error");
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("AdProxyImpl", 1, "createBannerAd, error", paramActivity);
      paramActivity = null;
    }
    return paramActivity;
  }
  
  private GdtHandler.Params getBannerClickParams(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramActivity == null) || (paramAdInfo == null)) {
      return null;
    }
    if (this.mGgtAppReceiver == null)
    {
      this.mGgtAppReceiver = new GdtAppReceiver();
      this.mGgtAppReceiver.register(paramActivity);
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGgtAppReceiver);
    localParams.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
    localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
    return localParams;
  }
  
  private String mockAdJson(String paramString)
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
  
  private qq_ad_get.QQAdGetRsp.AdInfo parseJson2AdInfo(String paramString)
  {
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)));
      return localAdInfo;
    }
    catch (Exception localException)
    {
      QLog.i("AdProxyImpl", 2, "parseJson2AdInfo error" + paramString, localException);
    }
    return null;
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
        AdUtil.putSpAdGdtCookie(paramInt, (String)localObject);
        QLog.i("AdProxyImpl", 1, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("AdProxyImpl", 1, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  public boolean adClick(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString));
      if (this.mGgtAppReceiver == null)
      {
        this.mGgtAppReceiver = new GdtAppReceiver();
        this.mGgtAppReceiver.register(paramActivity);
      }
      paramString = new GdtHandler.Params();
      paramString.c = 11;
      paramString.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      paramString.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(localAdInfo);
      paramString.jdField_a_of_type_Boolean = true;
      paramString.jdField_b_of_type_Boolean = true;
      paramString.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGgtAppReceiver);
      paramString.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniappD");
      paramString.jdField_a_of_type_AndroidOsBundle = paramActivity;
      GdtHandler.a(paramString);
      return true;
    }
    catch (JSONException paramActivity) {}
    return false;
  }
  
  public AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new AdProxyImpl.SDKBannerAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInt1, paramInt2, paramIBannerAdListener);
  }
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new AdProxyImpl.SDKBoxAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBoxADLisener);
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new AdProxyImpl.SDKInterstitialAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInterstitialADLisener);
  }
  
  public AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new AdProxyImpl.SDKRewardedVideoAdView(this, paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIRewardVideoAdListener);
  }
  
  public void destroy(Activity paramActivity)
  {
    if (this.mGgtAppReceiver != null) {}
    try
    {
      this.mGgtAppReceiver.unregister(paramActivity);
      label15:
      this.mGgtAppReceiver = null;
      return;
    }
    catch (Throwable paramActivity)
    {
      break label15;
    }
  }
  
  public void requestAdInfo(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.ICmdListener paramICmdListener)
  {
    ThreadManagerV2.excute(new AdProxyImpl.1(this, paramActivity, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, paramString8, paramICmdListener), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl
 * JD-Core Version:    0.7.0.1
 */
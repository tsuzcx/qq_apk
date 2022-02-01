package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKInterstitialAdView
  extends AdProxy.AbsInterstitialAdView
{
  int jdField_a_of_type_Int = 53;
  volatile long jdField_a_of_type_Long;
  IGdtInterstitialAd jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd;
  AdProxy.InterstitialADLisener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  WeakReference<IMiniAppContext> jdField_b_of_type_JavaLangRefWeakReference;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  
  public AdProxyImpl$SDKInterstitialAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.InterstitialADLisener paramInterstitialADLisener, IMiniAppContext paramIMiniAppContext)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener = paramInterstitialADLisener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIMiniAppContext);
  }
  
  private GdtHandler.Options a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    GdtHandler.Options localOptions = new GdtHandler.Options();
    localOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
    localOptions.jdField_a_of_type_Boolean = true;
    localOptions.b = true;
    paramAdInfo = new Bundle();
    paramAdInfo.putString("big_brother_ref_source_key", "biz_src_miniapp");
    localOptions.jdField_a_of_type_AndroidOsBundle = paramAdInfo;
    return localOptions;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener = null;
  }
  
  public void loadAD()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAD, act is null, ");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.e("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener;
      if (localObject != null) {
        ((AdProxy.InterstitialADLisener)localObject).onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo((Context)localObject, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d, this.e, this.f, this.g, this.h, 1, new AdProxyImpl.SDKInterstitialAdView.1(this, (Activity)localObject));
  }
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd != null) && (paramActivity != null))
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd.a(paramActivity, paramInt, paramIntent);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("AdProxyImpl", 1, "onClose", paramActivity);
    }
  }
  
  public boolean show(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd != null) && (paramActivity != null))
    {
      Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
      if (localObject != null) {
        localObject = (IMiniAppContext)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      localObject = MiniAdAntiSpamReportUtil.a((IMiniAppContext)localObject, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd.a((JSONObject)localObject);
      boolean bool = this.jdField_a_of_type_ComTencentGdtadApiInterstitialIGdtInterstitialAd.a(paramActivity);
      if (bool)
      {
        paramActivity = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener;
        if (paramActivity != null) {
          paramActivity.onShow();
        }
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView
 * JD-Core Version:    0.7.0.1
 */
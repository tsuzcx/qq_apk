package com.tencent.qqmini.proxyimpl;

import aaon;
import aasd;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKInterstitialAdView
  extends AdProxy.AbsInterstitialAdView
{
  int SHARE_RATE = 53;
  WeakReference<Activity> mActivity;
  int mAdType;
  String mAppid;
  int mDeviceOrientation;
  String mEntryPath;
  String mGdtCookie;
  AdProxy.InterstitialADLisener mInterstitialAdListener;
  aaon mInterstitialAdView;
  String mPosid;
  String mRefer;
  String mReportData;
  String mUin;
  String mVia;
  
  public AdProxyImpl$SDKInterstitialAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.InterstitialADLisener paramInterstitialADLisener)
  {
    super(paramAdProxyImpl);
    this.mActivity = new WeakReference(paramActivity);
    this.mInterstitialAdListener = paramInterstitialADLisener;
    this.mAppid = paramString1;
    this.mPosid = paramString2;
    this.mUin = paramString3;
    this.mAdType = paramInt1;
    this.mDeviceOrientation = paramInt2;
    this.mGdtCookie = paramString4;
    this.mEntryPath = paramString5;
    this.mReportData = paramString6;
    this.mRefer = paramString7;
    this.mVia = paramString8;
  }
  
  private GdtHandler.Options getClickOption(JSONObject paramJSONObject)
  {
    Object localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject));
    paramJSONObject = new GdtHandler.Options();
    paramJSONObject.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    paramJSONObject.jdField_a_of_type_Boolean = true;
    paramJSONObject.b = true;
    localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramJSONObject.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
    return paramJSONObject;
  }
  
  public void destroy()
  {
    this.mInterstitialAdView = null;
    this.mActivity = null;
    this.mInterstitialAdListener = null;
  }
  
  public void loadAD()
  {
    Object localObject;
    if (this.mActivity != null)
    {
      localObject = (Activity)this.mActivity.get();
      if (localObject != null) {
        break label91;
      }
      localObject = new StringBuilder().append("loadAD, act is null, ");
      if (this.mInterstitialAdListener == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.mInterstitialAdListener != null) {
        this.mInterstitialAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label91:
    this.this$0.requestAdInfo((Activity)localObject, this.mUin, this.mPosid, this.mAppid, this.SHARE_RATE, this.mAdType, this.mDeviceOrientation, this.mGdtCookie, this.mEntryPath, this.mReportData, this.mRefer, this.mVia, new AdProxyImpl.SDKInterstitialAdView.1(this, (Activity)localObject));
  }
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if ((this.mInterstitialAdView != null) && (paramActivity != null)) {
        this.mInterstitialAdView.a(paramActivity, paramInt, paramIntent);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QMLog.i("AdProxyImpl", "onClose", paramActivity);
    }
  }
  
  public boolean show(Activity paramActivity)
  {
    if ((this.mInterstitialAdView != null) && (paramActivity != null))
    {
      boolean bool = this.mInterstitialAdView.a(paramActivity);
      if ((bool) && (this.mInterstitialAdListener != null)) {
        this.mInterstitialAdListener.onShow();
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView
 * JD-Core Version:    0.7.0.1
 */
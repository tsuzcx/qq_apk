package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBannerAdListener;
import java.lang.ref.WeakReference;
import yku;

class AdProxyImpl$SDKBannerAdView
  extends AdProxy.AbsBannerAdView
{
  int SHARE_RATE = 53;
  WeakReference<Activity> mActivity;
  int mAdType;
  String mAppid;
  AdProxy.IBannerAdListener mBannerListener;
  int mDeviceOrientation;
  String mEntryPath;
  yku mGdtBannerView;
  String mGdtCookie;
  int mHeight;
  String mPosid;
  String mRefer;
  String mReportData;
  String mReportUrl;
  String mUin;
  String mVia;
  int mWidth;
  
  public AdProxyImpl$SDKBannerAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, AdProxy.IBannerAdListener paramIBannerAdListener)
  {
    super(paramAdProxyImpl);
    this.mActivity = new WeakReference(paramActivity);
    this.mBannerListener = paramIBannerAdListener;
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
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public void destroy(Context paramContext)
  {
    this.mActivity = null;
    this.mBannerListener = null;
    this.mGdtBannerView = null;
  }
  
  public String getReportUrl()
  {
    return this.mReportUrl;
  }
  
  public View getView()
  {
    if (this.mGdtBannerView != null) {
      return this.mGdtBannerView.a();
    }
    return null;
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
      if (this.mBannerListener == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.mBannerListener != null) {
        this.mBannerListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label91:
    this.this$0.requestAdInfo((Activity)localObject, this.mUin, this.mPosid, this.mAppid, this.SHARE_RATE, this.mAdType, this.mDeviceOrientation, this.mGdtCookie, this.mEntryPath, this.mReportData, this.mRefer, this.mVia, new AdProxyImpl.SDKBannerAdView.1(this, (Activity)localObject));
  }
  
  public void pause(Context paramContext)
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.a(paramContext);
    }
  }
  
  public void resume(Context paramContext)
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.b(paramContext);
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView
 * JD-Core Version:    0.7.0.1
 */
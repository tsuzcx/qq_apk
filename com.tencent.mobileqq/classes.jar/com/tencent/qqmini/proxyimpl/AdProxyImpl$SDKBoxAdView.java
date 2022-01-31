package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBoxADLisener;
import java.lang.ref.WeakReference;
import ykd;

class AdProxyImpl$SDKBoxAdView
  extends AdProxy.AbsBoxAdView
{
  int SHARE_RATE = 53;
  WeakReference<Activity> mActivity;
  int mAdType;
  String mAppid;
  AdProxy.IBoxADLisener mBoxListener;
  int mDeviceOrientation;
  String mEntryPath;
  ykd mGdtBoxView;
  String mGdtCookie;
  String mPosid;
  String mRefer;
  String mReportData;
  String mUin;
  String mVia;
  
  public AdProxyImpl$SDKBoxAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBoxADLisener paramIBoxADLisener)
  {
    super(paramAdProxyImpl);
    this.mActivity = new WeakReference(paramActivity);
    this.mBoxListener = paramIBoxADLisener;
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
  
  public void destroy()
  {
    if (this.mGdtBoxView != null) {
      this.mGdtBoxView.b();
    }
    this.mGdtBoxView = null;
    this.mActivity = null;
    this.mBoxListener = null;
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
      if (this.mBoxListener == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.mBoxListener != null) {
        this.mBoxListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label91:
    this.this$0.requestAdInfo((Activity)localObject, this.mUin, this.mPosid, this.mAppid, this.SHARE_RATE, this.mAdType, this.mDeviceOrientation, this.mGdtCookie, this.mEntryPath, this.mReportData, this.mRefer, this.mVia, new AdProxyImpl.SDKBoxAdView.1(this, (Activity)localObject));
  }
  
  public void show()
  {
    if (this.mGdtBoxView != null) {
      this.mGdtBoxView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView
 * JD-Core Version:    0.7.0.1
 */
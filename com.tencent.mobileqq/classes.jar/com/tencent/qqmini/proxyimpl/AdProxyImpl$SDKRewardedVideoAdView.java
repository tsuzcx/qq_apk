package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import bgqg;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.ref.WeakReference;

class AdProxyImpl$SDKRewardedVideoAdView
  extends AdProxy.AbsRewardVideoAdView
{
  public static final String PROFITABLE_FLAG = "profitable_flag";
  public static final String TIME_DURATION = "duration_time";
  public static final String TIME_ELAPSED = "elapsed_time";
  int SHARE_RATE = 53;
  WeakReference<Activity> mActivity;
  int mAdType;
  String mAppid;
  int mDeviceOrientation;
  String mEntryPath;
  String mGdtCookie;
  GdtMotiveVideoPageData mGdtMotiveVideoPageData;
  String mPosid;
  String mRefer;
  String mReportData;
  AdProxy.IRewardVideoAdListener mRewardedListener;
  String mUin;
  String mVia;
  
  public AdProxyImpl$SDKRewardedVideoAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener)
  {
    super(paramAdProxyImpl);
    this.mActivity = new WeakReference(paramActivity);
    this.mRewardedListener = paramIRewardVideoAdListener;
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
  
  public void loadAD()
  {
    if (this.mActivity != null) {}
    for (Activity localActivity = (Activity)this.mActivity.get(); localActivity == null; localActivity = null)
    {
      if (this.mRewardedListener != null) {
        this.mRewardedListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    this.this$0.requestAdInfo(localActivity, this.mUin, this.mPosid, this.mAppid, this.SHARE_RATE, this.mAdType, this.mDeviceOrientation, this.mGdtCookie, this.mEntryPath, this.mReportData, this.mRefer, this.mVia, new AdProxyImpl.SDKRewardedVideoAdView.1(this));
  }
  
  public void onReceiveVideoClose(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    }
    long l2 = paramBundle.getLong("duration_time");
    long l3 = paramBundle.getLong("elapsed_time");
    boolean bool = paramBundle.getBoolean("profitable_flag", false);
    long l1;
    if (l2 > l3)
    {
      l1 = l3;
      int j = (int)(l1 / 1000L);
      int i = j;
      if (j > 15) {
        i = 15;
      }
      Object localObject = null;
      paramBundle = localObject;
      if (AppRuntimeLoaderManager.g() != null)
      {
        paramBundle = localObject;
        if (AppRuntimeLoaderManager.g().getCurrentRunTimeLoader() != null) {
          paramBundle = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader().getMiniAppInfo();
        }
      }
      if (paramBundle == null) {
        break label293;
      }
      paramBundle.gameAdsTotalTime += i;
      QLog.d("AdProxyImpl", 1, "RewardedAd now gameAdsTotalTime = " + paramBundle.gameAdsTotalTime + ", reportTime = " + i);
    }
    for (;;)
    {
      if (this.mRewardedListener != null)
      {
        if ((bool) && (paramInt == -1)) {
          this.mRewardedListener.onReward();
        }
        this.mRewardedListener.onADClose();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdProxyImpl", 1, "RewardedAd ActivityResultListener receive durationTime= " + l2 + " elaspedTime=" + l3 + " profitable=" + bool + ", resultCode = " + paramInt);
      }
      return;
      l1 = l2;
      break;
      label293:
      QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
    }
  }
  
  public void showAD()
  {
    Activity localActivity;
    if (this.mActivity != null)
    {
      localActivity = (Activity)this.mActivity.get();
      if ((localActivity != null) && (this.mGdtMotiveVideoPageData != null)) {
        break label65;
      }
      QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
      if (this.mRewardedListener != null) {
        this.mRewardedListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
    }
    label65:
    do
    {
      return;
      localActivity = null;
      break;
      this.mGdtMotiveVideoPageData.refId = "biz_src_miniapp";
      this.mGdtMotiveVideoPageData.containerType = 1;
      this.mGdtMotiveVideoPageData.resultReceiver = new AdProxyImpl.AdResultReceiver(new Handler(Looper.getMainLooper()), this);
      GdtMotiveVideoFragment.a(localActivity, GdtMotiveVideoFragment.class, this.mGdtMotiveVideoPageData);
    } while (this.mRewardedListener == null);
    this.mRewardedListener.onADShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class AdProxyImpl$SDKRewardedVideoAdView
  extends AdProxy.AbsRewardVideoAdView
{
  int jdField_a_of_type_Int = 53;
  GdtMotiveVideoPageData jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData;
  IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  AdProxy.IRewardVideoAdListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  
  public AdProxyImpl$SDKRewardedVideoAdView(AdProxyImpl paramAdProxyImpl, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, IMiniAppContext paramIMiniAppContext)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener = paramIRewardVideoAdListener;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceiveResult() called with: resultCode = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], resultData = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("]");
      QLog.d("AdProxyImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = paramBundle.getLong("duration_time");
    long l3 = paramBundle.getLong("elapsed_time");
    boolean bool = paramBundle.getBoolean("profitable_flag", false);
    long l1;
    if (l2 > l3) {
      l1 = l3;
    } else {
      l1 = l2;
    }
    int k = (int)(l1 / 1000L);
    int j = k;
    if (k > 15) {
      j = 15;
    }
    paramBundle = null;
    Object localObject = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localObject != null) {
      paramBundle = ((BaseRuntime)localObject).getMiniAppInfo();
    }
    if (paramBundle != null)
    {
      paramBundle.gameAdsTotalTime += j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RewardedAd now gameAdsTotalTime = ");
      ((StringBuilder)localObject).append(paramBundle.gameAdsTotalTime);
      ((StringBuilder)localObject).append(", reportTime = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
    }
    paramBundle = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
    if (paramBundle != null)
    {
      if ((bool) && (paramInt == -1)) {
        paramBundle.onReward();
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADClose(this.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("RewardedAd ActivityResultListener receive durationTime= ");
      paramBundle.append(l2);
      paramBundle.append(" elaspedTime=");
      paramBundle.append(l3);
      paramBundle.append(" profitable=");
      paramBundle.append(bool);
      paramBundle.append(", resultCode = ");
      paramBundle.append(paramInt);
      QLog.d("AdProxyImpl", 1, paramBundle.toString());
    }
  }
  
  public void loadAD(Context paramContext)
  {
    if (paramContext == null)
    {
      paramContext = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
      if (paramContext != null) {
        paramContext.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    QLog.i("AdProxyImpl", 1, "reward load");
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo(paramContext, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.e, this.f, this.g, this.h, this.i, 1, new AdProxyImpl.SDKRewardedVideoAdView.1(this));
  }
  
  public void showAD(Context paramContext, String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = null;
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = (Activity)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData;
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        ((GdtMotiveVideoPageData)localObject).refId = "biz_src_miniapp";
        boolean bool = new GdtMotiveVideoModel((GdtMotiveVideoPageData)localObject).a().isProcessInTool();
        if (bool) {
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.containerType = 0;
        } else {
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.containerType = 1;
        }
        if ((this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.vSize != 185) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.vSize != 585))
        {
          paramString = new AdProxyImpl.CallbackData(this, null);
          localObject = AdProxyImpl.CallbackData.a(paramString);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mvBrowing dataKey = ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", data =");
          localStringBuilder.append(AdProxyImpl.CallbackData.a(paramString));
          QLog.i("AdProxyImpl", 1, localStringBuilder.toString());
          if (AdProxyImpl.a() == null) {
            AdProxyImpl.a(new HashMap());
          }
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.motiveBrowsingKey = ((String)localObject);
          AdProxyImpl.a().put(localObject, paramString);
          paramString = localGdtMotiveVideoPageData;
        }
        else
        {
          paramString = new AdProxyImpl.AdResultReceiver(new Handler(Looper.getMainLooper()), this);
        }
        localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData;
        localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData.adId);
        localStringBuilder.append("");
        localGdtMotiveVideoPageData.antiSpamParams = MiniAdAntiSpamReportUtil.a((IMiniAppContext)localObject, localStringBuilder.toString(), this.jdField_c_of_type_JavaLangString);
        paramContext = StartGdtMotiveVideoParams.a(paramContext, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData, paramString);
        paramContext.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          paramContext.jdField_a_of_type_Int = 4760;
          ActivityResultManager.g().addActivityResultListener(new AdProxyImpl.GdtMovieActResult(this));
        }
        ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(paramContext);
        paramContext = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
        if (paramContext != null) {
          paramContext.onADShow();
        }
        return;
      }
    }
    QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
    paramContext = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
    if (paramContext != null) {
      paramContext.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView
 * JD-Core Version:    0.7.0.1
 */
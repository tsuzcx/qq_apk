package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKRewardedVideoAdView
  extends AdProxy.AbsRewardVideoAdView
{
  WeakReference<Context> a;
  AdProxy.IRewardVideoAdListener b;
  GdtMotiveVideoPageData c;
  GdtMotiveVideoPageData d;
  String e;
  int f = 53;
  String g;
  String h;
  String i;
  int j;
  int k;
  String l;
  String m;
  String n;
  String o;
  String p;
  IMiniAppContext q;
  
  public AdProxyImpl$SDKRewardedVideoAdView(AdProxyImpl paramAdProxyImpl, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, IMiniAppContext paramIMiniAppContext)
  {
    super(paramAdProxyImpl);
    this.a = new WeakReference(paramContext);
    this.b = paramIRewardVideoAdListener;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramString4;
    this.m = paramString5;
    this.n = paramString6;
    this.o = paramString7;
    this.p = paramString8;
    this.q = paramIMiniAppContext;
  }
  
  private GdtMotiveVideoPageData a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (!bool) {
      localObject1 = AdProxyImpl.b(this.r, paramString);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
    Object localObject1 = localObject2;
    if (localGdtAd.isValid())
    {
      GdtPreLoader.a().a(localGdtAd);
      int i1;
      if (this.k == 90) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      paramString = RewardedVideoAdPlugin.a(localGdtAd, paramString, i1);
      localObject1 = paramString;
      if (paramString != null)
      {
        i1 = AdUtils.getRewardVideoShowTimeFromExp(localGdtAd);
        localObject1 = paramString;
        if (i1 > 0)
        {
          paramString.setVideoCountDown(i1);
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
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
    int i2 = (int)(l1 / 1000L);
    int i1 = i2;
    if (i2 > 15) {
      i1 = 15;
    }
    paramBundle = null;
    Object localObject = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localObject != null) {
      paramBundle = ((BaseRuntime)localObject).getMiniAppInfo();
    }
    if (paramBundle != null)
    {
      paramBundle.gameAdsTotalTime += i1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RewardedAd now gameAdsTotalTime = ");
      ((StringBuilder)localObject).append(paramBundle.gameAdsTotalTime);
      ((StringBuilder)localObject).append(", reportTime = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
    }
    paramBundle = this.b;
    if (paramBundle != null)
    {
      if ((bool) && (paramInt == -1)) {
        paramBundle.onReward();
      }
      this.b.onADClose(this.e);
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
      paramContext = this.b;
      if (paramContext != null) {
        paramContext.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    QLog.i("AdProxyImpl", 1, "reward load");
    this.r.requestAdInfo(paramContext, this.i, this.h, this.g, this.f, this.j, this.k, this.l, this.m, this.n, this.o, this.p, 2, new AdProxyImpl.SDKRewardedVideoAdView.1(this));
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
      Object localObject = this.c;
      if (localObject != null)
      {
        this.e = paramString;
        ((GdtMotiveVideoPageData)localObject).refId = "biz_src_miniapp";
        boolean bool = new GdtMotiveVideoModel((GdtMotiveVideoPageData)localObject).d().isProcessInTool();
        if (bool) {
          this.c.containerType = 0;
        } else {
          this.c.containerType = 1;
        }
        paramString = this.d;
        if (paramString != null)
        {
          paramString.refId = "biz_src_miniapp";
          if (bool) {
            paramString.containerType = 0;
          } else {
            paramString.containerType = 1;
          }
          paramString = this.d;
          localObject = this.q;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.d.adId);
          localStringBuilder.append("");
          paramString.antiSpamParams = MiniAdAntiSpamReportUtil.c((IMiniAppContext)localObject, localStringBuilder.toString(), this.h);
        }
        if ((this.c.vSize != 185) && (this.c.vSize != 585))
        {
          paramString = new AdProxyImpl.CallbackData(this, null);
          localObject = AdProxyImpl.CallbackData.b(paramString);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mvBrowing dataKey = ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", data =");
          localStringBuilder.append(AdProxyImpl.CallbackData.a(paramString));
          QLog.i("AdProxyImpl", 1, localStringBuilder.toString());
          if (AdProxyImpl.a() == null) {
            AdProxyImpl.a(new HashMap());
          }
          this.c.motiveBrowsingKey = ((String)localObject);
          AdProxyImpl.a().put(localObject, paramString);
          paramString = localGdtMotiveVideoPageData;
        }
        else
        {
          paramString = new AdProxyImpl.AdResultReceiver(new Handler(Looper.getMainLooper()), this);
        }
        localGdtMotiveVideoPageData = this.c;
        localObject = this.q;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c.adId);
        localStringBuilder.append("");
        localGdtMotiveVideoPageData.antiSpamParams = MiniAdAntiSpamReportUtil.c((IMiniAppContext)localObject, localStringBuilder.toString(), this.h);
        paramContext = StartGdtMotiveVideoParams.a(paramContext, this.c, paramString);
        paramContext.e = bool;
        paramContext.c = this.d;
        if (bool)
        {
          paramContext.g = 4760;
          AdProxyImpl.a(this.r, this);
        }
        paramString = new StringBuilder();
        paramString.append("[showAD] isProcessInTool=");
        paramString.append(bool);
        QLog.e("AdProxyImpl", 1, paramString.toString());
        ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(paramContext);
        paramContext = this.b;
        if (paramContext != null) {
          paramContext.onADShow();
        }
        return;
      }
    }
    QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView
 * JD-Core Version:    0.7.0.1
 */
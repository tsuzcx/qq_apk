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
  WeakReference<Activity> a;
  AdProxy.InterstitialADLisener b;
  IGdtInterstitialAd c;
  int d = 53;
  String e;
  String f;
  String g;
  int h;
  int i;
  String j;
  String k;
  String l;
  String m;
  String n;
  WeakReference<IMiniAppContext> o;
  volatile long p;
  
  public AdProxyImpl$SDKInterstitialAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.InterstitialADLisener paramInterstitialADLisener, IMiniAppContext paramIMiniAppContext)
  {
    super(paramAdProxyImpl);
    this.a = new WeakReference(paramActivity);
    this.b = paramInterstitialADLisener;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramString4;
    this.k = paramString5;
    this.l = paramString6;
    this.m = paramString7;
    this.n = paramString8;
    this.o = new WeakReference(paramIMiniAppContext);
  }
  
  private GdtHandler.Options a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    GdtHandler.Options localOptions = new GdtHandler.Options();
    localOptions.a = new GdtAd(paramAdInfo);
    localOptions.b = true;
    localOptions.e = true;
    paramAdInfo = new Bundle();
    paramAdInfo.putString("big_brother_ref_source_key", "biz_src_miniapp");
    localOptions.p = paramAdInfo;
    return localOptions;
  }
  
  public void destroy()
  {
    this.c = null;
    this.a = null;
    this.b = null;
  }
  
  public void loadAD()
  {
    Object localObject = this.a;
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
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.e("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
      localObject = this.b;
      if (localObject != null) {
        ((AdProxy.InterstitialADLisener)localObject).onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    this.p = System.currentTimeMillis();
    this.q.requestAdInfo((Context)localObject, this.g, this.f, this.e, this.d, this.h, this.i, this.j, this.k, this.l, this.m, this.n, 1, new AdProxyImpl.SDKInterstitialAdView.1(this, (Activity)localObject));
  }
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if ((this.c != null) && (paramActivity != null))
      {
        this.c.a(paramActivity, paramInt, paramIntent);
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
    if ((this.c != null) && (paramActivity != null))
    {
      Object localObject = this.o;
      if (localObject != null) {
        localObject = (IMiniAppContext)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      localObject = MiniAdAntiSpamReportUtil.a((IMiniAppContext)localObject, this.p, this.f);
      this.c.a((JSONObject)localObject);
      boolean bool = this.c.a(paramActivity);
      if (bool)
      {
        paramActivity = this.b;
        if (paramActivity != null) {
          paramActivity.onShow();
        }
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKInterstitialAdView
 * JD-Core Version:    0.7.0.1
 */
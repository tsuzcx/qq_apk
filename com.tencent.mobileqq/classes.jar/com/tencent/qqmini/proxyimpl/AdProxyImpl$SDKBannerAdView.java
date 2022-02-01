package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class AdProxyImpl$SDKBannerAdView
  extends AdProxy.AbsBannerAdView
{
  WeakReference<Activity> a;
  AdProxy.IBannerAdListener b;
  GdtBannerView c;
  GdtAdListener d;
  IGdtBannerAd e;
  protected qq_ad_get.QQAdGetRsp.AdInfo f;
  int g = 53;
  String h;
  String i;
  String j;
  int k;
  int l;
  String m;
  String n;
  String o;
  String p;
  String q;
  int r;
  int s;
  String t;
  long u;
  IMiniAppContext v;
  IGetAdPosInfo w;
  public ArrayList<AdExposureChecker> x = new ArrayList();
  public AdExposureChecker.ExposureCallback y = null;
  
  public AdProxyImpl$SDKBannerAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, AdProxy.IBannerAdListener paramIBannerAdListener, IMiniAppContext paramIMiniAppContext, IGetAdPosInfo paramIGetAdPosInfo)
  {
    super(paramAdProxyImpl);
    this.a = new WeakReference(paramActivity);
    this.b = paramIBannerAdListener;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramString4;
    this.n = paramString5;
    this.o = paramString6;
    this.p = paramString7;
    this.q = paramString8;
    this.r = paramInt3;
    this.s = paramInt4;
    this.v = paramIMiniAppContext;
    this.w = paramIGetAdPosInfo;
    a(paramActivity);
  }
  
  private GdtBannerView a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString, int paramInt1, int paramInt2, IMiniAppContext paramIMiniAppContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createBannerAdView width = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", height = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
    if (paramAdInfo != null)
    {
      if (paramActivity == null) {
        return null;
      }
      try
      {
        QLog.i("AdProxyImpl", 1, "createBannerAd");
        localObject = new GdtBannerParams();
        ((GdtBannerParams)localObject).b = AdProxyImpl.a(this.z, paramActivity, paramAdInfo, paramIMiniAppContext, paramString);
        ((GdtBannerParams)localObject).c = 0;
        ((GdtBannerParams)localObject).d = paramInt1;
        ((GdtBannerParams)localObject).e = paramInt2;
        this.e = ((IGdtBannerAdAPI)QRoute.api(IGdtBannerAdAPI.class)).buildBannerAd((GdtBannerParams)localObject);
        paramAdInfo = this.e.render(paramActivity, paramInt1, paramInt2);
        this.e.setListener(new WeakReference(this.d));
        paramActivity = paramAdInfo;
        if (paramAdInfo == null)
        {
          QLog.e("AdProxyImpl", 1, "build Ad error");
          return paramAdInfo;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("AdProxyImpl", 1, "createBannerAd, error", paramActivity);
        paramActivity = null;
      }
      return paramActivity;
    }
    return null;
  }
  
  private String a(MiniAdPosInfo paramMiniAdPosInfo)
  {
    if (paramMiniAdPosInfo == null) {
      return "";
    }
    int i1 = paramMiniAdPosInfo.left;
    int i2 = paramMiniAdPosInfo.top;
    int i3 = paramMiniAdPosInfo.width;
    int i4 = paramMiniAdPosInfo.height;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("px", String.valueOf(i1));
      ((JSONObject)localObject).put("py", String.valueOf(i2));
      ((JSONObject)localObject).put("da", String.valueOf(i3));
      ((JSONObject)localObject).put("db", String.valueOf(i4));
      ((JSONObject)localObject).put("x", "0");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("s=");
      localStringBuilder2.append(URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8"));
      localObject = localStringBuilder2.toString();
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", localUnsupportedEncodingException);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", localJSONException);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("getBannerExtraReportParams = ");
    localStringBuilder1.append(paramMiniAdPosInfo);
    QLog.i("AdProxyImpl", 1, localStringBuilder1.toString());
    return "";
  }
  
  private void a(Activity paramActivity)
  {
    if (this.d == null) {
      this.d = new AdProxyImpl.SDKBannerAdView.1(this, paramActivity);
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new AdProxyImpl.SDKBannerAdView.4(this, paramString));
  }
  
  private void a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, View paramView)
  {
    if ((paramAdInfo != null) && (paramView != null))
    {
      if (AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(paramAdInfo)))
      {
        if (this.x == null) {
          this.x = new ArrayList();
        }
        paramAdInfo = new AdExposureChecker(new GdtAd(paramAdInfo), new WeakReference(paramView));
        if (this.y == null) {
          this.y = new AdProxyImpl.SDKBannerAdView.3(this);
        }
        paramAdInfo.setCallback(new WeakReference(this.y));
        this.x.add(paramAdInfo);
        paramAdInfo.startCheck();
        QLog.i("AdProxyImpl", 1, "startonExposure");
      }
      return;
    }
    QLog.i("AdProxyImpl", 1, "initAdExposureChecker null");
  }
  
  public void destroy(Context paramContext)
  {
    paramContext = this.x;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.x.clear();
      this.y = null;
    }
    this.a = null;
    this.b = null;
    this.c = null;
    this.f = null;
    this.e = null;
  }
  
  public long getAdID()
  {
    return this.u;
  }
  
  public String getReportUrl()
  {
    return this.t;
  }
  
  public View getView()
  {
    GdtBannerView localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      return localGdtBannerView.getView();
    }
    return null;
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
        ((AdProxy.IBannerAdListener)localObject).onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    this.z.requestAdInfo((Context)localObject, this.j, this.i, this.h, this.g, this.k, this.l, this.m, this.n, this.o, this.p, this.q, 1, new AdProxyImpl.SDKBannerAdView.2(this, (Activity)localObject));
  }
  
  public void onExposure()
  {
    if (AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(this.f)))
    {
      a(this.f, getView());
    }
    else
    {
      a(this.t);
      MiniAdAntiSpamReportUtil.a(this.v, this.t, System.currentTimeMillis(), this.i, 2);
    }
    this.e.onDisplay();
  }
  
  public void pause(Context paramContext)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((GdtBannerView)localObject).a(paramContext);
    }
    paramContext = this.x;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (AdExposureChecker)paramContext.next();
        if (localObject != null) {
          ((AdExposureChecker)localObject).onActivityPause();
        }
      }
    }
  }
  
  public void resume(Context paramContext)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((GdtBannerView)localObject).b(paramContext);
    }
    paramContext = this.x;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (AdExposureChecker)paramContext.next();
        if (localObject != null) {
          ((AdExposureChecker)localObject).onActivityResume();
        }
      }
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    GdtBannerView localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      localGdtBannerView.setSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView
 * JD-Core Version:    0.7.0.1
 */
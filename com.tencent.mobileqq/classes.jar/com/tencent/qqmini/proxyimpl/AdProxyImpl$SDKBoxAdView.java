package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import java.lang.ref.WeakReference;

class AdProxyImpl$SDKBoxAdView
  extends AdProxy.AbsBoxAdView
{
  WeakReference<Activity> a;
  AdProxy.IBoxADLisener b;
  IGdtAdBox c;
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
  
  public AdProxyImpl$SDKBoxAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBoxADLisener paramIBoxADLisener)
  {
    super(paramAdProxyImpl);
    this.a = new WeakReference(paramActivity);
    this.b = paramIBoxADLisener;
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
  }
  
  public void destroy()
  {
    IGdtAdBox localIGdtAdBox = this.c;
    if (localIGdtAdBox != null) {
      localIGdtAdBox.c();
    }
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
        ((AdProxy.IBoxADLisener)localObject).onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    this.o.requestAdInfo((Context)localObject, this.g, this.f, this.e, this.d, this.h, this.i, this.j, this.k, this.l, this.m, this.n, 1, new AdProxyImpl.SDKBoxAdView.1(this, (Activity)localObject));
  }
  
  public void show()
  {
    IGdtAdBox localIGdtAdBox = this.c;
    if (localIGdtAdBox != null) {
      localIGdtAdBox.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView
 * JD-Core Version:    0.7.0.1
 */
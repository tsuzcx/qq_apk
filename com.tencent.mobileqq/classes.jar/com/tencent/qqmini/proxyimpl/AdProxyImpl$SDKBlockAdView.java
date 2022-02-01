package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class AdProxyImpl$SDKBlockAdView
  extends AdProxy.AbsBlockAdView
{
  WeakReference<Activity> a;
  AdProxy.IBlockAdListener b;
  BlockAdView c;
  BlockAdInfo d;
  int e = 53;
  String f;
  String g;
  int h;
  int i;
  String j;
  String k;
  String l;
  String m;
  String n;
  ArrayList<String> o;
  
  public AdProxyImpl$SDKBlockAdView(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, int paramInt6, int paramInt7, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBlockAdListener paramIBlockAdListener)
  {
    super(paramAdProxyImpl);
    this.a = new WeakReference(paramActivity);
    this.b = paramIBlockAdListener;
    this.f = paramString1;
    this.g = paramString3;
    this.h = paramInt6;
    this.i = paramInt7;
    this.j = paramString4;
    this.k = paramString5;
    this.l = paramString6;
    this.m = paramString7;
    this.n = paramString8;
    this.d = new BlockAdInfo(paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void clearBlockAdAnimation(AdProxy.AbsBlockAdView paramAbsBlockAdView)
  {
    if (paramAbsBlockAdView != null)
    {
      if (!(paramAbsBlockAdView.getView() instanceof BlockAdView)) {
        return;
      }
      ((BlockAdView)paramAbsBlockAdView.getView()).clearBlockAdAnimation();
    }
  }
  
  public void destroy(Context paramContext)
  {
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  public ArrayList<String> getReportUrl()
  {
    return this.o;
  }
  
  public View getView()
  {
    return this.c;
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
        ((AdProxy.IBlockAdListener)localObject).onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    BlockAdManager.getInstance().initActivitySize((Activity)localObject);
    this.p.requestAdInfo((Context)localObject, this.g, this.d.getAdUnitId(), this.f, this.e, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.d.getSize(), new AdProxyImpl.SDKBlockAdView.1(this, (Activity)localObject));
  }
  
  public void showBlockAdAnimation(AdProxy.AbsBlockAdView paramAbsBlockAdView)
  {
    if (paramAbsBlockAdView != null)
    {
      if (!(paramAbsBlockAdView.getView() instanceof BlockAdView)) {
        return;
      }
      ((BlockAdView)paramAbsBlockAdView.getView()).startBlockAnimation();
    }
  }
  
  public View updateAdInfo(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (this.c == null) {
        return null;
      }
      ((BlockAdInfo)localObject).setLeft(paramInt1);
      this.d.setTop(paramInt2);
      this.c.setData(this.d);
      if (this.c.getRealAdNum() == 0)
      {
        localObject = this.b;
        if (localObject != null)
        {
          ((AdProxy.IBlockAdListener)localObject).onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
          return null;
        }
      }
      return this.c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBlockAdView
 * JD-Core Version:    0.7.0.1
 */
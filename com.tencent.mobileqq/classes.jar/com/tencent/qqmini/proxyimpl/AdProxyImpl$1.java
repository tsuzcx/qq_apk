package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.content.Context;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;

class AdProxyImpl$1
  implements Runnable
{
  AdProxyImpl$1(AdProxyImpl paramAdProxyImpl, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, AdProxy.ICmdListener paramICmdListener) {}
  
  public void run()
  {
    MiniAppAd.StGetAdReq localStGetAdReq = AdUtils.createAdRequest(this.a, Long.parseLong(this.b), this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new AdProxyImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
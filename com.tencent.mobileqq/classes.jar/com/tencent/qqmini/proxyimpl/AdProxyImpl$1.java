package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;

class AdProxyImpl$1
  implements Runnable
{
  AdProxyImpl$1(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.ICmdListener paramICmdListener) {}
  
  public void run()
  {
    MiniAppAd.StGetAdReq localStGetAdReq = AdUtils.createAdRequest(this.val$activity, Long.parseLong(this.val$uin), this.val$adUnitId, this.val$appid, this.val$shareRate, this.val$adType, this.val$deviceOrientation, this.val$gdtCookie, this.val$queryData, this.val$reportData, this.val$refer, this.val$via);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new AdProxyImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
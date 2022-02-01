package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;

class AdProxyImpl$SDKBannerAdView$4
  implements Runnable
{
  AdProxyImpl$SDKBannerAdView$4(AdProxyImpl.SDKBannerAdView paramSDKBannerAdView, String paramString) {}
  
  public void run()
  {
    String str1 = this.a;
    Object localObject = str1;
    if (this.b.w != null)
    {
      localObject = this.b.w.getPosInfo();
      String str2 = AdProxyImpl.SDKBannerAdView.a(this.b, (MiniAdPosInfo)localObject);
      localObject = str1;
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append("&");
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    AdProxyImpl.a((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.4
 * JD-Core Version:    0.7.0.1
 */
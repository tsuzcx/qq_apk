package com.tencent.qqmini.proxyimpl;

import aanq;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBoxADLisener;

class AdProxyImpl$SDKBoxAdView$1$1
  implements aanq
{
  AdProxyImpl$SDKBoxAdView$1$1(AdProxyImpl.SDKBoxAdView.1 param1) {}
  
  public void onDismiss()
  {
    if (this.this$2.this$1.mBoxListener != null) {
      this.this$2.this$1.mBoxListener.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBoxAdView.1.1
 * JD-Core Version:    0.7.0.1
 */
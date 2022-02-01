package com.tencent.qqmini.proxyimpl;

import Wallet.FocusMpIdRsp;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import mqq.observer.BusinessObserver;

class ChannelProxyImpl$8
  implements BusinessObserver
{
  ChannelProxyImpl$8(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle != null) && (paramBundle.err_code == 0))
    {
      this.a.onReceiveResult(true, null);
      return;
    }
    this.a.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */
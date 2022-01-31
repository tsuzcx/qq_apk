package com.tencent.qqmini.proxyimpl;

import Wallet.FocusMpIdRsp;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import mqq.observer.BusinessObserver;

class ChannelProxyImpl$6
  implements BusinessObserver
{
  ChannelProxyImpl$6(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle == null) || (paramBundle.err_code != 0))
    {
      this.val$result.onReceiveResult(false, null);
      return;
    }
    this.val$result.onReceiveResult(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */
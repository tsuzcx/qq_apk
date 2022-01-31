package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import bgnk;
import bgnl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;

class ChannelProxyImpl$5
  implements bgnl
{
  ChannelProxyImpl$5(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 9)
    {
      bgnk.a().b(this);
      paramIntent = this.val$result;
      if (paramInt2 == 0) {
        bool = true;
      }
      paramIntent.onReceiveResult(bool, null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */
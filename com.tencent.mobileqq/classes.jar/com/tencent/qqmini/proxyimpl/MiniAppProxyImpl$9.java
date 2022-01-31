package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.core.proxy.AsyncResult;

class MiniAppProxyImpl$9
  implements ShortcutUtils.AddShortcutCallback
{
  MiniAppProxyImpl$9(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onAddResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.val$result.onReceiveResult(true, null);
      return;
    }
    this.val$result.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.9
 * JD-Core Version:    0.7.0.1
 */
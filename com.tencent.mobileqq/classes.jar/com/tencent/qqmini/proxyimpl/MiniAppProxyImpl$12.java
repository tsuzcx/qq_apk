package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;

class MiniAppProxyImpl$12
  implements ShortcutUtils.AddShortcutCallback
{
  MiniAppProxyImpl$12(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.a.onReceiveResult(true, null);
      return;
    }
    this.a.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.12
 * JD-Core Version:    0.7.0.1
 */
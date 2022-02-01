package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;

@ProxyService(proxy=IMiniAppNotifyProxy.class)
public class MiniAppNotifyProxyImpl
  implements IMiniAppNotifyProxy
{
  public void report(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    MiniAppNotify.g.notify(paramString1, paramInt, paramString2, paramString3, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppNotifyProxyImpl
 * JD-Core Version:    0.7.0.1
 */
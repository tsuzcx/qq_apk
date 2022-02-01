package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy;

@ProxyService(proxy=IMiniReportProxy.class)
public class MiniReportProxyImpl
  implements IMiniReportProxy
{
  private static String a;
  
  public static String a()
  {
    return a;
  }
  
  public void setMiniAppInfo(String paramString)
  {
    a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniReportProxyImpl
 * JD-Core Version:    0.7.0.1
 */
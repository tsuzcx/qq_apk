package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import java.util.List;

@ProxyService(proxy=WnsConfigProxy.class)
public class WnsConfigProxyDefault
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.WnsConfigProxyDefault
 * JD-Core Version:    0.7.0.1
 */
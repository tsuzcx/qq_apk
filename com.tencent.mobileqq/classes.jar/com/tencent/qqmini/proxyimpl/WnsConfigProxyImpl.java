package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.config.business.MiniAppApiReportBean;
import com.tencent.mobileqq.config.business.MiniAppApiReportProcessor;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;

@ProxyService(proxy=WnsConfigProxy.class)
public class WnsConfigProxyImpl
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    List localList = null;
    try
    {
      MiniAppApiReportBean localMiniAppApiReportBean = MiniAppApiReportProcessor.a();
      if (localMiniAppApiReportBean != null) {
        localList = localMiniAppApiReportBean.a();
      }
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WnsConfigProxyImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.proxyimpl;

import amsz;
import amta;
import com.tencent.qqmini.sdk.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;

public class WnsConfigProxyImpl
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    amsz localamsz = amta.a();
    if (localamsz != null) {
      return localamsz.a();
    }
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WnsConfigProxyImpl
 * JD-Core Version:    0.7.0.1
 */
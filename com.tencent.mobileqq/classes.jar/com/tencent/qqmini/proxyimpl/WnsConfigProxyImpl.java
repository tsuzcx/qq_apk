package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;

public class WnsConfigProxyImpl
  extends WnsConfigProxy
{
  public String getConfig(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WnsConfigProxyImpl
 * JD-Core Version:    0.7.0.1
 */
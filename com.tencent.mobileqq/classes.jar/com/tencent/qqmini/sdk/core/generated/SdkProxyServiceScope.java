package com.tencent.qqmini.sdk.core.generated;

import java.util.HashMap;
import java.util.Map;

public final class SdkProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.ChannelProxy", "com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault");
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.ShareProxy", "com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault");
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy", "com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault");
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.RequestProxy", "com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault");
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.MiniAppProxy", "com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault");
    PROXY_SERVICES.put("com.tencent.qqmini.sdk.core.proxy.DownloaderProxy", "com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import java.util.HashMap;
import java.util.Map;

public final class AppProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(VideoJsProxy.class, VideoJsProxyDefault.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */
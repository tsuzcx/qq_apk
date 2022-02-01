package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import java.util.HashMap;
import java.util.Map;

public final class MapProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(MapProxy.class, MapProxyImplDefault.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.MapProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */
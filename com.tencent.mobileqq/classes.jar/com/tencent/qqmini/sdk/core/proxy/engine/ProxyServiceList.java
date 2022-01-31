package com.tencent.qqmini.sdk.core.proxy.engine;

import bdgw;
import bdnw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProxyServiceList
{
  static final String AD_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AdProxyServiceScope";
  static final String APP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope";
  static final String MINI_APP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MiniAppProxyServiceScope";
  static final String MINI_GAME_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MiniGameProxyServiceScope";
  static final String PAY_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.PayProxyServiceScope";
  private static final String PROXY_SERVICES = "PROXY_SERVICES";
  static final String SDK_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope";
  private static final String TAG = "ProxyServiceList";
  
  public static Map<String, String> get()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.MiniAppProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.MiniGameProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.PayProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.AdProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope"));
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bdnw.a("ProxyServiceList", "ProxyService: " + localEntry);
    }
    return localHashMap;
  }
  
  private static Map<String, String> getProxyServices(String paramString)
  {
    paramString = bdgw.a(paramString, "PROXY_SERVICES");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceList
 * JD-Core Version:    0.7.0.1
 */
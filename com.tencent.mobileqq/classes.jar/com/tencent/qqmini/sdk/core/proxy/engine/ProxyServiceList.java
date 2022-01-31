package com.tencent.qqmini.sdk.core.proxy.engine;

import bglg;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProxyServiceList
{
  private static final String AD_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AdProxyServiceScope";
  private static final String APP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope";
  private static final String EXT_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope";
  private static final String GAME_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.GameProxyServiceScope";
  private static final String GENERATED_PACKAGE = "com.tencent.qqmini.sdk.core.generated.";
  private static final String MAP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MapProxyServiceScope";
  private static final String MINICODE_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MiniCodeProxyServiceScope";
  private static final String PAY_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.PayProxyServiceScope";
  private static final String PROXY_SERVICES = "PROXY_SERVICES";
  private static final String SDK_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope";
  private static final String TAG = "ProxyServiceList";
  
  public static Map<String, String> get()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.GameProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.PayProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.AdProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.MiniCodeProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.MapProxyServiceScope"));
    localHashMap.putAll(getProxyServices("com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope"));
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      QMLog.d("ProxyServiceList", "ProxyService: " + localEntry);
    }
    return localHashMap;
  }
  
  private static Map<String, String> getProxyServices(String paramString)
  {
    paramString = bglg.a(paramString, "PROXY_SERVICES");
    if ((paramString instanceof Map)) {
      return (Map)paramString;
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceList
 * JD-Core Version:    0.7.0.1
 */
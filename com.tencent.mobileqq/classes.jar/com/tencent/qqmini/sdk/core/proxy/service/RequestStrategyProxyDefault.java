package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy=RequestStrategyProxy.class)
public class RequestStrategyProxyDefault
  implements RequestStrategyProxy
{
  public String addHttpForwardingInfo(String paramString, Map<String, String> paramMap)
  {
    return paramString;
  }
  
  public void addHttpForwardingInfo(JSONObject paramJSONObject) {}
  
  public boolean isIPV6Only()
  {
    return false;
  }
  
  public void notifyNetWorkStatusChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.RequestStrategyProxyDefault
 * JD-Core Version:    0.7.0.1
 */
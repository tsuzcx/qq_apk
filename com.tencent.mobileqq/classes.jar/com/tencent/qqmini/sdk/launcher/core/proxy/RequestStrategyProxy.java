package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.Map;
import org.json.JSONObject;

public abstract interface RequestStrategyProxy
{
  public abstract String addHttpForwardingInfo(String paramString, Map<String, String> paramMap);
  
  public abstract void addHttpForwardingInfo(JSONObject paramJSONObject);
  
  public abstract boolean isIPV6Only();
  
  public abstract void notifyNetWorkStatusChange();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
 * JD-Core Version:    0.7.0.1
 */
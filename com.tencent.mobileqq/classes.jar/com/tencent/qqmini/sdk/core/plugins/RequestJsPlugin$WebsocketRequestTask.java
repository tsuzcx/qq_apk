package com.tencent.qqmini.sdk.core.plugins;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class RequestJsPlugin$WebsocketRequestTask
{
  public Map<String, String> mHeaders;
  public String mMethod;
  public int mTaskId = RequestJsPlugin.sWebSocketRequestId.getAndIncrement();
  public int mTimeout;
  public String mUrl;
  
  public RequestJsPlugin$WebsocketRequestTask(RequestJsPlugin paramRequestJsPlugin, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("method")) {
        this.mMethod = paramJSONObject.optString("method");
      }
      if (paramJSONObject.has("header"))
      {
        paramRequestJsPlugin = paramJSONObject.optJSONObject("header");
        Iterator localIterator = paramRequestJsPlugin.keys();
        if (this.mHeaders == null) {
          this.mHeaders = new HashMap();
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.mHeaders.put(str, paramRequestJsPlugin.optString(str));
        }
      }
      if (paramJSONObject.has("timeout")) {
        this.mTimeout = paramJSONObject.optInt("timeout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.WebsocketRequestTask
 * JD-Core Version:    0.7.0.1
 */
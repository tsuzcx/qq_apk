package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class RequestJsPlugin$WebsocketRequestTask
{
  public Map<String, String> mHeaders;
  public String mMethod;
  public String mOriginUrl;
  public int mTaskId = WebSocketProxy.getWebSocketRequestId();
  public int mTimeout;
  public String mUrl;
  
  public RequestJsPlugin$WebsocketRequestTask(RequestJsPlugin paramRequestJsPlugin, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.mUrl = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("origin_url")) {}
      for (this.mOriginUrl = paramJSONObject.optString("origin_url");; this.mOriginUrl = this.mUrl)
      {
        if (paramJSONObject.has("method")) {
          this.mMethod = paramJSONObject.optString("method");
        }
        if (!paramJSONObject.has("header")) {
          break;
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.WebsocketRequestTask
 * JD-Core Version:    0.7.0.1
 */
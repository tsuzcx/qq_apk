package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RequestJsPlugin$WebsocketRequestTask
{
  public Map<String, String> mHeaders = new HashMap();
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
      if (!paramJSONObject.has("origin_url")) {
        break label147;
      }
    }
    label147:
    for (this.mOriginUrl = paramJSONObject.optString("origin_url");; this.mOriginUrl = this.mUrl)
    {
      if (paramJSONObject.has("method")) {
        this.mMethod = paramJSONObject.optString("method");
      }
      RequestJsPlugin.access$1300(this.mHeaders, paramJSONObject);
      if (paramJSONObject.has("timeout")) {
        this.mTimeout = paramJSONObject.optInt("timeout");
      }
      this.mHeaders.put("Referer", RequestJsPlugin.access$1000(paramRequestJsPlugin));
      this.mHeaders.put("User-Agent", QUAUtil.getRequestUA());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.WebsocketRequestTask
 * JD-Core Version:    0.7.0.1
 */
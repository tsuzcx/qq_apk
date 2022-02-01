package com.tencent.mobileqq.mini.network.websocket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class WebsocketRequestTask$RequestParam
{
  public Map<String, String> mHeaders;
  public String mOriginUrl;
  public String mUrl;
  public String method;
  public int timeout = 60000;
  
  public WebsocketRequestTask$RequestParam(JSONObject paramJSONObject)
  {
    merge(paramJSONObject);
  }
  
  public void merge(JSONObject paramJSONObject)
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
          this.method = paramJSONObject.optString("method");
        }
        if (!paramJSONObject.has("header")) {
          break;
        }
        JSONObject localJSONObject = paramJSONObject.optJSONObject("header");
        Iterator localIterator = localJSONObject.keys();
        if (this.mHeaders == null) {
          this.mHeaders = new HashMap();
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.mHeaders.put(str, localJSONObject.optString(str));
        }
      }
      if (paramJSONObject.has("timeout")) {
        this.timeout = paramJSONObject.optInt("timeout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask.RequestParam
 * JD-Core Version:    0.7.0.1
 */
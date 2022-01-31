package com.tencent.mobileqq.mini.websocket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class WebsocketRequestTask$RequestParam
{
  public Map<String, String> mHeaders;
  public String method;
  public int timeout = 60000;
  public String url;
  
  public WebsocketRequestTask$RequestParam(JSONObject paramJSONObject)
  {
    merge(paramJSONObject);
  }
  
  public void merge(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.url = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("method")) {
        this.method = paramJSONObject.optString("method");
      }
      if (paramJSONObject.has("header"))
      {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.websocket.WebsocketRequestTask.RequestParam
 * JD-Core Version:    0.7.0.1
 */
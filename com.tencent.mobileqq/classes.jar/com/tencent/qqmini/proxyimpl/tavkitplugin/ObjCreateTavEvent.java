package com.tencent.qqmini.proxyimpl.tavkitplugin;

import org.json.JSONObject;

public class ObjCreateTavEvent
  extends BaseTavEvent
{
  ObjCreateTavEvent(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject.has("className"))
    {
      a(paramJSONObject.getString("className"));
      return;
    }
    throw new RuntimeException("send msg but no object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent
 * JD-Core Version:    0.7.0.1
 */
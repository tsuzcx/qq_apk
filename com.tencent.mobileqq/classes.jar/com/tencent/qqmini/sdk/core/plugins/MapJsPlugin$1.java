package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import beky;
import org.json.JSONObject;

class MapJsPlugin$1
  implements beky
{
  MapJsPlugin$1(MapJsPlugin paramMapJsPlugin, bekr parambekr) {}
  
  public void onLocationFinishCallback(JSONObject paramJSONObject)
  {
    this.val$req.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import bgoq;
import org.json.JSONObject;

class MapJsPlugin$1
  implements bgoq
{
  MapJsPlugin$1(MapJsPlugin paramMapJsPlugin, bgok parambgok) {}
  
  public void onLocationFinishCallback(JSONObject paramJSONObject)
  {
    this.val$req.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
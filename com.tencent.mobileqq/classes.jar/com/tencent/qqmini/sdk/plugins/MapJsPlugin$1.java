package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil.OnLocationFinish;
import org.json.JSONObject;

class MapJsPlugin$1
  implements ApiUtil.OnLocationFinish
{
  MapJsPlugin$1(MapJsPlugin paramMapJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onLocationFinishCallback(JSONObject paramJSONObject)
  {
    this.val$req.ok(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MapJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
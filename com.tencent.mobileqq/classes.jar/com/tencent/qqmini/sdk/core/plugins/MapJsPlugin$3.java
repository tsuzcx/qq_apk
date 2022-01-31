package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdgh;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class MapJsPlugin$3
  implements AsyncResult
{
  MapJsPlugin$3(MapJsPlugin paramMapJsPlugin, bdgh parambdgh, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$onLocationFinish.onLocationFinishCallback(paramJSONObject);
      return;
    }
    this.val$req.a(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
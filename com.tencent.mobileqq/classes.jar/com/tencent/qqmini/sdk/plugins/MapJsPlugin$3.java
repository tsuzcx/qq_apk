package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil.OnLocationFinish;
import org.json.JSONObject;

class MapJsPlugin$3
  implements AsyncResult
{
  MapJsPlugin$3(MapJsPlugin paramMapJsPlugin, ApiUtil.OnLocationFinish paramOnLocationFinish, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$onLocationFinish.onLocationFinishCallback(paramJSONObject);
      return;
    }
    this.val$req.fail(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MapJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
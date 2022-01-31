package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class MapJsPlugin$2
  implements AsyncResult
{
  MapJsPlugin$2(MapJsPlugin paramMapJsPlugin, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
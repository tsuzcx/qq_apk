package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$5
  implements Runnable
{
  MapViewJsPlugin$5(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject.optInt("mapId");
      MapContext localMapContext = MapViewJsPlugin.access$200(this.this$0, i);
      if (localMapContext != null)
      {
        localMapContext.addMapCircles(localJSONObject);
        this.val$req.ok();
        return;
      }
      this.val$req.fail();
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MapViewJsPlugin", this.val$req.event + " error.", localJSONException);
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$7
  implements Runnable
{
  MapViewJsPlugin$7(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject1.optInt("mapId", 0);
      JSONObject localJSONObject2 = new JSONObject();
      MapContext localMapContext = MapViewJsPlugin.access$200(this.this$0, i);
      if (localMapContext != null)
      {
        if ((localJSONObject1.has("longitude")) || (localJSONObject1.has("latitude"))) {
          localMapContext.moveToLocation(localJSONObject1);
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject2);
          return;
          localMapContext.moveToCurrentLocation();
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("MapViewJsPlugin", "", localJSONException);
      }
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */
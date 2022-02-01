package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$9
  implements Runnable
{
  MapViewJsPlugin$9(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.val$req.jsonParams);
      int i = 0;
      int j = localJSONObject1.optInt("mapId", 0);
      JSONObject localJSONObject2 = new JSONObject();
      MapContext localMapContext = MapViewJsPlugin.access$200(this.this$0, j);
      if (localMapContext != null)
      {
        localMapContext.includeMapPoints(localJSONObject1);
        i = 1;
      }
      if (i != 0)
      {
        this.val$req.ok(localJSONObject2);
        return;
      }
      this.val$req.fail();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */
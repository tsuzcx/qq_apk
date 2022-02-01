package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$2
  implements Runnable
{
  MapViewJsPlugin$2(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject.optInt("mapId");
      localObject = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject != null)
      {
        ((MapContext)localObject).updateMap(localJSONObject);
        this.val$req.ok();
        return;
      }
      this.val$req.fail();
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$req.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("MapViewJsPlugin", ((StringBuilder)localObject).toString(), localJSONException);
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$6
  implements Runnable
{
  MapViewJsPlugin$6(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$req.jsonParams).optInt("mapId", 0);
      Object localObject1 = null;
      Object localObject2 = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject2 != null) {
        localObject1 = ((MapContext)localObject2).getCenterLocation();
      }
      if (localObject1 != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("latitude", ((LatLng)localObject1).getLatitude());
        ((JSONObject)localObject2).put("longitude", ((LatLng)localObject1).getLongitude());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleNativeRequest eventName=");
        ((StringBuilder)localObject1).append(this.val$req.event);
        ((StringBuilder)localObject1).append("callbackJsEventOK:");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QMLog.w("MapViewJsPlugin", ((StringBuilder)localObject1).toString());
        this.val$req.ok((JSONObject)localObject2);
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
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */
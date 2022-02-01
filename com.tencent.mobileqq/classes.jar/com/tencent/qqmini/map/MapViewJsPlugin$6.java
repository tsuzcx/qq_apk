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
      LatLng localLatLng = null;
      Object localObject = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject != null) {
        localLatLng = ((MapContext)localObject).getCenterLocation();
      }
      if (localLatLng != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("latitude", localLatLng.getLatitude());
        ((JSONObject)localObject).put("longitude", localLatLng.getLongitude());
        QMLog.w("MapViewJsPlugin", "handleNativeRequest eventName=" + this.val$req.event + "callbackJsEventOK:" + ((JSONObject)localObject).toString());
        this.val$req.ok((JSONObject)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */
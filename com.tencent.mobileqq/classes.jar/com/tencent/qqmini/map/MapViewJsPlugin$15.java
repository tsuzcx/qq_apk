package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$15
  implements Runnable
{
  MapViewJsPlugin$15(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$req.jsonParams).optInt("mapId", 0);
      Object localObject = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject != null)
      {
        float f = ((MapContext)localObject).getRotate();
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("rotate", f);
          this.val$req.ok((JSONObject)localObject);
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          this.val$req.fail();
          return;
        }
      }
      this.val$req.fail();
    }
    catch (JSONException localJSONException2)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("MapViewJsPlugin", "", localJSONException2);
      }
      this.val$req.fail();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */
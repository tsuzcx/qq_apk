package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$1
  implements Runnable
{
  MapViewJsPlugin$1(MapViewJsPlugin paramMapViewJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject1.optInt("mapId");
      int j = localJSONObject1.optInt("parentId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      Object localObject = MapViewJsPlugin.access$000(this.this$0).appId;
      String str = localJSONObject1.optString("subKey");
      MapViewJsPlugin.access$100(this.this$0, i, j, str, (String)localObject);
      localObject = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject != null)
      {
        ((MapContext)localObject).updateMap(localJSONObject1);
        this.val$req.ok(localJSONObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
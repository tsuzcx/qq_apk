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
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      int i = localJSONObject.optInt("mapId");
      int j = localJSONObject.optInt("parentId");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("containerId", i);
      Object localObject2 = MapViewJsPlugin.access$000(this.this$0).appId;
      String str = localJSONObject.optString("subKey");
      MapViewJsPlugin.access$100(this.this$0, i, j, str, (String)localObject2);
      localObject2 = MapViewJsPlugin.access$200(this.this$0, i);
      if (localObject2 != null)
      {
        ((MapContext)localObject2).updateMap(localJSONObject);
        this.val$req.ok((JSONObject)localObject1);
        return;
      }
      this.val$req.fail();
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.val$req.event);
      ((StringBuilder)localObject1).append(" error.");
      QMLog.e("MapViewJsPlugin", ((StringBuilder)localObject1).toString(), localJSONException);
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.MapViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
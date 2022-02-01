package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$8
  implements AsyncResult
{
  DataJsPlugin$8(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramBoolean = DataJsPlugin.access$400(this.this$0);
      if (paramBoolean) {
        localJSONObject.put("data", paramJSONObject);
      } else {
        localJSONObject.put("data", paramJSONObject.toString());
      }
      this.val$req.ok(localJSONObject);
      return;
    }
    catch (Throwable paramJSONObject) {}
    this.val$req.fail();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */
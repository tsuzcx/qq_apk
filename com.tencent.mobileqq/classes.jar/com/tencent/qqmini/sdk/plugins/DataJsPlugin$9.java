package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$9
  implements AsyncResult
{
  DataJsPlugin$9(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (DataJsPlugin.access$400(this.this$0)) {
          localJSONObject.put("data", paramJSONObject);
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject);
          return;
          localJSONObject.put("data", paramJSONObject.toString());
        }
        this.val$req.fail();
      }
      catch (Throwable paramJSONObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */
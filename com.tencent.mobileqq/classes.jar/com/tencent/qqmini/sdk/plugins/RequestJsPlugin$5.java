package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$5
  implements AsyncResult
{
  RequestJsPlugin$5(RequestJsPlugin paramRequestJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$1100(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    RequestJsPlugin.access$1200(this.this$0, this.val$req, null, "do not support wnsGroupRequest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */
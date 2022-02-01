package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$3
  implements AsyncResult
{
  RequestJsPlugin$3(RequestJsPlugin paramRequestJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$1900(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    RequestJsPlugin.access$2000(this.this$0, this.val$req, null, "do not support wnsRequest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
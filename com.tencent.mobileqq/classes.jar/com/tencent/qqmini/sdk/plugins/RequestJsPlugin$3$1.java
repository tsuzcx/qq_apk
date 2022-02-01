package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$3$1
  implements AsyncResult
{
  RequestJsPlugin$3$1(RequestJsPlugin.3 param3) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$1100(this.this$1.this$0, this.this$1.val$req, paramJSONObject);
      return;
    }
    RequestJsPlugin.access$1200(this.this$1.this$0, this.this$1.val$req, null, "do not support wnsRequest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */
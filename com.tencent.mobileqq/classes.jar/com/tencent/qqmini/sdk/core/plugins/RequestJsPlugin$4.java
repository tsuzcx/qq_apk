package com.tencent.qqmini.sdk.core.plugins;

import beka;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$4
  implements AsyncResult
{
  RequestJsPlugin$4(RequestJsPlugin paramRequestJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$400(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    RequestJsPlugin.access$500(this.this$0, this.val$req, null, "do not support wnsCgiRequest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
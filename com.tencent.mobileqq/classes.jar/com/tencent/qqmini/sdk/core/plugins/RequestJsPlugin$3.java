package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class RequestJsPlugin$3
  implements AsyncResult
{
  RequestJsPlugin$3(RequestJsPlugin paramRequestJsPlugin, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      RequestJsPlugin.access$400(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    RequestJsPlugin.access$500(this.this$0, this.val$req, null, "do not support wnsRequest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
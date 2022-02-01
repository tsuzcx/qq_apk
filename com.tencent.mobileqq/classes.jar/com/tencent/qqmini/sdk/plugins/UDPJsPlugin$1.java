package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class UDPJsPlugin$1
  implements Runnable
{
  UDPJsPlugin$1(UDPJsPlugin paramUDPJsPlugin, RequestEvent paramRequestEvent, JSONObject paramJSONObject, UDPJsPlugin.UDPTask paramUDPTask) {}
  
  public void run()
  {
    try
    {
      UDPJsPlugin.access$000(this.this$0, this.val$req.jsService, this.val$json, this.val$task);
    }
    catch (Exception localException)
    {
      RequestEvent localRequestEvent = this.val$req;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("performSend exception,");
      localStringBuilder.append(localException.getMessage());
      localRequestEvent.fail(localStringBuilder.toString());
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UDPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
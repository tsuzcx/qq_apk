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
      this.val$req.ok();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.val$req.fail("performSend exception," + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UDPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
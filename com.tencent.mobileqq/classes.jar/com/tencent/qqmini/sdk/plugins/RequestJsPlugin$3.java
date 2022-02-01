package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class RequestJsPlugin$3
  implements Runnable
{
  RequestJsPlugin$3(RequestJsPlugin paramRequestJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      localObject2 = localJSONObject.optJSONObject("header");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      ((JSONObject)localObject1).put("Referer", RequestJsPlugin.access$1000(this.this$0));
      localObject1 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject1 != null)
      {
        ((ChannelProxy)localObject1).wnsCgiRequest(localJSONObject, new RequestJsPlugin.3.1(this));
        return;
      }
      RequestJsPlugin.access$1200(this.this$0, this.val$req, null, "do not support wnsRequest");
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.val$req.event);
      ((StringBuilder)localObject2).append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject2).toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
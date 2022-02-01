package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class PayJsPlugin$8
  implements PayJsPlugin.IStarQueryListener
{
  PayJsPlugin$8(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      PayJsPlugin.access$1600(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    paramJSONObject = paramJSONObject.optString("errMsg");
    PayJsPlugin.access$700(this.this$0, this.val$req, null, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */
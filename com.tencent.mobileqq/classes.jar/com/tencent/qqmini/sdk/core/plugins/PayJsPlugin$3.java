package com.tencent.qqmini.sdk.core.plugins;

import beka;
import org.json.JSONObject;

class PayJsPlugin$3
  implements PayJsPlugin.IStarQueryListener
{
  PayJsPlugin$3(PayJsPlugin paramPayJsPlugin, beka parambeka) {}
  
  public void onResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      PayJsPlugin.access$300(this.this$0, this.val$req, paramJSONObject);
      return;
    }
    paramJSONObject = paramJSONObject.optString("errMsg");
    PayJsPlugin.access$200(this.this$0, this.val$req, null, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
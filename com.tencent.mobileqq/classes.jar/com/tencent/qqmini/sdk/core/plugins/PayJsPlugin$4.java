package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import org.json.JSONObject;

class PayJsPlugin$4
  implements PayJsPlugin.IStarQueryListener
{
  PayJsPlugin$4(PayJsPlugin paramPayJsPlugin, bgok parambgok) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
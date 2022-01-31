package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import bekx;
import betc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class TelephonyJsPlugin$1
  implements AsyncResult
{
  TelephonyJsPlugin$1(TelephonyJsPlugin paramTelephonyJsPlugin, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.a("TelephonyJsPlugin", "onCmdListener result = " + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      this.val$req.a(bekx.a(this.val$req.a, paramJSONObject));
      return;
    }
    this.val$req.a(bekx.b(this.val$req.a, null).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
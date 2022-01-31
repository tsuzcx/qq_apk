package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import bgki;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class TelephonyJsPlugin$1
  implements AsyncResult
{
  TelephonyJsPlugin$1(TelephonyJsPlugin paramTelephonyJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("TelephonyJsPlugin", "onCmdListener result = " + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      this.val$req.a(bgki.a(this.val$req.a, paramJSONObject));
      return;
    }
    this.val$req.a(bgki.b(this.val$req.a, null).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
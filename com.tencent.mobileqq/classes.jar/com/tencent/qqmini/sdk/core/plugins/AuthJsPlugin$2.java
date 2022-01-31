package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AuthJsPlugin$2
  implements AsyncResult
{
  AuthJsPlugin$2(AuthJsPlugin paramAuthJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      bdnw.a("AuthJsPlugin", "call API_REFRESH_SESSION success.");
      this.val$req.a(paramJSONObject);
      return;
    }
    bdnw.a("AuthJsPlugin", "call API_REFRESH_SESSION success.");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
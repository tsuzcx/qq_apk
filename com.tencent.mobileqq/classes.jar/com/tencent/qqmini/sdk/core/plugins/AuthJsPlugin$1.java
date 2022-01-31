package com.tencent.qqmini.sdk.core.plugins;

import beka;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AuthJsPlugin$1
  implements AsyncResult
{
  AuthJsPlugin$1(AuthJsPlugin paramAuthJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      besl.a("AuthJsPlugin", "call API_LOGIN  code:" + paramJSONObject.toString());
      this.val$req.a(paramJSONObject);
      return;
    }
    besl.d("AuthJsPlugin", "call API_LOGIN failed ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
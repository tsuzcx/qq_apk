package com.tencent.qqmini.sdk.core.plugins.engine;

import beic;
import bekr;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class BaseJsPluginEngine$3
  implements AsyncResult
{
  BaseJsPluginEngine$3(BaseJsPluginEngine paramBaseJsPluginEngine, bekr parambekr) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str = "0";
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("purePhoneNumber");
      paramJSONObject.optString("countryCode");
    }
    if ((paramBoolean) && (!"0".equals(str)))
    {
      paramJSONObject = beic.a().a("scope.getPhoneNumber");
      if (paramJSONObject != null)
      {
        paramJSONObject.c = str;
        beic.a().a("scope.getPhoneNumber", paramJSONObject);
        BaseJsPluginEngine.access$400(this.this$0, this.val$req);
      }
      return;
    }
    if ("0".equals(str))
    {
      this.val$req.a(new JSONObject(), "用户未绑定手机");
      return;
    }
    this.val$req.a(new JSONObject(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.3
 * JD-Core Version:    0.7.0.1
 */
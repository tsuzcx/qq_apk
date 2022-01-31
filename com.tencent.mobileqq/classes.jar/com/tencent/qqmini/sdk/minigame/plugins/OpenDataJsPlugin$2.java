package com.tencent.qqmini.sdk.minigame.plugins;

import beka;
import bevi;
import bewt;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$2
  implements AsyncResult
{
  OpenDataJsPlugin$2(OpenDataJsPlugin paramOpenDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bewt.a().i("OpenDataJsPlugin", "getGroupCloudStorage callback appid:" + bevi.a().a() + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
          localJSONObject.put("data", paramJSONObject.get("data"));
        }
        for (;;)
        {
          this.val$req.a(localJSONObject);
          return;
          localJSONObject.put("data", paramJSONObject);
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        bewt.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
    }
    this.val$req.a(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
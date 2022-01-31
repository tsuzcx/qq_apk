package com.tencent.qqmini.sdk.minigame.plugins;

import bdfz;
import bdqa;
import bdrb;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$2
  implements AsyncResult
{
  OpenDataJsPlugin$2(OpenDataJsPlugin paramOpenDataJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdrb.a().i("OpenDataJsPlugin", "getGroupCloudStorage callback appid:" + bdqa.a().a() + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
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
        bdrb.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
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
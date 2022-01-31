package com.tencent.qqmini.sdk.minigame.plugins;

import beka;
import bevi;
import bewt;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$3
  implements AsyncResult
{
  OpenDataJsPlugin$3(OpenDataJsPlugin paramOpenDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bewt localbewt = bewt.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage callback appid:").append(bevi.a().a()).append(", isSuc:").append(paramBoolean).append(", ret:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localbewt.i("OpenDataJsPlugin", (String)localObject);
      localObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          ((JSONObject)localObject).put("state", "success");
          if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
            ((JSONObject)localObject).put("data", paramJSONObject.get("data"));
          }
          for (;;)
          {
            this.val$req.a((JSONObject)localObject);
            return;
            localObject = "";
            break;
            ((JSONObject)localObject).put("data", paramJSONObject);
          }
          ((JSONObject)localObject).put("state", "fail");
        }
        catch (Throwable paramJSONObject)
        {
          bewt.a().e("OpenDataJsPlugin", "getFriendCloudStorage error " + paramJSONObject.getMessage());
          this.val$req.b();
          return;
        }
      }
    }
    this.val$req.a((JSONObject)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
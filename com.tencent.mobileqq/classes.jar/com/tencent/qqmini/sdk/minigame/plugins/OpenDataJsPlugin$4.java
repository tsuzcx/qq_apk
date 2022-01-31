package com.tencent.qqmini.sdk.minigame.plugins;

import bdfz;
import bdqa;
import bdrb;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$4
  implements AsyncResult
{
  OpenDataJsPlugin$4(OpenDataJsPlugin paramOpenDataJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdrb localbdrb = bdrb.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage callback appid:").append(bdqa.a().a()).append(", isSuc").append(paramBoolean).append(", ret:");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      localbdrb.i("OpenDataJsPlugin", paramJSONObject);
      paramJSONObject = new JSONObject();
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramJSONObject.put("state", "success");
        this.val$req.a(paramJSONObject);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        bdrb.a().e("OpenDataJsPlugin", "setUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.b();
      }
    }
    paramJSONObject.put("state", "fail");
    this.val$req.a(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
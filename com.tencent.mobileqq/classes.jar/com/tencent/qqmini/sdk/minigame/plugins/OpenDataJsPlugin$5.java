package com.tencent.qqmini.sdk.minigame.plugins;

import bdfz;
import bdqa;
import bdrb;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$5
  implements AsyncResult
{
  OpenDataJsPlugin$5(OpenDataJsPlugin paramOpenDataJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdrb.a().i("OpenDataJsPlugin", "removeUserCloudStorage callback appid:" + bdqa.a().a() + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    paramJSONObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put("state", "success");
      this.val$req.a(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      bdrb.a().e("OpenDataJsPlugin", "removeUserCloudStorage error " + paramJSONObject.getMessage());
      this.val$req.b();
    }
    paramJSONObject.put("state", "fail");
    this.val$req.a(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import bgwc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$5
  implements AsyncResult
{
  OpenDataJsPlugin$5(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bgwc.a().i("OpenDataJsPlugin", "removeUserCloudStorage callback appid:" + OpenDataJsPlugin.access$400(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
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
      bgwc.a().e("OpenDataJsPlugin", "removeUserCloudStorage error " + paramJSONObject.getMessage());
      this.val$req.b();
    }
    paramJSONObject.put("state", "fail");
    this.val$req.a(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */
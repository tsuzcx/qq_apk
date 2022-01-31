package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import bgwc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$4
  implements AsyncResult
{
  OpenDataJsPlugin$4(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage callback appid:").append(OpenDataJsPlugin.access$300(this.this$0).appId).append(", isSuc").append(paramBoolean).append(", ret:");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      localbgwc.i("OpenDataJsPlugin", paramJSONObject);
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
        bgwc.a().e("OpenDataJsPlugin", "setUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.b();
      }
    }
    paramJSONObject.put("state", "fail");
    this.val$req.a(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
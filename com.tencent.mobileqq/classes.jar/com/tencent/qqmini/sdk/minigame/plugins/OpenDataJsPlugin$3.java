package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import bgwc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$3
  implements AsyncResult
{
  OpenDataJsPlugin$3(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage callback appid:").append(OpenDataJsPlugin.access$200(this.this$0).appId).append(", isSuc:").append(paramBoolean).append(", ret:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localbgwc.i("OpenDataJsPlugin", (String)localObject);
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
          bgwc.a().e("OpenDataJsPlugin", "getFriendCloudStorage error " + paramJSONObject.getMessage());
          this.val$req.b();
          return;
        }
      }
    }
    this.val$req.a((JSONObject)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
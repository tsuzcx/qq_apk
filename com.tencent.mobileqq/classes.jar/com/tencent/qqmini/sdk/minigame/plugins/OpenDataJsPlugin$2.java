package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import bgwc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$2
  implements AsyncResult
{
  OpenDataJsPlugin$2(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bgwc.a().i("OpenDataJsPlugin", "getGroupCloudStorage callback appid:" + OpenDataJsPlugin.access$100(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
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
        bgwc.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
    }
    this.val$req.a(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
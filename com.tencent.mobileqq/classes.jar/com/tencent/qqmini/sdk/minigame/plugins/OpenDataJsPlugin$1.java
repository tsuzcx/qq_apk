package com.tencent.qqmini.sdk.minigame.plugins;

import bgok;
import bhaj;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataJsPlugin$1
  implements AsyncResult
{
  OpenDataJsPlugin$1(OpenDataJsPlugin paramOpenDataJsPlugin, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bhaj.a().i("OpenDataJsPlugin", "getUserCloudStorage callback appid:" + OpenDataJsPlugin.access$000(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.has("KVDataList"))) {
          localJSONObject.put("KVDataList", paramJSONObject.get("KVDataList"));
        }
        for (;;)
        {
          this.val$req.a(localJSONObject);
          return;
          localJSONObject.put("KVDataList", "[]");
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        bhaj.a().e("OpenDataJsPlugin", "getUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
    }
    this.val$req.a(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadTask$1
  implements AsyncResult
{
  MiniAppInfoLoadTask$1(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
      paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      MiniAppInfoLoadTask localMiniAppInfoLoadTask = this.this$0;
      MiniAppInfoLoadTask.access$100(localMiniAppInfoLoadTask, localJSONObject, paramJSONObject, this.val$envVersion, this.val$cacheProxy, MiniAppInfoLoadTask.access$000(localMiniAppInfoLoadTask).appId, this.val$finalEntryPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadTask$2
  implements AsyncResult
{
  MiniAppInfoLoadTask$2(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
      paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      MiniAppInfoLoadTask.access$200(this.this$0, localJSONObject, paramJSONObject, this.val$envVersion, this.val$cacheProxy, MiniAppInfoLoadTask.access$100(this.this$0).appId, this.val$finalEntryPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.2
 * JD-Core Version:    0.7.0.1
 */
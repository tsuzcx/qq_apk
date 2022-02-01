package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadTask$3
  implements AsyncResult
{
  MiniAppInfoLoadTask$3(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, MiniAppCacheProxy paramMiniAppCacheProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
      byte[] arrayOfByte = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      MiniAppInfoLoadTask localMiniAppInfoLoadTask = this.this$0;
      MiniAppInfoLoadTask.access$300(localMiniAppInfoLoadTask, localJSONObject, arrayOfByte, paramJSONObject, this.val$cacheProxy, MiniAppInfoLoadTask.access$000(localMiniAppInfoLoadTask).link, MiniAppInfoLoadTask.access$000(this.this$0).linkType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.3
 * JD-Core Version:    0.7.0.1
 */
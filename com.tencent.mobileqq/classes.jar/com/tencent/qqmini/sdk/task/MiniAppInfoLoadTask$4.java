package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadTask$4
  implements AsyncResult
{
  MiniAppInfoLoadTask$4(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, MiniAppCacheProxy paramMiniAppCacheProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
      byte[] arrayOfByte = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      MiniAppInfoLoadTask.access$400(this.this$0, localJSONObject, arrayOfByte, paramJSONObject, this.val$cacheProxy, MiniAppInfoLoadTask.access$100(this.this$0).link, MiniAppInfoLoadTask.access$100(this.this$0).linkType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.4
 * JD-Core Version:    0.7.0.1
 */
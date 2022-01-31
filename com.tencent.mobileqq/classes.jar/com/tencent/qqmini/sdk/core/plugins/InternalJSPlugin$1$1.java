package com.tencent.qqmini.sdk.core.plugins;

import beka;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class InternalJSPlugin$1$1
  implements AsyncResult
{
  InternalJSPlugin$1$1(InternalJSPlugin.1 param1) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      InternalJSPlugin.access$000(this.this$1.this$0.mContext, this.this$1.this$0.mMiniAppInfo.appId, "", paramJSONObject.optString("data"));
      this.this$1.val$req.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */
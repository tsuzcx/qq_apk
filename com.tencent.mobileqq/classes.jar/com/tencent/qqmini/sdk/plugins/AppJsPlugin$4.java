package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

class AppJsPlugin$4
  implements AsyncResult
{
  AppJsPlugin$4(AppJsPlugin paramAppJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = ApiUtil.wrapCallbackOk(this.val$req.event, null);
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, paramJSONObject.toString());
      return;
    }
    paramJSONObject = ApiUtil.wrapCallbackFail(this.val$req.event, null);
    this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
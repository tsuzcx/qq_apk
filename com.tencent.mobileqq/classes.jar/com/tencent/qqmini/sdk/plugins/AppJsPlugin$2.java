package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppJsPlugin$2
  implements AsyncResult
{
  AppJsPlugin$2(AppJsPlugin paramAppJsPlugin, RequestEvent paramRequestEvent, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("AppJsPlugin", "queryApkDownloadInfo succ=" + paramBoolean + " result=" + paramJSONObject);
    if ((!paramBoolean) || (paramJSONObject == null))
    {
      paramJSONObject = ApiUtil.wrapCallbackFail(this.val$req.event, null);
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, paramJSONObject.toString());
      return;
    }
    AppJsPlugin.access$100(this.this$0).startDownload(this.val$appid, paramJSONObject, this.val$autoInstall, new AppJsPlugin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
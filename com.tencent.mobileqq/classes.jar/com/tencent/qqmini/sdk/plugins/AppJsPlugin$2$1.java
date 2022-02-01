package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppJsPlugin$2$1
  implements ThirdAppProxy.AppDownloadListener
{
  AppJsPlugin$2$1(AppJsPlugin.2 param2) {}
  
  public void onDownloadComplete()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appid", this.this$1.val$appid);
      localJSONObject1.put("packagename", this.this$1.val$packagename);
      localJSONObject1.put("version", this.this$1.val$version);
      localJSONObject1.put("md5", this.this$1.val$md5);
      localJSONObject1.put("state", "onDownloadAppSucceed");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onAppDownloadStateChange", localJSONObject1.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadComplete exception, appid: ");
      localStringBuilder.append(this.this$1.val$appid);
      QMLog.e("AppJsPlugin", localStringBuilder.toString(), localException);
      JSONObject localJSONObject2 = ApiUtil.wrapCallbackFail(this.this$1.val$req.event, null);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, localJSONObject2.toString());
    }
  }
  
  public void onDownloadFailed(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", this.this$1.val$appid);
      ((JSONObject)localObject).put("packagename", this.this$1.val$packagename);
      ((JSONObject)localObject).put("version", this.this$1.val$version);
      ((JSONObject)localObject).put("md5", this.this$1.val$md5);
      ((JSONObject)localObject).put("retCode", paramInt1);
      ((JSONObject)localObject).put("errMsg", paramString);
      ((JSONObject)localObject).put("state", "onDownloadAppFailed");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onAppDownloadStateChange", ((JSONObject)localObject).toString(), 0);
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed exception, appid: ");
      ((StringBuilder)localObject).append(this.this$1.val$appid);
      QMLog.e("AppJsPlugin", ((StringBuilder)localObject).toString(), paramString);
      paramString = ApiUtil.wrapCallbackFail(this.this$1.val$req.event, null);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, paramString.toString());
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appid", this.this$1.val$appid);
      localJSONObject1.put("packagename", this.this$1.val$packagename);
      localJSONObject1.put("version", this.this$1.val$version);
      localJSONObject1.put("md5", this.this$1.val$md5);
      localJSONObject1.put("downloadSize", paramLong1);
      localJSONObject1.put("totalSize", paramLong2);
      localJSONObject1.put("progress", paramInt);
      localJSONObject1.put("state", "onDownloadAppProgress");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onAppDownloadStateChange", localJSONObject1.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadProgress exception, appid: ");
      localStringBuilder.append(this.this$1.val$appid);
      QMLog.e("AppJsPlugin", localStringBuilder.toString(), localException);
      JSONObject localJSONObject2 = ApiUtil.wrapCallbackFail(this.this$1.val$req.event, null);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, localJSONObject2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
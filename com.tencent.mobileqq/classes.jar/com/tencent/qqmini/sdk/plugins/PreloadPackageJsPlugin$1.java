package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class PreloadPackageJsPlugin$1
  implements AsyncResult
{
  PreloadPackageJsPlugin$1(PreloadPackageJsPlugin paramPreloadPackageJsPlugin, RequestEvent paramRequestEvent, String paramString) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      PreloadPackageJsPlugin.a(this.c, this.a, PreloadPackageJsPlugin.PreloadResult.GET_APP_INFO_NULL_RESULT);
      return;
    }
    long l = paramJSONObject.optLong("retCode");
    String str = paramJSONObject.optString("errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppInfoById request appId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("; response, retCode:");
    localStringBuilder.append(l);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(str);
    localStringBuilder.append(" , is success:");
    localStringBuilder.append(paramBoolean);
    QMLog.d("PreloadPackageJsPlugin", localStringBuilder.toString());
    if (!paramBoolean)
    {
      PreloadPackageJsPlugin.a(this.c, this.a, PreloadPackageJsPlugin.PreloadResult.GET_APP_INFO_FAIL);
      return;
    }
    paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
    if (paramJSONObject == null)
    {
      QMLog.w("PreloadPackageJsPlugin", "no mini app info obj found");
      PreloadPackageJsPlugin.a(this.c, this.a, PreloadPackageJsPlugin.PreloadResult.GET_APP_INFO_NO_DATA);
      return;
    }
    PreloadPackageJsPlugin.a(this.c, paramJSONObject, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PreloadPackageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
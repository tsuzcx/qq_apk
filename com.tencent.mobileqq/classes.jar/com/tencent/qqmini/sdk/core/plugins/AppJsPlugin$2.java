package com.tencent.qqmini.sdk.core.plugins;

import bglu;
import bgok;
import bgop;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class AppJsPlugin$2
  implements AsyncResult
{
  AppJsPlugin$2(AppJsPlugin paramAppJsPlugin, bgok parambgok, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("AppJsPlugin", "queryApkDownloadInfo succ=" + paramBoolean + " result=" + paramJSONObject);
    if ((!paramBoolean) || (paramJSONObject == null))
    {
      paramJSONObject = bgop.b(this.val$req.jdField_a_of_type_JavaLangString, null);
      this.val$req.jdField_a_of_type_Bglu.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    AppJsPlugin.access$000(this.this$0).startDownload(this.val$appid, paramJSONObject, this.val$autoInstall, new AppJsPlugin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
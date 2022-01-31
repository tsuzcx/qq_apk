package com.tencent.qqmini.sdk.core.plugins;

import begy;
import beka;
import bekg;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy;
import org.json.JSONObject;

class AppJsPlugin$1
  implements AsyncResult
{
  AppJsPlugin$1(AppJsPlugin paramAppJsPlugin, beka parambeka, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.b("AppJsPlugin", "queryApkDownloadInfo succ=" + paramBoolean + " result=" + paramJSONObject);
    if ((!paramBoolean) || (paramJSONObject == null))
    {
      paramJSONObject = bekg.b(this.val$req.jdField_a_of_type_JavaLangString, null);
      this.val$req.jdField_a_of_type_Begy.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    AppJsPlugin.access$000(this.this$0).startDownload(this.val$appid, paramJSONObject, this.val$autoInstall, new AppJsPlugin.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
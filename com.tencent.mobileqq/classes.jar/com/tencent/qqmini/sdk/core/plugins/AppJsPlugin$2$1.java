package com.tencent.qqmini.sdk.core.plugins;

import bglu;
import bgok;
import bgop;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy.AppDownloadListener;
import com.tencent.qqmini.sdk.log.QMLog;
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
      this.this$1.val$req.jdField_a_of_type_Bglu.a("onAppDownloadStateChange", localJSONObject1.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AppJsPlugin", "onDownloadComplete exception, appid: " + this.this$1.val$appid, localException);
      JSONObject localJSONObject2 = bgop.b(this.this$1.val$req.jdField_a_of_type_JavaLangString, null);
      this.this$1.val$req.jdField_a_of_type_Bglu.a(this.this$1.val$req.b, localJSONObject2.toString());
    }
  }
  
  public void onDownloadFailed(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.this$1.val$appid);
      localJSONObject.put("packagename", this.this$1.val$packagename);
      localJSONObject.put("version", this.this$1.val$version);
      localJSONObject.put("md5", this.this$1.val$md5);
      localJSONObject.put("retCode", paramInt1);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("state", "onDownloadAppFailed");
      this.this$1.val$req.jdField_a_of_type_Bglu.a("onAppDownloadStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.e("AppJsPlugin", "onDownloadFailed exception, appid: " + this.this$1.val$appid, paramString);
      paramString = bgop.b(this.this$1.val$req.jdField_a_of_type_JavaLangString, null);
      this.this$1.val$req.jdField_a_of_type_Bglu.a(this.this$1.val$req.b, paramString.toString());
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
      this.this$1.val$req.jdField_a_of_type_Bglu.a("onAppDownloadStateChange", localJSONObject1.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AppJsPlugin", "onDownloadProgress exception, appid: " + this.this$1.val$appid, localException);
      JSONObject localJSONObject2 = bgop.b(this.this$1.val$req.jdField_a_of_type_JavaLangString, null);
      this.this$1.val$req.jdField_a_of_type_Bglu.a(this.this$1.val$req.b, localJSONObject2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
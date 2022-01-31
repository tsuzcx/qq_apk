package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppBrandRuntime$5$1$1
  implements ApkgManager.OnInitApkgListener
{
  AppBrandRuntime$5$1$1(AppBrandRuntime.5.1 param1) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    QLog.i("AppBrandRuntime", 1, "initApkgByConfig end. result=" + paramInt + "; msg : " + paramString);
    if ((paramInt == 0) && (paramApkgInfo != null))
    {
      MiniAppFileManager.getInstance().initFileManager(paramApkgInfo, false);
      QLog.i("AppBrandRuntime", 1, "initApkgByConfig appid=" + paramApkgInfo.appId + " appName=" + paramApkgInfo.apkgName);
      try
      {
        paramString = new JSONObject();
        paramString.put("state", "updateready");
        this.this$2.this$1.this$0.evaluateServiceSubcribeJS("onUpdateStatusChange", paramString.toString());
        AppBrandRuntime.access$002(this.this$2.this$1.this$0, paramApkgInfo.appConfig);
        AppBrandRuntime.access$000(this.this$2.this$1.this$0).launchParam.tempState = 0;
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.e("AppBrandRuntime", 1, "updateJSONObject error." + paramString);
        }
      }
    }
    try
    {
      paramApkgInfo = new JSONObject();
      paramApkgInfo.put("state", "updatefailed");
      this.this$2.this$1.this$0.evaluateServiceSubcribeJS("onUpdateStatusChange", paramApkgInfo.toString());
      return;
    }
    catch (Throwable paramApkgInfo)
    {
      QLog.e("AppBrandRuntime", 1, "updateJSONObject error." + paramApkgInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.5.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import org.json.JSONObject;

class EventListener$3
  implements ApkgManager.OnInitApkgListener
{
  EventListener$3(EventListener paramEventListener, MiniAppInfo paramMiniAppInfo) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    QMLog.i("EventListener", "getApkgInfoByConfig end. result=" + paramInt + "; msg : " + paramString);
    if ((paramInt == 0) && (paramApkgInfo != null))
    {
      ((MiniAppFileManager)this.this$0.mRuntime.getManager(MiniAppFileManager.class)).initFileManager(paramApkgInfo, false);
      QMLog.i("EventListener", "initApkgByConfig appid=" + paramApkgInfo.appId + " appName=" + paramApkgInfo.apkgName);
      try
      {
        paramApkgInfo = new JSONObject();
        paramApkgInfo.put("state", "updateready");
        this.this$0.mRuntime.appBrandService.evaluateSubscribeJS("onUpdateStatusChange", paramApkgInfo.toString(), 0);
        EventListener.access$202(this.this$0, this.val$miniAppInfo);
        EventListener.access$200(this.this$0).forceReroad = 2;
        EventListener.access$200(this.this$0).launchParam.tempState = 0;
        return;
      }
      catch (Throwable paramApkgInfo)
      {
        for (;;)
        {
          QMLog.e("EventListener", "updateJSONObject error." + paramApkgInfo);
        }
      }
    }
    try
    {
      paramApkgInfo = new JSONObject();
      paramApkgInfo.put("state", "updatefailed");
      this.this$0.mRuntime.appBrandService.evaluateSubscribeJS("onUpdateStatusChange", paramApkgInfo.toString(), 0);
      return;
    }
    catch (Throwable paramApkgInfo)
    {
      QMLog.e("EventListener", "updateJSONObject error." + paramApkgInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.3
 * JD-Core Version:    0.7.0.1
 */
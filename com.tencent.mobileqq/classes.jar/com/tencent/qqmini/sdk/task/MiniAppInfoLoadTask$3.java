package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import org.json.JSONObject;

class MiniAppInfoLoadTask$3
  implements AsyncResult
{
  MiniAppInfoLoadTask$3(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      QMLog.i("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      localObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (localObject != null)
      {
        MiniAppInfoLoadTask.access$300(this.this$0, (MiniAppInfo)localObject);
        MiniReportManager.reportEventType((MiniAppInfo)localObject, 1028, "main_loading", MiniReportManager.getAppType((MiniAppInfo)localObject));
        this.this$0.onTaskSucceed();
      }
      for (;;)
      {
        localObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
        paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
        MiniAppInfoLoadTask.access$200(this.this$0, (JSONObject)localObject, paramJSONObject, this.val$envVersion, this.val$cacheProxy, MiniAppInfoLoadTask.access$100(this.this$0).appId, this.val$finalEntryPath);
        return;
        SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
        this.this$0.onTaskFailed();
      }
    }
    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
    this.this$0.onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.3
 * JD-Core Version:    0.7.0.1
 */
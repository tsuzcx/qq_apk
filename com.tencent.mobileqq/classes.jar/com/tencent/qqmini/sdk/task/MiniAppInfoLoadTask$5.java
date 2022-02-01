package com.tencent.qqmini.sdk.task;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import org.json.JSONObject;

class MiniAppInfoLoadTask$5
  implements AsyncResult
{
  MiniAppInfoLoadTask$5(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, MiniAppCacheProxy paramMiniAppCacheProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      for (;;)
      {
        try
        {
          long l = paramJSONObject.optLong("retCode");
          String str = paramJSONObject.optString("errMsg");
          QMLog.d("MiniAppInfoLoadTask", "getAppInfoByLink, retCode = " + l + ",errMsg = " + str);
          if (l != 0L)
          {
            if ((TextUtils.isEmpty(str)) && (DebugUtil.isDebugVersion())) {
              new StringBuilder().append("请求失败").append(", retCode = ").append(l).toString();
            }
            this.this$0.onTaskFailed();
          }
          Object localObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
          str = paramJSONObject.optString("shareTicket", "");
          if ((l == 0L) && (localObject != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).appId)))
          {
            MiniAppInfoLoadTask.access$500(this.this$0, (MiniAppInfo)localObject, str);
            MiniReportManager.reportEventType((MiniAppInfo)localObject, 1028, "main_loading", MiniReportManager.getAppType((MiniAppInfo)localObject));
            this.this$0.onTaskSucceed();
            localObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
            paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
            MiniAppInfoLoadTask.access$400(this.this$0, (JSONObject)localObject, paramJSONObject, str, this.val$cacheProxy, MiniAppInfoLoadTask.access$100(this.this$0).link, MiniAppInfoLoadTask.access$100(this.this$0).linkType);
            return;
          }
          SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
          MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
          if (localObject == null)
          {
            QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
            this.this$0.onTaskFailed();
          }
          else
          {
            QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + ((MiniAppInfo)localObject).appId);
          }
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("MiniAppInfoLoadTask", "", paramJSONObject);
          this.this$0.onTaskFailed();
          return;
        }
      }
    }
    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
    this.this$0.onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.5
 * JD-Core Version:    0.7.0.1
 */
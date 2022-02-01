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
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject1 = paramJSONObject.optString("errMsg");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppInfoByLink, retCode = ");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(",errMsg = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.d("MiniAppInfoLoadTask", ((StringBuilder)localObject2).toString());
      if (l != 0L)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (DebugUtil.isDebugVersion()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("请求失败");
          ((StringBuilder)localObject1).append(", retCode = ");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).toString();
        }
        this.this$0.onTaskFailed();
      }
      localObject2 = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      localObject1 = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localObject2 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject2).appId)))
      {
        MiniAppInfoLoadTask.access$500(this.this$0, (MiniAppInfo)localObject2, (String)localObject1);
        MiniReportManager.reportEventType((MiniAppInfo)localObject2, 1028, "main_loading", MiniReportManager.getAppType((MiniAppInfo)localObject2));
        this.this$0.onTaskSucceed();
      }
      else
      {
        SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
        if (localObject2 == null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getAppInfoByLink  onCmdListener appinfo==null retCode= ");
          ((StringBuilder)localObject2).append(l);
          QMLog.e("MiniAppInfoLoadTask", ((StringBuilder)localObject2).toString());
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAppInfoByLink  onCmdListener retCode= ");
          localStringBuilder.append(l);
          localStringBuilder.append(" appid=");
          localStringBuilder.append(((MiniAppInfo)localObject2).appId);
          QMLog.e("MiniAppInfoLoadTask", localStringBuilder.toString());
        }
        this.this$0.onTaskFailed();
      }
      localObject2 = paramJSONObject.optJSONObject("mini_app_info_data_json");
      paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      MiniAppInfoLoadTask.access$400(this.this$0, (JSONObject)localObject2, paramJSONObject, (String)localObject1, this.val$cacheProxy, MiniAppInfoLoadTask.access$100(this.this$0).link, MiniAppInfoLoadTask.access$100(this.this$0).linkType);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QMLog.e("MiniAppInfoLoadTask", "", paramJSONObject);
      this.this$0.onTaskFailed();
    }
    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
    this.this$0.onTaskFailed();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.5
 * JD-Core Version:    0.7.0.1
 */
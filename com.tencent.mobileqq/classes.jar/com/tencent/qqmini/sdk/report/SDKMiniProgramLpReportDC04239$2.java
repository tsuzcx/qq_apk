package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$2
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$2(String paramString1, String paramString2, String paramString3, String paramString4, MiniAppInfo paramMiniAppInfo, String paramString5) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserClick() called with: actionType = [");
      localStringBuilder.append(this.val$actionType);
      localStringBuilder.append("],subActionType = [");
      localStringBuilder.append(this.val$subActionType);
      localStringBuilder.append("], reserves = [");
      localStringBuilder.append(this.val$reserves);
      localStringBuilder.append("], appType = [");
      localStringBuilder.append(this.val$appType);
      localStringBuilder.append("]");
      QMLog.d("MiniProgramLpReportDC04239", localStringBuilder.toString());
    }
    SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, this.val$appType, this.val$path, this.val$actionType, this.val$subActionType, this.val$reserves);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.2
 * JD-Core Version:    0.7.0.1
 */
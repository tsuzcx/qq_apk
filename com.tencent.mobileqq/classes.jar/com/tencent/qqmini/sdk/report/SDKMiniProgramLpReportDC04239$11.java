package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.EnvUtils;

final class SDKMiniProgramLpReportDC04239$11
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$11(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.val$miniAppConfig);
    localBundle.putString("actiontype", this.val$actionType);
    localBundle.putString("sub_action", this.val$subActionType);
    localBundle.putString("path", this.val$path);
    localBundle.putString("reserves", this.val$reserves);
    localBundle.putString("reserves2", this.val$reserves2);
    localBundle.putString("app_type", this.val$appType);
    localBundle.putBoolean("x5_enable", EnvUtils.isX5Enabled(this.val$miniAppConfig));
    AppBrandCmdProxy.g().sendCmd("launch_report", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.11
 * JD-Core Version:    0.7.0.1
 */
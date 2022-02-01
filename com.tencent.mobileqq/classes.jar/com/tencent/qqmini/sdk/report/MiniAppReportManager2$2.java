package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class MiniAppReportManager2$2
  implements Runnable
{
  MiniAppReportManager2$2(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.val$miniAppConfig);
    localBundle.putString("action_type", "page_view");
    localBundle.putString("sub_action", this.val$subActionType);
    localBundle.putString("path", this.val$path);
    localBundle.putString("reserves", this.val$reserves);
    AppBrandCmdProxy.g().sendCmd("launch_report2", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2.2
 * JD-Core Version:    0.7.0.1
 */
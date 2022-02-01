package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;

class ApkgManager$1
  implements ApkgManager.OnGetApkgInfoListener
{
  ApkgManager$1(ApkgManager paramApkgManager, ApkgManager.OnInitApkgListener paramOnInitApkgListener, long paramLong, MiniAppInfo paramMiniAppInfo) {}
  
  public void onGetApkgInfo(ApkgInfo paramApkgInfo, int paramInt, String paramString)
  {
    if ((paramInt == 0) && (paramApkgInfo != null)) {
      ApkgManager.access$000(this.this$0, this.val$listener, 0, paramApkgInfo, "Apkg init succ :" + (System.currentTimeMillis() - this.val$startTime));
    }
    for (;;)
    {
      MiniReportManager.reportEventType(this.val$miniConfig, 13, null, null, null, 0);
      return;
      ApkgManager.access$000(this.this$0, this.val$listener, paramInt, null, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.1
 * JD-Core Version:    0.7.0.1
 */
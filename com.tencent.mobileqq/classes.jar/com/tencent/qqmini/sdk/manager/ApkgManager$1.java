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
    if ((paramInt == 0) && (paramApkgInfo != null))
    {
      paramString = this.this$0;
      ApkgManager.OnInitApkgListener localOnInitApkgListener = this.val$listener;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Apkg init succ :");
      localStringBuilder.append(System.currentTimeMillis() - this.val$startTime);
      ApkgManager.access$000(paramString, localOnInitApkgListener, 0, paramApkgInfo, localStringBuilder.toString());
    }
    else
    {
      ApkgManager.access$000(this.this$0, this.val$listener, paramInt, null, paramString);
    }
    MiniReportManager.reportEventType(this.val$miniConfig, 13, null, null, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.1
 * JD-Core Version:    0.7.0.1
 */
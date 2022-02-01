package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class ShareManager$2
  implements Runnable
{
  ShareManager$2(ShareManager paramShareManager, Activity paramActivity, IMiniAppContext paramIMiniAppContext, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    ReportProgressDialog localReportProgressDialog = new ReportProgressDialog(this.val$activity);
    localReportProgressDialog.setMessage("分享中，请稍候");
    localReportProgressDialog.show();
    ShareManager.access$200(this.this$0, this.val$miniAppContext, this.val$shareData.sharePicPath, new ShareManager.2.1(this, localReportProgressDialog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.2
 * JD-Core Version:    0.7.0.1
 */
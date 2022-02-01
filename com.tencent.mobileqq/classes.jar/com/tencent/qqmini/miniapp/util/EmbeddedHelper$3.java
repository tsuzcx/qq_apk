package com.tencent.qqmini.miniapp.util;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.TbsListener;

final class EmbeddedHelper$3
  implements TbsListener
{
  EmbeddedHelper$3(Activity paramActivity) {}
  
  public void onDownloadFinish(int paramInt)
  {
    QMLog.e("EmbeddedHelper", "onDownloadFinish " + paramInt);
    if ((paramInt == 177) || (paramInt == 110)) {
      EmbeddedHelper.access$200(this.val$activity);
    }
    EmbeddedHelper.access$300(781, "downloadFinish" + paramInt);
  }
  
  public void onDownloadProgress(int paramInt)
  {
    QMLog.e("EmbeddedHelper", "onDownloadProgress : " + paramInt);
  }
  
  public void onInstallFinish(int paramInt)
  {
    QMLog.e("EmbeddedHelper", "onInstallFinish : " + paramInt);
    if ((paramInt == 220) || (paramInt == 232)) {
      EmbeddedHelper.access$200(this.val$activity);
    }
    EmbeddedHelper.access$300(781, "installFinish" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.3
 * JD-Core Version:    0.7.0.1
 */
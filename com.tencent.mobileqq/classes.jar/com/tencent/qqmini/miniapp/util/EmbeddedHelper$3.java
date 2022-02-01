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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish ");
    localStringBuilder.append(paramInt);
    QMLog.e("EmbeddedHelper", localStringBuilder.toString());
    if ((paramInt == 177) || (paramInt == 110)) {
      EmbeddedHelper.access$200(this.val$activity);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadFinish");
    localStringBuilder.append(paramInt);
    EmbeddedHelper.access$300(781, localStringBuilder.toString());
  }
  
  public void onDownloadProgress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProgress : ");
    localStringBuilder.append(paramInt);
    QMLog.e("EmbeddedHelper", localStringBuilder.toString());
  }
  
  public void onInstallFinish(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallFinish : ");
    localStringBuilder.append(paramInt);
    QMLog.e("EmbeddedHelper", localStringBuilder.toString());
    if ((paramInt == 220) || (paramInt == 232)) {
      EmbeddedHelper.access$200(this.val$activity);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("installFinish");
    localStringBuilder.append(paramInt);
    EmbeddedHelper.access$300(781, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

class Achilles$AchilesRockDownloadListener
  extends RockDownloadListener
{
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download cancel: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
    if (paramRockDownloadInfo != null) {
      Achilles.a(false, paramRockDownloadInfo.getPackageName(), -1, "");
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download fail: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
    if (paramRockDownloadInfo != null)
    {
      if (paramInt == 10010)
      {
        ThreadManager.getFileThreadHandler().postDelayed(Achilles.a(), 10000L);
        return;
      }
      Achilles.a(false, paramRockDownloadInfo.getPackageName(), paramInt, paramString);
    }
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadInfo: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download process: ");
    localStringBuilder.append(paramRockDownloadInfo);
    localStringBuilder.append(" process: ");
    localStringBuilder.append(paramInt);
    QLog.d("Achilles", 2, localStringBuilder.toString());
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download start: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
    Achilles.a().put(paramRockDownloadInfo.getPackageName(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download success: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
    if (paramRockDownloadInfo != null) {
      Achilles.a(true, paramRockDownloadInfo.getPackageName(), 0, "");
    }
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download wait: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download permission denied: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download permission permitted: ");
    localStringBuilder.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.Achilles.AchilesRockDownloadListener
 * JD-Core Version:    0.7.0.1
 */
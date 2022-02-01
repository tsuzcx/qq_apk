package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class QbSdk$5
  implements TbsListener
{
  public void onDownloadFinish(int paramInt)
  {
    if (TbsDownloader.needDownloadDecoupleCore())
    {
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
      TbsDownloader.a = true;
      return;
    }
    TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
    TbsDownloader.a = false;
    if (QbSdk.b() != null) {
      QbSdk.b().onDownloadFinish(paramInt);
    }
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadFinish(paramInt);
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadProgress(paramInt);
    }
    if (QbSdk.b() != null) {
      QbSdk.b().onDownloadProgress(paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt != 200) {}
    boolean bool = false;
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.a = false;
    if (TbsDownloader.startDecoupleCoreIfNeeded()) {
      bool = true;
    }
    TbsDownloader.a = bool;
    if (QbSdk.b() != null) {
      QbSdk.b().onInstallFinish(paramInt);
    }
    if (QbSdk.c() != null) {
      QbSdk.c().onInstallFinish(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class QbSdk$6
  implements TbsListener
{
  public void onDownloadFinish(int paramInt)
  {
    if (TbsDownloader.needDownloadDecoupleCore())
    {
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
      TbsDownloader.mIsDownloading = true;
    }
    do
    {
      return;
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
      TbsDownloader.mIsDownloading = false;
      if ((paramInt != 100) || (QbSdk.access$100() != null)) {
        QbSdk.access$100().onDownloadFinish(paramInt);
      }
    } while (QbSdk.access$200() == null);
    QbSdk.access$200().onDownloadFinish(paramInt);
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QbSdk.access$200() != null) {
      QbSdk.access$200().onDownloadProgress(paramInt);
    }
    if (QbSdk.access$100() != null) {
      QbSdk.access$100().onDownloadProgress(paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    if ((paramInt != 200) && (paramInt == 220)) {}
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.mIsDownloading = false;
    if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
    for (TbsDownloader.mIsDownloading = true;; TbsDownloader.mIsDownloading = false)
    {
      if (QbSdk.access$100() != null) {
        QbSdk.access$100().onInstallFinish(paramInt);
      }
      if (QbSdk.access$200() != null) {
        QbSdk.access$200().onInstallFinish(paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.6
 * JD-Core Version:    0.7.0.1
 */
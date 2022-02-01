package com.tencent.mobileqq.qrscan.ipc;

final class QRScanResDownloadManager$2
  implements Runnable
{
  QRScanResDownloadManager$2(QRScanResDownloadManager.DownloadCallback paramDownloadCallback, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    QRScanResDownloadManager.DownloadCallback localDownloadCallback = this.a;
    if (localDownloadCallback != null) {
      localDownloadCallback.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */
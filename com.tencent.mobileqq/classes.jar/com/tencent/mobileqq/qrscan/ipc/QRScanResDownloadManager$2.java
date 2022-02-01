package com.tencent.mobileqq.qrscan.ipc;

final class QRScanResDownloadManager$2
  implements Runnable
{
  QRScanResDownloadManager$2(QRScanResDownloadManager.DownloadCallback paramDownloadCallback, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    QRScanResDownloadManager.DownloadCallback localDownloadCallback = this.jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResDownloadManager$DownloadCallback;
    if (localDownloadCallback != null) {
      localDownloadCallback.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */
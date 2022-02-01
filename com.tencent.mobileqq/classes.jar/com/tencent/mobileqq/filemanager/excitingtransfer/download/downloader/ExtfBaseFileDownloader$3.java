package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;

class ExtfBaseFileDownloader$3
  implements Runnable
{
  ExtfBaseFileDownloader$3(ExtfBaseFileDownloader paramExtfBaseFileDownloader, int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    ExtfBaseFileDownloader localExtfBaseFileDownloader = this.this$0;
    localExtfBaseFileDownloader.a = true;
    localExtfBaseFileDownloader.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */
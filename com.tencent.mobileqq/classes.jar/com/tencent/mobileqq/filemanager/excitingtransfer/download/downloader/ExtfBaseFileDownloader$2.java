package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;

class ExtfBaseFileDownloader$2
  implements Runnable
{
  ExtfBaseFileDownloader$2(ExtfBaseFileDownloader paramExtfBaseFileDownloader, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    ExtfBaseFileDownloader localExtfBaseFileDownloader = this.this$0;
    localExtfBaseFileDownloader.a = true;
    localExtfBaseFileDownloader.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;

public abstract interface IExtfDownloaderSink
{
  public abstract void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo);
  
  public abstract void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.IExtfDownloaderSink
 * JD-Core Version:    0.7.0.1
 */
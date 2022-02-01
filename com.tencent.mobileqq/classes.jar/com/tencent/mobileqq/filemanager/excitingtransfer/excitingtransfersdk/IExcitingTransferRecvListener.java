package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public abstract interface IExcitingTransferRecvListener
{
  public abstract void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete);
  
  public abstract void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo);
  
  public abstract void onRecvProgress(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onRecvStart();
  
  public abstract void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
 * JD-Core Version:    0.7.0.1
 */
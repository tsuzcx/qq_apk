package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public abstract interface IExcitingTransferEngineCallback
{
  public abstract void onOneSlotComplete(long paramLong, int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete);
  
  public abstract void onRecvComplete(long paramLong, int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo);
  
  public abstract void onRecvProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  public abstract void onRecvStart(long paramLong);
  
  public abstract void onSendComplete(long paramLong, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp);
  
  public abstract void onSendProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
  
  public abstract void onSendStart(long paramLong);
  
  public abstract void onSpeed(long paramLong, ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo);
  
  public abstract void onSubSenderResult(long paramLong, int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferEngineCallback
 * JD-Core Version:    0.7.0.1
 */
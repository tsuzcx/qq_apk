package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public abstract interface IExcitingTransferSendListener
{
  public abstract ExcitingTransferHostInfo getNextBigDataHost();
  
  public abstract void onExcitingSendProgress(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onExcitingSendResult(boolean paramBoolean, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp);
  
  public abstract void onExcitingSendStart();
  
  public abstract void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp);
  
  public abstract void setFailBigDataHost(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener
 * JD-Core Version:    0.7.0.1
 */
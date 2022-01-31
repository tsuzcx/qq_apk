package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferEngine$ExcitingSendJobContent
{
  ExcitingTransferEngine.ExcitingSendInfo mExcSendInfo;
  long mExcitingID;
  IExcitingTransferSendListener mListener;
  
  public ExcitingTransferEngine$ExcitingSendJobContent(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, ExcitingTransferEngine.ExcitingSendInfo paramExcitingSendInfo, IExcitingTransferSendListener paramIExcitingTransferSendListener)
  {
    this.mExcitingID = paramLong;
    this.mExcSendInfo = paramExcitingSendInfo;
    this.mListener = paramIExcitingTransferSendListener;
  }
  
  public ExcitingTransferHostInfo getNextBigDataHost()
  {
    if (this.mListener != null) {
      return this.mListener.getNextBigDataHost();
    }
    return new ExcitingTransferHostInfo("", 0);
  }
  
  public void setFailBigDataHost(String paramString, int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.setFailBigDataHost(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendJobContent
 * JD-Core Version:    0.7.0.1
 */
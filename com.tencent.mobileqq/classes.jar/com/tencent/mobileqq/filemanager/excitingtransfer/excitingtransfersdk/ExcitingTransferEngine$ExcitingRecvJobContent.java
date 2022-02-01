package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferEngine$ExcitingRecvJobContent
{
  ExcitingTransferDownloadReqInfo mExcRecvReqInfo;
  long mExcitingID;
  IExcitingTransferRecvListener mListener;
  
  public ExcitingTransferEngine$ExcitingRecvJobContent(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo, IExcitingTransferRecvListener paramIExcitingTransferRecvListener)
  {
    this.mExcitingID = paramLong;
    this.mExcRecvReqInfo = paramExcitingTransferDownloadReqInfo;
    this.mListener = paramIExcitingTransferRecvListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingRecvJobContent
 * JD-Core Version:    0.7.0.1
 */
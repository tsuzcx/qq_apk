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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendJobContent
 * JD-Core Version:    0.7.0.1
 */
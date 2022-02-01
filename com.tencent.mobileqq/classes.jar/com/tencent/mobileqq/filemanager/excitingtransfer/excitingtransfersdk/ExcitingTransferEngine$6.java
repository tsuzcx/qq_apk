package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$6
  implements Runnable
{
  ExcitingTransferEngine$6(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = ExcitingTransferEngine.access$200(this.this$0, this.a);
    if (localExcitingRecvJobContent == null) {
      return;
    }
    if (localExcitingRecvJobContent.mListener != null) {
      localExcitingRecvJobContent.mListener.onRecvComplete(this.b, this.c);
    }
    ExcitingTransferEngine.access$300(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.6
 * JD-Core Version:    0.7.0.1
 */
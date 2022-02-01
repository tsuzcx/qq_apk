package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$5
  implements Runnable
{
  ExcitingTransferEngine$5(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = ExcitingTransferEngine.access$200(this.this$0, this.a);
    if (localExcitingRecvJobContent == null) {
      return;
    }
    if (localExcitingRecvJobContent.mListener != null) {
      localExcitingRecvJobContent.mListener.onRecvStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.5
 * JD-Core Version:    0.7.0.1
 */
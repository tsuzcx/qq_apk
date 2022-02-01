package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$1
  implements Runnable
{
  ExcitingTransferEngine$1(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = ExcitingTransferEngine.access$000(this.this$0, this.a);
    if (localExcitingSendJobContent == null) {
      return;
    }
    if (localExcitingSendJobContent.mListener != null) {
      localExcitingSendJobContent.mListener.onExcitingSendStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.1
 * JD-Core Version:    0.7.0.1
 */
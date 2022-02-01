package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$3
  implements Runnable
{
  ExcitingTransferEngine$3(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = ExcitingTransferEngine.access$000(this.this$0, this.a);
    if (localExcitingSendJobContent == null) {}
    while (localExcitingSendJobContent.mListener == null) {
      return;
    }
    localExcitingSendJobContent.mListener.onExcitingSendProgress(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.3
 * JD-Core Version:    0.7.0.1
 */
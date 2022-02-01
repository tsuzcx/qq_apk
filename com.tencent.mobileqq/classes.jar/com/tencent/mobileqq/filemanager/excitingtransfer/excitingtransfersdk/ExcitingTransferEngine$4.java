package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$4
  implements Runnable
{
  ExcitingTransferEngine$4(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = ExcitingTransferEngine.access$000(this.this$0, this.a);
    if (localExcitingSendJobContent == null) {
      return;
    }
    if (localExcitingSendJobContent.mListener != null) {
      localExcitingSendJobContent.mListener.onExcitingSubSenderResult(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.4
 * JD-Core Version:    0.7.0.1
 */
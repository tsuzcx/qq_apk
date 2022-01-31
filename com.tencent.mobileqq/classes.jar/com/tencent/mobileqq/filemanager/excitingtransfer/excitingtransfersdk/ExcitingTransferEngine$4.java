package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$4
  implements Runnable
{
  ExcitingTransferEngine$4(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = ExcitingTransferEngine.access$000(this.this$0, this.jdField_a_of_type_Long);
    if (localExcitingSendJobContent == null) {}
    while (localExcitingSendJobContent.mListener == null) {
      return;
    }
    localExcitingSendJobContent.mListener.onExcitingSubSenderResult(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.4
 * JD-Core Version:    0.7.0.1
 */
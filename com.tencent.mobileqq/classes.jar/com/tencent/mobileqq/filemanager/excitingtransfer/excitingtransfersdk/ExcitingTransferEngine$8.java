package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$8
  implements Runnable
{
  ExcitingTransferEngine$8(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = ExcitingTransferEngine.access$200(this.this$0, this.jdField_a_of_type_Long);
    if (localExcitingRecvJobContent == null) {
      return;
    }
    if (localExcitingRecvJobContent.mListener != null) {
      localExcitingRecvJobContent.mListener.onOneSlotComplete(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.8
 * JD-Core Version:    0.7.0.1
 */
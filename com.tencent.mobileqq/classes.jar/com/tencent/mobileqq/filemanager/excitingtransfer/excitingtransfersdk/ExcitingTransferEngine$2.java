package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$2
  implements Runnable
{
  ExcitingTransferEngine$2(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void run()
  {
    Object localObject = ExcitingTransferEngine.access$000(this.this$0, this.jdField_a_of_type_Long);
    if (localObject == null) {
      return;
    }
    if (((ExcitingTransferEngine.ExcitingSendJobContent)localObject).mListener != null)
    {
      localObject = ((ExcitingTransferEngine.ExcitingSendJobContent)localObject).mListener;
      if (this.jdField_a_of_type_Int != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ((IExcitingTransferSendListener)localObject).onExcitingSendResult(bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp);
      ExcitingTransferEngine.access$100(this.this$0, this.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;

class UFTUploadCbWrapper$3
  implements Runnable
{
  UFTUploadCbWrapper$3(UFTUploadCbWrapper paramUFTUploadCbWrapper, IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCompleteInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.3
 * JD-Core Version:    0.7.0.1
 */
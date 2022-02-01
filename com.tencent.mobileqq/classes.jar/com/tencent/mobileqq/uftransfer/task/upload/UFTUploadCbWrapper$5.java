package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;

class UFTUploadCbWrapper$5
  implements Runnable
{
  UFTUploadCbWrapper$5(UFTUploadCbWrapper paramUFTUploadCbWrapper, IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo) {}
  
  public void run()
  {
    if (UFTUploadCbWrapper.a(this.this$0)) {
      return;
    }
    if (this.this$0.a != null) {
      this.this$0.a.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTFileLocalInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;

class UFTUploadCbWrapper$2
  implements Runnable
{
  UFTUploadCbWrapper$2(UFTUploadCbWrapper paramUFTUploadCbWrapper, IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (UFTUploadCbWrapper.a(this.this$0)) {
      return;
    }
    if (this.this$0.a != null) {
      this.this$0.a.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey, this.jdField_a_of_type_Long, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.2
 * JD-Core Version:    0.7.0.1
 */
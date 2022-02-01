package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class UFTUploadCbWrapper$7
  implements Runnable
{
  UFTUploadCbWrapper$7(UFTUploadCbWrapper paramUFTUploadCbWrapper, IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback) {}
  
  public void run()
  {
    int i;
    if (this.this$0.a != null) {
      i = this.this$0.a.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadSendMsgCallback);
    } else {
      i = -1;
    }
    if (i != 0)
    {
      IUFTUploadSendMsgCallback localIUFTUploadSendMsgCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadSendMsgCallback;
      if (localIUFTUploadSendMsgCallback != null) {
        localIUFTUploadSendMsgCallback.a(false, i, new Bundle());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.7
 * JD-Core Version:    0.7.0.1
 */
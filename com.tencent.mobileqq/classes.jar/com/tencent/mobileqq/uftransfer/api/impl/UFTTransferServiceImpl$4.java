package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController;

class UFTTransferServiceImpl$4
  implements Runnable
{
  UFTTransferServiceImpl$4(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferKey paramUFTTransferKey, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo.b())
    {
      UFTTransferServiceImpl.access$400(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback);
      return;
    }
    UFTTransferServiceImpl.access$100(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */
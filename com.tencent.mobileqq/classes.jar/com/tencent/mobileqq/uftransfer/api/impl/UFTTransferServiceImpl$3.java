package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController;

class UFTTransferServiceImpl$3
  implements Runnable
{
  UFTTransferServiceImpl$3(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferKey paramUFTTransferKey, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.b())
    {
      UFTTransferServiceImpl.access$500(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback);
      return;
    }
    UFTTransferServiceImpl.access$200(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig, this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */
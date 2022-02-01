package com.tencent.mobileqq.uftransfer.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTC2CUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController;

class UFTTransferServiceImpl$5
  implements Runnable
{
  UFTTransferServiceImpl$5(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTTransferKey paramUFTTransferKey, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop fail. trans type error:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a());
          UFTLog.d("[UFTTransfer] UFTTransferService", 1, localStringBuilder.toString());
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a())
        {
          UFTTransferServiceImpl.access$400(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        UFTTransferServiceImpl.access$100(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a())
      {
        UFTTransferServiceImpl.access$500(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      UFTTransferServiceImpl.access$200(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a())
    {
      UFTTransferServiceImpl.access$300(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    UFTTransferServiceImpl.access$000(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */
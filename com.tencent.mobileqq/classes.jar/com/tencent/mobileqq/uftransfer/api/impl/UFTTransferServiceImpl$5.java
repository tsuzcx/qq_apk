package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController;

class UFTTransferServiceImpl$5
  implements Runnable
{
  UFTTransferServiceImpl$5(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferKey paramUFTTransferKey, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback) {}
  
  public void run()
  {
    if (this.a.f())
    {
      UFTTransferServiceImpl.access$400(this.this$0).a(this.b, this.a, this.c, this.d);
      return;
    }
    UFTTransferServiceImpl.access$100(this.this$0).a(this.b, this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTC2CUploadController;

class UFTTransferServiceImpl$2
  implements Runnable
{
  UFTTransferServiceImpl$2(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferKey paramUFTTransferKey, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback) {}
  
  public void run()
  {
    if (this.a.f())
    {
      UFTTransferServiceImpl.access$300(this.this$0).a(this.b, this.a, this.c, this.d);
      return;
    }
    UFTTransferServiceImpl.access$000(this.this$0).a(this.b, this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */
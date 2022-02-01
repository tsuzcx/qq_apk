package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController;

class UFTTransferServiceImpl$4
  implements Runnable
{
  UFTTransferServiceImpl$4(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferKey paramUFTTransferKey, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback) {}
  
  public void run()
  {
    if (this.a.f())
    {
      UFTTransferServiceImpl.access$500(this.this$0).a(this.b, this.a, this.c, this.d);
      return;
    }
    UFTTransferServiceImpl.access$200(this.this$0).a(this.b, this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */
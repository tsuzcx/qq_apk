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
    if (this.this$0.e) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.a != null) {
      this.this$0.a.a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.3
 * JD-Core Version:    0.7.0.1
 */
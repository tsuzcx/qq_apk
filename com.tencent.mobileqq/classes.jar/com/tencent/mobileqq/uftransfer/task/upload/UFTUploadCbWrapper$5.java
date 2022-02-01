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
      this.this$0.a.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTC2CUploadTask$2
  extends UFTBaseOp.UFTOpCallback
{
  UFTC2CUploadTask$2(UFTC2CUploadTask paramUFTC2CUploadTask) {}
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTC2CUploadTask.b(this.a)) {
      this.a.c(paramOpRetData.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.2
 * JD-Core Version:    0.7.0.1
 */
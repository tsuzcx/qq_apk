package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTC2CBigFileUploadTask$2
  extends UFTBaseOp.UFTOpCallback
{
  UFTC2CBigFileUploadTask$2(UFTC2CBigFileUploadTask paramUFTC2CBigFileUploadTask) {}
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (UFTC2CBigFileUploadTask.b(this.a)) {
      return;
    }
    this.a.a(paramOpRetData.a(), paramOpRetData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CBigFileUploadTask.2
 * JD-Core Version:    0.7.0.1
 */
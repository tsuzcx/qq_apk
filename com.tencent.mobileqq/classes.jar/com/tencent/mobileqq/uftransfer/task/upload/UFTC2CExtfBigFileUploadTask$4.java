package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTC2CExtfBigFileUploadTask$4
  extends UFTBaseOp.UFTOpCallback
{
  UFTC2CExtfBigFileUploadTask$4(UFTC2CExtfBigFileUploadTask paramUFTC2CExtfBigFileUploadTask) {}
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (UFTC2CExtfBigFileUploadTask.d(this.a)) {
      return;
    }
    UFTC2CExtfBigFileUploadTask localUFTC2CExtfBigFileUploadTask = this.a;
    boolean bool;
    if (paramOpRetData.a() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localUFTC2CExtfBigFileUploadTask.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfBigFileUploadTask.4
 * JD-Core Version:    0.7.0.1
 */
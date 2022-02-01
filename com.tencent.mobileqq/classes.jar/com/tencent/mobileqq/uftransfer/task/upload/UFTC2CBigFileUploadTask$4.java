package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTC2CBigFileUploadTask$4
  extends UFTBaseOp.UFTOpCallback
{
  UFTC2CBigFileUploadTask$4(UFTC2CBigFileUploadTask paramUFTC2CBigFileUploadTask) {}
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (UFTC2CBigFileUploadTask.d(this.a)) {
      return;
    }
    UFTC2CBigFileUploadTask localUFTC2CBigFileUploadTask = this.a;
    boolean bool;
    if (paramOpRetData.a() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localUFTC2CBigFileUploadTask.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CBigFileUploadTask.4
 * JD-Core Version:    0.7.0.1
 */
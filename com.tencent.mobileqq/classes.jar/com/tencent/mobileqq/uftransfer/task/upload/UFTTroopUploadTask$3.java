package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTTroopUploadTask$3
  extends UFTBaseOp.UFTOpCallback
{
  UFTTroopUploadTask$3(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTTroopUploadTask.e(this.a)) {
      this.a.a(paramOpRetData.a(), paramOpRetData.b(), paramOpRetData.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.3
 * JD-Core Version:    0.7.0.1
 */
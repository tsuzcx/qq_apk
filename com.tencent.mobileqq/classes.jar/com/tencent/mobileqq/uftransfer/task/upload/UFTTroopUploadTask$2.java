package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;

class UFTTroopUploadTask$2
  extends UFTBaseOp.UFTOpCallback
{
  UFTTroopUploadTask$2(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.k.a(UFTTroopUploadTask.d(this.a), paramLong1, paramLong2);
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTTroopUploadTask.c(this.a)) {
      this.a.a(paramOpRetData.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;

class UFTC2CUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTC2CUploadTask$4(UFTC2CUploadTask paramUFTC2CUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTC2CUploadTask.f(this.a)) && (paramInt != 0))
    {
      paramString1 = new UFTUploadTaskCompParam(4, paramString1, paramString2, false, paramObject);
      paramString1.m = this.a.n.b();
      paramString1.n = this.a.n.d();
      this.a.c(paramLong, paramInt, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTC2CUploadTask.g(this.a))
    {
      this.a.j.i(paramLong1);
      this.a.k.a(UFTC2CUploadTask.h(this.a), UFTC2CUploadTask.i(this.a).p(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTC2CUploadTask.e(this.a)) {
      this.a.a((UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData);
    }
  }
  
  public void a(String paramString)
  {
    this.a.j.a(paramString);
    this.a.j.b(this.a.j.n() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.4
 * JD-Core Version:    0.7.0.1
 */
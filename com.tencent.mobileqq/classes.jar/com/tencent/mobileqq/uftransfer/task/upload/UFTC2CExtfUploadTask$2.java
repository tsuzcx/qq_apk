package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;

class UFTC2CExtfUploadTask$2
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTC2CExtfUploadTask$2(UFTC2CExtfUploadTask paramUFTC2CExtfUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if (!UFTC2CExtfUploadTask.c(this.a)) {
      this.a.a(paramLong, paramInt, new UFTUploadTaskCompParam(4, paramString1, paramString2, true, paramObject));
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTC2CExtfUploadTask.d(this.a))
    {
      this.a.j.i(paramLong1);
      this.a.k.a(UFTC2CExtfUploadTask.e(this.a), UFTC2CExtfUploadTask.f(this.a).p(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTC2CExtfUploadTask.b(this.a)) {
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfUploadTask.2
 * JD-Core Version:    0.7.0.1
 */
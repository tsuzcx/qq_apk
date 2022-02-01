package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp.UFTUploadFileOpCallback;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp.UploadFileOpRetData;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadTaskCompParam;

class UFTGuildExtfUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTGuildExtfUploadTask$4(UFTGuildExtfUploadTask paramUFTGuildExtfUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTGuildExtfUploadTask.g(this.a)) && (paramInt != 0))
    {
      paramString1 = new UFTUploadTaskCompParam(4, paramString1, paramString2, false, paramObject);
      paramString1.m = this.a.e.b();
      paramString1.n = this.a.e.d();
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTGuildExtfUploadTask.h(this.a))
    {
      UFTGuildExtfUploadTask.i(this.a).i(paramLong1);
      UFTGuildExtfUploadTask.l(this.a).a(UFTGuildExtfUploadTask.j(this.a), UFTGuildExtfUploadTask.k(this.a).p(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTGuildExtfUploadTask.f(this.a)) {
      this.a.a((UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData);
    }
  }
  
  public void a(String paramString)
  {
    UFTGuildExtfUploadTask.m(this.a).a(paramString);
    UFTGuildExtfUploadTask.o(this.a).b(UFTGuildExtfUploadTask.n(this.a).n() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildExtfUploadTask.4
 * JD-Core Version:    0.7.0.1
 */
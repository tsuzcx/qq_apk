package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;

class UFTTroopUploadTask$4
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTTroopUploadTask$4(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void a()
  {
    if (!UFTTroopUploadTask.k(this.a)) {
      return;
    }
    UFTBaseUploadFileOp.UploadFileOpRetData localUploadFileOpRetData = new UFTBaseUploadFileOp.UploadFileOpRetData();
    localUploadFileOpRetData.a(-29120);
    localUploadFileOpRetData.a("upload out date");
    this.a.b(localUploadFileOpRetData);
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTTroopUploadTask.g(this.a)) && (paramInt != 0))
    {
      int j = UFTTransferUtility.c(paramString1);
      int i = j;
      if (j == 0) {
        i = UFTTransferUtility.d(paramString2);
      }
      int k = UFTTransferUtility.e(paramString1);
      int m = UFTTroopReportData.a(paramInt, k);
      if (paramInt == 9050) {
        j = 4;
      } else {
        j = 3;
      }
      paramString1 = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(4, paramString1, paramString2, false, paramObject);
      paramString1.a(j, m, 3, paramInt);
      paramString1.a(k);
      paramString1.b(i);
      paramString1.m = this.a.l.b();
      paramString1.n = this.a.l.d();
      this.a.b(paramLong, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTTroopUploadTask.h(this.a))
    {
      this.a.j.i(paramLong1);
      this.a.k.a(UFTTroopUploadTask.i(this.a), UFTTroopUploadTask.j(this.a).p(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTTroopUploadTask.f(this.a)) {
      this.a.b((UFTBaseUploadFileOp.UploadFileOpRetData)paramOpRetData);
    }
  }
  
  public void a(String paramString)
  {
    this.a.j.a(paramString);
    this.a.j.b(this.a.j.n() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.4
 * JD-Core Version:    0.7.0.1
 */
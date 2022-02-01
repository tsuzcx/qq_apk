package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.task.utils.UFTTaskUtils;

class UFTTroopExtfUploadTask$1
  extends UFTBaseUploadFileOp.UFTUploadFileOpCallback
{
  UFTTroopExtfUploadTask$1(UFTTroopExtfUploadTask paramUFTTroopExtfUploadTask) {}
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2, Object paramObject)
  {
    if ((!UFTTroopExtfUploadTask.b(this.a)) && (paramInt != 0))
    {
      paramString1 = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(4, paramString1, paramString2, true, paramObject);
      if (paramInt != 0) {
        paramString1.a(UFTTaskUtils.b(paramInt), UFTTaskUtils.c(paramInt), 3, UFTTaskUtils.e(paramInt));
      } else {
        paramString1.a(0, 0, 0, 0);
      }
      paramString1.g = paramInt;
      this.a.a(paramLong, paramString1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!UFTTroopExtfUploadTask.c(this.a))
    {
      this.a.j.i(paramLong1);
      this.a.k.a(UFTTroopExtfUploadTask.d(this.a), UFTTroopExtfUploadTask.e(this.a).p(), paramLong1, paramLong3);
    }
  }
  
  public void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (!UFTTroopExtfUploadTask.a(this.a)) {
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
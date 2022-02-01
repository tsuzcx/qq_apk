package com.tencent.mobileqq.profile.upload.task;

import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;

class VipBaseUploadTask$1
  implements IUploadTaskCallback
{
  VipBaseUploadTask$1(VipBaseUploadTask paramVipBaseUploadTask) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    paramAbstractUploadTask = this.a;
    paramAbstractUploadTask.z = 1002;
    paramAbstractUploadTask.f = paramInt;
    paramAbstractUploadTask.g = paramString;
    paramAbstractUploadTask.a(1002, new Object[0]);
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (this.a.z != paramInt)
    {
      paramAbstractUploadTask = this.a;
      paramAbstractUploadTask.z = paramInt;
      paramAbstractUploadTask.a(paramAbstractUploadTask.z, new Object[0]);
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    paramAbstractUploadTask = this.a;
    paramAbstractUploadTask.z = 1001;
    paramAbstractUploadTask.e = paramObject;
    paramAbstractUploadTask.a(1001, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
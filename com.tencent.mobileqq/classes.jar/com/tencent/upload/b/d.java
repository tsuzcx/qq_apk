package com.tencent.upload.b;

import com.tencent.upload.common.b;
import com.tencent.upload.e.a.c;
import com.tencent.upload.uinterface.AbstractUploadTask;

public class d
  extends a
{
  public d(c paramc)
  {
    super(paramc);
    this.a = new g(paramc, 1);
  }
  
  protected boolean a()
  {
    return this.a.d() == 0;
  }
  
  protected boolean a(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    b.d("OtherUploadService", "cancel AbstractUploadTask flowId: " + paramAbstractUploadTask.flowId);
    this.a.d(paramAbstractUploadTask);
    return true;
  }
  
  protected void b()
  {
    this.a.c();
  }
  
  protected boolean b(AbstractUploadTask paramAbstractUploadTask)
  {
    b.d("OtherUploadService", "upload task flowId: " + paramAbstractUploadTask.flowId + " type:" + paramAbstractUploadTask.getClass().getSimpleName());
    this.a.a(paramAbstractUploadTask);
    return true;
  }
  
  protected void c()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.d
 * JD-Core Version:    0.7.0.1
 */
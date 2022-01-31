package com.tencent.upload.b;

import com.tencent.upload.common.Const.b;
import com.tencent.upload.e.a.c;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.V2Config;

public abstract class a
{
  g a;
  c b;
  
  public a(c paramc)
  {
    this.b = paramc;
  }
  
  protected void a(Const.b paramb)
  {
    this.a.a(paramb);
  }
  
  abstract boolean a();
  
  abstract boolean a(AbstractUploadTask paramAbstractUploadTask);
  
  abstract void b();
  
  abstract boolean b(AbstractUploadTask paramAbstractUploadTask);
  
  abstract void c();
  
  protected void d()
  {
    this.a.a();
  }
  
  public int e()
  {
    return com.tencent.upload.common.a.f().mParallelFileNumber;
  }
  
  public int f()
  {
    return com.tencent.upload.common.a.f().mBatchControlNumber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.a
 * JD-Core Version:    0.7.0.1
 */
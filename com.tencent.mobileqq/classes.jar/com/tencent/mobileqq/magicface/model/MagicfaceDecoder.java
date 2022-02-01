package com.tencent.mobileqq.magicface.model;

import com.tencent.qphone.base.util.QLog;

public abstract class MagicfaceDecoder
{
  MagicfaceData a;
  MagicfaceDecoder.MagicPlayListener b;
  MagicfaceDecoder.MagicfaceRenderListener c;
  public int d = 8;
  public int e = 1000 / this.d;
  volatile boolean f;
  
  public MagicfaceDecoder()
  {
    g();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.e = (1000 / paramInt);
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.a = paramMagicfaceData;
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.b = paramMagicPlayListener;
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.c = paramMagicfaceRenderListener;
  }
  
  public void c() {}
  
  public void d()
  {
    f();
    if (!this.f) {
      try
      {
        new Thread(new MagicfaceDecoder.1(this)).start();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDecoder err:");
          localStringBuilder.append(localOutOfMemoryError.getMessage());
          QLog.d("MagicfaceDecoder", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void e()
  {
    this.f = false;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.f = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder
 * JD-Core Version:    0.7.0.1
 */
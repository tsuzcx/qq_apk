package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceXBigDecoder
  extends MagicfaceFFMepgDecoder
{
  Runnable A = new MagicfaceXBigDecoder.2(this);
  Object w = new Object();
  Object x = new Object();
  volatile boolean y = false;
  Runnable z = new MagicfaceXBigDecoder.1(this);
  
  public MagicfaceXBigDecoder()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder init=");
    }
    this.g = new DecoderUtil();
    this.g.createVideoDecoder();
    this.g.createAlphaDecoder();
  }
  
  public void a()
  {
    try
    {
      this.h = this.a.d;
      if (this.h == null) {
        return;
      }
      this.o = this.a.c;
      if (this.o == null) {
        return;
      }
      b();
      if (this.j != null)
      {
        if (this.q == null) {
          return;
        }
        new Thread(this.A).start();
        this.z.run();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception=");
        localStringBuilder.append(localException.toString());
        QLog.i("MagicfaceXBigDecoder", 2, localStringBuilder.toString());
      }
    }
  }
  
  void b()
  {
    try
    {
      this.j = new byte[921600];
      this.q = new byte[921600];
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder release=");
    }
    if (this.g != null) {}
    try
    {
      this.g.releaseAlphaDecoder();
      this.g.releaseVideoDecoder();
      label37:
      this.g = null;
      super.c();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder
 * JD-Core Version:    0.7.0.1
 */
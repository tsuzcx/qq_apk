package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceSuperBigDecoder
  extends MagicfaceFFMepgDecoder
{
  private Runnable w = new MagicFaceSuperBigDecoder.1(this);
  
  public MagicFaceSuperBigDecoder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
    }
    this.g = new DecoderUtil();
    int i = this.g.createVideoDecoder();
    int j = this.g.createAlphaDecoder();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:");
      localStringBuilder.append(i);
      localStringBuilder.append(",alphaRet:");
      localStringBuilder.append(j);
      QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder begins");
    }
    this.h = this.a.d;
    if (this.h == null) {
      return;
    }
    this.o = this.a.c;
    if (this.o == null) {
      return;
    }
    b();
    this.w.run();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder ends");
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig begins");
    }
    try
    {
      this.j = new byte[817920];
      this.q = new byte[817920];
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig ends");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release begins.");
    }
    if (this.g != null) {}
    try
    {
      this.g.releaseAlphaDecoder();
      this.g.releaseVideoDecoder();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label40:
      break label40;
    }
    this.g = null;
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release ends.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder
 * JD-Core Version:    0.7.0.1
 */
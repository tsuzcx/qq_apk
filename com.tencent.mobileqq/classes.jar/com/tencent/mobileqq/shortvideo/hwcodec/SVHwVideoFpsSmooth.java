package com.tencent.mobileqq.shortvideo.hwcodec;

public class SVHwVideoFpsSmooth
{
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  
  public long a(long paramLong)
  {
    if (this.a == 0L)
    {
      long l = paramLong * 1000L;
      this.a = l;
      this.b = l;
      this.c = paramLong;
    }
    return paramLong * 1000L;
  }
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = 0.0F;
  }
  
  public void a(float paramFloat)
  {
    double d1 = paramFloat;
    Double.isNaN(d1);
    this.d = ((float)(1000.0D / d1));
    paramFloat = this.d;
    this.e = (0.3F + paramFloat);
    this.f = (paramFloat - 0.7F);
  }
  
  public long b(float paramFloat)
  {
    this.b += (paramFloat * 1000.0F);
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwVideoFpsSmooth
 * JD-Core Version:    0.7.0.1
 */
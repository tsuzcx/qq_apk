package com.tencent.mobileqq.streamtransfile;

public class StreamDataInfo
{
  private byte[] a = null;
  private int b = 0;
  private short c = 0;
  private boolean d = false;
  private boolean e = false;
  
  StreamDataInfo(int paramInt)
  {
    this.a = new byte[paramInt];
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(short paramShort)
  {
    this.c = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public short c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamDataInfo
 * JD-Core Version:    0.7.0.1
 */
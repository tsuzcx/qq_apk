package com.tencent.turingfd.sdk.xq;

public class Nucleus
{
  public static final byte[] a = new byte[0];
  public long b;
  public byte[] c;
  public Olive d;
  
  public Nucleus(long paramLong, byte[] paramArrayOfByte, Olive paramOlive)
  {
    this.b = paramLong;
    this.c = paramArrayOfByte;
    this.d = paramOlive;
  }
  
  public static Nucleus a(long paramLong, Olive paramOlive)
  {
    paramOlive.a = paramLong;
    return new Nucleus(paramLong, a, paramOlive);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Nucleus
 * JD-Core Version:    0.7.0.1
 */
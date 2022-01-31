package com.tencent.turingfd.sdk.xq;

public class boolean
{
  public static final byte[] Bb = new byte[0];
  public int Rb;
  public byte[] jc;
  
  public boolean(int paramInt, byte[] paramArrayOfByte)
  {
    this.Rb = paramInt;
    this.jc = paramArrayOfByte;
  }
  
  public static boolean c(int paramInt)
  {
    return new boolean(paramInt, Bb);
  }
  
  public static boolean f(byte[] paramArrayOfByte)
  {
    return new boolean(0, paramArrayOfByte);
  }
  
  public int getErrorCode()
  {
    return this.Rb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.boolean
 * JD-Core Version:    0.7.0.1
 */
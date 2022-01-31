package com.tencent.turingfd.sdk.xq;

public class throws
{
  public static final byte[] Bb = new byte[0];
  public int Rb;
  public byte[] ic;
  
  public throws(int paramInt, byte[] paramArrayOfByte)
  {
    this.Rb = paramInt;
    this.ic = paramArrayOfByte;
  }
  
  public static throws c(int paramInt)
  {
    return new throws(paramInt, Bb);
  }
  
  public int getErrorCode()
  {
    return this.Rb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.throws
 * JD-Core Version:    0.7.0.1
 */
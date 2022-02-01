package com.tencent.turingfd.sdk.ams.ga;

public class Auriga
{
  public static final byte[] ld = new byte[0];
  public byte[] Bd;
  public int cd;
  
  public Auriga(int paramInt, byte[] paramArrayOfByte)
  {
    this.cd = paramInt;
    this.Bd = paramArrayOfByte;
  }
  
  public static Auriga g(int paramInt)
  {
    return new Auriga(paramInt, ld);
  }
  
  public byte[] M()
  {
    return this.Bd;
  }
  
  public int getErrorCode()
  {
    return this.cd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Auriga
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tfd.sdk.wxa;

public class Auriga
{
  public static final byte[] Vc = new byte[0];
  public int Oc;
  public byte[] nd;
  
  public Auriga(int paramInt, byte[] paramArrayOfByte)
  {
    this.Oc = paramInt;
    this.nd = paramArrayOfByte;
  }
  
  public static Auriga g(int paramInt)
  {
    return new Auriga(paramInt, Vc);
  }
  
  public int getErrorCode()
  {
    return this.Oc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Auriga
 * JD-Core Version:    0.7.0.1
 */
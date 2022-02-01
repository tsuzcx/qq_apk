package com.tencent.tfd.sdk.wxa;

public class Bootes
{
  public static final byte[] Vc = new byte[0];
  public int Oc;
  public int Wc;
  public int Xc;
  public byte[] od;
  
  public Bootes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.Oc = paramInt1;
    this.od = paramArrayOfByte;
    this.Wc = paramInt2;
    this.Xc = paramInt3;
  }
  
  public static Bootes g(int paramInt)
  {
    return new Bootes(paramInt, Vc, 0, 0);
  }
  
  public byte[] K()
  {
    return this.od;
  }
  
  public int L()
  {
    return this.Xc;
  }
  
  public int M()
  {
    return this.Wc;
  }
  
  public int getErrorCode()
  {
    return this.Oc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Bootes
 * JD-Core Version:    0.7.0.1
 */
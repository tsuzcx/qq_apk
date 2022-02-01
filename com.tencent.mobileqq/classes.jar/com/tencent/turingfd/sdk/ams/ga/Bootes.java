package com.tencent.turingfd.sdk.ams.ga;

public class Bootes
{
  public static final byte[] ld = new byte[0];
  public byte[] Cd;
  public int cd;
  public int md;
  public int nd;
  
  public Bootes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.cd = paramInt1;
    this.Cd = paramArrayOfByte;
    this.md = paramInt2;
    this.nd = paramInt3;
  }
  
  public static Bootes g(int paramInt)
  {
    return new Bootes(paramInt, ld, 0, 0);
  }
  
  public byte[] N()
  {
    return this.Cd;
  }
  
  public int O()
  {
    return this.nd;
  }
  
  public int P()
  {
    return this.md;
  }
  
  public int getErrorCode()
  {
    return this.cd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Bootes
 * JD-Core Version:    0.7.0.1
 */
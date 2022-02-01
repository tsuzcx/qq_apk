package com.tencent.turingfd.sdk.xq;

public class Carambola
{
  public static final byte[] Mh = new byte[0];
  public int Nh;
  public int Oh;
  public byte[] Yh;
  public int zg;
  
  public Carambola(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.zg = paramInt1;
    this.Yh = paramArrayOfByte;
    this.Nh = paramInt2;
    this.Oh = paramInt3;
  }
  
  public static Carambola g(int paramInt)
  {
    return new Carambola(paramInt, Mh, 0, 0);
  }
  
  public byte[] X()
  {
    return this.Yh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Carambola
 * JD-Core Version:    0.7.0.1
 */
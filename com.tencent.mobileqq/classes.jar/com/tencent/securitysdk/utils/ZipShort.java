package com.tencent.securitysdk.utils;

public final class ZipShort
  implements Cloneable
{
  private int a;
  
  public ZipShort(int paramInt)
  {
    this.a = paramInt;
  }
  
  public ZipShort(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ZipShort(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public byte[] a()
  {
    return new byte[] { (byte)(this.a & 0xFF), (byte)((this.a & 0xFF00) >> 8) };
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ZipShort))) {}
    while (this.a != ((ZipShort)paramObject).a()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ZipShort
 * JD-Core Version:    0.7.0.1
 */
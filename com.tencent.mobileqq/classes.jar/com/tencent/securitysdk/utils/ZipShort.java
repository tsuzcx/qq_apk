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
  
  public byte[] a()
  {
    int i = this.a;
    return new byte[] { (byte)(i & 0xFF), (byte)((i & 0xFF00) >> 8) };
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof ZipShort)) {
        return false;
      }
      bool1 = bool2;
      if (this.a == ((ZipShort)paramObject).b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ZipShort
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.securitysdk.utils;

public final class ZipLong
  implements Cloneable
{
  private long a;
  
  public ZipLong(long paramLong)
  {
    this.a = paramLong;
  }
  
  public ZipLong(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ZipLong(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000);
    this.a += (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000);
    this.a += (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public byte[] a()
  {
    long l = this.a;
    return new byte[] { (byte)(int)(0xFF & l), (byte)(int)((0xFF00 & l) >> 8), (byte)(int)((0xFF0000 & l) >> 16), (byte)(int)((l & 0xFF000000) >> 24) };
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof ZipLong)) {
        return false;
      }
      bool1 = bool2;
      if (this.a == ((ZipLong)paramObject).a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (int)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ZipLong
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqlive.utils;

import java.io.ByteArrayInputStream;

public class InBuffer
{
  public ByteArrayInputStream a = null;
  private boolean b = false;
  
  public InBuffer(byte[] paramArrayOfByte)
  {
    this.a = new ByteArrayInputStream(paramArrayOfByte);
    this.b = true;
  }
  
  public int a()
  {
    return this.a.read();
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    return this.a.read(paramArrayOfByte);
  }
  
  public long a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      localObject = new byte[paramInt];
      if (this.a.markSupported()) {
        this.a.mark(paramInt);
      }
      ByteArrayInputStream localByteArrayInputStream = this.a;
      int j = 0;
      int i = localByteArrayInputStream.read((byte[])localObject, 0, paramInt);
      if (i <= 0)
      {
        this.a = null;
        return -1L;
      }
      if (this.b) {
        paramInt = j;
      } else {
        paramInt = i - 1;
      }
      boolean bool = this.b;
      j = -1;
      if (!bool) {
        i = -1;
      }
      if (this.b) {
        j = 1;
      }
      long l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | localObject[paramInt] & 0xFF;
        paramInt += j;
      }
      return l;
    }
    Object localObject = new IllegalArgumentException("integer length must between 1 and 8 bytes.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int b()
  {
    return (int)a(2);
  }
  
  public long c()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.InBuffer
 * JD-Core Version:    0.7.0.1
 */
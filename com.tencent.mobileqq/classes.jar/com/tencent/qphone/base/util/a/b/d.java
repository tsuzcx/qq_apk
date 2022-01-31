package com.tencent.qphone.base.util.a.b;

public class d
{
  public byte[] a;
  public int b;
  public int c;
  public int d;
  
  public d()
  {
    this.a = new byte[2048];
    this.b = 2048;
    this.c = 0;
    this.d = 0;
  }
  
  public d(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = paramInt;
    this.c = 0;
    this.d = 0;
  }
  
  public d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      this.b = i;
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  public void a()
  {
    this.c = 0;
    this.d = 0;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      this.a[(this.d + i)] = paramArrayOfByte[i];
      i += 1;
    }
    this.d += paramInt;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramArrayOfByte.length;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      byte[] arrayOfByte = this.a;
      int j = this.c;
      this.c = (j + 1);
      arrayOfByte[j] = paramArrayOfByte[(paramInt1 + i)];
      i += 1;
    }
    this.d += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.b.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qmsp.sdk.f;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

class c
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  private int d;
  private int e;
  private int f;
  private int g;
  private byte[] h;
  private boolean i = true;
  private int j;
  private Random k = new Random();
  
  private void a()
  {
    byte[] arrayOfByte;
    for (this.f = 0;; this.f += 1)
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.i)
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.b[m]));
      }
      else
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.c[(this.e + m)]));
      }
    }
    System.arraycopy(b(this.a), 0, this.c, this.d, 8);
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      arrayOfByte = this.c;
      int n = this.d + m;
      arrayOfByte[n] = ((byte)(arrayOfByte[n] ^ this.b[m]));
    }
    System.arraycopy(this.a, 0, this.b, 0, 8);
    int m = this.d;
    this.e = m;
    this.d = (m + 8);
    this.f = 0;
    this.i = false;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m;
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.j + m >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.b;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ paramArrayOfByte[(this.d + paramInt1 + m)]));
    }
    this.b = a(this.b);
    if (this.b == null) {
      return false;
    }
    this.j += 8;
    this.d += 8;
    this.f = 0;
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    long l2;
    long l1;
    long l4;
    long l5;
    long l6;
    long l7;
    long l3;
    try
    {
      l2 = b(paramArrayOfByte, paramInt, 4);
      l1 = b(paramArrayOfByte, paramInt + 4, 4);
      l4 = b(this.h, 0, 4);
      l5 = b(this.h, 4, 4);
      l6 = b(this.h, 8, 4);
      l7 = b(this.h, 12, 4);
      l3 = 3816266640L;
      paramInt = 16;
    }
    catch (IOException paramArrayOfByte)
    {
      DataOutputStream localDataOutputStream;
      break label121;
    }
    paramArrayOfByte = new ByteArrayOutputStream(8);
    localDataOutputStream = new DataOutputStream(paramArrayOfByte);
    localDataOutputStream.writeInt((int)l2);
    localDataOutputStream.writeInt((int)l1);
    localDataOutputStream.close();
    paramArrayOfByte = paramArrayOfByte.toByteArray();
    return paramArrayOfByte;
    label121:
    return null;
    while (paramInt > 0)
    {
      l1 = l1 - ((l2 << 4) + l6 ^ l2 + l3 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
      l2 = l2 - ((l1 << 4) + l4 ^ l1 + l3 ^ (l1 >>> 5) + l5) & 0xFFFFFFFF;
      l3 = l3 - 2654435769L & 0xFFFFFFFF;
      paramInt -= 1;
    }
  }
  
  private int b()
  {
    return this.k.nextInt();
  }
  
  private static long b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    } else {
      paramInt2 += paramInt1;
    }
    while (paramInt1 < paramInt2)
    {
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
    }
    return 0xFFFFFFFF & l | l >>> 32;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    long l1;
    long l2;
    long l4;
    long l5;
    long l6;
    long l7;
    long l3;
    int m;
    try
    {
      l1 = b(paramArrayOfByte, 0, 4);
      l2 = b(paramArrayOfByte, 4, 4);
      l4 = b(this.h, 0, 4);
      l5 = b(this.h, 4, 4);
      l6 = b(this.h, 8, 4);
      l7 = b(this.h, 12, 4);
      l3 = 0L;
      m = 16;
    }
    catch (IOException paramArrayOfByte)
    {
      DataOutputStream localDataOutputStream;
      label117:
      break label117;
    }
    paramArrayOfByte = new ByteArrayOutputStream(8);
    localDataOutputStream = new DataOutputStream(paramArrayOfByte);
    localDataOutputStream.writeInt((int)l1);
    localDataOutputStream.writeInt((int)l2);
    localDataOutputStream.close();
    paramArrayOfByte = paramArrayOfByte.toByteArray();
    return paramArrayOfByte;
    return null;
    while (m > 0)
    {
      l3 = l3 + 2654435769L & 0xFFFFFFFF;
      l1 = l1 + ((l2 << 4) + l4 ^ l2 + l3 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
      l2 = l2 + ((l1 << 4) + l6 ^ l1 + l3 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
      m -= 1;
    }
  }
  
  private byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((paramInt2 + 10) % 8);
    int m = this.f;
    if (m != 0) {
      this.f = (8 - m);
    }
    this.c = new byte[this.f + paramInt2 + 10];
    this.a[0] = ((byte)(b() & 0xF8 | this.f));
    m = 1;
    int n;
    for (;;)
    {
      n = this.f;
      if (m > n) {
        break;
      }
      this.a[m] = ((byte)(b() & 0xFF));
      m += 1;
    }
    this.f = (n + 1);
    m = 0;
    while (m < 8)
    {
      this.b[m] = 0;
      m += 1;
    }
    this.g = 1;
    for (;;)
    {
      m = paramInt1;
      n = paramInt2;
      if (this.g > 2) {
        break;
      }
      m = this.f;
      if (m < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (m + 1);
        paramArrayOfByte2[m] = ((byte)(b() & 0xFF));
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    while (n > 0)
    {
      int i1 = this.f;
      paramInt2 = m;
      paramInt1 = n;
      if (i1 < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (i1 + 1);
        paramArrayOfByte2[i1] = paramArrayOfByte1[m];
        paramInt1 = n - 1;
        paramInt2 = m + 1;
      }
      m = paramInt2;
      n = paramInt1;
      if (this.f == 8)
      {
        a();
        m = paramInt2;
        n = paramInt1;
      }
    }
    this.g = 1;
    for (;;)
    {
      paramInt1 = this.g;
      if (paramInt1 > 7) {
        break;
      }
      paramInt2 = this.f;
      if (paramInt2 < 8)
      {
        paramArrayOfByte1 = this.a;
        this.f = (paramInt2 + 1);
        paramArrayOfByte1[paramInt2] = 0;
        this.g = (paramInt1 + 1);
      }
      if (this.f == 8) {
        a();
      }
    }
    return this.c;
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i1 = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if (paramInt2 % 8 == 0)
    {
      if (paramInt2 < 16) {
        return null;
      }
      this.b = a(paramArrayOfByte1, paramInt1);
      this.f = (this.b[0] & 0x7);
      int i2 = paramInt2 - this.f - 10;
      if (i2 < 0) {
        return null;
      }
      int m = paramInt1;
      while (m < paramArrayOfByte2.length)
      {
        paramArrayOfByte2[m] = 0;
        m += 1;
      }
      this.c = new byte[i2];
      this.e = 0;
      this.d = 8;
      this.j = 8;
      this.f += 1;
      this.g = 1;
      int i3;
      int n;
      byte[] arrayOfByte;
      for (;;)
      {
        i3 = this.g;
        n = i1;
        m = i2;
        arrayOfByte = paramArrayOfByte2;
        if (i3 > 2) {
          break;
        }
        m = this.f;
        if (m < 8)
        {
          this.f = (m + 1);
          this.g = (i3 + 1);
        }
        if (this.f == 8)
        {
          if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      while (m != 0)
      {
        i3 = this.f;
        i2 = n;
        i1 = m;
        if (i3 < 8)
        {
          this.c[n] = ((byte)(arrayOfByte[(this.e + paramInt1 + i3)] ^ this.b[i3]));
          i2 = n + 1;
          i1 = m - 1;
          this.f = (i3 + 1);
        }
        n = i2;
        m = i1;
        if (this.f == 8)
        {
          this.e = (this.d - 8);
          if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          arrayOfByte = paramArrayOfByte1;
          n = i2;
          m = i1;
        }
      }
      this.g = 1;
      while (this.g < 8)
      {
        m = this.f;
        if (m < 8)
        {
          if ((arrayOfByte[(this.e + paramInt1 + m)] ^ this.b[m]) != 0) {
            return null;
          }
          this.f = (m + 1);
        }
        paramArrayOfByte2 = arrayOfByte;
        if (this.f == 8)
        {
          this.e = this.d;
          if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
        this.g += 1;
        arrayOfByte = paramArrayOfByte2;
      }
      return this.c;
    }
    return null;
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.c
 * JD-Core Version:    0.7.0.1
 */
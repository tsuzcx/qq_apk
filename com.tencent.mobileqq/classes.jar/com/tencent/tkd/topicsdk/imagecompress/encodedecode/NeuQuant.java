package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import com.tencent.tkd.topicsdk.framework.TLog;

class NeuQuant
{
  protected int a;
  protected byte[] b;
  protected int c;
  protected int d;
  protected int[][] e;
  protected int[] f = new int[256];
  protected int[] g = new int[256];
  protected int[] h = new int[256];
  protected int[] i = new int[32];
  
  public NeuQuant(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = new int[256][];
    paramInt1 = 0;
    while (paramInt1 < 256)
    {
      paramArrayOfByte = this.e;
      paramArrayOfByte[paramInt1] = new int[4];
      paramArrayOfByte = paramArrayOfByte[paramInt1];
      paramInt2 = (paramInt1 << 12) / 256;
      paramArrayOfByte[2] = paramInt2;
      paramArrayOfByte[1] = paramInt2;
      paramArrayOfByte[0] = paramInt2;
      this.h[paramInt1] = 256;
      this.g[paramInt1] = 0;
      paramInt1 += 1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = this.f[paramInt2];
    int j = i3 - 1;
    int k = -1;
    int m = 1000;
    for (;;)
    {
      if ((i3 >= 256) && (j < 0)) {
        return k;
      }
      int n = i3;
      int i2 = k;
      int i1 = m;
      int[] arrayOfInt;
      int i4;
      if (i3 < 256)
      {
        arrayOfInt = this.e[i3];
        i1 = arrayOfInt[1] - paramInt2;
        if (i1 >= m)
        {
          n = 256;
          i2 = k;
          i1 = m;
        }
        else
        {
          i3 += 1;
          n = i1;
          if (i1 < 0) {
            n = -i1;
          }
          i2 = arrayOfInt[0] - paramInt1;
          i1 = i2;
          if (i2 < 0) {
            i1 = -i2;
          }
          i4 = n + i1;
          n = i3;
          i2 = k;
          i1 = m;
          if (i4 < m)
          {
            i1 = arrayOfInt[2] - paramInt3;
            n = i1;
            if (i1 < 0) {
              n = -i1;
            }
            i4 += n;
            n = i3;
            i2 = k;
            i1 = m;
            if (i4 < m)
            {
              i2 = arrayOfInt[3];
              i1 = i4;
              n = i3;
            }
          }
        }
      }
      i3 = n;
      k = i2;
      m = i1;
      if (j >= 0)
      {
        arrayOfInt = this.e[j];
        k = paramInt2 - arrayOfInt[1];
        if (k >= i1)
        {
          j = -1;
          i3 = n;
          k = i2;
          m = i1;
        }
        else
        {
          i4 = j - 1;
          j = k;
          if (k < 0) {
            j = -k;
          }
          m = arrayOfInt[0] - paramInt1;
          k = m;
          if (m < 0) {
            k = -m;
          }
          int i5 = j + k;
          i3 = n;
          j = i4;
          k = i2;
          m = i1;
          if (i5 < i1)
          {
            k = arrayOfInt[2] - paramInt3;
            j = k;
            if (k < 0) {
              j = -k;
            }
            i5 = j + i5;
            i3 = n;
            j = i4;
            k = i2;
            m = i1;
            if (i5 < i1)
            {
              k = arrayOfInt[3];
              m = i5;
              i3 = n;
              j = i4;
            }
          }
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = paramInt2 - paramInt1;
    int k = -1;
    if (j < -1) {
      j = k;
    }
    k = paramInt2 + paramInt1;
    paramInt1 = 256;
    if (k > 256) {
      k = paramInt1;
    }
    paramInt1 = paramInt2 + 1;
    paramInt2 -= 1;
    int n;
    for (int m = 1;; m = n)
    {
      if ((paramInt1 >= k) && (paramInt2 <= j)) {
        return;
      }
      Object localObject = this.i;
      n = m + 1;
      int i1 = localObject[m];
      if (paramInt1 < k)
      {
        localObject = this.e;
        m = paramInt1 + 1;
        localObject = localObject[paramInt1];
        try
        {
          localObject[0] -= (localObject[0] - paramInt3) * i1 / 262144;
          localObject[1] -= (localObject[1] - paramInt4) * i1 / 262144;
          localObject[2] -= (localObject[2] - paramInt5) * i1 / 262144;
          paramInt1 = m;
        }
        catch (Exception localException1)
        {
          TLog.d("NeuQuant", localException1.toString());
          paramInt1 = m;
        }
      }
      if (paramInt2 > j)
      {
        int[] arrayOfInt = this.e[paramInt2];
        try
        {
          arrayOfInt[0] -= (arrayOfInt[0] - paramInt3) * i1 / 262144;
          arrayOfInt[1] -= (arrayOfInt[1] - paramInt4) * i1 / 262144;
          arrayOfInt[2] -= i1 * (arrayOfInt[2] - paramInt5) / 262144;
        }
        catch (Exception localException2)
        {
          TLog.d("NeuQuant", localException2.toString());
        }
        paramInt2 -= 1;
      }
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[768];
    int[] arrayOfInt = new int[256];
    int j = 0;
    while (j < 256)
    {
      arrayOfInt[this.e[j][3]] = j;
      j += 1;
    }
    j = 0;
    int k = 0;
    while (j < 256)
    {
      int m = arrayOfInt[j];
      int n = k + 1;
      int[][] arrayOfInt1 = this.e;
      arrayOfByte[k] = ((byte)arrayOfInt1[m][0]);
      k = n + 1;
      arrayOfByte[n] = ((byte)arrayOfInt1[m][1]);
      arrayOfByte[k] = ((byte)arrayOfInt1[m][2]);
      j += 1;
      k += 1;
    }
    return arrayOfByte;
  }
  
  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = -1;
    int j = 0;
    int m = -1;
    int n = 2147483647;
    int i3;
    for (int k = 2147483647; j < 256; k = i3)
    {
      arrayOfInt = this.e[j];
      i3 = arrayOfInt[0] - paramInt1;
      int i2 = i3;
      if (i3 < 0) {
        i2 = -i3;
      }
      int i4 = arrayOfInt[1] - paramInt2;
      i3 = i4;
      if (i4 < 0) {
        i3 = -i4;
      }
      int i5 = arrayOfInt[2] - paramInt3;
      i4 = i5;
      if (i5 < 0) {
        i4 = -i5;
      }
      i3 = i2 + i3 + i4;
      i2 = n;
      if (i3 < n)
      {
        i1 = j;
        i2 = i3;
      }
      n = i3 - (this.g[j] >> 12);
      i3 = k;
      if (n < k)
      {
        m = j;
        i3 = n;
      }
      arrayOfInt = this.h;
      k = arrayOfInt[j] >> 10;
      arrayOfInt[j] -= k;
      arrayOfInt = this.g;
      arrayOfInt[j] += (k << 10);
      j += 1;
      n = i2;
    }
    int[] arrayOfInt = this.h;
    arrayOfInt[i1] += 64;
    arrayOfInt = this.g;
    arrayOfInt[i1] -= 65536;
    return m;
  }
  
  public void b()
  {
    int j = 0;
    int k = 0;
    int n;
    for (int i2 = 0; j < 256; i2 = n)
    {
      int[] arrayOfInt1 = this.e[j];
      int m = arrayOfInt1[1];
      int i1 = j + 1;
      n = j;
      int i3 = i1;
      int i4 = n;
      n = i3;
      while (n < 256)
      {
        arrayOfInt2 = this.e[n];
        i3 = m;
        if (arrayOfInt2[1] < m)
        {
          i3 = arrayOfInt2[1];
          i4 = n;
        }
        n += 1;
        m = i3;
      }
      int[] arrayOfInt2 = this.e[i4];
      if (j != i4)
      {
        n = arrayOfInt2[0];
        arrayOfInt2[0] = arrayOfInt1[0];
        arrayOfInt1[0] = n;
        n = arrayOfInt2[1];
        arrayOfInt2[1] = arrayOfInt1[1];
        arrayOfInt1[1] = n;
        n = arrayOfInt2[2];
        arrayOfInt2[2] = arrayOfInt1[2];
        arrayOfInt1[2] = n;
        n = arrayOfInt2[3];
        arrayOfInt2[3] = arrayOfInt1[3];
        arrayOfInt1[3] = n;
      }
      i3 = k;
      n = i2;
      if (m != k)
      {
        this.f[k] = (i2 + j >> 1);
        for (;;)
        {
          k += 1;
          if (k >= m) {
            break;
          }
          this.f[k] = j;
        }
        n = j;
        i3 = m;
      }
      j = i1;
      k = i3;
    }
    this.f[k] = (i2 + 255 >> 1);
    j = k + 1;
    while (j < 256)
    {
      this.f[j] = 255;
      j += 1;
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.e[paramInt2];
    arrayOfInt[0] -= (arrayOfInt[0] - paramInt3) * paramInt1 / 1024;
    arrayOfInt[1] -= (arrayOfInt[1] - paramInt4) * paramInt1 / 1024;
    arrayOfInt[2] -= paramInt1 * (arrayOfInt[2] - paramInt5) / 1024;
  }
  
  public void c()
  {
    if (this.c < 1509) {
      this.d = 1;
    }
    int j = this.d;
    this.a = ((j - 1) / 3 + 30);
    byte[] arrayOfByte = this.b;
    int i8 = this.c;
    int i9 = i8 / (j * 3);
    int i2 = i9 / 100;
    j = 0;
    while (j < 32)
    {
      this.i[j] = (1024 * ((1024 - j * j) * 256 / 1024));
      j += 1;
    }
    j = this.c;
    if (j < 1509) {
      j = 3;
    } else if (j % 499 != 0) {
      j = 1497;
    } else if (j % 491 != 0) {
      j = 1473;
    } else if (j % 487 != 0) {
      j = 1461;
    } else {
      j = 1509;
    }
    int i4 = 0;
    int i5 = 0;
    int n = 1024;
    int i1 = 32;
    int m = 2048;
    while (i4 < i9)
    {
      int k = (arrayOfByte[(i5 + 0)] & 0xFF) << 4;
      int i3 = (arrayOfByte[(i5 + 1)] & 0xFF) << 4;
      int i6 = (arrayOfByte[(i5 + 2)] & 0xFF) << 4;
      int i7 = b(k, i3, i6);
      b(n, i7, k, i3, i6);
      if (i1 != 0) {
        a(i1, i7, k, i3, i6);
      }
      i3 = i5 + j;
      k = i3;
      if (i3 >= i8) {
        k = i3 - this.c;
      }
      i6 = i4 + 1;
      i3 = i2;
      if (i2 == 0) {
        i3 = 1;
      }
      i4 = i6;
      i5 = k;
      i2 = i3;
      if (i6 % i3 == 0)
      {
        i1 = n - n / this.a;
        i7 = m - m / 30;
        n = i7 >> 6;
        m = n;
        if (n <= 1) {
          m = 0;
        }
        n = 0;
        while (n < m)
        {
          int[] arrayOfInt = this.i;
          i2 = m * m;
          arrayOfInt[n] = ((i2 - n * n) * 256 / i2 * i1);
          n += 1;
        }
        i4 = i6;
        i5 = k;
        n = i1;
        i1 = m;
        i2 = i3;
        m = i7;
      }
    }
  }
  
  public byte[] d()
  {
    c();
    e();
    b();
    return a();
  }
  
  public void e()
  {
    int j = 0;
    while (j < 256)
    {
      int[][] arrayOfInt = this.e;
      int[] arrayOfInt1 = arrayOfInt[j];
      arrayOfInt1[0] >>= 4;
      arrayOfInt1 = arrayOfInt[j];
      arrayOfInt1[1] >>= 4;
      arrayOfInt1 = arrayOfInt[j];
      arrayOfInt1[2] >>= 4;
      arrayOfInt[j][3] = j;
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.NeuQuant
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import com.tencent.tkd.topicsdk.framework.TLog;

class NeuQuant
{
  protected int a;
  protected byte[] a;
  protected int[] a;
  protected int[][] a;
  protected int b;
  protected int[] b;
  protected int c;
  protected int[] c;
  protected int[] d = new int[32];
  
  public NeuQuant(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[256];
    this.jdField_b_of_type_ArrayOfInt = new int[256];
    this.jdField_c_of_type_ArrayOfInt = new int[256];
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Array2dOfInt = new int[256][];
    paramInt1 = 0;
    while (paramInt1 < 256)
    {
      paramArrayOfByte = this.jdField_a_of_type_Array2dOfInt;
      paramArrayOfByte[paramInt1] = new int[4];
      paramArrayOfByte = paramArrayOfByte[paramInt1];
      paramInt2 = (paramInt1 << 12) / 256;
      paramArrayOfByte[2] = paramInt2;
      paramArrayOfByte[1] = paramInt2;
      paramArrayOfByte[0] = paramInt2;
      this.jdField_c_of_type_ArrayOfInt[paramInt1] = 256;
      this.jdField_b_of_type_ArrayOfInt[paramInt1] = 0;
      paramInt1 += 1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = this.jdField_a_of_type_ArrayOfInt[paramInt2];
    int i = i2 - 1;
    int j = -1;
    int k = 1000;
    for (;;)
    {
      if ((i2 >= 256) && (i < 0)) {
        return j;
      }
      int m = i2;
      int i1 = j;
      int n = k;
      int[] arrayOfInt;
      int i3;
      if (i2 < 256)
      {
        arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i2];
        n = arrayOfInt[1] - paramInt2;
        if (n >= k)
        {
          m = 256;
          i1 = j;
          n = k;
        }
        else
        {
          i2 += 1;
          m = n;
          if (n < 0) {
            m = -n;
          }
          i1 = arrayOfInt[0] - paramInt1;
          n = i1;
          if (i1 < 0) {
            n = -i1;
          }
          i3 = m + n;
          m = i2;
          i1 = j;
          n = k;
          if (i3 < k)
          {
            n = arrayOfInt[2] - paramInt3;
            m = n;
            if (n < 0) {
              m = -n;
            }
            i3 += m;
            m = i2;
            i1 = j;
            n = k;
            if (i3 < k)
            {
              i1 = arrayOfInt[3];
              n = i3;
              m = i2;
            }
          }
        }
      }
      i2 = m;
      j = i1;
      k = n;
      if (i >= 0)
      {
        arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
        j = paramInt2 - arrayOfInt[1];
        if (j >= n)
        {
          i = -1;
          i2 = m;
          j = i1;
          k = n;
        }
        else
        {
          i3 = i - 1;
          i = j;
          if (j < 0) {
            i = -j;
          }
          k = arrayOfInt[0] - paramInt1;
          j = k;
          if (k < 0) {
            j = -k;
          }
          int i4 = i + j;
          i2 = m;
          i = i3;
          j = i1;
          k = n;
          if (i4 < n)
          {
            j = arrayOfInt[2] - paramInt3;
            i = j;
            if (j < 0) {
              i = -j;
            }
            i4 = i + i4;
            i2 = m;
            i = i3;
            j = i1;
            k = n;
            if (i4 < n)
            {
              j = arrayOfInt[3];
              k = i4;
              i2 = m;
              i = i3;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    int i = 0;
    int j = 0;
    int m;
    for (int i1 = 0; i < 256; i1 = m)
    {
      int[] arrayOfInt1 = this.jdField_a_of_type_Array2dOfInt[i];
      int k = arrayOfInt1[1];
      int n = i + 1;
      m = i;
      int i2 = n;
      int i3 = m;
      m = i2;
      while (m < 256)
      {
        arrayOfInt2 = this.jdField_a_of_type_Array2dOfInt[m];
        i2 = k;
        if (arrayOfInt2[1] < k)
        {
          i2 = arrayOfInt2[1];
          i3 = m;
        }
        m += 1;
        k = i2;
      }
      int[] arrayOfInt2 = this.jdField_a_of_type_Array2dOfInt[i3];
      if (i != i3)
      {
        m = arrayOfInt2[0];
        arrayOfInt2[0] = arrayOfInt1[0];
        arrayOfInt1[0] = m;
        m = arrayOfInt2[1];
        arrayOfInt2[1] = arrayOfInt1[1];
        arrayOfInt1[1] = m;
        m = arrayOfInt2[2];
        arrayOfInt2[2] = arrayOfInt1[2];
        arrayOfInt1[2] = m;
        m = arrayOfInt2[3];
        arrayOfInt2[3] = arrayOfInt1[3];
        arrayOfInt1[3] = m;
      }
      i2 = j;
      m = i1;
      if (k != j)
      {
        this.jdField_a_of_type_ArrayOfInt[j] = (i1 + i >> 1);
        for (;;)
        {
          j += 1;
          if (j >= k) {
            break;
          }
          this.jdField_a_of_type_ArrayOfInt[j] = i;
        }
        m = i;
        i2 = k;
      }
      i = n;
      j = i2;
    }
    this.jdField_a_of_type_ArrayOfInt[j] = (i1 + 255 >> 1);
    i = j + 1;
    while (i < 256)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = 255;
      i += 1;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt2 - paramInt1;
    int j = -1;
    if (i < -1) {
      i = j;
    }
    j = paramInt2 + paramInt1;
    paramInt1 = 256;
    if (j > 256) {
      j = paramInt1;
    }
    paramInt1 = paramInt2 + 1;
    paramInt2 -= 1;
    int m;
    for (int k = 1;; k = m)
    {
      if ((paramInt1 >= j) && (paramInt2 <= i)) {
        return;
      }
      Object localObject = this.d;
      m = k + 1;
      int n = localObject[k];
      if (paramInt1 < j)
      {
        localObject = this.jdField_a_of_type_Array2dOfInt;
        k = paramInt1 + 1;
        localObject = localObject[paramInt1];
        try
        {
          localObject[0] -= (localObject[0] - paramInt3) * n / 262144;
          localObject[1] -= (localObject[1] - paramInt4) * n / 262144;
          localObject[2] -= (localObject[2] - paramInt5) * n / 262144;
          paramInt1 = k;
        }
        catch (Exception localException1)
        {
          TLog.d("NeuQuant", localException1.toString());
          paramInt1 = k;
        }
      }
      if (paramInt2 > i)
      {
        int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[paramInt2];
        try
        {
          arrayOfInt[0] -= (arrayOfInt[0] - paramInt3) * n / 262144;
          arrayOfInt[1] -= (arrayOfInt[1] - paramInt4) * n / 262144;
          arrayOfInt[2] -= n * (arrayOfInt[2] - paramInt5) / 262144;
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
    int i = 0;
    while (i < 256)
    {
      arrayOfInt[this.jdField_a_of_type_Array2dOfInt[i][3]] = i;
      i += 1;
    }
    i = 0;
    int j = 0;
    while (i < 256)
    {
      int k = arrayOfInt[i];
      int m = j + 1;
      int[][] arrayOfInt1 = this.jdField_a_of_type_Array2dOfInt;
      arrayOfByte[j] = ((byte)arrayOfInt1[k][0]);
      j = m + 1;
      arrayOfByte[m] = ((byte)arrayOfInt1[k][1]);
      arrayOfByte[j] = ((byte)arrayOfInt1[k][2]);
      i += 1;
      j += 1;
    }
    return arrayOfByte;
  }
  
  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = -1;
    int i = 0;
    int k = -1;
    int m = 2147483647;
    int i2;
    for (int j = 2147483647; i < 256; j = i2)
    {
      arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
      i2 = arrayOfInt[0] - paramInt1;
      int i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      int i3 = arrayOfInt[1] - paramInt2;
      i2 = i3;
      if (i3 < 0) {
        i2 = -i3;
      }
      int i4 = arrayOfInt[2] - paramInt3;
      i3 = i4;
      if (i4 < 0) {
        i3 = -i4;
      }
      i2 = i1 + i2 + i3;
      i1 = m;
      if (i2 < m)
      {
        n = i;
        i1 = i2;
      }
      m = i2 - (this.jdField_b_of_type_ArrayOfInt[i] >> 12);
      i2 = j;
      if (m < j)
      {
        k = i;
        i2 = m;
      }
      arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
      j = arrayOfInt[i] >> 10;
      arrayOfInt[i] -= j;
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt[i] += (j << 10);
      i += 1;
      m = i1;
    }
    int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
    arrayOfInt[n] += 64;
    arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    arrayOfInt[n] -= 65536;
    return k;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int < 1509) {
      this.jdField_c_of_type_Int = 1;
    }
    int i = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Int = ((i - 1) / 3 + 30);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i7 = this.jdField_b_of_type_Int;
    int i8 = i7 / (i * 3);
    int i1 = i8 / 100;
    i = 0;
    while (i < 32)
    {
      this.d[i] = (1024 * ((1024 - i * i) * 256 / 1024));
      i += 1;
    }
    i = this.jdField_b_of_type_Int;
    if (i < 1509) {
      i = 3;
    } else if (i % 499 != 0) {
      i = 1497;
    } else if (i % 491 != 0) {
      i = 1473;
    } else if (i % 487 != 0) {
      i = 1461;
    } else {
      i = 1509;
    }
    int i3 = 0;
    int i4 = 0;
    int m = 1024;
    int n = 32;
    int k = 2048;
    while (i3 < i8)
    {
      int j = (arrayOfByte[(i4 + 0)] & 0xFF) << 4;
      int i2 = (arrayOfByte[(i4 + 1)] & 0xFF) << 4;
      int i5 = (arrayOfByte[(i4 + 2)] & 0xFF) << 4;
      int i6 = b(j, i2, i5);
      b(m, i6, j, i2, i5);
      if (n != 0) {
        a(n, i6, j, i2, i5);
      }
      i2 = i4 + i;
      j = i2;
      if (i2 >= i7) {
        j = i2 - this.jdField_b_of_type_Int;
      }
      i5 = i3 + 1;
      i2 = i1;
      if (i1 == 0) {
        i2 = 1;
      }
      i3 = i5;
      i4 = j;
      i1 = i2;
      if (i5 % i2 == 0)
      {
        n = m - m / this.jdField_a_of_type_Int;
        i6 = k - k / 30;
        m = i6 >> 6;
        k = m;
        if (m <= 1) {
          k = 0;
        }
        m = 0;
        while (m < k)
        {
          int[] arrayOfInt = this.d;
          i1 = k * k;
          arrayOfInt[m] = ((i1 - m * m) * 256 / i1 * n);
          m += 1;
        }
        i3 = i5;
        i4 = j;
        m = n;
        n = k;
        i1 = i2;
        k = i6;
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[paramInt2];
    arrayOfInt[0] -= (arrayOfInt[0] - paramInt3) * paramInt1 / 1024;
    arrayOfInt[1] -= (arrayOfInt[1] - paramInt4) * paramInt1 / 1024;
    arrayOfInt[2] -= paramInt1 * (arrayOfInt[2] - paramInt5) / 1024;
  }
  
  public byte[] b()
  {
    b();
    c();
    a();
    return a();
  }
  
  public void c()
  {
    int i = 0;
    while (i < 256)
    {
      int[][] arrayOfInt = this.jdField_a_of_type_Array2dOfInt;
      int[] arrayOfInt1 = arrayOfInt[i];
      arrayOfInt1[0] >>= 4;
      arrayOfInt1 = arrayOfInt[i];
      arrayOfInt1[1] >>= 4;
      arrayOfInt1 = arrayOfInt[i];
      arrayOfInt1[2] >>= 4;
      arrayOfInt[i][3] = i;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.NeuQuant
 * JD-Core Version:    0.7.0.1
 */
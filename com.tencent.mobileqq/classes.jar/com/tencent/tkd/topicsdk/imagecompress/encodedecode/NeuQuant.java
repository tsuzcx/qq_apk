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
      this.jdField_a_of_type_Array2dOfInt[paramInt1] = new int[4];
      paramArrayOfByte = this.jdField_a_of_type_Array2dOfInt[paramInt1];
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
    int k = this.jdField_a_of_type_ArrayOfInt[paramInt2];
    int m = k - 1;
    int j = 1000;
    int i = -1;
    int n;
    int[] arrayOfInt;
    int i1;
    if ((k < 256) || (m >= 0))
    {
      n = k;
      if (k >= 256) {
        break label407;
      }
      arrayOfInt = this.jdField_a_of_type_Array2dOfInt[k];
      i1 = arrayOfInt[1] - paramInt2;
      if (i1 >= j)
      {
        n = 256;
        k = i;
        i = n;
      }
    }
    for (;;)
    {
      n = m;
      if (m >= 0)
      {
        arrayOfInt = this.jdField_a_of_type_Array2dOfInt[m];
        i1 = paramInt2 - arrayOfInt[1];
        if (i1 >= j)
        {
          n = -1;
          m = k;
          k = i;
          i = m;
          m = n;
          break;
          k += 1;
          n = i1;
          if (i1 < 0) {
            n = -i1;
          }
          i2 = arrayOfInt[0] - paramInt1;
          i1 = i2;
          if (i2 < 0) {
            i1 = -i2;
          }
          i2 = i1 + n;
          n = k;
          if (i2 >= j) {
            break label407;
          }
          i1 = arrayOfInt[2] - paramInt3;
          n = i1;
          if (i1 < 0) {
            n = -i1;
          }
          i1 = i2 + n;
          n = k;
          if (i1 >= j) {
            break label407;
          }
          j = arrayOfInt[3];
          i = k;
          k = j;
          j = i1;
          continue;
        }
        m -= 1;
        n = i1;
        if (i1 < 0) {
          n = -i1;
        }
        int i2 = arrayOfInt[0] - paramInt1;
        i1 = i2;
        if (i2 < 0) {
          i1 = -i2;
        }
        i2 = i1 + n;
        n = m;
        if (i2 < j)
        {
          i1 = arrayOfInt[2] - paramInt3;
          n = i1;
          if (i1 < 0) {
            n = -i1;
          }
          i1 = n + i2;
          n = m;
          if (i1 < j)
          {
            j = arrayOfInt[3];
            n = i1;
            k = i;
            i = j;
            j = n;
            break;
            return i;
          }
        }
      }
      m = k;
      k = i;
      i = m;
      m = n;
      break;
      label407:
      k = i;
      i = n;
    }
  }
  
  public void a()
  {
    int i = 0;
    int k = 0;
    int j = 0;
    if (i < 256)
    {
      int[] arrayOfInt1 = this.jdField_a_of_type_Array2dOfInt[i];
      int m = arrayOfInt1[1];
      int n = i + 1;
      int i1 = i;
      while (n < 256)
      {
        arrayOfInt2 = this.jdField_a_of_type_Array2dOfInt[n];
        int i2 = m;
        if (arrayOfInt2[1] < m)
        {
          i2 = arrayOfInt2[1];
          i1 = n;
        }
        n += 1;
        m = i2;
      }
      int[] arrayOfInt2 = this.jdField_a_of_type_Array2dOfInt[i1];
      if (i != i1)
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
      if (m == j) {
        break label277;
      }
      this.jdField_a_of_type_ArrayOfInt[j] = (k + i >> 1);
      j += 1;
      while (j < m)
      {
        this.jdField_a_of_type_ArrayOfInt[j] = i;
        j += 1;
      }
      j = m;
      k = i;
    }
    label277:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_ArrayOfInt[j] = (k + 255 >> 1);
      i = j + 1;
      while (i < 256)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = 255;
        i += 1;
      }
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = paramInt2 - paramInt1;
    if (k < -1) {
      k = -1;
    }
    for (;;)
    {
      paramInt1 = paramInt2 + paramInt1;
      int m = paramInt1;
      if (paramInt1 > 256) {
        m = 256;
      }
      int j = paramInt2 - 1;
      paramInt1 = 1;
      int i = paramInt2 + 1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      Object localObject;
      int n;
      if ((paramInt1 < m) || (j > k))
      {
        localObject = this.d;
        i = paramInt2 + 1;
        n = localObject[paramInt2];
        if (paramInt1 >= m) {
          break label313;
        }
        localObject = this.jdField_a_of_type_Array2dOfInt;
        paramInt2 = paramInt1 + 1;
        localObject = localObject[paramInt1];
      }
      label307:
      label313:
      for (;;)
      {
        try
        {
          localObject[0] -= (localObject[0] - paramInt3) * n / 262144;
          localObject[1] -= (localObject[1] - paramInt4) * n / 262144;
          localObject[2] -= (localObject[2] - paramInt5) * n / 262144;
          paramInt1 = paramInt2;
          if (j <= k) {
            break label307;
          }
          localObject = this.jdField_a_of_type_Array2dOfInt;
          paramInt2 = j - 1;
          localObject = localObject[j];
        }
        catch (Exception localException1)
        {
          try
          {
            localObject[0] -= (localObject[0] - paramInt3) * n / 262144;
            localObject[1] -= (localObject[1] - paramInt4) * n / 262144;
            localObject[2] -= n * (localObject[2] - paramInt5) / 262144;
            j = paramInt2;
            paramInt2 = i;
          }
          catch (Exception localException2)
          {
            TLog.d("NeuQuant", localException2.toString());
            j = paramInt2;
            paramInt2 = i;
          }
          localException1 = localException1;
          TLog.d("NeuQuant", localException1.toString());
          paramInt1 = paramInt2;
          continue;
        }
        break;
        return;
        paramInt2 = i;
        break;
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
      arrayOfByte[j] = ((byte)this.jdField_a_of_type_Array2dOfInt[k][0]);
      int n = m + 1;
      arrayOfByte[m] = ((byte)this.jdField_a_of_type_Array2dOfInt[k][1]);
      j = n + 1;
      arrayOfByte[n] = ((byte)this.jdField_a_of_type_Array2dOfInt[k][2]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    int n = -1;
    int m = 2147483647;
    int[] arrayOfInt;
    int i2;
    int i1;
    if (i < 256)
    {
      arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
      i2 = arrayOfInt[0] - paramInt1;
      i1 = i2;
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
      i2 = i2 + i1 + i3;
      if (i2 >= m) {
        break label273;
      }
      m = i;
    }
    for (n = i2;; n = i1)
    {
      i1 = i2 - (this.jdField_b_of_type_ArrayOfInt[i] >> 12);
      if (i1 < j)
      {
        j = i1;
        k = i;
      }
      for (;;)
      {
        i1 = this.jdField_c_of_type_ArrayOfInt[i] >> 10;
        arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
        arrayOfInt[i] -= i1;
        arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        arrayOfInt[i] = ((i1 << 10) + arrayOfInt[i]);
        i += 1;
        i1 = n;
        n = m;
        m = i1;
        break;
        arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
        arrayOfInt[n] += 64;
        arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        arrayOfInt[n] -= 65536;
        return k;
      }
      label273:
      i1 = m;
      m = n;
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int < 1509) {
      this.jdField_c_of_type_Int = 1;
    }
    this.jdField_a_of_type_Int = ((this.jdField_c_of_type_Int - 1) / 3 + 30);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i4 = this.jdField_b_of_type_Int;
    int i5 = this.jdField_b_of_type_Int / (this.jdField_c_of_type_Int * 3);
    int k = i5 / 100;
    int i = 0;
    while (i < 32)
    {
      this.d[i] = ((1024 - i * i) * 256 / 1024 * 1024);
      i += 1;
    }
    int m;
    int i2;
    int n;
    int i1;
    label132:
    int i3;
    if (this.jdField_b_of_type_Int < 1509)
    {
      i = 3;
      m = 0;
      i2 = 32;
      n = 2048;
      int j = 0;
      i1 = 1024;
      if (m >= i5) {
        break label415;
      }
      i3 = (arrayOfByte[(j + 0)] & 0xFF) << 4;
      int i6 = (arrayOfByte[(j + 1)] & 0xFF) << 4;
      int i7 = (arrayOfByte[(j + 2)] & 0xFF) << 4;
      int i8 = b(i3, i6, i7);
      b(i1, i8, i3, i6, i7);
      if (i2 != 0) {
        a(i2, i8, i3, i6, i7);
      }
      j += i;
      if (j < i4) {
        break label441;
      }
      j -= this.jdField_b_of_type_Int;
    }
    label415:
    label441:
    for (;;)
    {
      i3 = m + 1;
      if (k == 0) {
        k = 1;
      }
      for (;;)
      {
        if (i3 % k == 0)
        {
          i1 -= i1 / this.jdField_a_of_type_Int;
          i2 = n - n / 30;
          n = i2 >> 6;
          m = n;
          if (n <= 1) {
            m = 0;
          }
          n = 0;
          for (;;)
          {
            if (n < m)
            {
              this.d[n] = ((m * m - n * n) * 256 / (m * m) * i1);
              n += 1;
              continue;
              if (this.jdField_b_of_type_Int % 499 != 0)
              {
                i = 1497;
                break;
              }
              if (this.jdField_b_of_type_Int % 491 != 0)
              {
                i = 1473;
                break;
              }
              if (this.jdField_b_of_type_Int % 487 != 0)
              {
                i = 1461;
                break;
              }
              i = 1509;
              break;
              return;
            }
          }
          n = i2;
          i2 = m;
          m = i3;
          break label132;
        }
        m = i3;
        break label132;
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[paramInt2];
    arrayOfInt[0] -= (arrayOfInt[0] - paramInt3) * paramInt1 / 1024;
    arrayOfInt[1] -= (arrayOfInt[1] - paramInt4) * paramInt1 / 1024;
    arrayOfInt[2] -= (arrayOfInt[2] - paramInt5) * paramInt1 / 1024;
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
      int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
      arrayOfInt[0] >>= 4;
      arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
      arrayOfInt[1] >>= 4;
      arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
      arrayOfInt[2] >>= 4;
      this.jdField_a_of_type_Array2dOfInt[i][3] = i;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.NeuQuant
 * JD-Core Version:    0.7.0.1
 */
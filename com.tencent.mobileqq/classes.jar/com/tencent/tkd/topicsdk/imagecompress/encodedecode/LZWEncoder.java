package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import java.io.OutputStream;

class LZWEncoder
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[256];
  int[] jdField_a_of_type_ArrayOfInt = new int[5003];
  int jdField_b_of_type_Int = 12;
  private byte[] jdField_b_of_type_ArrayOfByte;
  int[] jdField_b_of_type_ArrayOfInt = new int[5003];
  int jdField_c_of_type_Int;
  int[] jdField_c_of_type_ArrayOfInt = { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535 };
  int d = 4096;
  int e = 5003;
  int f = 0;
  int g;
  int h;
  int i;
  int j = 0;
  int k = 0;
  int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  LZWEncoder(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    this.o = Math.max(2, paramInt3);
  }
  
  private int a()
  {
    int i1 = this.p;
    if (i1 == 0) {
      return -1;
    }
    this.p = (i1 - 1);
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    i1 = this.q;
    this.q = (i1 + 1);
    return arrayOfByte[i1] & 0xFF;
  }
  
  final int a(int paramInt)
  {
    return (1 << paramInt) - 1;
  }
  
  void a(byte paramByte, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i1 = this.l;
    this.l = (i1 + 1);
    arrayOfByte[i1] = paramByte;
    if (this.l >= 254) {
      c(paramOutputStream);
    }
  }
  
  void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.jdField_a_of_type_ArrayOfInt[i1] = -1;
      i1 += 1;
    }
  }
  
  void a(int paramInt, OutputStream paramOutputStream)
  {
    this.g = paramInt;
    int i2 = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = this.g;
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_Int);
    this.h = (1 << paramInt - 1);
    paramInt = this.h;
    this.i = (paramInt + 1);
    this.f = (paramInt + 2);
    this.l = 0;
    paramInt = this.e;
    while (paramInt < 65536)
    {
      i2 += 1;
      paramInt *= 2;
    }
    int i6 = this.e;
    a(i6);
    b(this.h, paramOutputStream);
    paramInt = a();
    for (;;)
    {
      int i5 = a();
      if (i5 == -1) {
        break;
      }
      int i7 = (i5 << this.jdField_b_of_type_Int) + paramInt;
      int i1 = i5 << 8 - i2 ^ paramInt;
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (arrayOfInt[i1] == i7)
      {
        paramInt = this.jdField_b_of_type_ArrayOfInt[i1];
      }
      else
      {
        int i3 = i1;
        if (arrayOfInt[i1] >= 0)
        {
          i3 = i6 - i1;
          int i4 = i1;
          if (i1 == 0)
          {
            i3 = 1;
            i4 = i1;
          }
          do
          {
            i4 -= i3;
            i1 = i4;
            if (i4 < 0) {
              i1 = i4 + i6;
            }
            arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
            if (arrayOfInt[i1] == i7)
            {
              paramInt = this.jdField_b_of_type_ArrayOfInt[i1];
              break;
            }
            i4 = i1;
          } while (arrayOfInt[i1] >= 0);
          i3 = i1;
        }
        b(paramInt, paramOutputStream);
        paramInt = this.f;
        if (paramInt < this.d)
        {
          arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
          this.f = (paramInt + 1);
          arrayOfInt[i3] = paramInt;
          this.jdField_a_of_type_ArrayOfInt[i3] = i7;
        }
        else
        {
          a(paramOutputStream);
        }
        paramInt = i5;
      }
    }
    b(paramInt, paramOutputStream);
    b(this.i, paramOutputStream);
  }
  
  void a(OutputStream paramOutputStream)
  {
    a(this.e);
    int i1 = this.h;
    this.f = (i1 + 2);
    this.jdField_a_of_type_Boolean = true;
    b(i1, paramOutputStream);
  }
  
  void b(int paramInt, OutputStream paramOutputStream)
  {
    int i1 = this.j;
    int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
    int i2 = this.k;
    this.j = (i1 & arrayOfInt[i2]);
    if (i2 > 0) {
      this.j |= paramInt << i2;
    } else {
      this.j = paramInt;
    }
    for (this.k += this.jdField_a_of_type_Int; this.k >= 8; this.k -= 8)
    {
      a((byte)(this.j & 0xFF), paramOutputStream);
      this.j >>= 8;
    }
    if ((this.f > this.jdField_c_of_type_Int) || (this.jdField_a_of_type_Boolean)) {
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = this.g;
        this.jdField_a_of_type_Int = i1;
        this.jdField_c_of_type_Int = a(i1);
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_Int += 1;
        i1 = this.jdField_a_of_type_Int;
        if (i1 == this.jdField_b_of_type_Int) {
          this.jdField_c_of_type_Int = this.d;
        } else {
          this.jdField_c_of_type_Int = a(i1);
        }
      }
    }
    if (paramInt == this.i)
    {
      while (this.k > 0)
      {
        a((byte)(this.j & 0xFF), paramOutputStream);
        this.j >>= 8;
        this.k -= 8;
      }
      c(paramOutputStream);
    }
  }
  
  void b(OutputStream paramOutputStream)
  {
    paramOutputStream.write(this.o);
    this.p = (this.m * this.n);
    this.q = 0;
    a(this.o + 1, paramOutputStream);
    paramOutputStream.write(0);
  }
  
  void c(OutputStream paramOutputStream)
  {
    int i1 = this.l;
    if (i1 > 0)
    {
      paramOutputStream.write(i1);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte, 0, this.l);
      this.l = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.LZWEncoder
 * JD-Core Version:    0.7.0.1
 */
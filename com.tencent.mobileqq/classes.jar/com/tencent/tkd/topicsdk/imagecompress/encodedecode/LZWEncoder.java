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
    if (this.p == 0) {
      return -1;
    }
    this.p -= 1;
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    int i1 = this.q;
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
    int i2 = 0;
    this.g = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = this.g;
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_Int);
    this.h = (1 << paramInt - 1);
    this.i = (this.h + 1);
    this.f = (this.h + 2);
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
      int i3 = a();
      if (i3 == -1) {
        break;
      }
      int i7 = (i3 << this.jdField_b_of_type_Int) + paramInt;
      int i1 = i3 << 8 - i2 ^ paramInt;
      if (this.jdField_a_of_type_ArrayOfInt[i1] == i7)
      {
        paramInt = this.jdField_b_of_type_ArrayOfInt[i1];
      }
      else
      {
        int i4 = i1;
        if (this.jdField_a_of_type_ArrayOfInt[i1] >= 0)
        {
          i4 = i6 - i1;
          int i5 = i1;
          if (i1 == 0)
          {
            i4 = 1;
            i5 = i1;
          }
          do
          {
            i5 -= i4;
            i1 = i5;
            if (i5 < 0) {
              i1 = i5 + i6;
            }
            if (this.jdField_a_of_type_ArrayOfInt[i1] == i7)
            {
              paramInt = this.jdField_b_of_type_ArrayOfInt[i1];
              break;
            }
            i5 = i1;
          } while (this.jdField_a_of_type_ArrayOfInt[i1] >= 0);
          i4 = i1;
        }
        b(paramInt, paramOutputStream);
        if (this.f < this.d)
        {
          int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
          paramInt = this.f;
          this.f = (paramInt + 1);
          arrayOfInt[i4] = paramInt;
          this.jdField_a_of_type_ArrayOfInt[i4] = i7;
          paramInt = i3;
        }
        else
        {
          a(paramOutputStream);
          paramInt = i3;
        }
      }
    }
    b(paramInt, paramOutputStream);
    b(this.i, paramOutputStream);
  }
  
  void a(OutputStream paramOutputStream)
  {
    a(this.e);
    this.f = (this.h + 2);
    this.jdField_a_of_type_Boolean = true;
    b(this.h, paramOutputStream);
  }
  
  void b(int paramInt, OutputStream paramOutputStream)
  {
    this.j &= this.jdField_c_of_type_ArrayOfInt[this.k];
    if (this.k > 0) {}
    for (this.j |= paramInt << this.k;; this.j = paramInt) {
      for (this.k += this.jdField_a_of_type_Int; this.k >= 8; this.k -= 8)
      {
        a((byte)(this.j & 0xFF), paramOutputStream);
        this.j >>= 8;
      }
    }
    if ((this.f > this.jdField_c_of_type_Int) || (this.jdField_a_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label212;
      }
      int i1 = this.g;
      this.jdField_a_of_type_Int = i1;
      this.jdField_c_of_type_Int = a(i1);
      this.jdField_a_of_type_Boolean = false;
    }
    while (paramInt == this.i)
    {
      for (;;)
      {
        if (this.k > 0)
        {
          a((byte)(this.j & 0xFF), paramOutputStream);
          this.j >>= 8;
          this.k -= 8;
          continue;
          label212:
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int)
          {
            this.jdField_c_of_type_Int = this.d;
            break;
          }
          this.jdField_c_of_type_Int = a(this.jdField_a_of_type_Int);
          break;
        }
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
    if (this.l > 0)
    {
      paramOutputStream.write(this.l);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte, 0, this.l);
      this.l = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.LZWEncoder
 * JD-Core Version:    0.7.0.1
 */
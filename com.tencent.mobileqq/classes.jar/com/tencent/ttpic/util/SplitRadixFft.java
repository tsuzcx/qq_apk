package com.tencent.ttpic.util;

public class SplitRadixFft
{
  private static final int CDFT_RECURSIVE_N = 512;
  
  private final void bitrv2(int paramInt1, int[] paramArrayOfInt, int paramInt2, double[] paramArrayOfDouble)
  {
    paramArrayOfInt[(paramInt2 + 0)] = 0;
    int k = 1;
    int i = 1;
    int j = paramInt1;
    paramInt1 = i;
    int n;
    for (;;)
    {
      n = paramInt1 << 3;
      if (n >= j) {
        break;
      }
      j >>= 1;
      i = 0;
      while (i < paramInt1)
      {
        paramArrayOfInt[(paramInt2 + paramInt1 + i)] = (paramArrayOfInt[(paramInt2 + i)] + j);
        i += 1;
      }
      paramInt1 <<= 1;
    }
    int m = paramInt1 * 2;
    i = k;
    double d1;
    int i1;
    double d2;
    double d3;
    int i2;
    double d4;
    if (n == j)
    {
      i = 0;
      while (i < paramInt1)
      {
        j = 0;
        while (j < i)
        {
          k = j * 2 + paramArrayOfInt[(paramInt2 + i)];
          n = i * 2 + paramArrayOfInt[(paramInt2 + j)];
          d1 = paramArrayOfDouble[k];
          i1 = k + 1;
          d2 = paramArrayOfDouble[i1];
          d3 = paramArrayOfDouble[n];
          i2 = n + 1;
          d4 = paramArrayOfDouble[i2];
          paramArrayOfDouble[k] = d3;
          paramArrayOfDouble[i1] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i2] = d2;
          i1 = k + m;
          k = m * 2;
          n += k;
          d1 = paramArrayOfDouble[i1];
          i2 = i1 + 1;
          d2 = paramArrayOfDouble[i2];
          d3 = paramArrayOfDouble[n];
          int i3 = n + 1;
          d4 = paramArrayOfDouble[i3];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[i2] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i3] = d2;
          i1 += m;
          n -= m;
          d1 = paramArrayOfDouble[i1];
          i2 = i1 + 1;
          d2 = paramArrayOfDouble[i2];
          d3 = paramArrayOfDouble[n];
          i3 = n + 1;
          d4 = paramArrayOfDouble[i3];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[i2] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i3] = d2;
          i1 += m;
          k = n + k;
          d1 = paramArrayOfDouble[i1];
          n = i1 + 1;
          d2 = paramArrayOfDouble[n];
          d3 = paramArrayOfDouble[k];
          i2 = k + 1;
          d4 = paramArrayOfDouble[i2];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[n] = d4;
          paramArrayOfDouble[k] = d1;
          paramArrayOfDouble[i2] = d2;
          j += 1;
        }
        j = i * 2 + m + paramArrayOfInt[(paramInt2 + i)];
        k = j + m;
        d1 = paramArrayOfDouble[j];
        n = j + 1;
        d2 = paramArrayOfDouble[n];
        d3 = paramArrayOfDouble[k];
        i1 = k + 1;
        d4 = paramArrayOfDouble[i1];
        paramArrayOfDouble[j] = d3;
        paramArrayOfDouble[n] = d4;
        paramArrayOfDouble[k] = d1;
        paramArrayOfDouble[i1] = d2;
        i += 1;
      }
    }
    while (i < paramInt1)
    {
      j = 0;
      while (j < i)
      {
        n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
        k = i * 2 + paramArrayOfInt[(paramInt2 + j)];
        d1 = paramArrayOfDouble[n];
        i1 = n + 1;
        d2 = paramArrayOfDouble[i1];
        d3 = paramArrayOfDouble[k];
        i2 = k + 1;
        d4 = paramArrayOfDouble[i2];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[i1] = d4;
        paramArrayOfDouble[k] = d1;
        paramArrayOfDouble[i2] = d2;
        n += m;
        k += m;
        d1 = paramArrayOfDouble[n];
        i1 = n + 1;
        d2 = paramArrayOfDouble[i1];
        d3 = paramArrayOfDouble[k];
        i2 = k + 1;
        d4 = paramArrayOfDouble[i2];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[i1] = d4;
        paramArrayOfDouble[k] = d1;
        paramArrayOfDouble[i2] = d2;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void bitrv208(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[6];
    double d4 = paramArrayOfDouble[7];
    double d5 = paramArrayOfDouble[8];
    double d6 = paramArrayOfDouble[9];
    double d7 = paramArrayOfDouble[12];
    double d8 = paramArrayOfDouble[13];
    paramArrayOfDouble[2] = d5;
    paramArrayOfDouble[3] = d6;
    paramArrayOfDouble[6] = d7;
    paramArrayOfDouble[7] = d8;
    paramArrayOfDouble[8] = d1;
    paramArrayOfDouble[9] = d2;
    paramArrayOfDouble[12] = d3;
    paramArrayOfDouble[13] = d4;
  }
  
  private void bitrv208neg(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[12];
    double d12 = paramArrayOfDouble[13];
    double d13 = paramArrayOfDouble[14];
    double d14 = paramArrayOfDouble[15];
    paramArrayOfDouble[2] = d13;
    paramArrayOfDouble[3] = d14;
    paramArrayOfDouble[4] = d5;
    paramArrayOfDouble[5] = d6;
    paramArrayOfDouble[6] = d9;
    paramArrayOfDouble[7] = d10;
    paramArrayOfDouble[8] = d1;
    paramArrayOfDouble[9] = d2;
    paramArrayOfDouble[10] = d11;
    paramArrayOfDouble[11] = d12;
    paramArrayOfDouble[12] = d3;
    paramArrayOfDouble[13] = d4;
    paramArrayOfDouble[14] = d7;
    paramArrayOfDouble[15] = d8;
  }
  
  private void bitrv216(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[14];
    double d12 = paramArrayOfDouble[15];
    double d13 = paramArrayOfDouble[16];
    double d14 = paramArrayOfDouble[17];
    double d15 = paramArrayOfDouble[20];
    double d16 = paramArrayOfDouble[21];
    double d17 = paramArrayOfDouble[22];
    double d18 = paramArrayOfDouble[23];
    double d19 = paramArrayOfDouble[24];
    double d20 = paramArrayOfDouble[25];
    double d21 = paramArrayOfDouble[26];
    double d22 = paramArrayOfDouble[27];
    double d23 = paramArrayOfDouble[28];
    double d24 = paramArrayOfDouble[29];
    paramArrayOfDouble[2] = d13;
    paramArrayOfDouble[3] = d14;
    paramArrayOfDouble[4] = d7;
    paramArrayOfDouble[5] = d8;
    paramArrayOfDouble[6] = d19;
    paramArrayOfDouble[7] = d20;
    paramArrayOfDouble[8] = d3;
    paramArrayOfDouble[9] = d4;
    paramArrayOfDouble[10] = d15;
    paramArrayOfDouble[11] = d16;
    paramArrayOfDouble[14] = d23;
    paramArrayOfDouble[15] = d24;
    paramArrayOfDouble[16] = d1;
    paramArrayOfDouble[17] = d2;
    paramArrayOfDouble[20] = d9;
    paramArrayOfDouble[21] = d10;
    paramArrayOfDouble[22] = d21;
    paramArrayOfDouble[23] = d22;
    paramArrayOfDouble[24] = d5;
    paramArrayOfDouble[25] = d6;
    paramArrayOfDouble[26] = d17;
    paramArrayOfDouble[27] = d18;
    paramArrayOfDouble[28] = d11;
    paramArrayOfDouble[29] = d12;
  }
  
  private void bitrv216neg(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[12];
    double d12 = paramArrayOfDouble[13];
    double d13 = paramArrayOfDouble[14];
    double d14 = paramArrayOfDouble[15];
    double d15 = paramArrayOfDouble[16];
    double d16 = paramArrayOfDouble[17];
    double d17 = paramArrayOfDouble[18];
    double d18 = paramArrayOfDouble[19];
    double d19 = paramArrayOfDouble[20];
    double d20 = paramArrayOfDouble[21];
    double d21 = paramArrayOfDouble[22];
    double d22 = paramArrayOfDouble[23];
    double d23 = paramArrayOfDouble[24];
    double d24 = paramArrayOfDouble[25];
    double d25 = paramArrayOfDouble[26];
    double d26 = paramArrayOfDouble[27];
    double d27 = paramArrayOfDouble[28];
    double d28 = paramArrayOfDouble[29];
    double d29 = paramArrayOfDouble[30];
    double d30 = paramArrayOfDouble[31];
    paramArrayOfDouble[2] = d29;
    paramArrayOfDouble[3] = d30;
    paramArrayOfDouble[4] = d13;
    paramArrayOfDouble[5] = d14;
    paramArrayOfDouble[6] = d21;
    paramArrayOfDouble[7] = d22;
    paramArrayOfDouble[8] = d5;
    paramArrayOfDouble[9] = d6;
    paramArrayOfDouble[10] = d25;
    paramArrayOfDouble[11] = d26;
    paramArrayOfDouble[12] = d9;
    paramArrayOfDouble[13] = d10;
    paramArrayOfDouble[14] = d17;
    paramArrayOfDouble[15] = d18;
    paramArrayOfDouble[16] = d1;
    paramArrayOfDouble[17] = d2;
    paramArrayOfDouble[18] = d27;
    paramArrayOfDouble[19] = d28;
    paramArrayOfDouble[20] = d11;
    paramArrayOfDouble[21] = d12;
    paramArrayOfDouble[22] = d19;
    paramArrayOfDouble[23] = d20;
    paramArrayOfDouble[24] = d3;
    paramArrayOfDouble[25] = d4;
    paramArrayOfDouble[26] = d23;
    paramArrayOfDouble[27] = d24;
    paramArrayOfDouble[28] = d7;
    paramArrayOfDouble[29] = d8;
    paramArrayOfDouble[30] = d15;
    paramArrayOfDouble[31] = d16;
  }
  
  private final void bitrv2conj(int paramInt1, int[] paramArrayOfInt, int paramInt2, double[] paramArrayOfDouble)
  {
    paramArrayOfInt[(paramInt2 + 0)] = 0;
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      j = paramInt1 << 3;
      if (j >= i) {
        break;
      }
      j = i >> 1;
      i = 0;
      while (i < paramInt1)
      {
        paramArrayOfInt[(paramInt2 + paramInt1 + i)] = (paramArrayOfInt[(paramInt2 + i)] + j);
        i += 1;
      }
      paramInt1 <<= 1;
      i = j;
    }
    int k = paramInt1 * 2;
    int m;
    int n;
    double d1;
    int i1;
    double d2;
    double d3;
    int i2;
    double d4;
    if (j == i)
    {
      i = 0;
      while (i < paramInt1)
      {
        j = 0;
        while (j < i)
        {
          m = j * 2 + paramArrayOfInt[(paramInt2 + i)];
          n = i * 2 + paramArrayOfInt[(paramInt2 + j)];
          d1 = paramArrayOfDouble[m];
          i1 = m + 1;
          d2 = -paramArrayOfDouble[i1];
          d3 = paramArrayOfDouble[n];
          i2 = n + 1;
          d4 = -paramArrayOfDouble[i2];
          paramArrayOfDouble[m] = d3;
          paramArrayOfDouble[i1] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i2] = d2;
          i1 = m + k;
          m = k * 2;
          n += m;
          d1 = paramArrayOfDouble[i1];
          i2 = i1 + 1;
          d2 = -paramArrayOfDouble[i2];
          d3 = paramArrayOfDouble[n];
          int i3 = n + 1;
          d4 = -paramArrayOfDouble[i3];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[i2] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i3] = d2;
          i1 += k;
          n -= k;
          d1 = paramArrayOfDouble[i1];
          i2 = i1 + 1;
          d2 = -paramArrayOfDouble[i2];
          d3 = paramArrayOfDouble[n];
          i3 = n + 1;
          d4 = -paramArrayOfDouble[i3];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[i2] = d4;
          paramArrayOfDouble[n] = d1;
          paramArrayOfDouble[i3] = d2;
          i1 += k;
          m = n + m;
          d1 = paramArrayOfDouble[i1];
          n = i1 + 1;
          d2 = -paramArrayOfDouble[n];
          d3 = paramArrayOfDouble[m];
          i2 = m + 1;
          d4 = -paramArrayOfDouble[i2];
          paramArrayOfDouble[i1] = d3;
          paramArrayOfDouble[n] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[i2] = d2;
          j += 1;
        }
        j = i * 2 + paramArrayOfInt[(paramInt2 + i)];
        m = j + 1;
        paramArrayOfDouble[m] = (-paramArrayOfDouble[m]);
        j += k;
        m = j + k;
        d1 = paramArrayOfDouble[j];
        n = j + 1;
        d2 = -paramArrayOfDouble[n];
        d3 = paramArrayOfDouble[m];
        i1 = m + 1;
        d4 = -paramArrayOfDouble[i1];
        paramArrayOfDouble[j] = d3;
        paramArrayOfDouble[n] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[i1] = d2;
        j = m + k + 1;
        paramArrayOfDouble[j] = (-paramArrayOfDouble[j]);
        i += 1;
      }
    }
    paramArrayOfDouble[1] = (-paramArrayOfDouble[1]);
    i = k + 1;
    paramArrayOfDouble[i] = (-paramArrayOfDouble[i]);
    i = 1;
    while (i < paramInt1)
    {
      j = 0;
      while (j < i)
      {
        n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
        m = i * 2 + paramArrayOfInt[(paramInt2 + j)];
        d1 = paramArrayOfDouble[n];
        i1 = n + 1;
        d2 = -paramArrayOfDouble[i1];
        d3 = paramArrayOfDouble[m];
        i2 = m + 1;
        d4 = -paramArrayOfDouble[i2];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[i1] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[i2] = d2;
        n += k;
        m += k;
        d1 = paramArrayOfDouble[n];
        i1 = n + 1;
        d2 = -paramArrayOfDouble[i1];
        d3 = paramArrayOfDouble[m];
        i2 = m + 1;
        d4 = -paramArrayOfDouble[i2];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[i1] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[i2] = d2;
        j += 1;
      }
      j = i * 2 + paramArrayOfInt[(paramInt2 + i)];
      m = j + 1;
      paramArrayOfDouble[m] = (-paramArrayOfDouble[m]);
      j = j + k + 1;
      paramArrayOfDouble[j] = (-paramArrayOfDouble[j]);
      i += 1;
    }
  }
  
  private void cftb040(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0] + paramArrayOfDouble[4];
    double d2 = paramArrayOfDouble[1] + paramArrayOfDouble[5];
    double d3 = paramArrayOfDouble[0] - paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[1] - paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[2] + paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[3] + paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[2] - paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[3] - paramArrayOfDouble[7];
    paramArrayOfDouble[0] = (d1 + d5);
    paramArrayOfDouble[1] = (d2 + d6);
    paramArrayOfDouble[4] = (d1 - d5);
    paramArrayOfDouble[5] = (d2 - d6);
    paramArrayOfDouble[2] = (d3 + d8);
    paramArrayOfDouble[3] = (d4 - d7);
    paramArrayOfDouble[6] = (d3 - d8);
    paramArrayOfDouble[7] = (d4 + d7);
  }
  
  private final void cftb1st(int paramInt1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt2)
  {
    paramInt1 >>= 3;
    int i = paramInt1 * 2;
    int j = i + i;
    int m = j + i;
    int k = 0;
    double d1 = paramArrayOfDouble1[0] + paramArrayOfDouble1[j];
    double d2 = -paramArrayOfDouble1[1];
    int n = j + 1;
    d2 -= paramArrayOfDouble1[n];
    double d3 = paramArrayOfDouble1[0] - paramArrayOfDouble1[j];
    double d4 = -paramArrayOfDouble1[1] + paramArrayOfDouble1[n];
    double d5 = paramArrayOfDouble1[i] + paramArrayOfDouble1[m];
    int i1 = i + 1;
    double d6 = paramArrayOfDouble1[i1];
    int i2 = m + 1;
    d6 += paramArrayOfDouble1[i2];
    double d7 = paramArrayOfDouble1[i] - paramArrayOfDouble1[m];
    double d8 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    paramArrayOfDouble1[0] = (d1 + d5);
    paramArrayOfDouble1[1] = (d2 - d6);
    paramArrayOfDouble1[i] = (d1 - d5);
    paramArrayOfDouble1[i1] = (d2 + d6);
    paramArrayOfDouble1[j] = (d3 + d8);
    paramArrayOfDouble1[n] = (d4 + d7);
    paramArrayOfDouble1[m] = (d3 - d8);
    paramArrayOfDouble1[i2] = (d4 - d7);
    d1 = paramArrayOfDouble2[(paramInt2 + 1)];
    d3 = paramArrayOfDouble2[(paramInt2 + 2)];
    d2 = paramArrayOfDouble2[(paramInt2 + 3)];
    d6 = 0.0D;
    d7 = 1.0D;
    j = 2;
    d4 = 0.0D;
    d5 = 1.0D;
    for (;;)
    {
      m = paramInt1 - 2;
      if (j >= m) {
        break;
      }
      k += 4;
      m = paramInt2 + k;
      d10 = (d7 + paramArrayOfDouble2[m]) * d3;
      n = m + 1;
      d11 = (d6 + paramArrayOfDouble2[n]) * d3;
      i1 = m + 2;
      d7 = (d5 + paramArrayOfDouble2[i1]) * d2;
      i2 = m + 3;
      d9 = (d4 - paramArrayOfDouble2[i2]) * d2;
      d4 = paramArrayOfDouble2[m];
      d6 = paramArrayOfDouble2[n];
      d5 = paramArrayOfDouble2[i1];
      d8 = -paramArrayOfDouble2[i2];
      m = j + i;
      n = m + i;
      i1 = n + i;
      double d18 = paramArrayOfDouble1[j] + paramArrayOfDouble1[n];
      i2 = j + 1;
      d12 = -paramArrayOfDouble1[i2];
      i3 = n + 1;
      double d21 = d12 - paramArrayOfDouble1[i3];
      double d14 = paramArrayOfDouble1[j] - paramArrayOfDouble1[n];
      d12 = -paramArrayOfDouble1[i2] + paramArrayOfDouble1[i3];
      i4 = j + 2;
      d13 = paramArrayOfDouble1[i4];
      i5 = n + 2;
      double d22 = d13 + paramArrayOfDouble1[i5];
      int i6 = j + 3;
      d13 = -paramArrayOfDouble1[i6];
      int i7 = n + 3;
      double d23 = d13 - paramArrayOfDouble1[i7];
      double d15 = paramArrayOfDouble1[i4] - paramArrayOfDouble1[i5];
      d13 = -paramArrayOfDouble1[i6] + paramArrayOfDouble1[i7];
      double d24 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      int i8 = m + 1;
      double d16 = paramArrayOfDouble1[i8];
      int i9 = i1 + 1;
      double d25 = d16 + paramArrayOfDouble1[i9];
      d16 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      double d19 = paramArrayOfDouble1[i8] - paramArrayOfDouble1[i9];
      int i10 = m + 2;
      double d17 = paramArrayOfDouble1[i10];
      int i11 = i1 + 2;
      double d26 = d17 + paramArrayOfDouble1[i11];
      int i12 = m + 3;
      d17 = paramArrayOfDouble1[i12];
      int i13 = i1 + 3;
      double d27 = d17 + paramArrayOfDouble1[i13];
      d17 = paramArrayOfDouble1[i10] - paramArrayOfDouble1[i11];
      double d20 = paramArrayOfDouble1[i12] - paramArrayOfDouble1[i13];
      paramArrayOfDouble1[j] = (d18 + d24);
      paramArrayOfDouble1[i2] = (d21 - d25);
      paramArrayOfDouble1[i4] = (d22 + d26);
      paramArrayOfDouble1[i6] = (d23 - d27);
      paramArrayOfDouble1[m] = (d18 - d24);
      paramArrayOfDouble1[i8] = (d21 + d25);
      paramArrayOfDouble1[i10] = (d22 - d26);
      paramArrayOfDouble1[i12] = (d23 + d27);
      d18 = d14 + d19;
      d21 = d12 + d16;
      paramArrayOfDouble1[n] = (d10 * d18 - d11 * d21);
      paramArrayOfDouble1[i3] = (d21 * d10 + d18 * d11);
      d18 = d15 + d20;
      d21 = d13 + d17;
      paramArrayOfDouble1[i5] = (d4 * d18 - d6 * d21);
      paramArrayOfDouble1[i7] = (d21 * d4 + d18 * d6);
      d14 -= d19;
      d12 -= d16;
      paramArrayOfDouble1[i1] = (d7 * d14 + d9 * d12);
      paramArrayOfDouble1[i9] = (d12 * d7 - d14 * d9);
      d12 = d15 - d20;
      d13 -= d17;
      paramArrayOfDouble1[i11] = (d5 * d12 + d8 * d13);
      paramArrayOfDouble1[i13] = (d13 * d5 - d8 * d12);
      m = i - j;
      n = m + i;
      i1 = n + i;
      i2 = i1 + i;
      d18 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      i3 = m + 1;
      d12 = -paramArrayOfDouble1[i3];
      i4 = i1 + 1;
      d21 = d12 - paramArrayOfDouble1[i4];
      d14 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      d12 = -paramArrayOfDouble1[i3] + paramArrayOfDouble1[i4];
      i5 = m - 2;
      d13 = paramArrayOfDouble1[i5];
      i6 = i1 - 2;
      d22 = d13 + paramArrayOfDouble1[i6];
      i7 = m - 1;
      d13 = -paramArrayOfDouble1[i7];
      i8 = i1 - 1;
      d23 = d13 - paramArrayOfDouble1[i8];
      d15 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
      d13 = -paramArrayOfDouble1[i7] + paramArrayOfDouble1[i8];
      d24 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      i9 = n + 1;
      d16 = paramArrayOfDouble1[i9];
      i10 = i2 + 1;
      d25 = d16 + paramArrayOfDouble1[i10];
      d16 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i2];
      d19 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[i10];
      i11 = n - 2;
      d17 = paramArrayOfDouble1[i11];
      i12 = i2 - 2;
      d26 = d17 + paramArrayOfDouble1[i12];
      i13 = n - 1;
      d17 = paramArrayOfDouble1[i13];
      int i14 = i2 - 1;
      d27 = d17 + paramArrayOfDouble1[i14];
      d17 = paramArrayOfDouble1[i11] - paramArrayOfDouble1[i12];
      d20 = paramArrayOfDouble1[i13] - paramArrayOfDouble1[i14];
      paramArrayOfDouble1[m] = (d18 + d24);
      paramArrayOfDouble1[i3] = (d21 - d25);
      paramArrayOfDouble1[i5] = (d22 + d26);
      paramArrayOfDouble1[i7] = (d23 - d27);
      paramArrayOfDouble1[n] = (d18 - d24);
      paramArrayOfDouble1[i9] = (d21 + d25);
      paramArrayOfDouble1[i11] = (d22 - d26);
      paramArrayOfDouble1[i13] = (d23 + d27);
      d18 = d14 + d19;
      d21 = d12 + d16;
      paramArrayOfDouble1[i1] = (d11 * d18 - d10 * d21);
      paramArrayOfDouble1[i4] = (d21 * d11 + d10 * d18);
      d10 = d15 + d20;
      d11 = d13 + d17;
      paramArrayOfDouble1[i6] = (d6 * d10 - d4 * d11);
      paramArrayOfDouble1[i8] = (d11 * d6 + d10 * d4);
      d10 = d14 - d19;
      d11 = d12 - d16;
      paramArrayOfDouble1[i2] = (d9 * d10 + d7 * d11);
      paramArrayOfDouble1[i10] = (d9 * d11 - d7 * d10);
      d7 = d15 - d20;
      d9 = d13 - d17;
      paramArrayOfDouble1[i12] = (d8 * d7 + d5 * d9);
      paramArrayOfDouble1[i14] = (d8 * d9 - d7 * d5);
      j += 4;
      d7 = d4;
      d4 = d8;
    }
    d7 = d3 * (d7 + d1);
    d6 = d3 * (d6 + d1);
    d3 = d2 * (d5 - d1);
    d2 *= (d4 - d1);
    paramInt2 = paramInt1 + i;
    j = paramInt2 + i;
    i = j + i;
    d4 = paramArrayOfDouble1[m];
    k = j - 2;
    d8 = d4 + paramArrayOfDouble1[k];
    n = paramInt1 - 1;
    d4 = -paramArrayOfDouble1[n];
    i1 = j - 1;
    double d10 = d4 - paramArrayOfDouble1[i1];
    d5 = paramArrayOfDouble1[m] - paramArrayOfDouble1[k];
    d4 = -paramArrayOfDouble1[n] + paramArrayOfDouble1[i1];
    i2 = paramInt2 - 2;
    double d9 = paramArrayOfDouble1[i2];
    int i3 = i - 2;
    double d12 = d9 + paramArrayOfDouble1[i3];
    int i4 = paramInt2 - 1;
    d9 = paramArrayOfDouble1[i4];
    int i5 = i - 1;
    double d13 = d9 + paramArrayOfDouble1[i5];
    d9 = paramArrayOfDouble1[i2] - paramArrayOfDouble1[i3];
    double d11 = paramArrayOfDouble1[i4] - paramArrayOfDouble1[i5];
    paramArrayOfDouble1[m] = (d8 + d12);
    paramArrayOfDouble1[n] = (d10 - d13);
    paramArrayOfDouble1[i2] = (d8 - d12);
    paramArrayOfDouble1[i4] = (d10 + d13);
    d8 = d5 + d11;
    d10 = d4 + d9;
    paramArrayOfDouble1[k] = (d7 * d8 - d6 * d10);
    paramArrayOfDouble1[i1] = (d10 * d7 + d8 * d6);
    d5 -= d11;
    d4 -= d9;
    paramArrayOfDouble1[i3] = (d3 * d5 + d2 * d4);
    paramArrayOfDouble1[i5] = (d4 * d3 - d2 * d5);
    d9 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[j];
    k = paramInt1 + 1;
    d4 = -paramArrayOfDouble1[k];
    m = j + 1;
    d11 = d4 - paramArrayOfDouble1[m];
    d5 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[j];
    d4 = -paramArrayOfDouble1[k] + paramArrayOfDouble1[m];
    d12 = paramArrayOfDouble1[paramInt2] + paramArrayOfDouble1[i];
    n = paramInt2 + 1;
    d8 = paramArrayOfDouble1[n];
    i1 = i + 1;
    d13 = d8 + paramArrayOfDouble1[i1];
    d8 = paramArrayOfDouble1[paramInt2] - paramArrayOfDouble1[i];
    d10 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i1];
    paramArrayOfDouble1[paramInt1] = (d9 + d12);
    paramArrayOfDouble1[k] = (d11 - d13);
    paramArrayOfDouble1[paramInt2] = (d9 - d12);
    paramArrayOfDouble1[n] = (d11 + d13);
    d9 = d5 + d10;
    d11 = d4 + d8;
    paramArrayOfDouble1[j] = ((d9 - d11) * d1);
    paramArrayOfDouble1[m] = (d1 * (d11 + d9));
    d5 -= d10;
    d4 -= d8;
    d1 = -d1;
    paramArrayOfDouble1[i] = ((d5 + d4) * d1);
    paramArrayOfDouble1[i1] = (d1 * (d4 - d5));
    k = paramInt1 + 2;
    d1 = paramArrayOfDouble1[k];
    m = j + 2;
    d5 = d1 + paramArrayOfDouble1[m];
    paramInt1 += 3;
    d1 = -paramArrayOfDouble1[paramInt1];
    j += 3;
    d9 = d1 - paramArrayOfDouble1[j];
    d4 = paramArrayOfDouble1[k] - paramArrayOfDouble1[m];
    d1 = -paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[j];
    n = paramInt2 + 2;
    d8 = paramArrayOfDouble1[n];
    i1 = i + 2;
    d11 = d8 + paramArrayOfDouble1[i1];
    paramInt2 += 3;
    d8 = paramArrayOfDouble1[paramInt2];
    i += 3;
    d12 = d8 + paramArrayOfDouble1[i];
    d8 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i1];
    d10 = paramArrayOfDouble1[paramInt2] - paramArrayOfDouble1[i];
    paramArrayOfDouble1[k] = (d5 + d11);
    paramArrayOfDouble1[paramInt1] = (d9 - d12);
    paramArrayOfDouble1[n] = (d5 - d11);
    paramArrayOfDouble1[paramInt2] = (d9 + d12);
    d5 = d4 + d10;
    d9 = d1 + d8;
    paramArrayOfDouble1[m] = (d6 * d5 - d7 * d9);
    paramArrayOfDouble1[j] = (d6 * d9 + d7 * d5);
    d4 -= d10;
    d1 -= d8;
    paramArrayOfDouble1[i1] = (d2 * d4 + d3 * d1);
    paramArrayOfDouble1[i] = (d2 * d1 - d3 * d4);
  }
  
  private void cftbsub(int paramInt1, double[] paramArrayOfDouble1, int[] paramArrayOfInt, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 > 32)
    {
      int i = paramInt1 >> 2;
      cftb1st(paramInt1, paramArrayOfDouble1, paramArrayOfDouble2, paramInt3 - i);
      if (paramInt1 > 512)
      {
        cftrec1(i, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        cftrec2(i, paramArrayOfDouble1, i, paramInt3, paramArrayOfDouble2);
        cftrec1(i, paramArrayOfDouble1, i * 2, paramInt3, paramArrayOfDouble2);
        cftrec1(i, paramArrayOfDouble1, i * 3, paramInt3, paramArrayOfDouble2);
      }
      for (;;)
      {
        break;
        if (i > 32) {
          cftexp1(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        } else {
          cftfx41(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        }
      }
      bitrv2conj(paramInt1, paramArrayOfInt, paramInt2, paramArrayOfDouble1);
      return;
    }
    if (paramInt1 > 8)
    {
      if (paramInt1 == 32)
      {
        cftf161(paramArrayOfDouble1, 0, paramArrayOfDouble2, paramInt3 - 8);
        bitrv216neg(paramArrayOfDouble1);
        return;
      }
      cftf081(paramArrayOfDouble1, 0, paramArrayOfDouble2, 0);
      bitrv208neg(paramArrayOfDouble1);
      return;
    }
    if (paramInt1 == 8)
    {
      cftb040(paramArrayOfDouble1);
      return;
    }
    if (paramInt1 == 4) {
      cftx020(paramArrayOfDouble1);
    }
  }
  
  private void cftexp1(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    int k;
    int m;
    while (i > 128)
    {
      j = i;
      while (j < paramInt1)
      {
        k = j - i;
        while (k < paramInt1)
        {
          m = paramInt3 - (i >> 1);
          cftmdl1(i, paramArrayOfDouble1, paramInt2 + k, paramArrayOfDouble2, m);
          cftmdl2(i, paramArrayOfDouble1, paramInt2 + j + k, paramArrayOfDouble2, paramInt3 - i);
          cftmdl1(i, paramArrayOfDouble1, paramInt2 + j * 2 + k, paramArrayOfDouble2, m);
          k += j * 4;
        }
        j <<= 2;
      }
      cftmdl1(i, paramArrayOfDouble1, paramInt2 + paramInt1 - i, paramArrayOfDouble2, paramInt3 - (i >> 1));
      i >>= 2;
    }
    int j = i;
    while (j < paramInt1)
    {
      k = j - i;
      while (k < paramInt1)
      {
        int n = paramInt2 + k;
        m = paramInt3 - (i >> 1);
        cftmdl1(i, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx41(i, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        n = paramInt2 + j + k;
        cftmdl2(i, paramArrayOfDouble1, n, paramArrayOfDouble2, paramInt3 - i);
        cftfx42(i, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        n = paramInt2 + j * 2 + k;
        cftmdl1(i, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx41(i, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        k += j * 4;
      }
      j <<= 2;
    }
    paramInt1 = paramInt2 + paramInt1 - i;
    cftmdl1(i, paramArrayOfDouble1, paramInt1, paramArrayOfDouble2, paramInt3 - (i >> 1));
    cftfx41(i, paramArrayOfDouble1, paramInt1, paramInt3, paramArrayOfDouble2);
  }
  
  private void cftexp2(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int k = paramInt1 >> 1;
    paramInt1 >>= 2;
    int j;
    int m;
    while (paramInt1 > 128)
    {
      i = paramInt1;
      while (i < k)
      {
        j = i - paramInt1;
        while (j < k)
        {
          m = paramInt3 - (paramInt1 >> 1);
          cftmdl1(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, m);
          cftmdl1(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, m);
          j += i * 2;
        }
        j = i * 2 - paramInt1;
        while (j < k)
        {
          m = paramInt3 - paramInt1;
          cftmdl2(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, m);
          cftmdl2(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, m);
          j += i * 4;
        }
        i <<= 2;
      }
      paramInt1 >>= 2;
    }
    int i = paramInt1;
    while (i < k)
    {
      j = i - paramInt1;
      int n;
      while (j < k)
      {
        n = paramInt2 + j;
        m = paramInt3 - (paramInt1 >> 1);
        cftmdl1(paramInt1, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx41(paramInt1, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        n = paramInt2 + k + j;
        cftmdl1(paramInt1, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx41(paramInt1, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        j += i * 2;
      }
      j = i * 2 - paramInt1;
      while (j < k)
      {
        n = paramInt2 + j;
        m = paramInt3 - paramInt1;
        cftmdl2(paramInt1, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx42(paramInt1, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        n = paramInt2 + k + j;
        cftmdl2(paramInt1, paramArrayOfDouble1, n, paramArrayOfDouble2, m);
        cftfx42(paramInt1, paramArrayOfDouble1, n, paramInt3, paramArrayOfDouble2);
        j += i * 4;
      }
      i <<= 2;
    }
  }
  
  private void cftf040(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0] + paramArrayOfDouble[4];
    double d2 = paramArrayOfDouble[1] + paramArrayOfDouble[5];
    double d3 = paramArrayOfDouble[0] - paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[1] - paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[2] + paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[3] + paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[2] - paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[3] - paramArrayOfDouble[7];
    paramArrayOfDouble[0] = (d1 + d5);
    paramArrayOfDouble[1] = (d2 + d6);
    paramArrayOfDouble[4] = (d1 - d5);
    paramArrayOfDouble[5] = (d2 - d6);
    paramArrayOfDouble[2] = (d3 - d8);
    paramArrayOfDouble[3] = (d4 + d7);
    paramArrayOfDouble[6] = (d3 + d8);
    paramArrayOfDouble[7] = (d4 - d7);
  }
  
  private void cftf081(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d1 = paramArrayOfDouble2[(paramInt2 + 1)];
    paramInt2 = paramInt1 + 0;
    double d2 = paramArrayOfDouble1[paramInt2];
    int i = paramInt1 + 8;
    double d4 = d2 + paramArrayOfDouble1[i];
    int j = paramInt1 + 1;
    d2 = paramArrayOfDouble1[j];
    int k = paramInt1 + 9;
    double d5 = d2 + paramArrayOfDouble1[k];
    double d8 = paramArrayOfDouble1[paramInt2] - paramArrayOfDouble1[i];
    double d9 = paramArrayOfDouble1[j] - paramArrayOfDouble1[k];
    int m = paramInt1 + 4;
    d2 = paramArrayOfDouble1[m];
    int n = paramInt1 + 12;
    double d6 = d2 + paramArrayOfDouble1[n];
    int i1 = paramInt1 + 5;
    d2 = paramArrayOfDouble1[i1];
    int i2 = paramInt1 + 13;
    double d7 = d2 + paramArrayOfDouble1[i2];
    double d10 = paramArrayOfDouble1[m] - paramArrayOfDouble1[n];
    double d11 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    d2 = d4 + d6;
    double d3 = d5 + d7;
    d4 -= d6;
    d5 -= d7;
    d6 = d8 - d11;
    d7 = d9 + d10;
    d8 += d11;
    d9 -= d10;
    int i3 = paramInt1 + 2;
    d10 = paramArrayOfDouble1[i3];
    int i4 = paramInt1 + 10;
    double d12 = d10 + paramArrayOfDouble1[i4];
    int i5 = paramInt1 + 3;
    d10 = paramArrayOfDouble1[i5];
    int i6 = paramInt1 + 11;
    double d15 = d10 + paramArrayOfDouble1[i6];
    double d14 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
    double d13 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
    int i7 = paramInt1 + 6;
    d10 = paramArrayOfDouble1[i7];
    int i8 = paramInt1 + 14;
    double d18 = d10 + paramArrayOfDouble1[i8];
    int i9 = paramInt1 + 7;
    d10 = paramArrayOfDouble1[i9];
    paramInt1 += 15;
    double d19 = d10 + paramArrayOfDouble1[paramInt1];
    double d16 = paramArrayOfDouble1[i7] - paramArrayOfDouble1[i8];
    double d17 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[paramInt1];
    d10 = d12 + d18;
    d11 = d15 + d19;
    d12 -= d18;
    d15 -= d19;
    d18 = d14 - d17;
    d19 = d13 + d16;
    d14 += d17;
    d16 = d13 - d16;
    d13 = (d18 - d19) * d1;
    d17 = (d18 + d19) * d1;
    d18 = (d14 - d16) * d1;
    d1 *= (d14 + d16);
    paramArrayOfDouble1[i] = (d6 + d13);
    paramArrayOfDouble1[k] = (d7 + d17);
    paramArrayOfDouble1[i4] = (d6 - d13);
    paramArrayOfDouble1[i6] = (d7 - d17);
    paramArrayOfDouble1[n] = (d8 - d1);
    paramArrayOfDouble1[i2] = (d9 + d18);
    paramArrayOfDouble1[i8] = (d8 + d1);
    paramArrayOfDouble1[paramInt1] = (d9 - d18);
    paramArrayOfDouble1[paramInt2] = (d2 + d10);
    paramArrayOfDouble1[j] = (d3 + d11);
    paramArrayOfDouble1[i3] = (d2 - d10);
    paramArrayOfDouble1[i5] = (d3 - d11);
    paramArrayOfDouble1[m] = (d4 - d15);
    paramArrayOfDouble1[i1] = (d5 + d12);
    paramArrayOfDouble1[i7] = (d4 + d15);
    paramArrayOfDouble1[i9] = (d5 - d12);
  }
  
  private void cftf082(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d6 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d10 = paramArrayOfDouble2[(paramInt2 + 4)];
    double d11 = paramArrayOfDouble2[(paramInt2 + 5)];
    paramInt2 = paramInt1 + 0;
    double d1 = paramArrayOfDouble1[paramInt2];
    int i = paramInt1 + 9;
    double d4 = d1 - paramArrayOfDouble1[i];
    int j = paramInt1 + 1;
    d1 = paramArrayOfDouble1[j];
    int k = paramInt1 + 8;
    double d5 = d1 + paramArrayOfDouble1[k];
    double d2 = paramArrayOfDouble1[paramInt2] + paramArrayOfDouble1[i];
    d1 = paramArrayOfDouble1[j] - paramArrayOfDouble1[k];
    int m = paramInt1 + 4;
    double d3 = paramArrayOfDouble1[m];
    int n = paramInt1 + 13;
    d3 -= paramArrayOfDouble1[n];
    int i1 = paramInt1 + 5;
    double d7 = paramArrayOfDouble1[i1];
    int i2 = paramInt1 + 12;
    d7 += paramArrayOfDouble1[i2];
    double d8 = (d3 - d7) * d6;
    double d12 = (d7 + d3) * d6;
    d7 = paramArrayOfDouble1[m] + paramArrayOfDouble1[n];
    double d9 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    d3 = (d7 - d9) * d6;
    d6 *= (d9 + d7);
    int i3 = paramInt1 + 2;
    d7 = paramArrayOfDouble1[i3];
    int i4 = paramInt1 + 11;
    d7 -= paramArrayOfDouble1[i4];
    int i5 = paramInt1 + 3;
    d9 = paramArrayOfDouble1[i5];
    int i6 = paramInt1 + 10;
    d9 += paramArrayOfDouble1[i6];
    double d13 = d10 * d7 - d11 * d9;
    double d15 = d9 * d10 + d7 * d11;
    d9 = paramArrayOfDouble1[i3] + paramArrayOfDouble1[i4];
    double d14 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
    d7 = d11 * d9 - d10 * d14;
    d9 = d14 * d11 + d9 * d10;
    int i7 = paramInt1 + 6;
    d14 = paramArrayOfDouble1[i7];
    int i8 = paramInt1 + 15;
    d14 -= paramArrayOfDouble1[i8];
    int i9 = paramInt1 + 7;
    double d16 = paramArrayOfDouble1[i9];
    paramInt1 += 14;
    double d17 = d16 + paramArrayOfDouble1[paramInt1];
    d16 = d11 * d14 - d10 * d17;
    d17 = d17 * d11 + d14 * d10;
    double d18 = paramArrayOfDouble1[i7] + paramArrayOfDouble1[i8];
    double d19 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[paramInt1];
    d14 = d10 * d18 - d11 * d19;
    d10 = d10 * d19 + d11 * d18;
    d11 = d4 + d8;
    d18 = d5 + d12;
    d19 = d13 + d16;
    double d20 = d15 + d17;
    paramArrayOfDouble1[paramInt2] = (d11 + d19);
    paramArrayOfDouble1[j] = (d18 + d20);
    paramArrayOfDouble1[i3] = (d11 - d19);
    paramArrayOfDouble1[i5] = (d18 - d20);
    d4 -= d8;
    d5 -= d12;
    d8 = d13 - d16;
    d11 = d15 - d17;
    paramArrayOfDouble1[m] = (d4 - d11);
    paramArrayOfDouble1[i1] = (d5 + d8);
    paramArrayOfDouble1[i7] = (d4 + d11);
    paramArrayOfDouble1[i9] = (d5 - d8);
    d4 = d2 - d6;
    d5 = d1 + d3;
    d8 = d7 - d14;
    d11 = d9 - d10;
    paramArrayOfDouble1[k] = (d4 + d8);
    paramArrayOfDouble1[i] = (d5 + d11);
    paramArrayOfDouble1[i6] = (d4 - d8);
    paramArrayOfDouble1[i4] = (d5 - d11);
    d2 += d6;
    d1 -= d3;
    d3 = d7 + d14;
    d4 = d9 + d10;
    paramArrayOfDouble1[i2] = (d2 - d4);
    paramArrayOfDouble1[n] = (d1 + d3);
    paramArrayOfDouble1[paramInt1] = (d2 + d4);
    paramArrayOfDouble1[i8] = (d1 - d3);
  }
  
  private void cftf161(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d3 = paramArrayOfDouble2[(paramInt2 + 1)];
    paramInt2 += 2;
    double d12 = paramArrayOfDouble2[paramInt2] * d3;
    double d13 = paramArrayOfDouble2[paramInt2] + d12;
    paramInt2 = paramInt1 + 0;
    double d1 = paramArrayOfDouble1[paramInt2];
    int i = paramInt1 + 16;
    double d4 = d1 + paramArrayOfDouble1[i];
    int j = paramInt1 + 1;
    d1 = paramArrayOfDouble1[j];
    int k = paramInt1 + 17;
    double d5 = d1 + paramArrayOfDouble1[k];
    double d7 = paramArrayOfDouble1[paramInt2] - paramArrayOfDouble1[i];
    double d6 = paramArrayOfDouble1[j] - paramArrayOfDouble1[k];
    int m = paramInt1 + 8;
    d1 = paramArrayOfDouble1[m];
    int n = paramInt1 + 24;
    double d8 = d1 + paramArrayOfDouble1[n];
    int i1 = paramInt1 + 9;
    d1 = paramArrayOfDouble1[i1];
    int i2 = paramInt1 + 25;
    double d9 = d1 + paramArrayOfDouble1[i2];
    double d10 = paramArrayOfDouble1[m] - paramArrayOfDouble1[n];
    double d11 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    double d2 = d4 + d8;
    d1 = d5 + d9;
    d4 -= d8;
    d5 -= d9;
    d9 = d7 - d11;
    d8 = d6 + d10;
    double d19 = d7 + d11;
    double d20 = d6 - d10;
    int i3 = paramInt1 + 2;
    d6 = paramArrayOfDouble1[i3];
    int i4 = paramInt1 + 18;
    d10 = d6 + paramArrayOfDouble1[i4];
    int i5 = paramInt1 + 3;
    d6 = paramArrayOfDouble1[i5];
    int i6 = paramInt1 + 19;
    d11 = d6 + paramArrayOfDouble1[i6];
    double d15 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
    double d14 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
    int i7 = paramInt1 + 10;
    d6 = paramArrayOfDouble1[i7];
    int i8 = paramInt1 + 26;
    double d16 = d6 + paramArrayOfDouble1[i8];
    int i9 = paramInt1 + 11;
    d6 = paramArrayOfDouble1[i9];
    int i10 = paramInt1 + 27;
    double d17 = d6 + paramArrayOfDouble1[i10];
    double d18 = paramArrayOfDouble1[i7] - paramArrayOfDouble1[i8];
    double d21 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[i10];
    d7 = d10 + d16;
    d6 = d11 + d17;
    d10 -= d16;
    d11 -= d17;
    d17 = d15 - d21;
    double d22 = d14 + d18;
    d16 = d13 * d17 - d12 * d22;
    d17 = d22 * d13 + d17 * d12;
    d15 += d21;
    d14 -= d18;
    double d24 = d12 * d15 - d13 * d14;
    double d25 = d14 * d12 + d15 * d13;
    int i11 = paramInt1 + 4;
    d14 = paramArrayOfDouble1[i11];
    int i12 = paramInt1 + 20;
    d18 = d14 + paramArrayOfDouble1[i12];
    int i13 = paramInt1 + 5;
    d14 = paramArrayOfDouble1[i13];
    int i14 = paramInt1 + 21;
    d21 = d14 + paramArrayOfDouble1[i14];
    double d23 = paramArrayOfDouble1[i11] - paramArrayOfDouble1[i12];
    d22 = paramArrayOfDouble1[i13] - paramArrayOfDouble1[i14];
    int i15 = paramInt1 + 12;
    d14 = paramArrayOfDouble1[i15];
    int i16 = paramInt1 + 28;
    double d26 = d14 + paramArrayOfDouble1[i16];
    int i17 = paramInt1 + 13;
    d14 = paramArrayOfDouble1[i17];
    int i18 = paramInt1 + 29;
    double d27 = d14 + paramArrayOfDouble1[i18];
    double d28 = paramArrayOfDouble1[i15] - paramArrayOfDouble1[i16];
    double d29 = paramArrayOfDouble1[i17] - paramArrayOfDouble1[i18];
    d15 = d18 + d26;
    d14 = d21 + d27;
    d18 -= d26;
    d21 -= d27;
    d27 = d23 - d29;
    double d30 = d22 + d28;
    d26 = (d27 - d30) * d3;
    d27 = (d30 + d27) * d3;
    d23 += d29;
    d22 -= d28;
    double d32 = (d23 + d22) * d3;
    double d33 = (d22 - d23) * d3;
    int i19 = paramInt1 + 6;
    d22 = paramArrayOfDouble1[i19];
    int i20 = paramInt1 + 22;
    d28 = d22 + paramArrayOfDouble1[i20];
    int i21 = paramInt1 + 7;
    d22 = paramArrayOfDouble1[i21];
    int i22 = paramInt1 + 23;
    d29 = d22 + paramArrayOfDouble1[i22];
    double d35 = paramArrayOfDouble1[i19] - paramArrayOfDouble1[i20];
    double d34 = paramArrayOfDouble1[i21] - paramArrayOfDouble1[i22];
    int i23 = paramInt1 + 14;
    d22 = paramArrayOfDouble1[i23];
    int i24 = paramInt1 + 30;
    d30 = d22 + paramArrayOfDouble1[i24];
    int i25 = paramInt1 + 15;
    d22 = paramArrayOfDouble1[i25];
    paramInt1 += 31;
    double d31 = d22 + paramArrayOfDouble1[paramInt1];
    double d36 = paramArrayOfDouble1[i23] - paramArrayOfDouble1[i24];
    double d37 = paramArrayOfDouble1[i25] - paramArrayOfDouble1[paramInt1];
    d23 = d28 + d30;
    d22 = d29 + d31;
    d28 -= d30;
    d29 -= d31;
    d31 = d35 - d37;
    double d38 = d34 + d36;
    d30 = d12 * d31 - d13 * d38;
    d31 = d38 * d12 + d31 * d13;
    d35 += d37;
    d36 = d34 - d36;
    d34 = d13 * d35 - d12 * d36;
    d35 = d13 * d36 + d12 * d35;
    d12 = d19 - d32;
    d13 = d20 - d33;
    d19 += d32;
    d20 += d33;
    d32 = d24 - d34;
    d33 = d25 - d35;
    d24 += d34;
    d25 += d35;
    paramArrayOfDouble1[n] = (d12 + d32);
    paramArrayOfDouble1[i2] = (d13 + d33);
    paramArrayOfDouble1[i8] = (d12 - d32);
    paramArrayOfDouble1[i10] = (d13 - d33);
    paramArrayOfDouble1[i16] = (d19 - d25);
    paramArrayOfDouble1[i18] = (d20 + d24);
    paramArrayOfDouble1[i24] = (d19 + d25);
    paramArrayOfDouble1[paramInt1] = (d20 - d24);
    d12 = d9 + d26;
    d13 = d8 + d27;
    d9 -= d26;
    d8 -= d27;
    d19 = d16 + d30;
    d20 = d17 + d31;
    d16 -= d30;
    d17 -= d31;
    paramArrayOfDouble1[i] = (d12 + d19);
    paramArrayOfDouble1[k] = (d13 + d20);
    paramArrayOfDouble1[i4] = (d12 - d19);
    paramArrayOfDouble1[i6] = (d13 - d20);
    paramArrayOfDouble1[i12] = (d9 - d17);
    paramArrayOfDouble1[i14] = (d8 + d16);
    paramArrayOfDouble1[i20] = (d9 + d17);
    paramArrayOfDouble1[i22] = (d8 - d16);
    d9 = d10 - d29;
    d12 = d11 + d28;
    d8 = (d9 - d12) * d3;
    d9 = (d12 + d9) * d3;
    d12 = d10 + d29;
    d11 -= d28;
    d10 = (d12 - d11) * d3;
    d3 *= (d11 + d12);
    d11 = d4 - d21;
    d12 = d5 + d18;
    d4 += d21;
    d5 -= d18;
    paramArrayOfDouble1[m] = (d11 + d8);
    paramArrayOfDouble1[i1] = (d12 + d9);
    paramArrayOfDouble1[i7] = (d11 - d8);
    paramArrayOfDouble1[i9] = (d12 - d9);
    paramArrayOfDouble1[i15] = (d4 - d3);
    paramArrayOfDouble1[i17] = (d5 + d10);
    paramArrayOfDouble1[i23] = (d4 + d3);
    paramArrayOfDouble1[i25] = (d5 - d10);
    d3 = d2 + d15;
    d4 = d1 + d14;
    d2 -= d15;
    d1 -= d14;
    d5 = d7 + d23;
    d8 = d6 + d22;
    d7 -= d23;
    d6 -= d22;
    paramArrayOfDouble1[paramInt2] = (d3 + d5);
    paramArrayOfDouble1[j] = (d4 + d8);
    paramArrayOfDouble1[i3] = (d3 - d5);
    paramArrayOfDouble1[i5] = (d4 - d8);
    paramArrayOfDouble1[i11] = (d2 - d6);
    paramArrayOfDouble1[i13] = (d1 + d7);
    paramArrayOfDouble1[i19] = (d2 + d6);
    paramArrayOfDouble1[i21] = (d1 - d7);
  }
  
  private void cftf162(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d1 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d16 = paramArrayOfDouble2[(paramInt2 + 4)];
    double d17 = paramArrayOfDouble2[(paramInt2 + 5)];
    double d12 = paramArrayOfDouble2[(paramInt2 + 6)];
    double d13 = paramArrayOfDouble2[(paramInt2 + 7)];
    double d22 = paramArrayOfDouble2[(paramInt2 + 8)];
    double d23 = paramArrayOfDouble2[(paramInt2 + 9)];
    paramInt2 = paramInt1 + 0;
    double d2 = paramArrayOfDouble1[paramInt2];
    int i = paramInt1 + 17;
    d2 -= paramArrayOfDouble1[i];
    int j = paramInt1 + 1;
    double d3 = paramArrayOfDouble1[j];
    int k = paramInt1 + 16;
    d3 += paramArrayOfDouble1[k];
    int m = paramInt1 + 8;
    double d4 = paramArrayOfDouble1[m];
    int n = paramInt1 + 25;
    double d5 = d4 - paramArrayOfDouble1[n];
    int i1 = paramInt1 + 9;
    d4 = paramArrayOfDouble1[i1];
    int i2 = paramInt1 + 24;
    double d6 = d4 + paramArrayOfDouble1[i2];
    d4 = (d5 - d6) * d1;
    d5 = (d6 + d5) * d1;
    double d11 = d2 + d4;
    double d10 = d3 + d5;
    d6 = d2 - d4;
    double d7 = d3 - d5;
    d2 = paramArrayOfDouble1[paramInt2] + paramArrayOfDouble1[i];
    d3 = paramArrayOfDouble1[j] - paramArrayOfDouble1[k];
    d4 = paramArrayOfDouble1[m] + paramArrayOfDouble1[n];
    d5 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    double d8 = (d4 - d5) * d1;
    double d9 = (d5 + d4) * d1;
    d5 = d2 - d9;
    d4 = d3 + d8;
    d2 += d9;
    d3 -= d8;
    int i3 = paramInt1 + 2;
    d8 = paramArrayOfDouble1[i3];
    int i4 = paramInt1 + 19;
    d9 = d8 - paramArrayOfDouble1[i4];
    int i5 = paramInt1 + 3;
    d8 = paramArrayOfDouble1[i5];
    int i6 = paramInt1 + 18;
    double d14 = d8 + paramArrayOfDouble1[i6];
    d8 = d16 * d9 - d17 * d14;
    d9 = d14 * d16 + d9 * d17;
    int i7 = paramInt1 + 10;
    d14 = paramArrayOfDouble1[i7];
    int i8 = paramInt1 + 27;
    double d15 = d14 - paramArrayOfDouble1[i8];
    int i9 = paramInt1 + 11;
    d14 = paramArrayOfDouble1[i9];
    int i10 = paramInt1 + 26;
    double d18 = d14 + paramArrayOfDouble1[i10];
    d14 = d13 * d15 - d12 * d18;
    d15 = d18 * d13 + d15 * d12;
    double d21 = d8 + d14;
    double d20 = d9 + d15;
    d18 = d8 - d14;
    double d19 = d9 - d15;
    d9 = paramArrayOfDouble1[i3] + paramArrayOfDouble1[i4];
    d14 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
    d8 = d12 * d9 - d13 * d14;
    d9 = d14 * d12 + d9 * d13;
    d14 = paramArrayOfDouble1[i7] + paramArrayOfDouble1[i8];
    d15 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[i10];
    double d24 = d16 * d14 + d17 * d15;
    double d25 = d15 * d16 - d14 * d17;
    d15 = d8 - d24;
    d14 = d9 - d25;
    d8 += d24;
    d9 += d25;
    int i11 = paramInt1 + 4;
    d24 = paramArrayOfDouble1[i11];
    int i12 = paramInt1 + 21;
    d25 = d24 - paramArrayOfDouble1[i12];
    int i13 = paramInt1 + 5;
    d24 = paramArrayOfDouble1[i13];
    int i14 = paramInt1 + 20;
    double d26 = d24 + paramArrayOfDouble1[i14];
    d24 = d22 * d25 - d23 * d26;
    d25 = d26 * d22 + d25 * d23;
    int i15 = paramInt1 + 12;
    d26 = paramArrayOfDouble1[i15];
    int i16 = paramInt1 + 29;
    double d27 = d26 - paramArrayOfDouble1[i16];
    int i17 = paramInt1 + 13;
    d26 = paramArrayOfDouble1[i17];
    int i18 = paramInt1 + 28;
    double d28 = d26 + paramArrayOfDouble1[i18];
    d26 = d23 * d27 - d22 * d28;
    d27 = d28 * d23 + d27 * d22;
    double d29 = d24 + d26;
    d28 = d25 + d27;
    d26 = d24 - d26;
    d27 = d25 - d27;
    d24 = paramArrayOfDouble1[i11] + paramArrayOfDouble1[i12];
    d25 = paramArrayOfDouble1[i13] - paramArrayOfDouble1[i14];
    double d30 = d23 * d24 - d22 * d25;
    double d31 = d25 * d23 + d24 * d22;
    d24 = paramArrayOfDouble1[i15] + paramArrayOfDouble1[i16];
    d25 = paramArrayOfDouble1[i17] - paramArrayOfDouble1[i18];
    double d32 = d22 * d24 - d23 * d25;
    d23 = d22 * d25 + d23 * d24;
    d25 = d30 - d32;
    d24 = d31 - d23;
    d22 = d30 + d32;
    d23 = d31 + d23;
    int i19 = paramInt1 + 6;
    d30 = paramArrayOfDouble1[i19];
    int i20 = paramInt1 + 23;
    d31 = d30 - paramArrayOfDouble1[i20];
    int i21 = paramInt1 + 7;
    d30 = paramArrayOfDouble1[i21];
    int i22 = paramInt1 + 22;
    d32 = d30 + paramArrayOfDouble1[i22];
    d30 = d12 * d31 - d13 * d32;
    d31 = d32 * d12 + d31 * d13;
    int i23 = paramInt1 + 14;
    d32 = paramArrayOfDouble1[i23];
    int i24 = paramInt1 + 31;
    d32 -= paramArrayOfDouble1[i24];
    int i25 = paramInt1 + 15;
    double d33 = paramArrayOfDouble1[i25];
    paramInt1 += 30;
    d33 += paramArrayOfDouble1[paramInt1];
    double d34 = d17 * d32 - d16 * d33;
    double d35 = d33 * d17 + d32 * d16;
    d33 = d30 + d34;
    d32 = d31 + d35;
    d30 -= d34;
    d31 -= d35;
    d35 = paramArrayOfDouble1[i19] + paramArrayOfDouble1[i20];
    double d36 = paramArrayOfDouble1[i21] - paramArrayOfDouble1[i22];
    d34 = d17 * d35 + d16 * d36;
    d35 = d17 * d36 - d16 * d35;
    d16 = paramArrayOfDouble1[i23] + paramArrayOfDouble1[i24];
    d17 = paramArrayOfDouble1[i25] - paramArrayOfDouble1[paramInt1];
    d36 = d13 * d16 - d12 * d17;
    d13 = d13 * d17 + d12 * d16;
    d17 = d34 + d36;
    d16 = d35 + d13;
    d12 = d34 - d36;
    d13 = d35 - d13;
    d34 = d11 + d29;
    d35 = d10 + d28;
    d36 = d21 + d33;
    double d37 = d20 + d32;
    paramArrayOfDouble1[paramInt2] = (d34 + d36);
    paramArrayOfDouble1[j] = (d35 + d37);
    paramArrayOfDouble1[i3] = (d34 - d36);
    paramArrayOfDouble1[i5] = (d35 - d37);
    d11 -= d29;
    d10 -= d28;
    d21 -= d33;
    d20 -= d32;
    paramArrayOfDouble1[i11] = (d11 - d20);
    paramArrayOfDouble1[i13] = (d10 + d21);
    paramArrayOfDouble1[i19] = (d11 + d20);
    paramArrayOfDouble1[i21] = (d10 - d21);
    d10 = d6 - d27;
    d11 = d7 + d26;
    d21 = d18 - d31;
    d28 = d19 + d30;
    d20 = (d21 - d28) * d1;
    d21 = (d28 + d21) * d1;
    paramArrayOfDouble1[m] = (d10 + d20);
    paramArrayOfDouble1[i1] = (d11 + d21);
    paramArrayOfDouble1[i7] = (d10 - d20);
    paramArrayOfDouble1[i9] = (d11 - d21);
    d6 += d27;
    d7 -= d26;
    d10 = d18 + d31;
    d18 = d19 - d30;
    d11 = (d10 - d18) * d1;
    d10 = (d18 + d10) * d1;
    paramArrayOfDouble1[i15] = (d6 - d10);
    paramArrayOfDouble1[i17] = (d7 + d11);
    paramArrayOfDouble1[i23] = (d6 + d10);
    paramArrayOfDouble1[i25] = (d7 - d11);
    d6 = d5 + d25;
    d7 = d4 + d24;
    d10 = d15 - d17;
    d11 = d14 - d16;
    paramArrayOfDouble1[k] = (d6 + d10);
    paramArrayOfDouble1[i] = (d7 + d11);
    paramArrayOfDouble1[i6] = (d6 - d10);
    paramArrayOfDouble1[i4] = (d7 - d11);
    d5 -= d25;
    d4 -= d24;
    d6 = d15 + d17;
    d7 = d14 + d16;
    paramArrayOfDouble1[i14] = (d5 - d7);
    paramArrayOfDouble1[i12] = (d4 + d6);
    paramArrayOfDouble1[i22] = (d5 + d7);
    paramArrayOfDouble1[i20] = (d4 - d6);
    d4 = d2 - d23;
    d5 = d3 + d22;
    d7 = d8 + d13;
    d10 = d9 - d12;
    d6 = (d7 - d10) * d1;
    d7 = (d10 + d7) * d1;
    paramArrayOfDouble1[i2] = (d4 + d6);
    paramArrayOfDouble1[n] = (d5 + d7);
    paramArrayOfDouble1[i10] = (d4 - d6);
    paramArrayOfDouble1[i8] = (d5 - d7);
    d2 += d23;
    d3 -= d22;
    d4 = d8 - d13;
    d6 = d9 + d12;
    d5 = (d4 - d6) * d1;
    d1 *= (d6 + d4);
    paramArrayOfDouble1[i18] = (d2 - d1);
    paramArrayOfDouble1[i16] = (d3 + d5);
    paramArrayOfDouble1[paramInt1] = (d2 + d1);
    paramArrayOfDouble1[i24] = (d3 - d5);
  }
  
  private void cftf1st(int paramInt1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt2)
  {
    int j = paramInt1 >> 3;
    int k = j * 2;
    paramInt1 = k + k;
    int m = paramInt1 + k;
    int i = 0;
    double d1 = paramArrayOfDouble1[0] + paramArrayOfDouble1[paramInt1];
    double d2 = paramArrayOfDouble1[1];
    int n = paramInt1 + 1;
    d2 += paramArrayOfDouble1[n];
    double d3 = paramArrayOfDouble1[0] - paramArrayOfDouble1[paramInt1];
    double d4 = paramArrayOfDouble1[1] - paramArrayOfDouble1[n];
    double d5 = paramArrayOfDouble1[k] + paramArrayOfDouble1[m];
    int i1 = k + 1;
    double d6 = paramArrayOfDouble1[i1];
    int i2 = m + 1;
    d6 += paramArrayOfDouble1[i2];
    double d7 = paramArrayOfDouble1[k] - paramArrayOfDouble1[m];
    double d8 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    paramArrayOfDouble1[0] = (d1 + d5);
    paramArrayOfDouble1[1] = (d2 + d6);
    paramArrayOfDouble1[k] = (d1 - d5);
    paramArrayOfDouble1[i1] = (d2 - d6);
    paramArrayOfDouble1[paramInt1] = (d3 - d8);
    paramArrayOfDouble1[n] = (d4 + d7);
    paramArrayOfDouble1[m] = (d3 + d8);
    paramArrayOfDouble1[i2] = (d4 - d7);
    d1 = paramArrayOfDouble2[(paramInt2 + 1)];
    d7 = paramArrayOfDouble2[(paramInt2 + 2)];
    d2 = paramArrayOfDouble2[(paramInt2 + 3)];
    d5 = 0.0D;
    d6 = 1.0D;
    paramInt1 = 2;
    d3 = 0.0D;
    d4 = 1.0D;
    for (;;)
    {
      m = j - 2;
      if (paramInt1 >= m) {
        break;
      }
      i += 4;
      m = paramInt2 + i;
      d10 = (d6 + paramArrayOfDouble2[m]) * d7;
      n = m + 1;
      d11 = (d5 + paramArrayOfDouble2[n]) * d7;
      i1 = m + 2;
      d8 = (d4 + paramArrayOfDouble2[i1]) * d2;
      i2 = m + 3;
      d9 = (d3 - paramArrayOfDouble2[i2]) * d2;
      d6 = paramArrayOfDouble2[m];
      d5 = paramArrayOfDouble2[n];
      d4 = paramArrayOfDouble2[i1];
      d3 = -paramArrayOfDouble2[i2];
      m = paramInt1 + k;
      n = m + k;
      i1 = n + k;
      double d18 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[n];
      i2 = paramInt1 + 1;
      d12 = paramArrayOfDouble1[i2];
      i3 = n + 1;
      double d21 = d12 + paramArrayOfDouble1[i3];
      double d14 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[n];
      d12 = paramArrayOfDouble1[i2] - paramArrayOfDouble1[i3];
      i4 = paramInt1 + 2;
      d13 = paramArrayOfDouble1[i4];
      i5 = n + 2;
      double d22 = d13 + paramArrayOfDouble1[i5];
      int i6 = paramInt1 + 3;
      d13 = paramArrayOfDouble1[i6];
      int i7 = n + 3;
      double d23 = d13 + paramArrayOfDouble1[i7];
      double d15 = paramArrayOfDouble1[i4] - paramArrayOfDouble1[i5];
      d13 = paramArrayOfDouble1[i6] - paramArrayOfDouble1[i7];
      double d24 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      int i8 = m + 1;
      double d16 = paramArrayOfDouble1[i8];
      int i9 = i1 + 1;
      double d25 = d16 + paramArrayOfDouble1[i9];
      d16 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      double d19 = paramArrayOfDouble1[i8] - paramArrayOfDouble1[i9];
      int i10 = m + 2;
      double d17 = paramArrayOfDouble1[i10];
      int i11 = i1 + 2;
      double d26 = d17 + paramArrayOfDouble1[i11];
      int i12 = m + 3;
      d17 = paramArrayOfDouble1[i12];
      int i13 = i1 + 3;
      double d27 = d17 + paramArrayOfDouble1[i13];
      d17 = paramArrayOfDouble1[i10] - paramArrayOfDouble1[i11];
      double d20 = paramArrayOfDouble1[i12] - paramArrayOfDouble1[i13];
      paramArrayOfDouble1[paramInt1] = (d18 + d24);
      paramArrayOfDouble1[i2] = (d21 + d25);
      paramArrayOfDouble1[i4] = (d22 + d26);
      paramArrayOfDouble1[i6] = (d23 + d27);
      paramArrayOfDouble1[m] = (d18 - d24);
      paramArrayOfDouble1[i8] = (d21 - d25);
      paramArrayOfDouble1[i10] = (d22 - d26);
      paramArrayOfDouble1[i12] = (d23 - d27);
      d18 = d14 - d19;
      d21 = d12 + d16;
      paramArrayOfDouble1[n] = (d10 * d18 - d11 * d21);
      paramArrayOfDouble1[i3] = (d21 * d10 + d18 * d11);
      d18 = d15 - d20;
      d21 = d13 + d17;
      paramArrayOfDouble1[i5] = (d6 * d18 - d5 * d21);
      paramArrayOfDouble1[i7] = (d21 * d6 + d18 * d5);
      d14 += d19;
      d12 -= d16;
      paramArrayOfDouble1[i1] = (d8 * d14 + d9 * d12);
      paramArrayOfDouble1[i9] = (d12 * d8 - d14 * d9);
      d12 = d15 + d20;
      d13 -= d17;
      paramArrayOfDouble1[i11] = (d4 * d12 + d3 * d13);
      paramArrayOfDouble1[i13] = (d13 * d4 - d12 * d3);
      m = k - paramInt1;
      n = m + k;
      i1 = n + k;
      i2 = i1 + k;
      d18 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      i3 = m + 1;
      d12 = paramArrayOfDouble1[i3];
      i4 = i1 + 1;
      d21 = d12 + paramArrayOfDouble1[i4];
      d14 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      d12 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
      i5 = m - 2;
      d13 = paramArrayOfDouble1[i5];
      i6 = i1 - 2;
      d22 = d13 + paramArrayOfDouble1[i6];
      i7 = m - 1;
      d13 = paramArrayOfDouble1[i7];
      i8 = i1 - 1;
      d23 = d13 + paramArrayOfDouble1[i8];
      d15 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
      d13 = paramArrayOfDouble1[i7] - paramArrayOfDouble1[i8];
      d24 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      i9 = n + 1;
      d16 = paramArrayOfDouble1[i9];
      i10 = i2 + 1;
      d25 = d16 + paramArrayOfDouble1[i10];
      d16 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i2];
      d19 = paramArrayOfDouble1[i9] - paramArrayOfDouble1[i10];
      i11 = n - 2;
      d17 = paramArrayOfDouble1[i11];
      i12 = i2 - 2;
      d26 = d17 + paramArrayOfDouble1[i12];
      i13 = n - 1;
      d17 = paramArrayOfDouble1[i13];
      int i14 = i2 - 1;
      d27 = d17 + paramArrayOfDouble1[i14];
      d17 = paramArrayOfDouble1[i11] - paramArrayOfDouble1[i12];
      d20 = paramArrayOfDouble1[i13] - paramArrayOfDouble1[i14];
      paramArrayOfDouble1[m] = (d18 + d24);
      paramArrayOfDouble1[i3] = (d21 + d25);
      paramArrayOfDouble1[i5] = (d22 + d26);
      paramArrayOfDouble1[i7] = (d23 + d27);
      paramArrayOfDouble1[n] = (d18 - d24);
      paramArrayOfDouble1[i9] = (d21 - d25);
      paramArrayOfDouble1[i11] = (d22 - d26);
      paramArrayOfDouble1[i13] = (d23 - d27);
      d18 = d14 - d19;
      d21 = d12 + d16;
      paramArrayOfDouble1[i1] = (d11 * d18 - d10 * d21);
      paramArrayOfDouble1[i4] = (d11 * d21 + d10 * d18);
      d10 = d15 - d20;
      d11 = d13 + d17;
      paramArrayOfDouble1[i6] = (d5 * d10 - d6 * d11);
      paramArrayOfDouble1[i8] = (d11 * d5 + d10 * d6);
      d10 = d14 + d19;
      d11 = d12 - d16;
      paramArrayOfDouble1[i2] = (d9 * d10 + d8 * d11);
      paramArrayOfDouble1[i10] = (d9 * d11 - d8 * d10);
      d8 = d15 + d20;
      d9 = d13 - d17;
      paramArrayOfDouble1[i12] = (d3 * d8 + d4 * d9);
      paramArrayOfDouble1[i14] = (d9 * d3 - d8 * d4);
      paramInt1 += 4;
    }
    d6 = (d6 + d1) * d7;
    d5 = d7 * (d5 + d1);
    d4 = d2 * (d4 - d1);
    d2 *= (d3 - d1);
    paramInt1 = j + k;
    i = paramInt1 + k;
    paramInt2 = k + i;
    d3 = paramArrayOfDouble1[m];
    k = i - 2;
    d8 = d3 + paramArrayOfDouble1[k];
    n = j - 1;
    d3 = paramArrayOfDouble1[n];
    i1 = i - 1;
    double d10 = d3 + paramArrayOfDouble1[i1];
    d7 = paramArrayOfDouble1[m] - paramArrayOfDouble1[k];
    d3 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i1];
    i2 = paramInt1 - 2;
    double d9 = paramArrayOfDouble1[i2];
    int i3 = paramInt2 - 2;
    double d12 = d9 + paramArrayOfDouble1[i3];
    int i4 = paramInt1 - 1;
    d9 = paramArrayOfDouble1[i4];
    int i5 = paramInt2 - 1;
    double d13 = d9 + paramArrayOfDouble1[i5];
    d9 = paramArrayOfDouble1[i2] - paramArrayOfDouble1[i3];
    double d11 = paramArrayOfDouble1[i4] - paramArrayOfDouble1[i5];
    paramArrayOfDouble1[m] = (d8 + d12);
    paramArrayOfDouble1[n] = (d10 + d13);
    paramArrayOfDouble1[i2] = (d8 - d12);
    paramArrayOfDouble1[i4] = (d10 - d13);
    d8 = d7 - d11;
    d10 = d3 + d9;
    paramArrayOfDouble1[k] = (d6 * d8 - d5 * d10);
    paramArrayOfDouble1[i1] = (d10 * d6 + d8 * d5);
    d7 += d11;
    d3 -= d9;
    paramArrayOfDouble1[i3] = (d4 * d7 + d2 * d3);
    paramArrayOfDouble1[i5] = (d3 * d4 - d7 * d2);
    d9 = paramArrayOfDouble1[j] + paramArrayOfDouble1[i];
    k = j + 1;
    d3 = paramArrayOfDouble1[k];
    m = i + 1;
    d11 = d3 + paramArrayOfDouble1[m];
    d7 = paramArrayOfDouble1[j] - paramArrayOfDouble1[i];
    d3 = paramArrayOfDouble1[k] - paramArrayOfDouble1[m];
    d12 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[paramInt2];
    n = paramInt1 + 1;
    d8 = paramArrayOfDouble1[n];
    i1 = paramInt2 + 1;
    d13 = d8 + paramArrayOfDouble1[i1];
    d8 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[paramInt2];
    d10 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i1];
    paramArrayOfDouble1[j] = (d9 + d12);
    paramArrayOfDouble1[k] = (d11 + d13);
    paramArrayOfDouble1[paramInt1] = (d9 - d12);
    paramArrayOfDouble1[n] = (d11 - d13);
    d9 = d7 - d10;
    d11 = d3 + d8;
    paramArrayOfDouble1[i] = ((d9 - d11) * d1);
    paramArrayOfDouble1[m] = (d1 * (d11 + d9));
    d7 += d10;
    d3 -= d8;
    d1 = -d1;
    paramArrayOfDouble1[paramInt2] = ((d7 + d3) * d1);
    paramArrayOfDouble1[i1] = (d1 * (d3 - d7));
    k = j + 2;
    d1 = paramArrayOfDouble1[k];
    m = i + 2;
    d7 = d1 + paramArrayOfDouble1[m];
    j += 3;
    d1 = paramArrayOfDouble1[j];
    i += 3;
    d9 = d1 + paramArrayOfDouble1[i];
    d3 = paramArrayOfDouble1[k] - paramArrayOfDouble1[m];
    d1 = paramArrayOfDouble1[j] - paramArrayOfDouble1[i];
    n = paramInt1 + 2;
    d8 = paramArrayOfDouble1[n];
    i1 = paramInt2 + 2;
    d11 = d8 + paramArrayOfDouble1[i1];
    paramInt1 += 3;
    d8 = paramArrayOfDouble1[paramInt1];
    paramInt2 += 3;
    d12 = d8 + paramArrayOfDouble1[paramInt2];
    d8 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i1];
    d10 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[paramInt2];
    paramArrayOfDouble1[k] = (d7 + d11);
    paramArrayOfDouble1[j] = (d9 + d12);
    paramArrayOfDouble1[n] = (d7 - d11);
    paramArrayOfDouble1[paramInt1] = (d9 - d12);
    d7 = d3 - d10;
    d9 = d1 + d8;
    paramArrayOfDouble1[m] = (d5 * d7 - d6 * d9);
    paramArrayOfDouble1[i] = (d5 * d9 + d6 * d7);
    d3 += d10;
    d1 -= d8;
    paramArrayOfDouble1[i1] = (d2 * d3 + d4 * d1);
    paramArrayOfDouble1[paramInt2] = (d2 * d1 - d4 * d3);
  }
  
  private void cftfsub(int paramInt1, double[] paramArrayOfDouble1, int[] paramArrayOfInt, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 > 32)
    {
      int i = paramInt1 >> 2;
      cftf1st(paramInt1, paramArrayOfDouble1, paramArrayOfDouble2, paramInt3 - i);
      if (paramInt1 > 512)
      {
        cftrec1(i, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        cftrec2(i, paramArrayOfDouble1, i, paramInt3, paramArrayOfDouble2);
        cftrec1(i, paramArrayOfDouble1, i * 2, paramInt3, paramArrayOfDouble2);
        cftrec1(i, paramArrayOfDouble1, i * 3, paramInt3, paramArrayOfDouble2);
      }
      for (;;)
      {
        break;
        if (i > 32) {
          cftexp1(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        } else {
          cftfx41(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        }
      }
      bitrv2(paramInt1, paramArrayOfInt, paramInt2, paramArrayOfDouble1);
      return;
    }
    if (paramInt1 > 8)
    {
      if (paramInt1 == 32)
      {
        cftf161(paramArrayOfDouble1, 0, paramArrayOfDouble2, paramInt3 - 8);
        bitrv216(paramArrayOfDouble1);
        return;
      }
      cftf081(paramArrayOfDouble1, 0, paramArrayOfDouble2, 0);
      bitrv208(paramArrayOfDouble1);
      return;
    }
    if (paramInt1 == 8)
    {
      cftf040(paramArrayOfDouble1);
      return;
    }
    if (paramInt1 == 4) {
      cftx020(paramArrayOfDouble1);
    }
  }
  
  private void cftfx41(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 == 128)
    {
      paramInt1 = paramInt3 - 8;
      cftf161(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1);
      cftf162(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3 - 32);
      cftf161(paramArrayOfDouble1, paramInt2 + 64, paramArrayOfDouble2, paramInt1);
      cftf161(paramArrayOfDouble1, paramInt2 + 96, paramArrayOfDouble2, paramInt1);
      return;
    }
    paramInt1 = paramInt3 - 16;
    cftf081(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1);
    cftf082(paramArrayOfDouble1, paramInt2 + 16, paramArrayOfDouble2, paramInt1);
    cftf081(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt1);
    cftf081(paramArrayOfDouble1, paramInt2 + 48, paramArrayOfDouble2, paramInt1);
  }
  
  private void cftfx42(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 == 128)
    {
      paramInt1 = paramInt3 - 8;
      cftf161(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1);
      paramInt3 -= 32;
      cftf162(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3);
      cftf161(paramArrayOfDouble1, paramInt2 + 64, paramArrayOfDouble2, paramInt1);
      cftf162(paramArrayOfDouble1, paramInt2 + 96, paramArrayOfDouble2, paramInt3);
      return;
    }
    paramInt1 = paramInt3 - 16;
    cftf081(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1);
    cftf082(paramArrayOfDouble1, paramInt2 + 16, paramArrayOfDouble2, paramInt1);
    cftf081(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt1);
    cftf082(paramArrayOfDouble1, paramInt2 + 48, paramArrayOfDouble2, paramInt1);
  }
  
  private final void cftmdl1(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 3;
    int j = k * 2;
    int i2 = j + j;
    paramInt1 = paramInt2 + 0;
    double d1 = paramArrayOfDouble1[paramInt1];
    int i = paramInt2 + i2;
    d1 += paramArrayOfDouble1[i];
    int m = paramInt2 + 1;
    double d2 = paramArrayOfDouble1[m];
    int n = i + 1;
    d2 += paramArrayOfDouble1[n];
    double d3 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[i];
    double d4 = paramArrayOfDouble1[m] - paramArrayOfDouble1[n];
    int i1 = paramInt2 + j;
    double d5 = paramArrayOfDouble1[i1];
    i2 = paramInt2 + (i2 + j);
    d5 += paramArrayOfDouble1[i2];
    int i3 = i1 + 1;
    double d6 = paramArrayOfDouble1[i3];
    int i4 = i2 + 1;
    d6 += paramArrayOfDouble1[i4];
    double d7 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
    double d8 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
    paramArrayOfDouble1[paramInt1] = (d1 + d5);
    paramArrayOfDouble1[m] = (d2 + d6);
    paramArrayOfDouble1[i1] = (d1 - d5);
    paramArrayOfDouble1[i3] = (d2 - d6);
    paramArrayOfDouble1[i] = (d3 - d8);
    paramArrayOfDouble1[n] = (d4 + d7);
    paramArrayOfDouble1[i2] = (d3 + d8);
    paramArrayOfDouble1[i4] = (d4 - d7);
    d1 = paramArrayOfDouble2[(paramInt3 + 1)];
    i = 0;
    paramInt1 = 2;
    while (paramInt1 < k)
    {
      i += 4;
      m = paramInt3 + i;
      d4 = paramArrayOfDouble2[m];
      d5 = paramArrayOfDouble2[(m + 1)];
      d2 = paramArrayOfDouble2[(m + 2)];
      d3 = -paramArrayOfDouble2[(m + 3)];
      i3 = paramInt1 + j;
      i4 = i3 + j;
      m = paramInt2 + paramInt1;
      d6 = paramArrayOfDouble1[m];
      n = paramInt2 + i4;
      d8 = d6 + paramArrayOfDouble1[n];
      i1 = m + 1;
      d6 = paramArrayOfDouble1[i1];
      i2 = n + 1;
      double d10 = d6 + paramArrayOfDouble1[i2];
      d7 = paramArrayOfDouble1[m] - paramArrayOfDouble1[n];
      d6 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
      i3 = paramInt2 + i3;
      d9 = paramArrayOfDouble1[i3];
      i4 = paramInt2 + (i4 + j);
      double d12 = d9 + paramArrayOfDouble1[i4];
      int i5 = i3 + 1;
      d9 = paramArrayOfDouble1[i5];
      int i6 = i4 + 1;
      double d13 = d9 + paramArrayOfDouble1[i6];
      d9 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
      double d11 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
      paramArrayOfDouble1[m] = (d8 + d12);
      paramArrayOfDouble1[i1] = (d10 + d13);
      paramArrayOfDouble1[i3] = (d8 - d12);
      paramArrayOfDouble1[i5] = (d10 - d13);
      d8 = d7 - d11;
      d10 = d6 + d9;
      paramArrayOfDouble1[n] = (d4 * d8 - d5 * d10);
      paramArrayOfDouble1[i2] = (d10 * d4 + d8 * d5);
      d7 += d11;
      d6 -= d9;
      paramArrayOfDouble1[i4] = (d2 * d7 + d3 * d6);
      paramArrayOfDouble1[i6] = (d6 * d2 - d7 * d3);
      m = j - paramInt1;
      i3 = m + j;
      i4 = i3 + j;
      m = paramInt2 + m;
      d6 = paramArrayOfDouble1[m];
      n = paramInt2 + i4;
      d8 = d6 + paramArrayOfDouble1[n];
      i1 = m + 1;
      d6 = paramArrayOfDouble1[i1];
      i2 = n + 1;
      d10 = d6 + paramArrayOfDouble1[i2];
      d7 = paramArrayOfDouble1[m] - paramArrayOfDouble1[n];
      d6 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
      i3 = paramInt2 + i3;
      d9 = paramArrayOfDouble1[i3];
      i4 = paramInt2 + (i4 + j);
      d12 = d9 + paramArrayOfDouble1[i4];
      i5 = i3 + 1;
      d9 = paramArrayOfDouble1[i5];
      i6 = i4 + 1;
      d13 = d9 + paramArrayOfDouble1[i6];
      d9 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i4];
      d11 = paramArrayOfDouble1[i5] - paramArrayOfDouble1[i6];
      paramArrayOfDouble1[m] = (d8 + d12);
      paramArrayOfDouble1[i1] = (d10 + d13);
      paramArrayOfDouble1[i3] = (d8 - d12);
      paramArrayOfDouble1[i5] = (d10 - d13);
      d8 = d7 - d11;
      d10 = d6 + d9;
      paramArrayOfDouble1[n] = (d5 * d8 - d4 * d10);
      paramArrayOfDouble1[i2] = (d5 * d10 + d4 * d8);
      d4 = d7 + d11;
      d5 = d6 - d9;
      paramArrayOfDouble1[i4] = (d3 * d4 + d2 * d5);
      paramArrayOfDouble1[i6] = (d3 * d5 - d2 * d4);
      paramInt1 += 2;
    }
    m = k + j;
    n = m + j;
    paramInt1 = paramInt2 + k;
    d2 = paramArrayOfDouble1[paramInt1];
    paramInt3 = paramInt2 + n;
    d4 = d2 + paramArrayOfDouble1[paramInt3];
    i = paramInt1 + 1;
    d2 = paramArrayOfDouble1[i];
    k = paramInt3 + 1;
    d6 = d2 + paramArrayOfDouble1[k];
    d3 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[paramInt3];
    d2 = paramArrayOfDouble1[i] - paramArrayOfDouble1[k];
    m = paramInt2 + m;
    d5 = paramArrayOfDouble1[m];
    paramInt2 += j + n;
    d8 = d5 + paramArrayOfDouble1[paramInt2];
    j = m + 1;
    d5 = paramArrayOfDouble1[j];
    n = paramInt2 + 1;
    double d9 = d5 + paramArrayOfDouble1[n];
    d5 = paramArrayOfDouble1[m] - paramArrayOfDouble1[paramInt2];
    d7 = paramArrayOfDouble1[j] - paramArrayOfDouble1[n];
    paramArrayOfDouble1[paramInt1] = (d4 + d8);
    paramArrayOfDouble1[i] = (d6 + d9);
    paramArrayOfDouble1[m] = (d4 - d8);
    paramArrayOfDouble1[j] = (d6 - d9);
    d4 = d3 - d7;
    d6 = d2 + d5;
    paramArrayOfDouble1[paramInt3] = ((d4 - d6) * d1);
    paramArrayOfDouble1[k] = ((d6 + d4) * d1);
    d3 += d7;
    d2 -= d5;
    d1 = -d1;
    paramArrayOfDouble1[paramInt2] = ((d3 + d2) * d1);
    paramArrayOfDouble1[n] = (d1 * (d2 - d3));
  }
  
  private final void cftmdl2(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int m = paramInt1 >> 3;
    int k = m * 2;
    double d1 = paramArrayOfDouble2[(paramInt3 + 1)];
    int i2 = k + k;
    paramInt1 = paramInt2 + 0;
    double d2 = paramArrayOfDouble1[paramInt1];
    int i = paramInt2 + i2;
    int j = i + 1;
    double d4 = d2 - paramArrayOfDouble1[j];
    int n = paramInt2 + 1;
    double d5 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i];
    d2 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[j];
    double d3 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i];
    int i1 = paramInt2 + k;
    double d6 = paramArrayOfDouble1[i1];
    i2 = paramInt2 + (i2 + k);
    int i3 = i2 + 1;
    double d9 = d6 - paramArrayOfDouble1[i3];
    int i4 = i1 + 1;
    double d10 = paramArrayOfDouble1[i4] + paramArrayOfDouble1[i2];
    d6 = paramArrayOfDouble1[i1] + paramArrayOfDouble1[i3];
    double d7 = paramArrayOfDouble1[i4] - paramArrayOfDouble1[i2];
    double d8 = (d9 - d10) * d1;
    d9 = (d10 + d9) * d1;
    paramArrayOfDouble1[paramInt1] = (d4 + d8);
    paramArrayOfDouble1[n] = (d5 + d9);
    paramArrayOfDouble1[i1] = (d4 - d8);
    paramArrayOfDouble1[i4] = (d5 - d9);
    d4 = (d6 - d7) * d1;
    d1 *= (d7 + d6);
    paramArrayOfDouble1[i] = (d2 - d1);
    paramArrayOfDouble1[j] = (d3 + d4);
    paramArrayOfDouble1[i2] = (d2 + d1);
    paramArrayOfDouble1[i3] = (d3 - d4);
    i = k * 2;
    j = 0;
    paramInt1 = 2;
    while (paramInt1 < m)
    {
      j += 4;
      n = paramInt3 + j;
      d5 = paramArrayOfDouble2[n];
      d6 = paramArrayOfDouble2[(n + 1)];
      d1 = paramArrayOfDouble2[(n + 2)];
      d2 = -paramArrayOfDouble2[(n + 3)];
      i -= 4;
      n = paramInt3 + i;
      d7 = paramArrayOfDouble2[n];
      d8 = paramArrayOfDouble2[(n + 1)];
      d3 = paramArrayOfDouble2[(n + 2)];
      d4 = -paramArrayOfDouble2[(n + 3)];
      i4 = paramInt1 + k;
      int i5 = i4 + k;
      n = paramInt2 + paramInt1;
      d9 = paramArrayOfDouble1[n];
      i1 = paramInt2 + i5;
      i2 = i1 + 1;
      double d16 = d9 - paramArrayOfDouble1[i2];
      i3 = n + 1;
      double d17 = paramArrayOfDouble1[i3] + paramArrayOfDouble1[i1];
      d11 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      double d12 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i1];
      i4 = paramInt2 + i4;
      d9 = paramArrayOfDouble1[i4];
      i5 = paramInt2 + (i5 + k);
      int i6 = i5 + 1;
      double d14 = d9 - paramArrayOfDouble1[i6];
      int i7 = i4 + 1;
      double d15 = paramArrayOfDouble1[i7] + paramArrayOfDouble1[i5];
      d9 = paramArrayOfDouble1[i4] + paramArrayOfDouble1[i6];
      d10 = paramArrayOfDouble1[i7] - paramArrayOfDouble1[i5];
      double d13 = d5 * d16 - d6 * d17;
      d16 = d17 * d5 + d16 * d6;
      d17 = d8 * d14 - d7 * d15;
      d14 = d15 * d8 + d14 * d7;
      paramArrayOfDouble1[n] = (d13 + d17);
      paramArrayOfDouble1[i3] = (d16 + d14);
      paramArrayOfDouble1[i4] = (d13 - d17);
      paramArrayOfDouble1[i7] = (d16 - d14);
      d13 = d1 * d11 + d2 * d12;
      d11 = d12 * d1 - d11 * d2;
      d12 = d4 * d9 + d3 * d10;
      d9 = d10 * d4 - d9 * d3;
      paramArrayOfDouble1[i1] = (d13 + d12);
      paramArrayOfDouble1[i2] = (d11 + d9);
      paramArrayOfDouble1[i5] = (d13 - d12);
      paramArrayOfDouble1[i6] = (d11 - d9);
      n = k - paramInt1;
      i4 = n + k;
      i5 = i4 + k;
      n = paramInt2 + n;
      d9 = paramArrayOfDouble1[n];
      i1 = paramInt2 + i5;
      i2 = i1 + 1;
      d16 = d9 - paramArrayOfDouble1[i2];
      i3 = n + 1;
      d17 = paramArrayOfDouble1[i3] + paramArrayOfDouble1[i1];
      d11 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      d12 = paramArrayOfDouble1[i3] - paramArrayOfDouble1[i1];
      i4 = paramInt2 + i4;
      d9 = paramArrayOfDouble1[i4];
      i5 = paramInt2 + (i5 + k);
      i6 = i5 + 1;
      d14 = d9 - paramArrayOfDouble1[i6];
      i7 = i4 + 1;
      d15 = paramArrayOfDouble1[i7] + paramArrayOfDouble1[i5];
      d9 = paramArrayOfDouble1[i4] + paramArrayOfDouble1[i6];
      d10 = paramArrayOfDouble1[i7] - paramArrayOfDouble1[i5];
      d13 = d7 * d16 - d8 * d17;
      d7 = d7 * d17 + d8 * d16;
      d8 = d6 * d14 - d5 * d15;
      d5 = d6 * d15 + d5 * d14;
      paramArrayOfDouble1[n] = (d13 + d8);
      paramArrayOfDouble1[i3] = (d7 + d5);
      paramArrayOfDouble1[i4] = (d13 - d8);
      paramArrayOfDouble1[i7] = (d7 - d5);
      d5 = d3 * d11 + d4 * d12;
      d3 = d3 * d12 - d4 * d11;
      d4 = d2 * d9 + d1 * d10;
      d1 = d2 * d10 - d1 * d9;
      paramArrayOfDouble1[i1] = (d5 + d4);
      paramArrayOfDouble1[i2] = (d3 + d1);
      paramArrayOfDouble1[i5] = (d5 - d4);
      paramArrayOfDouble1[i6] = (d3 - d1);
      paramInt1 += 2;
    }
    paramInt1 = paramInt3 + k;
    d1 = paramArrayOfDouble2[paramInt1];
    d2 = paramArrayOfDouble2[(paramInt1 + 1)];
    i1 = m + k;
    n = i1 + k;
    paramInt1 = paramInt2 + m;
    d3 = paramArrayOfDouble1[paramInt1];
    paramInt3 = paramInt2 + n;
    i = paramInt3 + 1;
    d10 = d3 - paramArrayOfDouble1[i];
    j = paramInt1 + 1;
    double d11 = paramArrayOfDouble1[j] + paramArrayOfDouble1[paramInt3];
    d5 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[i];
    d6 = paramArrayOfDouble1[j] - paramArrayOfDouble1[paramInt3];
    m = paramInt2 + i1;
    d3 = paramArrayOfDouble1[m];
    paramInt2 += k + n;
    k = paramInt2 + 1;
    d8 = d3 - paramArrayOfDouble1[k];
    n = m + 1;
    d9 = paramArrayOfDouble1[n] + paramArrayOfDouble1[paramInt2];
    d3 = paramArrayOfDouble1[m] + paramArrayOfDouble1[k];
    d4 = paramArrayOfDouble1[n] - paramArrayOfDouble1[paramInt2];
    d7 = d1 * d10 - d2 * d11;
    d10 = d11 * d1 + d10 * d2;
    d11 = d2 * d8 - d1 * d9;
    d8 = d9 * d2 + d8 * d1;
    paramArrayOfDouble1[paramInt1] = (d7 + d11);
    paramArrayOfDouble1[j] = (d10 + d8);
    paramArrayOfDouble1[m] = (d7 - d11);
    paramArrayOfDouble1[n] = (d10 - d8);
    d7 = d2 * d5 - d1 * d6;
    d5 = d6 * d2 + d5 * d1;
    d6 = d1 * d3 - d2 * d4;
    d1 = d1 * d4 + d2 * d3;
    paramArrayOfDouble1[paramInt3] = (d7 - d6);
    paramArrayOfDouble1[i] = (d5 - d1);
    paramArrayOfDouble1[paramInt2] = (d7 + d6);
    paramArrayOfDouble1[k] = (d5 + d1);
  }
  
  private void cftrec1(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    int j = i * 2;
    cftmdl1(paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - j);
    if (paramInt1 > 512)
    {
      cftrec1(i, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
      cftrec2(i, paramArrayOfDouble1, paramInt2 + i, paramInt3, paramArrayOfDouble2);
      cftrec1(i, paramArrayOfDouble1, paramInt2 + j, paramInt3, paramArrayOfDouble2);
      cftrec1(i, paramArrayOfDouble1, paramInt2 + i * 3, paramInt3, paramArrayOfDouble2);
      return;
    }
    cftexp1(paramInt1, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
  }
  
  private void cftrec2(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    cftmdl2(paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - paramInt1);
    if (paramInt1 > 512)
    {
      cftrec1(i, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
      cftrec2(i, paramArrayOfDouble1, paramInt2 + i, paramInt3, paramArrayOfDouble2);
      cftrec1(i, paramArrayOfDouble1, paramInt2 + i * 2, paramInt3, paramArrayOfDouble2);
      cftrec2(i, paramArrayOfDouble1, paramInt2 + i * 3, paramInt3, paramArrayOfDouble2);
      return;
    }
    cftexp2(paramInt1, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
  }
  
  private void cftx020(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[2];
    double d3 = paramArrayOfDouble[1];
    double d4 = paramArrayOfDouble[3];
    paramArrayOfDouble[0] += paramArrayOfDouble[2];
    paramArrayOfDouble[1] += paramArrayOfDouble[3];
    paramArrayOfDouble[2] = (d1 - d2);
    paramArrayOfDouble[3] = (d3 - d4);
  }
  
  private void dctsub(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 / paramInt1;
    int i = 1;
    int j = 0;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      int i1 = paramInt3 + j;
      double d1 = paramArrayOfDouble2[i1];
      int i2 = paramInt3 + paramInt2 - j;
      d1 -= paramArrayOfDouble2[i2];
      double d2 = paramArrayOfDouble2[i1] + paramArrayOfDouble2[i2];
      double d3 = paramArrayOfDouble1[i];
      double d4 = paramArrayOfDouble1[n];
      paramArrayOfDouble1[i] = (d1 * paramArrayOfDouble1[i] + d2 * paramArrayOfDouble1[n]);
      paramArrayOfDouble1[n] = (d3 * d2 - d4 * d1);
      i += 1;
    }
    paramArrayOfDouble1[k] *= paramArrayOfDouble2[(paramInt3 + 0)];
  }
  
  private void dstsub(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 / paramInt1;
    int i = 1;
    int j = 0;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      int i1 = paramInt3 + j;
      double d1 = paramArrayOfDouble2[i1];
      int i2 = paramInt3 + paramInt2 - j;
      d1 -= paramArrayOfDouble2[i2];
      double d2 = paramArrayOfDouble2[i1] + paramArrayOfDouble2[i2];
      double d3 = paramArrayOfDouble1[n];
      double d4 = paramArrayOfDouble1[i];
      paramArrayOfDouble1[n] = (d1 * paramArrayOfDouble1[n] + d2 * paramArrayOfDouble1[i]);
      paramArrayOfDouble1[i] = (d3 * d2 - d4 * d1);
      i += 1;
    }
    paramArrayOfDouble1[k] *= paramArrayOfDouble2[(paramInt3 + 0)];
  }
  
  private void makect(int paramInt1, int[] paramArrayOfInt, double[] paramArrayOfDouble, int paramInt2)
  {
    int i = 1;
    paramArrayOfInt[1] = paramInt1;
    if (paramInt1 > 1)
    {
      int j = paramInt1 >> 1;
      double d2 = j;
      Double.isNaN(d2);
      double d1 = 0.7853981633974483D / d2;
      int k = paramInt2 + 0;
      Double.isNaN(d2);
      paramArrayOfDouble[k] = Math.cos(d2 * d1);
      paramArrayOfDouble[(paramInt2 + j)] = (paramArrayOfDouble[k] * 0.5D);
      while (i < j)
      {
        d2 = i;
        Double.isNaN(d2);
        d2 *= d1;
        paramArrayOfDouble[(paramInt2 + i)] = (Math.cos(d2) * 0.5D);
        paramArrayOfDouble[(paramInt2 + paramInt1 - i)] = (Math.sin(d2) * 0.5D);
        i += 1;
      }
    }
  }
  
  private void makewt(int paramInt, int[] paramArrayOfInt, double[] paramArrayOfDouble)
  {
    int k = 0;
    paramArrayOfInt[0] = paramInt;
    paramArrayOfInt[1] = 1;
    if (paramInt > 2)
    {
      int m = paramInt >> 1;
      double d1 = m;
      Double.isNaN(d1);
      double d2 = 0.7853981633974483D / d1;
      Double.isNaN(d1);
      d1 = Math.cos(d1 * d2);
      paramArrayOfDouble[0] = 1.0D;
      paramArrayOfDouble[1] = d1;
      if (m >= 4)
      {
        paramArrayOfDouble[2] = (0.5D / Math.cos(2.0D * d2));
        paramArrayOfDouble[3] = (0.5D / Math.cos(6.0D * d2));
      }
      int j = 4;
      int i;
      double d3;
      double d4;
      for (;;)
      {
        i = m;
        paramInt = k;
        if (j >= m) {
          break;
        }
        d3 = j;
        Double.isNaN(d3);
        d4 = d2 * d3;
        paramArrayOfDouble[j] = Math.cos(d4);
        paramArrayOfDouble[(j + 1)] = Math.sin(d4);
        Double.isNaN(d3);
        d3 = 3.0D * d2 * d3;
        paramArrayOfDouble[(j + 2)] = Math.cos(d3);
        paramArrayOfDouble[(j + 3)] = Math.sin(d3);
        j += 4;
      }
      while (i > 2)
      {
        j = paramInt + i;
        k = i >> 1;
        paramArrayOfDouble[j] = 1.0D;
        paramArrayOfDouble[(j + 1)] = d1;
        if (k >= 4)
        {
          d2 = paramArrayOfDouble[(paramInt + 4)];
          d3 = paramArrayOfDouble[(paramInt + 6)];
          paramArrayOfDouble[(j + 2)] = (0.5D / d2);
          paramArrayOfDouble[(j + 3)] = (0.5D / d3);
        }
        i = 4;
        while (i < k)
        {
          m = i * 2 + paramInt;
          d2 = paramArrayOfDouble[m];
          d3 = paramArrayOfDouble[(m + 1)];
          d4 = paramArrayOfDouble[(m + 2)];
          double d5 = paramArrayOfDouble[(m + 3)];
          m = j + i;
          paramArrayOfDouble[m] = d2;
          paramArrayOfDouble[(m + 1)] = d3;
          paramArrayOfDouble[(m + 2)] = d4;
          paramArrayOfDouble[(m + 3)] = d5;
          i += 4;
        }
        paramInt = j;
        i = k;
      }
    }
  }
  
  private void rftbsub(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 * 2 / k;
    int i = 2;
    int j = 0;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      double d1 = 0.5D - paramArrayOfDouble2[(paramInt3 + paramInt2 - j)];
      double d2 = paramArrayOfDouble2[(paramInt3 + j)];
      double d3 = paramArrayOfDouble1[i] - paramArrayOfDouble1[n];
      int i1 = i + 1;
      double d4 = paramArrayOfDouble1[i1];
      int i2 = n + 1;
      double d5 = d4 + paramArrayOfDouble1[i2];
      d4 = d1 * d3 + d2 * d5;
      d1 = d1 * d5 - d2 * d3;
      paramArrayOfDouble1[i] -= d4;
      paramArrayOfDouble1[i1] -= d1;
      paramArrayOfDouble1[n] += d4;
      paramArrayOfDouble1[i2] -= d1;
      i += 2;
    }
  }
  
  private void rftfsub(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 * 2 / k;
    int i = 2;
    int j = 0;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      double d1 = 0.5D - paramArrayOfDouble2[(paramInt3 + paramInt2 - j)];
      double d2 = paramArrayOfDouble2[(paramInt3 + j)];
      double d3 = paramArrayOfDouble1[i] - paramArrayOfDouble1[n];
      int i1 = i + 1;
      double d4 = paramArrayOfDouble1[i1];
      int i2 = n + 1;
      double d5 = d4 + paramArrayOfDouble1[i2];
      d4 = d1 * d3 - d2 * d5;
      d1 = d1 * d5 + d2 * d3;
      paramArrayOfDouble1[i] -= d4;
      paramArrayOfDouble1[i1] -= d1;
      paramArrayOfDouble1[n] += d4;
      paramArrayOfDouble1[i2] -= d1;
      i += 2;
    }
  }
  
  public void cdft(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int[] paramArrayOfInt, double[] paramArrayOfDouble2)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt1 > j << 2)
    {
      i = paramInt1 >> 2;
      makewt(i, paramArrayOfInt, paramArrayOfDouble2);
    }
    if (paramInt2 >= 0)
    {
      cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      return;
    }
    cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
  }
  
  public void ddct(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int[] paramArrayOfInt, double[] paramArrayOfDouble2)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt1 > j << 2)
    {
      i = paramInt1 >> 2;
      makewt(i, paramArrayOfInt, paramArrayOfDouble2);
    }
    j = paramArrayOfInt[1];
    if (paramInt1 > j)
    {
      makect(paramInt1, paramArrayOfInt, paramArrayOfDouble2, i);
      j = paramInt1;
    }
    double d1;
    double d2;
    if (paramInt2 < 0)
    {
      d1 = paramArrayOfDouble1[(paramInt1 - 1)];
      int k = paramInt1 - 2;
      while (k >= 2)
      {
        d2 = paramArrayOfDouble1[k];
        int m = k - 1;
        paramArrayOfDouble1[(k + 1)] = (d2 - paramArrayOfDouble1[m]);
        paramArrayOfDouble1[k] += paramArrayOfDouble1[m];
        k -= 2;
      }
      paramArrayOfDouble1[1] = (paramArrayOfDouble1[0] - d1);
      paramArrayOfDouble1[0] += d1;
      if (paramInt1 > 4)
      {
        rftbsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
        cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
      else if (paramInt1 == 4)
      {
        cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
    }
    dctsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
    if (paramInt2 >= 0)
    {
      if (paramInt1 > 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        rftfsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
      }
      else if (paramInt1 == 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
      d1 = paramArrayOfDouble1[0];
      d2 = paramArrayOfDouble1[1];
      paramArrayOfDouble1[0] += paramArrayOfDouble1[1];
      paramInt2 = 2;
      while (paramInt2 < paramInt1)
      {
        double d3 = paramArrayOfDouble1[paramInt2];
        i = paramInt2 + 1;
        paramArrayOfDouble1[(paramInt2 - 1)] = (d3 - paramArrayOfDouble1[i]);
        paramArrayOfDouble1[paramInt2] += paramArrayOfDouble1[i];
        paramInt2 += 2;
      }
      paramArrayOfDouble1[(paramInt1 - 1)] = (d1 - d2);
    }
  }
  
  public void ddst(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int[] paramArrayOfInt, double[] paramArrayOfDouble2)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt1 > j << 2)
    {
      i = paramInt1 >> 2;
      makewt(i, paramArrayOfInt, paramArrayOfDouble2);
    }
    j = paramArrayOfInt[1];
    if (paramInt1 > j)
    {
      makect(paramInt1, paramArrayOfInt, paramArrayOfDouble2, i);
      j = paramInt1;
    }
    double d1;
    double d2;
    if (paramInt2 < 0)
    {
      d1 = paramArrayOfDouble1[(paramInt1 - 1)];
      int k = paramInt1 - 2;
      while (k >= 2)
      {
        d2 = -paramArrayOfDouble1[k];
        int m = k - 1;
        paramArrayOfDouble1[(k + 1)] = (d2 - paramArrayOfDouble1[m]);
        paramArrayOfDouble1[k] -= paramArrayOfDouble1[m];
        k -= 2;
      }
      paramArrayOfDouble1[1] = (paramArrayOfDouble1[0] + d1);
      paramArrayOfDouble1[0] -= d1;
      if (paramInt1 > 4)
      {
        rftbsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
        cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
      else if (paramInt1 == 4)
      {
        cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
    }
    dstsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
    if (paramInt2 >= 0)
    {
      if (paramInt1 > 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        rftfsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
      }
      else if (paramInt1 == 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
      d1 = paramArrayOfDouble1[0];
      d2 = paramArrayOfDouble1[1];
      paramArrayOfDouble1[0] += paramArrayOfDouble1[1];
      paramInt2 = 2;
      while (paramInt2 < paramInt1)
      {
        double d3 = -paramArrayOfDouble1[paramInt2];
        i = paramInt2 + 1;
        paramArrayOfDouble1[(paramInt2 - 1)] = (d3 - paramArrayOfDouble1[i]);
        paramArrayOfDouble1[paramInt2] -= paramArrayOfDouble1[i];
        paramInt2 += 2;
      }
      paramArrayOfDouble1[(paramInt1 - 1)] = (-(d1 - d2));
    }
  }
  
  public void dfct(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int[] paramArrayOfInt, double[] paramArrayOfDouble3)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt > j << 3)
    {
      i = paramInt >> 3;
      makewt(i, paramArrayOfInt, paramArrayOfDouble3);
    }
    int k = paramArrayOfInt[1];
    j = k;
    if (paramInt > k << 1)
    {
      j = paramInt >> 1;
      makect(j, paramArrayOfInt, paramArrayOfDouble3, i);
    }
    int n = paramInt >> 1;
    double d1 = paramArrayOfDouble1[n];
    double d2 = paramArrayOfDouble1[0] + paramArrayOfDouble1[paramInt];
    paramArrayOfDouble1[0] -= paramArrayOfDouble1[paramInt];
    paramArrayOfDouble2[0] = (d2 - d1);
    paramArrayOfDouble2[n] = (d2 + d1);
    if (paramInt > 2)
    {
      int m = n >> 1;
      k = 1;
      int i1;
      int i2;
      while (k < m)
      {
        i1 = n - k;
        d1 = paramArrayOfDouble1[k];
        i2 = paramInt - k;
        d2 = paramArrayOfDouble1[i2];
        double d3 = paramArrayOfDouble1[k] + paramArrayOfDouble1[i2];
        double d4 = paramArrayOfDouble1[i1];
        i2 = paramInt - i1;
        double d5 = paramArrayOfDouble1[i2];
        double d6 = paramArrayOfDouble1[i1] + paramArrayOfDouble1[i2];
        paramArrayOfDouble1[k] = (d1 - d2);
        paramArrayOfDouble1[i1] = (d4 - d5);
        paramArrayOfDouble2[k] = (d3 - d6);
        paramArrayOfDouble2[i1] = (d3 + d6);
        k += 1;
      }
      d1 = paramArrayOfDouble1[m];
      k = paramInt - m;
      paramArrayOfDouble2[m] = (d1 + paramArrayOfDouble1[k]);
      paramArrayOfDouble1[m] -= paramArrayOfDouble1[k];
      dctsub(n, paramArrayOfDouble1, j, paramArrayOfDouble3, i);
      if (n > 4)
      {
        cftfsub(n, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble3);
        rftfsub(n, paramArrayOfDouble1, j, paramArrayOfDouble3, i);
      }
      else if (n == 4)
      {
        cftfsub(n, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble3);
      }
      paramArrayOfDouble1[(paramInt - 1)] = (paramArrayOfDouble1[0] - paramArrayOfDouble1[1]);
      paramArrayOfDouble1[1] = (paramArrayOfDouble1[0] + paramArrayOfDouble1[1]);
      k = n - 2;
      while (k >= 2)
      {
        n = k * 2;
        d1 = paramArrayOfDouble1[k];
        i1 = k + 1;
        paramArrayOfDouble1[(n + 1)] = (d1 + paramArrayOfDouble1[i1]);
        paramArrayOfDouble1[(n - 1)] = (paramArrayOfDouble1[k] - paramArrayOfDouble1[i1]);
        k -= 2;
      }
      k = m;
      for (m = 2; k >= 2; m = n)
      {
        dctsub(k, paramArrayOfDouble2, j, paramArrayOfDouble3, i);
        if (k > 4)
        {
          cftfsub(k, paramArrayOfDouble2, paramArrayOfInt, 2, i, paramArrayOfDouble3);
          rftfsub(k, paramArrayOfDouble2, j, paramArrayOfDouble3, i);
        }
        else if (k == 4)
        {
          cftfsub(k, paramArrayOfDouble2, paramArrayOfInt, 2, i, paramArrayOfDouble3);
        }
        paramArrayOfDouble1[(paramInt - m)] = (paramArrayOfDouble2[0] - paramArrayOfDouble2[1]);
        paramArrayOfDouble1[m] = (paramArrayOfDouble2[0] + paramArrayOfDouble2[1]);
        n = 2;
        i1 = 0;
        while (n < k)
        {
          i1 += (m << 2);
          d1 = paramArrayOfDouble2[n];
          i2 = n + 1;
          paramArrayOfDouble1[(i1 - m)] = (d1 - paramArrayOfDouble2[i2]);
          paramArrayOfDouble1[(i1 + m)] = (paramArrayOfDouble2[n] + paramArrayOfDouble2[i2]);
          n += 2;
        }
        n = m << 1;
        i1 = k >> 1;
        m = 0;
        while (m < i1)
        {
          i2 = k - m;
          int i3 = k + i2;
          d1 = paramArrayOfDouble2[i3];
          int i4 = k + m;
          paramArrayOfDouble2[m] = (d1 - paramArrayOfDouble2[i4]);
          paramArrayOfDouble2[i3] += paramArrayOfDouble2[i4];
          m += 1;
        }
        paramArrayOfDouble2[i1] = paramArrayOfDouble2[(k + i1)];
        k = i1;
      }
      paramArrayOfDouble1[m] = paramArrayOfDouble2[0];
      paramArrayOfDouble1[paramInt] = (paramArrayOfDouble2[2] - paramArrayOfDouble2[1]);
      paramArrayOfDouble1[0] = (paramArrayOfDouble2[2] + paramArrayOfDouble2[1]);
      return;
    }
    paramArrayOfDouble1[1] = paramArrayOfDouble1[0];
    paramArrayOfDouble1[2] = paramArrayOfDouble2[0];
    paramArrayOfDouble1[0] = paramArrayOfDouble2[1];
  }
  
  public void dfst(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int[] paramArrayOfInt, double[] paramArrayOfDouble3)
  {
    int i = paramArrayOfInt[0];
    int j = i;
    if (paramInt > i << 3)
    {
      j = paramInt >> 3;
      makewt(j, paramArrayOfInt, paramArrayOfDouble3);
    }
    i = paramArrayOfInt[1];
    int k = i;
    if (paramInt > i << 1)
    {
      k = paramInt >> 1;
      makect(k, paramArrayOfInt, paramArrayOfDouble3, j);
    }
    if (paramInt > 2)
    {
      int n = paramInt >> 1;
      int m = n >> 1;
      i = 1;
      int i1;
      int i2;
      while (i < m)
      {
        i1 = n - i;
        d1 = paramArrayOfDouble1[i];
        i2 = paramInt - i;
        double d2 = paramArrayOfDouble1[i2];
        double d3 = paramArrayOfDouble1[i] - paramArrayOfDouble1[i2];
        double d4 = paramArrayOfDouble1[i1];
        i2 = paramInt - i1;
        double d5 = paramArrayOfDouble1[i2];
        double d6 = paramArrayOfDouble1[i1] - paramArrayOfDouble1[i2];
        paramArrayOfDouble1[i] = (d1 + d2);
        paramArrayOfDouble1[i1] = (d4 + d5);
        paramArrayOfDouble2[i] = (d3 + d6);
        paramArrayOfDouble2[i1] = (d3 - d6);
        i += 1;
      }
      double d1 = paramArrayOfDouble1[m];
      i = paramInt - m;
      paramArrayOfDouble2[0] = (d1 - paramArrayOfDouble1[i]);
      paramArrayOfDouble1[m] += paramArrayOfDouble1[i];
      paramArrayOfDouble1[0] = paramArrayOfDouble1[n];
      dstsub(n, paramArrayOfDouble1, k, paramArrayOfDouble3, j);
      if (n > 4)
      {
        cftfsub(n, paramArrayOfDouble1, paramArrayOfInt, 2, j, paramArrayOfDouble3);
        rftfsub(n, paramArrayOfDouble1, k, paramArrayOfDouble3, j);
      }
      else if (n == 4)
      {
        cftfsub(n, paramArrayOfDouble1, paramArrayOfInt, 2, j, paramArrayOfDouble3);
      }
      paramArrayOfDouble1[(paramInt - 1)] = (paramArrayOfDouble1[1] - paramArrayOfDouble1[0]);
      paramArrayOfDouble1[1] = (paramArrayOfDouble1[0] + paramArrayOfDouble1[1]);
      i = n - 2;
      while (i >= 2)
      {
        n = i * 2;
        d1 = paramArrayOfDouble1[i];
        i1 = i + 1;
        paramArrayOfDouble1[(n + 1)] = (d1 - paramArrayOfDouble1[i1]);
        paramArrayOfDouble1[(n - 1)] = (-paramArrayOfDouble1[i] - paramArrayOfDouble1[i1]);
        i -= 2;
      }
      i = m;
      m = 2;
      while (i >= 2)
      {
        dstsub(i, paramArrayOfDouble2, k, paramArrayOfDouble3, j);
        if (i > 4)
        {
          cftfsub(i, paramArrayOfDouble2, paramArrayOfInt, 2, j, paramArrayOfDouble3);
          rftfsub(i, paramArrayOfDouble2, k, paramArrayOfDouble3, j);
        }
        else if (i == 4)
        {
          cftfsub(i, paramArrayOfDouble2, paramArrayOfInt, 2, j, paramArrayOfDouble3);
        }
        i1 = i;
        paramArrayOfDouble1[(paramInt - m)] = (paramArrayOfDouble2[1] - paramArrayOfDouble2[0]);
        paramArrayOfDouble1[m] = (paramArrayOfDouble2[0] + paramArrayOfDouble2[1]);
        i = 2;
        n = 0;
        while (i < i1)
        {
          n += (m << 2);
          d1 = -paramArrayOfDouble2[i];
          i2 = i + 1;
          paramArrayOfDouble1[(n - m)] = (d1 - paramArrayOfDouble2[i2]);
          paramArrayOfDouble1[(n + m)] = (paramArrayOfDouble2[i] - paramArrayOfDouble2[i2]);
          i += 2;
        }
        m <<= 1;
        n = i1 >> 1;
        i = 1;
        while (i < n)
        {
          i2 = i1 - i;
          int i3 = i1 + i2;
          d1 = paramArrayOfDouble2[i3];
          int i4 = i1 + i;
          paramArrayOfDouble2[i] = (d1 + paramArrayOfDouble2[i4]);
          paramArrayOfDouble2[i3] -= paramArrayOfDouble2[i4];
          i += 1;
        }
        paramArrayOfDouble2[0] = paramArrayOfDouble2[(i1 + n)];
        i = n;
      }
      paramArrayOfDouble1[m] = paramArrayOfDouble2[0];
    }
    paramArrayOfDouble1[0] = 0.0D;
  }
  
  public void rdft(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int[] paramArrayOfInt, double[] paramArrayOfDouble2)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt1 > j << 2)
    {
      i = paramInt1 >> 2;
      makewt(i, paramArrayOfInt, paramArrayOfDouble2);
    }
    int k = paramArrayOfInt[1];
    j = k;
    if (paramInt1 > k << 2)
    {
      j = paramInt1 >> 2;
      makect(j, paramArrayOfInt, paramArrayOfDouble2, i);
    }
    if (paramInt2 >= 0)
    {
      if (paramInt1 > 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        rftfsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
      }
      else if (paramInt1 == 4)
      {
        cftfsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      }
      double d1 = paramArrayOfDouble1[0];
      double d2 = paramArrayOfDouble1[1];
      paramArrayOfDouble1[0] += paramArrayOfDouble1[1];
      paramArrayOfDouble1[1] = (d1 - d2);
      return;
    }
    paramArrayOfDouble1[1] = ((paramArrayOfDouble1[0] - paramArrayOfDouble1[1]) * 0.5D);
    paramArrayOfDouble1[0] -= paramArrayOfDouble1[1];
    if (paramInt1 > 4)
    {
      rftbsub(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
      cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
      return;
    }
    if (paramInt1 == 4) {
      cftbsub(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.SplitRadixFft
 * JD-Core Version:    0.7.0.1
 */
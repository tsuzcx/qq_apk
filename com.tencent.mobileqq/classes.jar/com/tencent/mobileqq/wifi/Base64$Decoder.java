package com.tencent.mobileqq.wifi;

class Base64$Decoder
  extends Base64.Coder
{
  private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int e;
  private int f;
  private final int[] g;
  
  public Base64$Decoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = c;
    } else {
      paramArrayOfByte = d;
    }
    this.g = paramArrayOfByte;
    this.e = 0;
    this.f = 0;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = this.e;
    if (m == 6) {
      return false;
    }
    int i1 = paramInt2 + paramInt1;
    int i = this.f;
    byte[] arrayOfByte = this.a;
    int[] arrayOfInt = this.g;
    paramInt2 = 0;
    int j = paramInt1;
    paramInt1 = i;
    i = j;
    int k = paramInt1;
    j = paramInt2;
    int n;
    if (i < i1)
    {
      n = i;
      j = paramInt1;
      k = paramInt2;
      if (m == 0)
      {
        for (;;)
        {
          k = i + 4;
          if (k > i1) {
            break;
          }
          j = arrayOfInt[(paramArrayOfByte[i] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(i + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(i + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(i + 3)] & 0xFF)];
          paramInt1 = j;
          if (j < 0) {
            break;
          }
          arrayOfByte[(paramInt2 + 2)] = ((byte)j);
          arrayOfByte[(paramInt2 + 1)] = ((byte)(j >> 8));
          arrayOfByte[paramInt2] = ((byte)(j >> 16));
          paramInt2 += 3;
          i = k;
          paramInt1 = j;
        }
        n = i;
        j = paramInt1;
        k = paramInt2;
        if (i >= i1)
        {
          k = paramInt1;
          j = paramInt2;
          break label620;
        }
      }
      i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
      if (m != 0) {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m != 4)
              {
                if (m != 5)
                {
                  paramInt1 = m;
                  paramInt2 = k;
                  break label605;
                }
                paramInt1 = m;
                paramInt2 = k;
                if (i == -1) {
                  break label605;
                }
                this.e = 6;
                label309:
                return false;
              }
              if (i == -2)
              {
                paramInt1 = m + 1;
                paramInt2 = k;
                break label605;
              }
              paramInt1 = m;
              paramInt2 = k;
              if (i == -1) {
                break label605;
              }
              this.e = 6;
              return false;
            }
            if (i >= 0)
            {
              j = i | j << 6;
              arrayOfByte[(k + 2)] = ((byte)j);
              arrayOfByte[(k + 1)] = ((byte)(j >> 8));
              arrayOfByte[k] = ((byte)(j >> 16));
              paramInt2 = k + 3;
              paramInt1 = 0;
              break label605;
            }
            if (i == -2)
            {
              arrayOfByte[(k + 1)] = ((byte)(j >> 2));
              arrayOfByte[k] = ((byte)(j >> 10));
              paramInt2 = k + 2;
              paramInt1 = 5;
              break label605;
            }
            paramInt1 = m;
            paramInt2 = k;
            if (i == -1) {
              break label605;
            }
            this.e = 6;
          }
        }
      }
    }
    for (;;)
    {
      return false;
      if (i < 0)
      {
        if (i == -2)
        {
          arrayOfByte[k] = ((byte)(j >> 4));
          paramInt2 = k + 1;
          paramInt1 = 4;
          break label605;
        }
        paramInt1 = m;
        paramInt2 = k;
        if (i == -1) {
          break label605;
        }
        this.e = 6;
        break label309;
        if (i < 0) {
          break label541;
        }
      }
      paramInt1 = i | j << 6;
      break label569;
      label541:
      paramInt1 = m;
      paramInt2 = k;
      if (i != -1)
      {
        this.e = 6;
        return false;
        if (i >= 0)
        {
          paramInt1 = i;
          label569:
          paramInt2 = m + 1;
          j = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = k;
        }
        else
        {
          paramInt1 = m;
          paramInt2 = k;
          if (i != -1)
          {
            this.e = 6;
            return false;
          }
        }
      }
      label605:
      i = n + 1;
      m = paramInt1;
      paramInt1 = j;
      break;
      label620:
      if (!paramBoolean)
      {
        this.e = m;
        this.f = k;
        this.b = j;
        return true;
      }
      paramInt1 = j;
      if (m == 0) {
        break label751;
      }
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              paramInt1 = j;
              break label751;
            }
            this.e = 6;
          }
          else
          {
            paramInt2 = j + 1;
            arrayOfByte[j] = ((byte)(k >> 10));
            paramInt1 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(k >> 2));
            break label751;
          }
        }
        else
        {
          arrayOfByte[j] = ((byte)(k >> 4));
          paramInt1 = j + 1;
          break label751;
        }
      }
      else {
        this.e = 6;
      }
    }
    label751:
    this.e = m;
    this.b = paramInt1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.Base64.Decoder
 * JD-Core Version:    0.7.0.1
 */
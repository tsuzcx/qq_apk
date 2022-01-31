package com.tencent.tmassistantbase.util;

class c
  extends b
{
  private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int e;
  private int f;
  private final int[] g;
  
  public c(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    if ((paramInt & 0x8) == 0) {}
    for (paramArrayOfByte = c;; paramArrayOfByte = d)
    {
      this.g = paramArrayOfByte;
      this.e = 0;
      this.f = 0;
      return;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.e == 6) {
      return false;
    }
    int i2 = paramInt2 + paramInt1;
    int j = this.e;
    paramInt2 = this.f;
    int i = 0;
    byte[] arrayOfByte = this.a;
    int[] arrayOfInt = this.g;
    int k;
    int m;
    int i1;
    if (paramInt1 < i2)
    {
      k = i;
      m = paramInt2;
      i1 = paramInt1;
      if (j == 0)
      {
        int n = paramInt1;
        for (paramInt1 = paramInt2; n + 4 <= i2; paramInt1 = paramInt2)
        {
          paramInt2 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(n + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(n + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(n + 3)] & 0xFF)];
          paramInt1 = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          arrayOfByte[(i + 2)] = ((byte)paramInt2);
          arrayOfByte[(i + 1)] = ((byte)(paramInt2 >> 8));
          arrayOfByte[i] = ((byte)(paramInt2 >> 16));
          i += 3;
          n += 4;
        }
        k = i;
        m = paramInt1;
        i1 = n;
        if (n >= i2) {
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        this.e = j;
        this.f = paramInt2;
        this.b = i;
        return true;
        paramInt2 = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
        switch (j)
        {
        }
        label292:
        label577:
        do
        {
          do
          {
            paramInt1 = j;
            paramInt2 = m;
            i = k;
            for (;;)
            {
              j = paramInt1;
              paramInt1 = i1 + 1;
              break;
              if (paramInt2 >= 0)
              {
                paramInt1 = j + 1;
                i = k;
              }
              else
              {
                if (paramInt2 == -1) {
                  break label292;
                }
                this.e = 6;
                return false;
                if (paramInt2 >= 0)
                {
                  paramInt2 = m << 6 | paramInt2;
                  paramInt1 = j + 1;
                  i = k;
                }
                else
                {
                  if (paramInt2 == -1) {
                    break label292;
                  }
                  this.e = 6;
                  return false;
                  if (paramInt2 >= 0)
                  {
                    paramInt2 = m << 6 | paramInt2;
                    paramInt1 = j + 1;
                    i = k;
                  }
                  else if (paramInt2 == -2)
                  {
                    arrayOfByte[k] = ((byte)(m >> 4));
                    paramInt1 = 4;
                    i = k + 1;
                    paramInt2 = m;
                  }
                  else
                  {
                    if (paramInt2 == -1) {
                      break label292;
                    }
                    this.e = 6;
                    return false;
                    if (paramInt2 >= 0)
                    {
                      paramInt2 = m << 6 | paramInt2;
                      arrayOfByte[(k + 2)] = ((byte)paramInt2);
                      arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
                      arrayOfByte[k] = ((byte)(paramInt2 >> 16));
                      i = k + 3;
                      paramInt1 = 0;
                    }
                    else if (paramInt2 == -2)
                    {
                      arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                      arrayOfByte[k] = ((byte)(m >> 10));
                      i = k + 2;
                      paramInt1 = 5;
                      paramInt2 = m;
                    }
                    else
                    {
                      if (paramInt2 == -1) {
                        break label292;
                      }
                      this.e = 6;
                      return false;
                      if (paramInt2 != -2) {
                        break label577;
                      }
                      paramInt1 = j + 1;
                      i = k;
                      paramInt2 = m;
                    }
                  }
                }
              }
            }
          } while (paramInt2 == -1);
          this.e = 6;
          return false;
        } while (paramInt2 == -1);
        this.e = 6;
        return false;
      }
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = i;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.e = j;
          this.b = paramInt1;
          return true;
          this.e = 6;
          return false;
          arrayOfByte[i] = ((byte)(paramInt2 >> 4));
          paramInt1 = i + 1;
          continue;
          k = i + 1;
          arrayOfByte[i] = ((byte)(paramInt2 >> 10));
          paramInt1 = k + 1;
          arrayOfByte[k] = ((byte)(paramInt2 >> 2));
        }
      }
      this.e = 6;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.c
 * JD-Core Version:    0.7.0.1
 */
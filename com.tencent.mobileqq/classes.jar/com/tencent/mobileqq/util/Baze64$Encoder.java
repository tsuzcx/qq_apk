package com.tencent.mobileqq.util;

class Baze64$Encoder
  extends Baze64.Coder
{
  private static final byte[] h = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] i = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] j = { 110, 76, 95, 101, 54, 114, 89, 117, 45, 73, 120, 112, 111, 55, 78, 68, 118, 97, 48, 75, 52, 50, 57, 104, 67, 81, 72, 79, 83, 86, 85, 74, 99, 109, 106, 119, 69, 49, 84, 56, 116, 51, 121, 98, 103, 90, 71, 66, 122, 53, 65, 105, 80, 107, 115, 108, 70, 113, 82, 102, 87, 77, 100, 88 };
  int c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  private final byte[] k;
  private int l;
  private final byte[] m;
  
  public Baze64$Encoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x1) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    if ((paramInt & 0x2) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if ((paramInt & 0x4) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = h;
    } else {
      paramArrayOfByte = j;
    }
    this.m = paramArrayOfByte;
    this.k = new byte[2];
    this.c = 0;
    if (this.e) {
      paramInt = 19;
    } else {
      paramInt = -1;
    }
    this.l = paramInt;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.m;
    byte[] arrayOfByte2 = this.a;
    int i1 = this.l;
    int i5 = paramInt2 + paramInt1;
    paramInt2 = this.c;
    int i4 = 0;
    int i3 = 0;
    int i2;
    if (paramInt2 != 0) {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 <= i5)
          {
            byte[] arrayOfByte3 = this.k;
            n = arrayOfByte3[0];
            i2 = arrayOfByte3[1];
            paramInt1 = paramArrayOfByte[paramInt1];
            this.c = 0;
            paramInt1 = (i2 & 0xFF) << 8 | (n & 0xFF) << 16 | paramInt1 & 0xFF;
            break label191;
          }
        }
      }
      else if (paramInt1 + 2 <= i5)
      {
        n = this.k[0];
        i2 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        paramInt2 = i2 + 1;
        paramInt1 = (n & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[i2] & 0xFF;
        this.c = 0;
        break label191;
      }
    }
    int n = -1;
    paramInt2 = paramInt1;
    paramInt1 = n;
    label191:
    if (paramInt1 != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
      i1 -= 1;
      if (i1 == 0)
      {
        if (this.f)
        {
          paramInt1 = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt1 = 4;
        }
        n = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = n;
        i1 = 19;
      }
      else
      {
        paramInt1 = 4;
      }
    }
    else
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      n = paramInt2 + 3;
      if (n > i5) {
        break label480;
      }
      i2 = paramArrayOfByte[paramInt2];
      paramInt2 = (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | (i2 & 0xFF) << 16 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
      arrayOfByte2[paramInt1] = arrayOfByte1[(paramInt2 >> 18 & 0x3F)];
      arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(paramInt2 >> 12 & 0x3F)];
      arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(paramInt2 >> 6 & 0x3F)];
      arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(paramInt2 & 0x3F)];
      paramInt1 += 4;
      i1 -= 1;
      if (i1 == 0)
      {
        if (this.f)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt2;
        }
        i1 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt2 = n;
        paramInt1 = i1;
        break;
      }
      paramInt2 = n;
    }
    label480:
    if (paramBoolean)
    {
      n = this.c;
      if (paramInt2 - n == i5 - 1)
      {
        if (n > 0)
        {
          i2 = this.k[0];
          n = 1;
        }
        else
        {
          i2 = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          n = i3;
        }
        i2 = (i2 & 0xFF) << 4;
        this.c -= n;
        i3 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(i2 >> 6 & 0x3F)];
        n = i3 + 1;
        arrayOfByte2[i3] = arrayOfByte1[(i2 & 0x3F)];
        paramInt1 = n;
        if (this.d)
        {
          i2 = n + 1;
          arrayOfByte2[n] = 61;
          paramInt1 = i2 + 1;
          arrayOfByte2[i2] = 61;
        }
        n = paramInt1;
        i2 = paramInt2;
        if (this.e)
        {
          if (this.f)
          {
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = n;
          }
          n = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          i2 = paramInt2;
        }
      }
      else if (paramInt2 - n == i5 - 2)
      {
        if (n > 1)
        {
          i2 = this.k[0];
          n = 1;
        }
        else
        {
          i2 = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          n = i4;
        }
        if (this.c > 0)
        {
          paramArrayOfByte = this.k;
          i4 = n + 1;
          i3 = paramArrayOfByte[n];
          n = i4;
        }
        else
        {
          i4 = paramInt2 + 1;
          i3 = paramArrayOfByte[paramInt2];
          paramInt2 = i4;
        }
        i2 = (i2 & 0xFF) << 10 | (i3 & 0xFF) << 2;
        this.c -= n;
        n = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(i2 >> 12 & 0x3F)];
        i3 = n + 1;
        arrayOfByte2[n] = arrayOfByte1[(i2 >> 6 & 0x3F)];
        paramInt1 = i3 + 1;
        arrayOfByte2[i3] = arrayOfByte1[(i2 & 0x3F)];
        if (this.d)
        {
          n = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 61;
          paramInt1 = n;
        }
        n = paramInt1;
        if (this.e)
        {
          n = paramInt1;
          if (this.f)
          {
            arrayOfByte2[paramInt1] = 13;
            n = paramInt1 + 1;
          }
          arrayOfByte2[n] = 10;
          n += 1;
        }
        i2 = paramInt2;
      }
      else
      {
        n = paramInt1;
        i2 = paramInt2;
        if (this.e)
        {
          n = paramInt1;
          i2 = paramInt2;
          if (paramInt1 > 0)
          {
            n = paramInt1;
            i2 = paramInt2;
            if (i1 != 19)
            {
              if (this.f)
              {
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = n;
              }
              n = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              i2 = paramInt2;
            }
          }
        }
      }
      if ((!g) && (this.c != 0)) {
        throw new AssertionError();
      }
      i3 = n;
      if (!g) {
        if (i2 == i5) {
          i3 = n;
        } else {
          throw new AssertionError();
        }
      }
    }
    else if (paramInt2 == i5 - 1)
    {
      arrayOfByte1 = this.k;
      n = this.c;
      this.c = (n + 1);
      arrayOfByte1[n] = paramArrayOfByte[paramInt2];
      i3 = paramInt1;
    }
    else
    {
      i3 = paramInt1;
      if (paramInt2 == i5 - 2)
      {
        arrayOfByte1 = this.k;
        n = this.c;
        this.c = (n + 1);
        arrayOfByte1[n] = paramArrayOfByte[paramInt2];
        n = this.c;
        this.c = (n + 1);
        arrayOfByte1[n] = paramArrayOfByte[(paramInt2 + 1)];
        i3 = paramInt1;
      }
    }
    this.b = i3;
    this.l = i1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.Baze64.Encoder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qg.sdk.base64;

class Base64$Encoder
  extends Base64.Coder
{
  private static final byte[] ENCODE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] ENCODE_WEBSAFE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  public static final int LINE_GROUPS = 19;
  private final byte[] alphabet;
  private int count;
  public final boolean do_cr;
  public final boolean do_newline;
  public final boolean do_padding;
  private final byte[] tail;
  int tailLen;
  
  public Base64$Encoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.output = paramArrayOfByte;
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x1) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.do_padding = bool1;
    if ((paramInt & 0x2) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.do_newline = bool1;
    if ((paramInt & 0x4) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.do_cr = bool1;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = ENCODE;
    } else {
      paramArrayOfByte = ENCODE_WEBSAFE;
    }
    this.alphabet = paramArrayOfByte;
    this.tail = new byte[2];
    this.tailLen = 0;
    if (this.do_newline) {
      paramInt = 19;
    } else {
      paramInt = -1;
    }
    this.count = paramInt;
  }
  
  public int maxOutputSize(int paramInt)
  {
    return paramInt * 8 / 5 + 10;
  }
  
  public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.alphabet;
    byte[] arrayOfByte2 = this.output;
    int i = this.count;
    int n = paramInt2 + paramInt1;
    paramInt2 = this.tailLen;
    int m = 0;
    int k = 0;
    int i1;
    if (paramInt2 != 0) {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 <= n)
          {
            byte[] arrayOfByte3 = this.tail;
            j = arrayOfByte3[0];
            i1 = arrayOfByte3[1];
            paramInt1 = paramArrayOfByte[paramInt1];
            this.tailLen = 0;
            paramInt1 = (i1 & 0xFF) << 8 | (j & 0xFF) << 16 | paramInt1 & 0xFF;
            break label191;
          }
        }
      }
      else if (paramInt1 + 2 <= n)
      {
        j = this.tail[0];
        i1 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        paramInt2 = i1 + 1;
        paramInt1 = (j & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[i1] & 0xFF;
        this.tailLen = 0;
        break label191;
      }
    }
    int j = -1;
    paramInt2 = paramInt1;
    paramInt1 = j;
    label191:
    if (paramInt1 != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
      i -= 1;
      if (i == 0)
      {
        if (this.do_cr)
        {
          paramInt1 = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt1 = 4;
        }
        i = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = i;
        i = 19;
        j = paramInt2;
      }
      else
      {
        paramInt1 = 4;
        j = paramInt2;
      }
    }
    else
    {
      paramInt1 = 0;
    }
    for (j = paramInt2;; j = paramInt2)
    {
      paramInt2 = j + 3;
      if (paramInt2 > n) {
        break label495;
      }
      i1 = paramArrayOfByte[j];
      j = (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | (i1 & 0xFF) << 16 | paramArrayOfByte[(j + 2)] & 0xFF;
      arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 18 & 0x3F)];
      arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(j >> 12 & 0x3F)];
      arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(j >> 6 & 0x3F)];
      arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(j & 0x3F)];
      paramInt1 += 4;
      i -= 1;
      if (i == 0)
      {
        if (this.do_cr)
        {
          i = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = i;
        }
        i = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = i;
        break;
      }
    }
    label495:
    if (paramBoolean)
    {
      paramInt2 = this.tailLen;
      if (j - paramInt2 == n - 1)
      {
        if (paramInt2 > 0)
        {
          j = this.tail[0];
          paramInt2 = 1;
        }
        else
        {
          j = paramArrayOfByte[j];
          paramInt2 = k;
        }
        j = (j & 0xFF) << 4;
        this.tailLen -= paramInt2;
        k = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 6 & 0x3F)];
        paramInt2 = k + 1;
        arrayOfByte2[k] = arrayOfByte1[(j & 0x3F)];
        paramInt1 = paramInt2;
        if (this.do_padding)
        {
          j = paramInt2 + 1;
          arrayOfByte2[paramInt2] = 61;
          paramInt1 = j + 1;
          arrayOfByte2[j] = 61;
        }
        paramInt2 = paramInt1;
        if (this.do_newline)
        {
          if (this.do_cr)
          {
            paramInt2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = paramInt2;
          }
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
        }
      }
      else if (j - paramInt2 == n - 2)
      {
        if (paramInt2 > 1)
        {
          k = this.tail[0];
          paramInt2 = 1;
        }
        else
        {
          k = paramArrayOfByte[j];
          j += 1;
          paramInt2 = m;
        }
        if (this.tailLen > 0)
        {
          j = this.tail[paramInt2];
          paramInt2 += 1;
        }
        else
        {
          j = paramArrayOfByte[j];
        }
        j = (k & 0xFF) << 10 | (j & 0xFF) << 2;
        this.tailLen -= paramInt2;
        paramInt2 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 12 & 0x3F)];
        k = paramInt2 + 1;
        arrayOfByte2[paramInt2] = arrayOfByte1[(j >> 6 & 0x3F)];
        paramInt1 = k + 1;
        arrayOfByte2[k] = arrayOfByte1[(j & 0x3F)];
        if (this.do_padding)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 61;
          paramInt1 = paramInt2;
        }
        paramInt2 = paramInt1;
        if (this.do_newline)
        {
          paramInt2 = paramInt1;
          if (this.do_cr)
          {
            arrayOfByte2[paramInt1] = 13;
            paramInt2 = paramInt1 + 1;
          }
          arrayOfByte2[paramInt2] = 10;
          paramInt2 += 1;
        }
      }
      else
      {
        paramInt2 = paramInt1;
        if (this.do_newline)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > 0)
          {
            paramInt2 = paramInt1;
            if (i != 19)
            {
              if (this.do_cr)
              {
                paramInt2 = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = paramInt2;
              }
              arrayOfByte2[paramInt1] = 10;
              paramInt2 = paramInt1 + 1;
            }
          }
        }
      }
    }
    else if (j == n - 1)
    {
      arrayOfByte1 = this.tail;
      paramInt2 = this.tailLen;
      this.tailLen = (paramInt2 + 1);
      arrayOfByte1[paramInt2] = paramArrayOfByte[j];
      paramInt2 = paramInt1;
    }
    else
    {
      paramInt2 = paramInt1;
      if (j == n - 2)
      {
        arrayOfByte1 = this.tail;
        paramInt2 = this.tailLen;
        this.tailLen = (paramInt2 + 1);
        arrayOfByte1[paramInt2] = paramArrayOfByte[j];
        paramInt2 = this.tailLen;
        this.tailLen = (paramInt2 + 1);
        arrayOfByte1[paramInt2] = paramArrayOfByte[(j + 1)];
        paramInt2 = paramInt1;
      }
    }
    this.op = paramInt2;
    this.count = i;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.base64.Base64.Encoder
 * JD-Core Version:    0.7.0.1
 */
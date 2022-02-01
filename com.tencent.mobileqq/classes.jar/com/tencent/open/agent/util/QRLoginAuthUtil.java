package com.tencent.open.agent.util;

public class QRLoginAuthUtil
{
  private static final short[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int j = paramInt;
    paramInt = n;
    n = i;
    if (j > 0)
    {
      i = paramArrayOfByte[k];
      n = i;
      if (i != 0) {
        if (i == 95)
        {
          n = i;
        }
        else
        {
          n = i;
          if (i == 32) {
            n = 42;
          }
          i = a[n];
          if (i < 0) {}
          for (;;)
          {
            k += 1;
            j -= 1;
            break;
            n = m % 4;
            if (n != 0)
            {
              if (n != 1)
              {
                if (n != 2)
                {
                  if (n != 3) {
                    break label224;
                  }
                  n = paramInt + 1;
                  arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i));
                  paramInt = n;
                }
                else
                {
                  n = paramInt + 1;
                  arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i >> 2));
                  arrayOfByte[n] = ((byte)((i & 0x3) << 6));
                  paramInt = n;
                }
              }
              else
              {
                n = paramInt + 1;
                arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i >> 4));
                arrayOfByte[n] = ((byte)((i & 0xF) << 4));
                paramInt = n;
              }
            }
            else {
              arrayOfByte[paramInt] = ((byte)(i << 2));
            }
            label224:
            m += 1;
          }
        }
      }
    }
    if (n == 95)
    {
      i = m % 4;
      if ((i != 0) && (i != 1))
      {
        if (i != 2)
        {
          if (i != 3) {
            return arrayOfByte;
          }
        }
        else {
          paramInt += 1;
        }
        arrayOfByte[paramInt] = 0;
        return arrayOfByte;
      }
      return null;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.QRLoginAuthUtil
 * JD-Core Version:    0.7.0.1
 */
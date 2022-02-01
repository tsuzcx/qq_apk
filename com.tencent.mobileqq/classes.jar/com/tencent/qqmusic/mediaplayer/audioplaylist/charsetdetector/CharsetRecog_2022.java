package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_2022
  extends CharsetRecognizer
{
  int match(byte[] paramArrayOfByte, int paramInt, byte[][] paramArrayOfByte1)
  {
    int i = 0;
    int n = 0;
    int j = 0;
    label104:
    int i3;
    for (int m = 0; i < paramInt; m = i3)
    {
      int k = j;
      int i1;
      int i2;
      if (paramArrayOfByte[i] == 27)
      {
        k = 0;
        if (k < paramArrayOfByte1.length)
        {
          byte[] arrayOfByte = paramArrayOfByte1[k];
          if (paramInt - i >= arrayOfByte.length) {
            i1 = 1;
          }
          for (;;)
          {
            if (i1 >= arrayOfByte.length) {
              break label104;
            }
            if (arrayOfByte[i1] != paramArrayOfByte[(i + i1)])
            {
              k += 1;
              break;
            }
            i1 += 1;
          }
          i2 = n + 1;
          i1 = i + (arrayOfByte.length - 1);
          i3 = m;
        }
        else
        {
          k = j + 1;
        }
      }
      else if (paramArrayOfByte[i] != 14)
      {
        i1 = i;
        i2 = n;
        j = k;
        i3 = m;
        if (paramArrayOfByte[i] != 15) {}
      }
      else
      {
        i3 = m + 1;
        j = k;
        i2 = n;
        i1 = i;
      }
      i = i1 + 1;
      n = i2;
    }
    if (n == 0) {
      return 0;
    }
    i = (n * 100 - j * 100) / (j + n);
    j = n + m;
    paramInt = i;
    if (j < 5) {
      paramInt = i - (5 - j) * 10;
    }
    i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022
 * JD-Core Version:    0.7.0.1
 */
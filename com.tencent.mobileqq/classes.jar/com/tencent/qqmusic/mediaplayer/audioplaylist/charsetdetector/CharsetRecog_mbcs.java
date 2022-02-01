package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import java.util.Arrays;

abstract class CharsetRecog_mbcs
  extends CharsetRecognizer
{
  abstract String getName();
  
  int match(CharsetDetector paramCharsetDetector, int[] paramArrayOfInt)
  {
    CharsetRecog_mbcs.iteratedChar localiteratedChar = new CharsetRecog_mbcs.iteratedChar();
    localiteratedChar.reset();
    int k = 0;
    int n = 0;
    int j = 0;
    int i = 0;
    while (nextChar(localiteratedChar, paramCharsetDetector))
    {
      int i3 = n + 1;
      int i1;
      int m;
      int i2;
      if (localiteratedChar.error)
      {
        i1 = j + 1;
        m = k;
        i2 = i;
      }
      else
      {
        long l = localiteratedChar.charValue & 0xFFFFFFFF;
        if (l <= 255L)
        {
          m = k;
          i1 = j;
          i2 = i;
        }
        else
        {
          k += 1;
          m = k;
          i1 = j;
          i2 = i;
          if (paramArrayOfInt != null)
          {
            m = k;
            i1 = j;
            i2 = i;
            if (Arrays.binarySearch(paramArrayOfInt, (int)l) >= 0)
            {
              i2 = i + 1;
              i1 = j;
              m = k;
            }
          }
        }
      }
      k = m;
      n = i3;
      j = i1;
      i = i2;
      if (i1 >= 2)
      {
        k = m;
        n = i3;
        j = i1;
        i = i2;
        if (i1 * 5 >= m) {
          return 0;
        }
      }
    }
    if ((k <= 10) && (j == 0))
    {
      if ((k == 0) && (n < 10)) {
        return 0;
      }
      return 10;
    }
    j *= 20;
    if (k < j) {
      return 0;
    }
    if (paramArrayOfInt == null)
    {
      j = k + 30 - j;
      i = j;
      if (j > 100) {
        return 100;
      }
    }
    else
    {
      double d = 90.0D / Math.log(k / 4.0F);
      i = Math.min((int)(Math.log(i + 1) * d + 10.0D), 100);
    }
    return i;
  }
  
  abstract boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
 * JD-Core Version:    0.7.0.1
 */
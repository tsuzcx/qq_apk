package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_Unicode$CharsetRecog_UTF_32
  extends CharsetRecog_Unicode
{
  abstract int getChar(byte[] paramArrayOfByte, int paramInt);
  
  abstract String getName();
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    int n = paramCharsetDetector.fRawLength / 4 * 4;
    if (n == 0) {
      return null;
    }
    int i;
    if (getChar(arrayOfByte, 0) == 65279) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < n)
    {
      int i1 = getChar(arrayOfByte, j);
      if ((i1 >= 0) && (i1 < 1114111) && ((i1 < 55296) || (i1 > 57343))) {
        m += 1;
      } else {
        k += 1;
      }
      j += 4;
    }
    j = 80;
    if ((i != 0) && (k == 0)) {}
    do
    {
      i = 100;
      break;
      if ((i != 0) && (m > k * 10))
      {
        i = j;
        break;
      }
    } while ((m > 3) && (k == 0));
    if ((m > 0) && (k == 0)) {
      i = j;
    } else if (m > k * 10) {
      i = 25;
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_Unicode$CharsetRecog_UTF_16_LE
  extends CharsetRecog_Unicode
{
  String getName()
  {
    return "UTF-16LE";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    int n = Math.min(arrayOfByte.length, 30);
    int m = 0;
    int k = 0;
    int j = 10;
    int i;
    for (;;)
    {
      i = j;
      if (k >= n - 1) {
        break;
      }
      i = codeUnit16FromBytes(arrayOfByte[(k + 1)], arrayOfByte[k]);
      if ((k == 0) && (i == 65279))
      {
        i = 100;
        break;
      }
      j = adjustConfidence(i, j);
      i = j;
      if (j == 0) {
        break;
      }
      if (j == 100)
      {
        i = j;
        break;
      }
      k += 2;
    }
    if ((n < 4) && (i < 100)) {
      i = m;
    }
    if (i > 0) {
      return new CharsetMatch(paramCharsetDetector, this, i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_16_LE
 * JD-Core Version:    0.7.0.1
 */
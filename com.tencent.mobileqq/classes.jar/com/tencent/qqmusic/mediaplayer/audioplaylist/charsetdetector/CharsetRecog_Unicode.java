package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_Unicode
  extends CharsetRecognizer
{
  static int adjustConfidence(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0)
    {
      i = paramInt2 - 10;
    }
    else if ((paramInt1 < 32) || (paramInt1 > 255))
    {
      i = paramInt2;
      if (paramInt1 != 10) {}
    }
    else
    {
      i = paramInt2 + 10;
    }
    if (i < 0) {
      return 0;
    }
    paramInt1 = i;
    if (i > 100) {
      paramInt1 = 100;
    }
    return paramInt1;
  }
  
  static int codeUnit16FromBytes(byte paramByte1, byte paramByte2)
  {
    return (paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF;
  }
  
  abstract String getName();
  
  abstract CharsetMatch match(CharsetDetector paramCharsetDetector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
 * JD-Core Version:    0.7.0.1
 */
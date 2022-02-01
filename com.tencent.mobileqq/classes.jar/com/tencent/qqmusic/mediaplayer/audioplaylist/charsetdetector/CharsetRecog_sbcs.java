package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_sbcs
  extends CharsetRecognizer
{
  abstract String getName();
  
  int match(CharsetDetector paramCharsetDetector, int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    return match(paramCharsetDetector, paramArrayOfInt, paramArrayOfByte, (byte)32);
  }
  
  int match(CharsetDetector paramCharsetDetector, int[] paramArrayOfInt, byte[] paramArrayOfByte, byte paramByte)
  {
    return new CharsetRecog_sbcs.NGramParser(paramArrayOfInt, paramArrayOfByte).parse(paramCharsetDetector, paramByte);
  }
  
  int matchIBM420(CharsetDetector paramCharsetDetector, int[] paramArrayOfInt, byte[] paramArrayOfByte, byte paramByte)
  {
    return new CharsetRecog_sbcs.NGramParser_IBM420(paramArrayOfInt, paramArrayOfByte).parse(paramCharsetDetector, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs
 * JD-Core Version:    0.7.0.1
 */
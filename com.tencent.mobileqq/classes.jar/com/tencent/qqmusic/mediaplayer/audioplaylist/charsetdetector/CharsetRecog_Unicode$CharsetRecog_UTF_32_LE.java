package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_Unicode$CharsetRecog_UTF_32_LE
  extends CharsetRecog_Unicode.CharsetRecog_UTF_32
{
  int getChar(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return paramArrayOfByte[(paramInt + 0)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  String getName()
  {
    return "UTF-32LE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32_LE
 * JD-Core Version:    0.7.0.1
 */
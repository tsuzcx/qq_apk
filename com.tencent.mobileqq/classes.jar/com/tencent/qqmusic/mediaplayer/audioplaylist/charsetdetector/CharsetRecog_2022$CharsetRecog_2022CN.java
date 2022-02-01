package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_2022$CharsetRecog_2022CN
  extends CharsetRecog_2022
{
  private byte[][] escapeSequences;
  
  CharsetRecog_2022$CharsetRecog_2022CN()
  {
    byte[] arrayOfByte1 = { 27, 36, 41, 65 };
    byte[] arrayOfByte2 = { 27, 36, 41, 71 };
    byte[] arrayOfByte3 = { 27, 36, 43, 77 };
    byte[] arrayOfByte4 = { 27, 79 };
    this.escapeSequences = new byte[][] { arrayOfByte1, arrayOfByte2, { 27, 36, 42, 72 }, { 27, 36, 41, 69 }, { 27, 36, 43, 73 }, { 27, 36, 43, 74 }, { 27, 36, 43, 75 }, { 27, 36, 43, 76 }, arrayOfByte3, { 27, 78 }, arrayOfByte4 };
  }
  
  String getName()
  {
    return "ISO-2022-CN";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022.CharsetRecog_2022CN
 * JD-Core Version:    0.7.0.1
 */
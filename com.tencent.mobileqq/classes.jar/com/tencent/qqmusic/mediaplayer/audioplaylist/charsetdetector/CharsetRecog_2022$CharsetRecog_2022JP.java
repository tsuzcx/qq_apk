package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_2022$CharsetRecog_2022JP
  extends CharsetRecog_2022
{
  private byte[][] escapeSequences;
  
  CharsetRecog_2022$CharsetRecog_2022JP()
  {
    byte[] arrayOfByte1 = { 27, 36, 40, 67 };
    byte[] arrayOfByte2 = { 27, 36, 40, 68 };
    byte[] arrayOfByte3 = { 27, 36, 66 };
    byte[] arrayOfByte4 = { 27, 40, 73 };
    byte[] arrayOfByte5 = { 27, 46, 70 };
    this.escapeSequences = new byte[][] { arrayOfByte1, arrayOfByte2, { 27, 36, 64 }, { 27, 36, 65 }, arrayOfByte3, { 27, 38, 64 }, { 27, 40, 66 }, { 27, 40, 72 }, arrayOfByte4, { 27, 40, 74 }, { 27, 46, 65 }, arrayOfByte5 };
  }
  
  String getName()
  {
    return "ISO-2022-JP";
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
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022.CharsetRecog_2022JP
 * JD-Core Version:    0.7.0.1
 */
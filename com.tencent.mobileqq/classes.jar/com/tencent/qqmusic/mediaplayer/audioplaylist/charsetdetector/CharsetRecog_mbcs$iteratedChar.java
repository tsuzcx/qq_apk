package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_mbcs$iteratedChar
{
  int charValue = 0;
  boolean done = false;
  boolean error = false;
  int nextIndex = 0;
  
  int nextByte(CharsetDetector paramCharsetDetector)
  {
    if (this.nextIndex >= paramCharsetDetector.fRawLength)
    {
      this.done = true;
      return -1;
    }
    paramCharsetDetector = paramCharsetDetector.fRawInput;
    int i = this.nextIndex;
    this.nextIndex = (i + 1);
    return paramCharsetDetector[i] & 0xFF;
  }
  
  void reset()
  {
    this.charValue = 0;
    this.nextIndex = 0;
    this.error = false;
    this.done = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs.iteratedChar
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_mbcs$CharsetRecog_euc
  extends CharsetRecog_mbcs
{
  boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
  {
    paramiteratedChar.error = false;
    int i = paramiteratedChar.nextByte(paramCharsetDetector);
    paramiteratedChar.charValue = i;
    if (i < 0)
    {
      paramiteratedChar.done = true;
    }
    else if (i > 141)
    {
      int j = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | j);
      if ((i >= 161) && (i <= 254))
      {
        if (j < 161) {
          paramiteratedChar.error = true;
        }
      }
      else if (i == 142)
      {
        if (j < 161) {
          paramiteratedChar.error = true;
        }
      }
      else if (i == 143)
      {
        i = paramiteratedChar.nextByte(paramCharsetDetector);
        paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | i);
        if (i < 161) {
          paramiteratedChar.error = true;
        }
      }
    }
    return paramiteratedChar.done ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs.CharsetRecog_euc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_UTF8
  extends CharsetRecognizer
{
  String getName()
  {
    return "UTF-8";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    int i = paramCharsetDetector.fRawLength;
    int i2 = 0;
    int k;
    if ((i >= 3) && ((arrayOfByte[0] & 0xFF) == 239) && ((arrayOfByte[1] & 0xFF) == 187) && ((arrayOfByte[2] & 0xFF) == 191)) {
      k = 1;
    } else {
      k = 0;
    }
    i = 0;
    int n = 0;
    int m = 0;
    while (i < paramCharsetDetector.fRawLength)
    {
      int i1 = arrayOfByte[i];
      if ((i1 & 0x80) != 0)
      {
        int j;
        if ((i1 & 0xE0) == 192)
        {
          j = 1;
          i1 = i;
        }
        else if ((i1 & 0xF0) == 224)
        {
          j = 2;
          i1 = i;
        }
        else
        {
          j = i;
          if ((i1 & 0xF8) != 240) {
            break label223;
          }
          j = 3;
          i1 = i;
        }
        int i3;
        do
        {
          i = i1 + 1;
          if (i >= paramCharsetDetector.fRawLength) {
            break label231;
          }
          if ((arrayOfByte[i] & 0xC0) != 128)
          {
            j = i;
            break;
          }
          i3 = j - 1;
          i1 = i;
          j = i3;
        } while (i3 != 0);
        m += 1;
        break label231;
        label223:
        n += 1;
        i = j;
      }
      label231:
      i += 1;
    }
    if ((k != 0) && (n == 0))
    {
      i = 100;
    }
    else
    {
      if ((k != 0) && (m > n * 10)) {}
      do
      {
        i = 80;
        break label334;
        if ((m > 3) && (n == 0)) {
          break;
        }
      } while ((m > 0) && (n == 0));
      if ((m == 0) && (n == 0))
      {
        i = 15;
      }
      else
      {
        i = i2;
        if (m > n * 10) {
          i = 25;
        }
      }
    }
    label334:
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_UTF8
 * JD-Core Version:    0.7.0.1
 */
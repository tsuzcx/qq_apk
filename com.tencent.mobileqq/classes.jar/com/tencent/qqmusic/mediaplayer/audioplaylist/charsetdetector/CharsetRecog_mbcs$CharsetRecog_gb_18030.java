package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_mbcs$CharsetRecog_gb_18030
  extends CharsetRecog_mbcs
{
  static int[] commonChars = { 41377, 41378, 41379, 41380, 41392, 41393, 41457, 41459, 41889, 41900, 41914, 45480, 45496, 45502, 45755, 46025, 46070, 46323, 46525, 46532, 46563, 46767, 46804, 46816, 47010, 47016, 47037, 47062, 47069, 47284, 47327, 47350, 47531, 47561, 47576, 47610, 47613, 47821, 48039, 48086, 48097, 48122, 48316, 48347, 48382, 48588, 48845, 48861, 49076, 49094, 49097, 49332, 49389, 49611, 49883, 50119, 50396, 50410, 50636, 50935, 51192, 51371, 51403, 51413, 51431, 51663, 51706, 51889, 51893, 51911, 51920, 51926, 51957, 51965, 52460, 52728, 52906, 52932, 52946, 52965, 53173, 53186, 53206, 53442, 53445, 53456, 53460, 53671, 53930, 53938, 53941, 53947, 53972, 54211, 54224, 54269, 54466, 54490, 54754, 54992 };
  
  public String getLanguage()
  {
    return "zh";
  }
  
  String getName()
  {
    return "GB18030";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i = match(paramCharsetDetector, commonChars);
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
  
  boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
  {
    paramiteratedChar.error = false;
    int i = paramiteratedChar.nextByte(paramCharsetDetector);
    paramiteratedChar.charValue = i;
    if (i < 0)
    {
      paramiteratedChar.done = true;
    }
    else if (i > 128)
    {
      int j = paramiteratedChar.nextByte(paramCharsetDetector);
      paramiteratedChar.charValue = (paramiteratedChar.charValue << 8 | j);
      if ((i >= 129) && (i <= 254) && ((j < 64) || (j > 126)) && ((j < 80) || (j > 254)))
      {
        if ((j >= 48) && (j <= 57))
        {
          i = paramiteratedChar.nextByte(paramCharsetDetector);
          if ((i >= 129) && (i <= 254))
          {
            j = paramiteratedChar.nextByte(paramCharsetDetector);
            if ((j >= 48) && (j <= 57))
            {
              paramiteratedChar.charValue = (j | paramiteratedChar.charValue << 16 | i << 8);
              break label187;
            }
          }
        }
        paramiteratedChar.error = true;
      }
    }
    label187:
    return paramiteratedChar.done ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs.CharsetRecog_gb_18030
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;
import java.util.ArrayList;

public class LyricParseHelper
{
  public static Lyric a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() >= 0))
    {
      if (paramBoolean) {}
      try
      {
        paramString = new ParsingQrc(paramString).a();
        break label42;
        paramString = new ParsingLrc(paramString).a();
        label42:
        if (paramString != null)
        {
          int i = paramString.a.size();
          if (i > 0) {
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.e("LyricParseHelper", "parse exception:", paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.LyricParseHelper
 * JD-Core Version:    0.7.0.1
 */
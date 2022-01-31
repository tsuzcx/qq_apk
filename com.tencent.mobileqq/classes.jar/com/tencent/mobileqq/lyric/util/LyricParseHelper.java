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
      for (;;)
      {
        try
        {
          paramString = new ParsingQrc(paramString).a();
          if ((paramString == null) || (paramString.a.size() <= 0)) {
            break;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("LyricParseHelper", "parse exception:", paramString);
        }
        paramString = new ParsingLrc(paramString).a(false);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.LyricParseHelper
 * JD-Core Version:    0.7.0.1
 */
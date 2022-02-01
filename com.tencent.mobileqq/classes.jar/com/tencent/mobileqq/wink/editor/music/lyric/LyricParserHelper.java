package com.tencent.mobileqq.wink.editor.music.lyric;

import com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric;
import java.util.ArrayList;

public class LyricParserHelper
{
  private static LyricParserHelper.Instance a = new LyricParserHelper.Instance();
  
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
          int i = paramString.b.size();
          if (i > 0) {
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.LyricParserHelper
 * JD-Core Version:    0.7.0.1
 */
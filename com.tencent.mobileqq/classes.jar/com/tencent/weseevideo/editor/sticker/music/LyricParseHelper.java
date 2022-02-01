package com.tencent.weseevideo.editor.sticker.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.LyricParserManager;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WEmptyLineProvider;
import java.util.ArrayList;

public class LyricParseHelper
{
  public static final String LYRIC_FROMAT_LRC = "LRC";
  public static final String LYRIC_FROMAT_QRC = "QRC";
  private static final String TAG = "LyricParseHelper";
  
  public static <T extends IParserProvider> Lyric parseTextToLyric(@NonNull Class<T> paramClass, @Nullable String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramClass = LyricParserManager.getInstance().getProvider(paramClass);
      if (paramBoolean) {}
      try
      {
        paramClass = paramClass.createQrcParser();
        paramClass.init(paramString);
        paramClass = paramClass.parse();
        break label68;
        paramClass = paramClass.createLrcParser();
        paramClass.init(paramString);
        paramClass = paramClass.parse();
        label68:
        if (paramClass != null)
        {
          int i = paramClass.mSentences.size();
          if (i > 0) {
            return paramClass;
          }
        }
      }
      catch (Exception paramClass)
      {
        Log.e("LyricParseHelper", "parse exception:", paramClass);
      }
    }
    return null;
  }
  
  @Deprecated
  public static Lyric parseTextToLyric(String paramString, boolean paramBoolean)
  {
    return parseTextToLyric(WEmptyLineProvider.class, paramString, paramBoolean);
  }
  
  public static <T extends IParserProvider> void registerParserProvider(@NonNull Class<T> paramClass, @NonNull T paramT)
  {
    LyricParserManager.getInstance().registerProvider(paramClass, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.LyricParseHelper
 * JD-Core Version:    0.7.0.1
 */
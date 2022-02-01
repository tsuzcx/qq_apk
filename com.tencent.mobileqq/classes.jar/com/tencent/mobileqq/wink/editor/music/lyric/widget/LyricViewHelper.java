package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric;
import com.tencent.mobileqq.wink.editor.music.lyric.data.Sentence;
import com.tencent.mobileqq.wink.editor.music.lyric.data.SentenceUI;
import java.util.ArrayList;
import java.util.Iterator;

public class LyricViewHelper
{
  public static final Lyric a(Lyric paramLyric)
  {
    if (paramLyric == null) {
      return new Lyric(2, 0, null);
    }
    Lyric localLyric = new Lyric(2, paramLyric.d, new ArrayList());
    localLyric.a = paramLyric.a;
    paramLyric = paramLyric.b.iterator();
    while (paramLyric.hasNext())
    {
      Object localObject = (Sentence)paramLyric.next();
      if (localObject != null)
      {
        localObject = ((Sentence)localObject).d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SentenceUI localSentenceUI = (SentenceUI)((Iterator)localObject).next();
          localLyric.b.add(new Sentence(localSentenceUI));
        }
      }
    }
    return localLyric;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewHelper
 * JD-Core Version:    0.7.0.1
 */
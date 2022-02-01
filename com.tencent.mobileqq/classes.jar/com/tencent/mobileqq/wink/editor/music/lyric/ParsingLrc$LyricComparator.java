package com.tencent.mobileqq.wink.editor.music.lyric;

import com.tencent.mobileqq.wink.editor.music.lyric.data.Sentence;
import java.util.Comparator;

class ParsingLrc$LyricComparator
  implements Comparator<Sentence>
{
  public int a(Sentence paramSentence1, Sentence paramSentence2)
  {
    if (paramSentence1.b >= paramSentence2.b) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.ParsingLrc.LyricComparator
 * JD-Core Version:    0.7.0.1
 */
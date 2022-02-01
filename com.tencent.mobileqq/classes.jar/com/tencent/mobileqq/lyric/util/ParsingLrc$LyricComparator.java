package com.tencent.mobileqq.lyric.util;

import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.Comparator;

class ParsingLrc$LyricComparator
  implements Comparator<Sentence>
{
  public int a(Sentence paramSentence1, Sentence paramSentence2)
  {
    if (paramSentence1.a >= paramSentence2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.ParsingLrc.LyricComparator
 * JD-Core Version:    0.7.0.1
 */
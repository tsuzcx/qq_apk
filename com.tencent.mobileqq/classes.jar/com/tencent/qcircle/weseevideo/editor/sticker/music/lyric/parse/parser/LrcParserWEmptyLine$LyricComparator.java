package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.io.Serializable;
import java.util.Comparator;

class LrcParserWEmptyLine$LyricComparator
  implements Serializable, Comparator<Sentence>
{
  public int compare(Sentence paramSentence1, Sentence paramSentence2)
  {
    if (paramSentence1.mStartTime >= paramSentence2.mStartTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWEmptyLine.LyricComparator
 * JD-Core Version:    0.7.0.1
 */
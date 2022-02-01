package com.tencent.videocut.utils.lyric;

import java.io.Serializable;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/lyric/ParsingLrc$LyricComparator;", "Ljava/util/Comparator;", "Lcom/tencent/videocut/utils/lyric/Sentence;", "Ljava/io/Serializable;", "()V", "compare", "", "line1", "line2", "lib_utils_release"}, k=1, mv={1, 4, 2})
final class ParsingLrc$LyricComparator
  implements Serializable, Comparator<Sentence>
{
  public int compare(@NotNull Sentence paramSentence1, @NotNull Sentence paramSentence2)
  {
    Intrinsics.checkNotNullParameter(paramSentence1, "line1");
    Intrinsics.checkNotNullParameter(paramSentence2, "line2");
    if (paramSentence1.a() >= paramSentence2.a()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.lyric.ParsingLrc.LyricComparator
 * JD-Core Version:    0.7.0.1
 */
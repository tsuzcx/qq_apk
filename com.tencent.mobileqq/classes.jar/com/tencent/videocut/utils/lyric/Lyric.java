package com.tencent.videocut.utils.lyric;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/lyric/Lyric;", "", "mType", "", "mOffset", "mSentences", "", "Lcom/tencent/videocut/utils/lyric/Sentence;", "(IILjava/util/List;)V", "mLastHitSentence", "mLastHitSentenceNo", "getMOffset", "()I", "setMOffset", "(I)V", "getMSentences", "()Ljava/util/List;", "setMSentences", "(Ljava/util/List;)V", "getMType", "setMType", "clear", "", "copy", "lyric", "countSentence", "startTime", "endTime", "findEndLineByStartTime", "time", "findLineNo", "findLineNoByEndTime", "findLineNoByStartTime", "findTextByTime", "", "", "floorLineNoByEndTime", "getFirstSentenceStartTime", "getLastSentenceEndTime", "getLyricTimeArray", "", "getSentence", "index", "getSentenceList", "", "getSentenceText", "size", "toString", "Companion", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class Lyric
{
  @NotNull
  public static final Lyric.Companion a = new Lyric.Companion(null);
  @NotNull
  private List<Sentence> b;
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringBuilder();
    int j = ((Collection)this.b).size();
    int i = 0;
    while (i < j)
    {
      Sentence localSentence = (Sentence)this.b.get(i);
      String str = localSentence.b();
      long l1 = localSentence.c();
      long l2 = localSentence.d();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l2 + l1);
      ((StringBuilder)localObject).append("\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkNotNullExpressionValue(localObject, "sb.toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.lyric.Lyric
 * JD-Core Version:    0.7.0.1
 */
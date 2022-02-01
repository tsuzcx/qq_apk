package com.tencent.qcircle.weseevideo.editor.sticker.music;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$IStrategy;", "()V", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LyricPlayStrategy$LoopStrategy
  implements LyricPlayStrategy.IStrategy
{
  public float calculateProgress(long paramLong1, long paramLong2, @NotNull LyricPlayStrategy.LyricAnimation paramLyricAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramLyricAnimation, "animation");
    float f;
    if (paramLong2 < paramLyricAnimation.getPrefixDuration() + paramLyricAnimation.getSuffixDuration())
    {
      if (paramLong1 <= paramLyricAnimation.getPrefixDuration())
      {
        f = (float)paramLong1;
        paramLong1 = paramLyricAnimation.getDuration();
      }
      else
      {
        f = (float)(paramLong1 + paramLyricAnimation.getLoopRangeDuration());
        paramLong1 = paramLyricAnimation.getDuration();
      }
      return f / (float)paramLong1;
    }
    if (paramLong1 <= paramLyricAnimation.getPrefixDuration()) {
      f = (float)paramLong1;
    }
    for (paramLong1 = paramLyricAnimation.getDuration();; paramLong1 = paramLyricAnimation.getDuration())
    {
      return f / (float)paramLong1;
      if (paramLong1 >= paramLong2 - paramLyricAnimation.getSuffixDuration()) {
        break;
      }
      f = (float)((paramLong1 - paramLyricAnimation.getPrefixDuration()) % paramLyricAnimation.getLoopRangeDuration() + paramLyricAnimation.getPrefixDuration());
    }
    return 1 - (float)(paramLong2 - paramLong1) / (float)paramLyricAnimation.getDuration();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy.LoopStrategy
 * JD-Core Version:    0.7.0.1
 */
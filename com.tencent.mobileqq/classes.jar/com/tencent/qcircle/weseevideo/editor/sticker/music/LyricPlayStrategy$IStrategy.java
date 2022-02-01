package com.tencent.qcircle.weseevideo.editor.sticker.music;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$IStrategy;", "", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface LyricPlayStrategy$IStrategy
{
  public abstract float calculateProgress(long paramLong1, long paramLong2, @NotNull LyricPlayStrategy.LyricAnimation paramLyricAnimation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy.IStrategy
 * JD-Core Version:    0.7.0.1
 */
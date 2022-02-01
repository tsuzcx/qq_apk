package com.tencent.weseevideo.editor.sticker.music;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy;", "", "()V", "STRATEGY_LOOP", "", "STRATEGY_SPEED", "mLoopStrategy", "Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "getMLoopStrategy", "()Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$LoopStrategy;", "mLoopStrategy$delegate", "Lkotlin/Lazy;", "mSpeedStrategy", "Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$SpeedStrategy;", "getMSpeedStrategy", "()Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$SpeedStrategy;", "mSpeedStrategy$delegate", "calculateProgress", "", "currentPosition", "", "lyricDuration", "animation", "Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "IStrategy", "LoopStrategy", "LyricAnimation", "SpeedStrategy", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LyricPlayStrategy
{
  public static final LyricPlayStrategy INSTANCE = new LyricPlayStrategy();
  public static final int STRATEGY_LOOP = 1;
  public static final int STRATEGY_SPEED = 0;
  private static final Lazy mLoopStrategy$delegate = LazyKt.lazy((Function0)LyricPlayStrategy.mLoopStrategy.2.INSTANCE);
  private static final Lazy mSpeedStrategy$delegate = LazyKt.lazy((Function0)LyricPlayStrategy.mSpeedStrategy.2.INSTANCE);
  
  private final LyricPlayStrategy.LoopStrategy getMLoopStrategy()
  {
    return (LyricPlayStrategy.LoopStrategy)mLoopStrategy$delegate.getValue();
  }
  
  private final LyricPlayStrategy.SpeedStrategy getMSpeedStrategy()
  {
    return (LyricPlayStrategy.SpeedStrategy)mSpeedStrategy$delegate.getValue();
  }
  
  public final float calculateProgress(long paramLong1, long paramLong2, @NotNull LyricPlayStrategy.LyricAnimation paramLyricAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramLyricAnimation, "animation");
    switch (paramLyricAnimation.getType())
    {
    default: 
      return getMLoopStrategy().calculateProgress(paramLong1, paramLong2, paramLyricAnimation);
    }
    return getMSpeedStrategy().calculateProgress(paramLong1, paramLong2, paramLyricAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.LyricPlayStrategy
 * JD-Core Version:    0.7.0.1
 */
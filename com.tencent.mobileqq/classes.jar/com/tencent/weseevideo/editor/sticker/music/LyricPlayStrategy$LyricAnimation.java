package com.tencent.weseevideo.editor.sticker.music;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "", "loopStart", "", "loopEnd", "duration", "type", "", "(JJJI)V", "getDuration", "()J", "setDuration", "(J)V", "getLoopEnd", "setLoopEnd", "loopRangeDuration", "getLoopRangeDuration", "getLoopStart", "setLoopStart", "prefixDuration", "getPrefixDuration", "suffixDuration", "getSuffixDuration", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "format", "hashCode", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LyricPlayStrategy$LyricAnimation
{
  private long duration;
  private long loopEnd;
  private long loopStart;
  private final int type;
  
  public LyricPlayStrategy$LyricAnimation(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    this.loopStart = paramLong1;
    this.loopEnd = paramLong2;
    this.duration = paramLong3;
    this.type = paramInt;
  }
  
  public final long component1()
  {
    return this.loopStart;
  }
  
  public final long component2()
  {
    return this.loopEnd;
  }
  
  public final long component3()
  {
    return this.duration;
  }
  
  public final int component4()
  {
    return this.type;
  }
  
  @NotNull
  public final LyricAnimation copy(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    return new LyricAnimation(paramLong1, paramLong2, paramLong3, paramInt);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof LyricAnimation))
      {
        paramObject = (LyricAnimation)paramObject;
        if ((this.loopStart != paramObject.loopStart) || (this.loopEnd != paramObject.loopEnd) || (this.duration != paramObject.duration) || (this.type != paramObject.type)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final LyricAnimation format()
  {
    if (this.duration < 0L) {
      this.duration = 0L;
    }
    if (this.loopStart <= 0L) {
      this.loopStart = 0L;
    }
    if ((this.loopEnd == 0L) || (this.loopEnd > this.duration)) {
      this.loopEnd = this.duration;
    }
    return this;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final long getLoopEnd()
  {
    return this.loopEnd;
  }
  
  public final long getLoopRangeDuration()
  {
    return this.loopEnd - this.loopStart;
  }
  
  public final long getLoopStart()
  {
    return this.loopStart;
  }
  
  public final long getPrefixDuration()
  {
    return this.loopStart;
  }
  
  public final long getSuffixDuration()
  {
    return this.duration - this.loopEnd;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    long l = this.loopStart;
    int i = (int)(l ^ l >>> 32);
    l = this.loopEnd;
    int j = (int)(l ^ l >>> 32);
    l = this.duration;
    return ((i * 31 + j) * 31 + (int)(l ^ l >>> 32)) * 31 + this.type;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setLoopEnd(long paramLong)
  {
    this.loopEnd = paramLong;
  }
  
  public final void setLoopStart(long paramLong)
  {
    this.loopStart = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    return "LyricAnimation(loopStart=" + this.loopStart + ", loopEnd=" + this.loopEnd + ", duration=" + this.duration + ", type=" + this.type + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.LyricPlayStrategy.LyricAnimation
 * JD-Core Version:    0.7.0.1
 */
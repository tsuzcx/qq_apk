package com.tencent.weseevideo.model.effect;

import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "Lcom/tencent/weseevideo/model/effect/StickerModel;", "()V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "effectPath", "getEffectPath", "setEffectPath", "fontPath", "getFontPath", "setFontPath", "loopEnd", "", "getLoopEnd", "()J", "setLoopEnd", "(J)V", "loopStart", "getLoopStart", "setLoopStart", "loopType", "", "getLoopType", "()I", "setLoopType", "(I)V", "lyric", "getLyric", "setLyric", "lyricFormatIsQRC", "", "getLyricFormatIsQRC", "()Z", "setLyricFormatIsQRC", "(Z)V", "musicStartTime", "getMusicStartTime", "setMusicStartTime", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class SubtitleModel
  extends StickerModel
{
  @NotNull
  private String effectId = "";
  @NotNull
  private String effectPath = "";
  @NotNull
  private String fontPath = "";
  private long loopEnd;
  private long loopStart;
  private int loopType;
  @NotNull
  private String lyric = "";
  private boolean lyricFormatIsQRC;
  private int musicStartTime;
  
  public SubtitleModel()
  {
    this.effectType = VideoEffectType.TYPE_SUBTITLE.value;
    this.scale = 1.0F;
    this.minScale = 1.0F;
    this.maxScale = 1.0F;
    this.rotate = 0.0F;
    this.editable = false;
  }
  
  @NotNull
  public final String getEffectId()
  {
    return this.effectId;
  }
  
  @NotNull
  public final String getEffectPath()
  {
    return this.effectPath;
  }
  
  @NotNull
  public final String getFontPath()
  {
    return this.fontPath;
  }
  
  public final long getLoopEnd()
  {
    return this.loopEnd;
  }
  
  public final long getLoopStart()
  {
    return this.loopStart;
  }
  
  public final int getLoopType()
  {
    return this.loopType;
  }
  
  @NotNull
  public final String getLyric()
  {
    return this.lyric;
  }
  
  public final boolean getLyricFormatIsQRC()
  {
    return this.lyricFormatIsQRC;
  }
  
  public final int getMusicStartTime()
  {
    return this.musicStartTime;
  }
  
  public final void setEffectId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.effectId = paramString;
  }
  
  public final void setEffectPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.effectPath = paramString;
  }
  
  public final void setFontPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fontPath = paramString;
  }
  
  public final void setLoopEnd(long paramLong)
  {
    this.loopEnd = paramLong;
  }
  
  public final void setLoopStart(long paramLong)
  {
    this.loopStart = paramLong;
  }
  
  public final void setLoopType(int paramInt)
  {
    this.loopType = paramInt;
  }
  
  public final void setLyric(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.lyric = paramString;
  }
  
  public final void setLyricFormatIsQRC(boolean paramBoolean)
  {
    this.lyricFormatIsQRC = paramBoolean;
  }
  
  public final void setMusicStartTime(int paramInt)
  {
    this.musicStartTime = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.SubtitleModel
 * JD-Core Version:    0.7.0.1
 */
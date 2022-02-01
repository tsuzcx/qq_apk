package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$LyricInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "()V", "strFormat", "", "strLyric", "strMatchLyric", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$LyricInfo$Builder
  extends Message.Builder<AudioModel.LyricInfo, Builder>
{
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  @NotNull
  public String c = "";
  
  @NotNull
  public AudioModel.LyricInfo a()
  {
    return new AudioModel.LyricInfo(this.a, this.b, this.c, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.LyricInfo.Builder
 * JD-Core Version:    0.7.0.1
 */
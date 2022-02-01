package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "()V", "durationUs", "", "endOffsetUs", "endVolume", "", "startOffsetUs", "startVolume", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$VolumeEffect$Builder
  extends Message.Builder<AudioModel.VolumeEffect, Builder>
{
  @JvmField
  public long a;
  @JvmField
  public long b;
  @JvmField
  public long c;
  @JvmField
  public float d;
  @JvmField
  public float e;
  
  @NotNull
  public AudioModel.VolumeEffect a()
  {
    return new AudioModel.VolumeEffect(this.a, this.b, this.c, this.d, this.e, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.VolumeEffect.Builder
 * JD-Core Version:    0.7.0.1
 */
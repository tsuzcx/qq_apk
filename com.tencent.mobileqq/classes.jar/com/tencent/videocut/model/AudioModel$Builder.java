package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel;", "()V", "fadeInDuration", "", "fadeOutDuration", "id", "", "lyricInfo", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "name", "path", "selectDuration", "selectStartTime", "sourceDuration", "sourceStartTime", "speed", "", "startTimeInTimeline", "timelineTrackIndex", "", "Ljava/lang/Integer;", "type", "Lcom/tencent/videocut/model/AudioModel$Type;", "volume", "volumeEffects", "", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "waveSampleData", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/AudioModel$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/AudioModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/AudioModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$Builder
  extends Message.Builder<AudioModel, Builder>
{
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  @JvmField
  public long c;
  @JvmField
  public long d;
  @JvmField
  public long e;
  @JvmField
  public float f;
  @JvmField
  public float g;
  @JvmField
  @NotNull
  public List<AudioModel.VolumeEffect> h = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public String i = "";
  @JvmField
  @Nullable
  public Integer j;
  @JvmField
  public long k;
  @JvmField
  public long l;
  @JvmField
  public long m;
  @JvmField
  public long n;
  @JvmField
  @Nullable
  public AudioModel.LyricInfo o;
  @JvmField
  @Nullable
  public AudioModel.Type p;
  @JvmField
  @NotNull
  public List<Integer> q = CollectionsKt.emptyList();
  
  @NotNull
  public final Builder a(@Nullable AudioModel.LyricInfo paramLyricInfo)
  {
    this.o = paramLyricInfo;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable AudioModel.Type paramType)
  {
    this.p = paramType;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable Float paramFloat)
  {
    float f1;
    if (paramFloat != null) {
      f1 = paramFloat.floatValue();
    } else {
      f1 = 0.0F;
    }
    this.f = f1;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable Long paramLong)
  {
    long l1;
    if (paramLong != null) {
      l1 = paramLong.longValue();
    } else {
      l1 = 0L;
    }
    this.d = l1;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.a = paramString;
    return this;
  }
  
  @NotNull
  public AudioModel a()
  {
    return new AudioModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, buildUnknownFields());
  }
  
  @NotNull
  public final Builder b(@Nullable Float paramFloat)
  {
    float f1;
    if (paramFloat != null) {
      f1 = paramFloat.floatValue();
    } else {
      f1 = 0.0F;
    }
    this.g = f1;
    return this;
  }
  
  @NotNull
  public final Builder b(@Nullable Long paramLong)
  {
    long l1;
    if (paramLong != null) {
      l1 = paramLong.longValue();
    } else {
      l1 = 0L;
    }
    this.k = l1;
    return this;
  }
  
  @NotNull
  public final Builder b(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.b = paramString;
    return this;
  }
  
  @NotNull
  public final Builder c(@Nullable Long paramLong)
  {
    long l1;
    if (paramLong != null) {
      l1 = paramLong.longValue();
    } else {
      l1 = 0L;
    }
    this.l = l1;
    return this;
  }
  
  @NotNull
  public final Builder c(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.Builder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "()V", "duration", "", "Ljava/lang/Long;", "end", "", "Ljava/lang/Float;", "endOffset", "interpolationType", "", "start", "startOffset", "build", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class VolumeEffect$Builder
  extends Message.Builder<VolumeEffect, Builder>
{
  @JvmField
  @Nullable
  public Long duration;
  @JvmField
  @Nullable
  public Float end;
  @JvmField
  @Nullable
  public Long endOffset;
  @JvmField
  @Nullable
  public String interpolationType;
  @JvmField
  @Nullable
  public Float start;
  @JvmField
  @Nullable
  public Long startOffset;
  
  @NotNull
  public VolumeEffect build()
  {
    return new VolumeEffect(this.startOffset, this.endOffset, this.duration, this.start, this.end, this.interpolationType, buildUnknownFields());
  }
  
  @NotNull
  public final Builder duration(@Nullable Long paramLong)
  {
    this.duration = paramLong;
    return this;
  }
  
  @NotNull
  public final Builder end(@Nullable Float paramFloat)
  {
    this.end = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder endOffset(@Nullable Long paramLong)
  {
    this.endOffset = paramLong;
    return this;
  }
  
  @NotNull
  public final Builder interpolationType(@Nullable String paramString)
  {
    this.interpolationType = paramString;
    return this;
  }
  
  @NotNull
  public final Builder start(@Nullable Float paramFloat)
  {
    this.start = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder startOffset(@Nullable Long paramLong)
  {
    this.startOffset = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.VolumeEffect.Builder
 * JD-Core Version:    0.7.0.1
 */
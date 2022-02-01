package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "()V", "maxDuration", "", "Ljava/lang/Integer;", "minDuration", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia$ImageDuration$Builder
  extends Message.Builder<MultiMedia.ImageDuration, Builder>
{
  @JvmField
  @Nullable
  public Integer maxDuration;
  @JvmField
  @Nullable
  public Integer minDuration;
  
  @NotNull
  public MultiMedia.ImageDuration build()
  {
    return new MultiMedia.ImageDuration(this.maxDuration, this.minDuration, buildUnknownFields());
  }
  
  @NotNull
  public final Builder maxDuration(@Nullable Integer paramInteger)
  {
    this.maxDuration = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder minDuration(@Nullable Integer paramInteger)
  {
    this.minDuration = paramInteger;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia.ImageDuration.Builder
 * JD-Core Version:    0.7.0.1
 */
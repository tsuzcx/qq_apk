package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/LayerMarkData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LayerMarkData;", "()V", "desc", "", "durationUs", "", "Ljava/lang/Long;", "startTimeUs", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LayerMarkData$Builder
  extends Message.Builder<LayerMarkData, Builder>
{
  @JvmField
  @Nullable
  public String desc;
  @JvmField
  @Nullable
  public Long durationUs;
  @JvmField
  @Nullable
  public Long startTimeUs;
  
  @NotNull
  public LayerMarkData build()
  {
    Long localLong = this.startTimeUs;
    if (localLong != null)
    {
      long l = localLong.longValue();
      localLong = this.durationUs;
      if (localLong != null) {
        return new LayerMarkData(l, localLong.longValue(), this.desc, buildUnknownFields());
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "durationUs" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "startTimeUs" }));
  }
  
  @NotNull
  public final Builder desc(@Nullable String paramString)
  {
    this.desc = paramString;
    return this;
  }
  
  @NotNull
  public final Builder durationUs(long paramLong)
  {
    this.durationUs = Long.valueOf(paramLong);
    return this;
  }
  
  @NotNull
  public final Builder startTimeUs(long paramLong)
  {
    this.startTimeUs = Long.valueOf(paramLong);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LayerMarkData.Builder
 * JD-Core Version:    0.7.0.1
 */
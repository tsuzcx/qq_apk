package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/TimeRange$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "()V", "duration", "", "Ljava/lang/Long;", "startTime", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TimeRange$Builder
  extends Message.Builder<TimeRange, Builder>
{
  @JvmField
  @Nullable
  public Long duration;
  @JvmField
  @Nullable
  public Long startTime;
  
  @NotNull
  public TimeRange build()
  {
    Long localLong = this.startTime;
    if (localLong != null)
    {
      long l = localLong.longValue();
      localLong = this.duration;
      if (localLong != null) {
        return new TimeRange(l, localLong.longValue(), buildUnknownFields());
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "duration" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "startTime" }));
  }
  
  @NotNull
  public final Builder duration(long paramLong)
  {
    this.duration = Long.valueOf(paramLong);
    return this;
  }
  
  @NotNull
  public final Builder startTime(long paramLong)
  {
    this.startTime = Long.valueOf(paramLong);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeRange.Builder
 * JD-Core Version:    0.7.0.1
 */
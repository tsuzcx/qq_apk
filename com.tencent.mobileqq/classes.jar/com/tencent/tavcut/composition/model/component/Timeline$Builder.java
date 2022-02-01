package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "()V", "entityID", "", "Ljava/lang/Integer;", "event", "", "range", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "time", "", "Ljava/lang/Long;", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Timeline$Builder
  extends Message.Builder<Timeline, Builder>
{
  @JvmField
  @Nullable
  public Integer entityID;
  @JvmField
  @Nullable
  public String event;
  @JvmField
  @Nullable
  public TimeRange range;
  @JvmField
  @Nullable
  public Long time;
  @JvmField
  @Nullable
  public String type;
  
  @NotNull
  public Timeline build()
  {
    return new Timeline(this.entityID, this.type, this.range, this.time, this.event, buildUnknownFields());
  }
  
  @NotNull
  public final Builder entityID(@Nullable Integer paramInteger)
  {
    this.entityID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder event(@Nullable String paramString)
  {
    this.event = paramString;
    return this;
  }
  
  @NotNull
  public final Builder range(@Nullable TimeRange paramTimeRange)
  {
    this.range = paramTimeRange;
    return this;
  }
  
  @NotNull
  public final Builder time(@Nullable Long paramLong)
  {
    this.time = paramLong;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Timeline.Builder
 * JD-Core Version:    0.7.0.1
 */
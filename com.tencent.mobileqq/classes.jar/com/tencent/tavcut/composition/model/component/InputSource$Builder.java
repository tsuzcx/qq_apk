package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "()V", "events", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "inputKey", "", "key", "label", "loopCount", "", "Ljava/lang/Integer;", "path", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "timeStretchMode", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource$Builder
  extends Message.Builder<InputSource, Builder>
{
  @JvmField
  @Nullable
  public InputSource.Event events;
  @JvmField
  @Nullable
  public String inputKey;
  @JvmField
  @Nullable
  public String key;
  @JvmField
  @Nullable
  public String label;
  @JvmField
  @Nullable
  public Integer loopCount;
  @JvmField
  @Nullable
  public String path;
  @JvmField
  @Nullable
  public TimeRange timeRange;
  @JvmField
  @Nullable
  public Integer timeStretchMode;
  @JvmField
  @Nullable
  public String type;
  
  @NotNull
  public InputSource build()
  {
    return new InputSource(this.key, this.type, this.path, this.label, this.timeRange, this.loopCount, this.events, this.inputKey, this.timeStretchMode, buildUnknownFields());
  }
  
  @NotNull
  public final Builder events(@Nullable InputSource.Event paramEvent)
  {
    this.events = paramEvent;
    return this;
  }
  
  @NotNull
  public final Builder inputKey(@Nullable String paramString)
  {
    this.inputKey = paramString;
    return this;
  }
  
  @NotNull
  public final Builder key(@Nullable String paramString)
  {
    this.key = paramString;
    return this;
  }
  
  @NotNull
  public final Builder label(@Nullable String paramString)
  {
    this.label = paramString;
    return this;
  }
  
  @NotNull
  public final Builder loopCount(@Nullable Integer paramInteger)
  {
    this.loopCount = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder path(@Nullable String paramString)
  {
    this.path = paramString;
    return this;
  }
  
  @NotNull
  public final Builder timeRange(@Nullable TimeRange paramTimeRange)
  {
    this.timeRange = paramTimeRange;
    return this;
  }
  
  @NotNull
  public final Builder timeStretchMode(@Nullable Integer paramInteger)
  {
    this.timeStretchMode = paramInteger;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource.Builder
 * JD-Core Version:    0.7.0.1
 */
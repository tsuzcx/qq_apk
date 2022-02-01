package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/FilterGroup$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "()V", "componentID", "", "Ljava/lang/Integer;", "enabled", "", "Ljava/lang/Boolean;", "entityId", "name", "", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/FilterGroup$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/FilterGroup$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class FilterGroup$Builder
  extends Message.Builder<FilterGroup, Builder>
{
  @JvmField
  @Nullable
  public Integer componentID;
  @JvmField
  @Nullable
  public Boolean enabled;
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public String name;
  @JvmField
  @Nullable
  public String type;
  
  @NotNull
  public FilterGroup build()
  {
    return new FilterGroup(this.entityId, this.componentID, this.enabled, this.type, this.name, buildUnknownFields());
  }
  
  @NotNull
  public final Builder componentID(@Nullable Integer paramInteger)
  {
    this.componentID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder enabled(@Nullable Boolean paramBoolean)
  {
    this.enabled = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder entityId(@Nullable Integer paramInteger)
  {
    this.entityId = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder name(@Nullable String paramString)
  {
    this.name = paramString;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.FilterGroup.Builder
 * JD-Core Version:    0.7.0.1
 */
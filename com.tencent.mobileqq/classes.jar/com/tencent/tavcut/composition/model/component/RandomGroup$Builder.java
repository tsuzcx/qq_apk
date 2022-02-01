package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/RandomGroup;", "()V", "componentID", "", "Ljava/lang/Integer;", "enabled", "", "Ljava/lang/Boolean;", "entityId", "randomType", "type", "", "weights", "", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class RandomGroup$Builder
  extends Message.Builder<RandomGroup, Builder>
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
  public Integer randomType;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  @NotNull
  public List<Integer> weights = CollectionsKt.emptyList();
  
  @NotNull
  public RandomGroup build()
  {
    return new RandomGroup(this.entityId, this.componentID, this.enabled, this.type, this.randomType, this.weights, buildUnknownFields());
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
  public final Builder randomType(@Nullable Integer paramInteger)
  {
    this.randomType = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  @NotNull
  public final Builder weights(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "weights");
    Internal.checkElementsNotNull(paramList);
    this.weights = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.RandomGroup.Builder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavcut.rendermodel.component;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "", "data", "(Ljava/lang/Object;)V", "id", "", "entityId", "rawData", "Lcom/google/gson/JsonObject;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Lcom/google/gson/JsonObject;)V", "getData", "()Ljava/lang/Object;", "getEntityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getRawData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Lcom/google/gson/JsonObject;)Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class IdentifyComponent
{
  @NotNull
  private final Object data;
  @Nullable
  private final Integer entityId;
  @Nullable
  private final Integer id;
  @Nullable
  private final JsonObject rawData;
  
  public IdentifyComponent(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull Object paramObject, @Nullable JsonObject paramJsonObject)
  {
    this.id = paramInteger1;
    this.entityId = paramInteger2;
    this.data = paramObject;
    this.rawData = paramJsonObject;
  }
  
  public IdentifyComponent(@NotNull Object paramObject)
  {
    this(localInteger, localInteger, paramObject, null, 8, null);
  }
  
  @Nullable
  public final Integer component1()
  {
    return this.id;
  }
  
  @Nullable
  public final Integer component2()
  {
    return this.entityId;
  }
  
  @NotNull
  public final Object component3()
  {
    return this.data;
  }
  
  @Nullable
  public final JsonObject component4()
  {
    return this.rawData;
  }
  
  @NotNull
  public final IdentifyComponent copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull Object paramObject, @Nullable JsonObject paramJsonObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    return new IdentifyComponent(paramInteger1, paramInteger2, paramObject, paramJsonObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof IdentifyComponent))
      {
        paramObject = (IdentifyComponent)paramObject;
        if ((Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.entityId, paramObject.entityId)) && (Intrinsics.areEqual(this.data, paramObject.data)) && (Intrinsics.areEqual(this.rawData, paramObject.rawData))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Object getData()
  {
    return this.data;
  }
  
  @Nullable
  public final Integer getEntityId()
  {
    return this.entityId;
  }
  
  @Nullable
  public final Integer getId()
  {
    return this.id;
  }
  
  @Nullable
  public final JsonObject getRawData()
  {
    return this.rawData;
  }
  
  public int hashCode()
  {
    Object localObject = this.id;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.entityId;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.data;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.rawData;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IdentifyComponent(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", entityId=");
    localStringBuilder.append(this.entityId);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append(", rawData=");
    localStringBuilder.append(this.rawData);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.component.IdentifyComponent
 * JD-Core Version:    0.7.0.1
 */
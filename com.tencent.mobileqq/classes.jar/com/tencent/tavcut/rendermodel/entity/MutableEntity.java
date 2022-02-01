package com.tencent.tavcut.rendermodel.entity;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/entity/MutableEntity;", "", "entities", "", "", "Lcom/tencent/tavcut/rendermodel/entity/EntityId;", "components", "rawComponents", "Lcom/google/gson/JsonObject;", "entityMapToComponent", "", "byComponentType", "", "parentMapToEntity", "entityMapToParent", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getByComponentType", "()Ljava/util/Map;", "getComponents", "getEntities", "getEntityMapToComponent", "getEntityMapToParent", "getParentMapToEntity", "getRawComponents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MutableEntity
{
  public static final MutableEntity.Companion Companion = new MutableEntity.Companion(null);
  public static final int ROOT_NONE = 0;
  @NotNull
  private final Map<String, List<Integer>> byComponentType;
  @NotNull
  private final Map<Integer, Object> components;
  @NotNull
  private final Map<Integer, EntityId> entities;
  @NotNull
  private final Map<Integer, List<Integer>> entityMapToComponent;
  @NotNull
  private final Map<Integer, Integer> entityMapToParent;
  @NotNull
  private final Map<Integer, List<Integer>> parentMapToEntity;
  @NotNull
  private final Map<Integer, JsonObject> rawComponents;
  
  public MutableEntity()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public MutableEntity(@NotNull Map<Integer, EntityId> paramMap, @NotNull Map<Integer, ? extends Object> paramMap1, @NotNull Map<Integer, JsonObject> paramMap2, @NotNull Map<Integer, ? extends List<Integer>> paramMap3, @NotNull Map<String, ? extends List<Integer>> paramMap4, @NotNull Map<Integer, ? extends List<Integer>> paramMap5, @NotNull Map<Integer, Integer> paramMap6)
  {
    this.entities = paramMap;
    this.components = paramMap1;
    this.rawComponents = paramMap2;
    this.entityMapToComponent = paramMap3;
    this.byComponentType = paramMap4;
    this.parentMapToEntity = paramMap5;
    this.entityMapToParent = paramMap6;
  }
  
  @NotNull
  public final Map<Integer, EntityId> component1()
  {
    return this.entities;
  }
  
  @NotNull
  public final Map<Integer, Object> component2()
  {
    return this.components;
  }
  
  @NotNull
  public final Map<Integer, JsonObject> component3()
  {
    return this.rawComponents;
  }
  
  @NotNull
  public final Map<Integer, List<Integer>> component4()
  {
    return this.entityMapToComponent;
  }
  
  @NotNull
  public final Map<String, List<Integer>> component5()
  {
    return this.byComponentType;
  }
  
  @NotNull
  public final Map<Integer, List<Integer>> component6()
  {
    return this.parentMapToEntity;
  }
  
  @NotNull
  public final Map<Integer, Integer> component7()
  {
    return this.entityMapToParent;
  }
  
  @NotNull
  public final MutableEntity copy(@NotNull Map<Integer, EntityId> paramMap, @NotNull Map<Integer, ? extends Object> paramMap1, @NotNull Map<Integer, JsonObject> paramMap2, @NotNull Map<Integer, ? extends List<Integer>> paramMap3, @NotNull Map<String, ? extends List<Integer>> paramMap4, @NotNull Map<Integer, ? extends List<Integer>> paramMap5, @NotNull Map<Integer, Integer> paramMap6)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "entities");
    Intrinsics.checkParameterIsNotNull(paramMap1, "components");
    Intrinsics.checkParameterIsNotNull(paramMap2, "rawComponents");
    Intrinsics.checkParameterIsNotNull(paramMap3, "entityMapToComponent");
    Intrinsics.checkParameterIsNotNull(paramMap4, "byComponentType");
    Intrinsics.checkParameterIsNotNull(paramMap5, "parentMapToEntity");
    Intrinsics.checkParameterIsNotNull(paramMap6, "entityMapToParent");
    return new MutableEntity(paramMap, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap6);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MutableEntity))
      {
        paramObject = (MutableEntity)paramObject;
        if ((Intrinsics.areEqual(this.entities, paramObject.entities)) && (Intrinsics.areEqual(this.components, paramObject.components)) && (Intrinsics.areEqual(this.rawComponents, paramObject.rawComponents)) && (Intrinsics.areEqual(this.entityMapToComponent, paramObject.entityMapToComponent)) && (Intrinsics.areEqual(this.byComponentType, paramObject.byComponentType)) && (Intrinsics.areEqual(this.parentMapToEntity, paramObject.parentMapToEntity)) && (Intrinsics.areEqual(this.entityMapToParent, paramObject.entityMapToParent))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Map<String, List<Integer>> getByComponentType()
  {
    return this.byComponentType;
  }
  
  @NotNull
  public final Map<Integer, Object> getComponents()
  {
    return this.components;
  }
  
  @NotNull
  public final Map<Integer, EntityId> getEntities()
  {
    return this.entities;
  }
  
  @NotNull
  public final Map<Integer, List<Integer>> getEntityMapToComponent()
  {
    return this.entityMapToComponent;
  }
  
  @NotNull
  public final Map<Integer, Integer> getEntityMapToParent()
  {
    return this.entityMapToParent;
  }
  
  @NotNull
  public final Map<Integer, List<Integer>> getParentMapToEntity()
  {
    return this.parentMapToEntity;
  }
  
  @NotNull
  public final Map<Integer, JsonObject> getRawComponents()
  {
    return this.rawComponents;
  }
  
  public int hashCode()
  {
    Map localMap = this.entities;
    int i2 = 0;
    int i;
    if (localMap != null) {
      i = localMap.hashCode();
    } else {
      i = 0;
    }
    localMap = this.components;
    int j;
    if (localMap != null) {
      j = localMap.hashCode();
    } else {
      j = 0;
    }
    localMap = this.rawComponents;
    int k;
    if (localMap != null) {
      k = localMap.hashCode();
    } else {
      k = 0;
    }
    localMap = this.entityMapToComponent;
    int m;
    if (localMap != null) {
      m = localMap.hashCode();
    } else {
      m = 0;
    }
    localMap = this.byComponentType;
    int n;
    if (localMap != null) {
      n = localMap.hashCode();
    } else {
      n = 0;
    }
    localMap = this.parentMapToEntity;
    int i1;
    if (localMap != null) {
      i1 = localMap.hashCode();
    } else {
      i1 = 0;
    }
    localMap = this.entityMapToParent;
    if (localMap != null) {
      i2 = localMap.hashCode();
    }
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutableEntity(entities=");
    localStringBuilder.append(this.entities);
    localStringBuilder.append(", components=");
    localStringBuilder.append(this.components);
    localStringBuilder.append(", rawComponents=");
    localStringBuilder.append(this.rawComponents);
    localStringBuilder.append(", entityMapToComponent=");
    localStringBuilder.append(this.entityMapToComponent);
    localStringBuilder.append(", byComponentType=");
    localStringBuilder.append(this.byComponentType);
    localStringBuilder.append(", parentMapToEntity=");
    localStringBuilder.append(this.parentMapToEntity);
    localStringBuilder.append(", entityMapToParent=");
    localStringBuilder.append(this.entityMapToParent);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.entity.MutableEntity
 * JD-Core Version:    0.7.0.1
 */
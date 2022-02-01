package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/RenderData;", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "id", "", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/composition/model/component/InputSource;Ljava/lang/String;)V", "getEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getId", "()Ljava/lang/String;", "getInputSource", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RenderData
{
  @NotNull
  private final Entity a;
  @NotNull
  private final InputSource b;
  @NotNull
  private final String c;
  
  public RenderData(@NotNull Entity paramEntity, @NotNull InputSource paramInputSource, @NotNull String paramString)
  {
    this.a = paramEntity;
    this.b = paramInputSource;
    this.c = paramString;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  @NotNull
  public final RenderData a(@NotNull Entity paramEntity, @NotNull InputSource paramInputSource, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    return new RenderData(paramEntity, paramInputSource, paramString);
  }
  
  @NotNull
  public final InputSource b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RenderData))
      {
        paramObject = (RenderData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderData(entity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", inputSource=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.RenderData
 * JD-Core Version:    0.7.0.1
 */
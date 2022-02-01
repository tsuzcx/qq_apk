package com.tencent.videocut.render;

import .r8.java8methods.utility.Integer.hashCode.II;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/SingleMediaRender$RenderData;", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "index", "", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;I)V", "getEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SingleMediaRender$RenderData
{
  @NotNull
  private final Entity a;
  private final int b;
  
  public SingleMediaRender$RenderData(@NotNull Entity paramEntity, int paramInt)
  {
    this.a = paramEntity;
    this.b = paramInt;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RenderData))
      {
        paramObject = (RenderData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
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
    Entity localEntity = this.a;
    int i;
    if (localEntity != null) {
      i = localEntity.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderData(entity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.SingleMediaRender.RenderData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.videocut.render.extension;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/extension/PipRenderTargetData;", "", "renderTargetEntity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "imageEntity", "inputSource", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/List;)V", "getImageEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getInputSource", "()Ljava/util/List;", "getRenderTargetEntity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipRenderTargetData
{
  @NotNull
  private final Entity a;
  @NotNull
  private final Entity b;
  @NotNull
  private final List<InputSource> c;
  
  public PipRenderTargetData(@NotNull Entity paramEntity1, @NotNull Entity paramEntity2, @NotNull List<InputSource> paramList)
  {
    this.a = paramEntity1;
    this.b = paramEntity2;
    this.c = paramList;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  @NotNull
  public final Entity b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<InputSource> c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PipRenderTargetData))
      {
        paramObject = (PipRenderTargetData)paramObject;
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
    localStringBuilder.append("PipRenderTargetData(renderTargetEntity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", imageEntity=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", inputSource=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.PipRenderTargetData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/StickerRenderHelper$RenderData;", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "bgInputSource", "id", "", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/composition/model/component/InputSource;Lcom/tencent/tavcut/composition/model/component/InputSource;Ljava/lang/String;)V", "getBgInputSource", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "getEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getId", "()Ljava/lang/String;", "getInputSource", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerRenderHelper$RenderData
{
  @NotNull
  private final Entity a;
  @NotNull
  private final InputSource b;
  @Nullable
  private final InputSource c;
  @NotNull
  private final String d;
  
  public StickerRenderHelper$RenderData(@NotNull Entity paramEntity, @NotNull InputSource paramInputSource1, @Nullable InputSource paramInputSource2, @NotNull String paramString)
  {
    this.a = paramEntity;
    this.b = paramInputSource1;
    this.c = paramInputSource2;
    this.d = paramString;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  @NotNull
  public final InputSource b()
  {
    return this.b;
  }
  
  @Nullable
  public final InputSource c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RenderData))
      {
        paramObject = (RenderData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int m = 0;
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
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderData(entity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", inputSource=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", bgInputSource=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.StickerRenderHelper.RenderData
 * JD-Core Version:    0.7.0.1
 */
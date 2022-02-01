package com.tencent.videocut.render.extension;

import .r8.java8methods.utility.Integer.hashCode.II;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/extension/PipRenderData;", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSource", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "timelineIndex", "", "pipId", "", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/List;ILjava/lang/String;)V", "getEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getInputSource", "()Ljava/util/List;", "getPipId", "()Ljava/lang/String;", "getTimelineIndex", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipRenderData
{
  @NotNull
  private final Entity a;
  @NotNull
  private final List<InputSource> b;
  private final int c;
  @NotNull
  private final String d;
  
  public PipRenderData(@NotNull Entity paramEntity, @NotNull List<InputSource> paramList, int paramInt, @NotNull String paramString)
  {
    this.a = paramEntity;
    this.b = paramList;
    this.c = paramInt;
    this.d = paramString;
  }
  
  @NotNull
  public final Entity a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<InputSource> b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PipRenderData))
      {
        paramObject = (PipRenderData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int m = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.c);
    localObject = this.d;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + m) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PipRenderData(entity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", inputSource=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", timelineIndex=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", pipId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.PipRenderData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.videocut.render;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/TransitionRenderData;", "", "index", "", "renderData", "Lcom/tencent/videocut/render/RenderData;", "(ILcom/tencent/videocut/render/RenderData;)V", "getIndex", "()I", "getRenderData", "()Lcom/tencent/videocut/render/RenderData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionRenderData
{
  private final int a;
  @NotNull
  private final RenderData b;
  
  public TransitionRenderData(int paramInt, @NotNull RenderData paramRenderData)
  {
    this.a = paramInt;
    this.b = paramRenderData;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final RenderData b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TransitionRenderData))
      {
        paramObject = (TransitionRenderData)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    int j = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a);
    RenderData localRenderData = this.b;
    int i;
    if (localRenderData != null) {
      i = localRenderData.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransitionRenderData(index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", renderData=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.TransitionRenderData
 * JD-Core Version:    0.7.0.1
 */
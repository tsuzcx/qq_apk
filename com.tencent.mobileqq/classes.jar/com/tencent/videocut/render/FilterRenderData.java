package com.tencent.videocut.render;

import .r8.java8methods.utility.Integer.hashCode.II;
import com.tencent.videocut.model.FilterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/FilterRenderData;", "", "index", "", "filterModel", "Lcom/tencent/videocut/model/FilterModel;", "parentId", "", "(ILcom/tencent/videocut/model/FilterModel;Ljava/lang/String;)V", "getFilterModel", "()Lcom/tencent/videocut/model/FilterModel;", "getIndex", "()I", "getParentId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FilterRenderData
{
  private final int a;
  @NotNull
  private final FilterModel b;
  @NotNull
  private final String c;
  
  public FilterRenderData(int paramInt, @NotNull FilterModel paramFilterModel, @NotNull String paramString)
  {
    this.a = paramInt;
    this.b = paramFilterModel;
    this.c = paramString;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final FilterModel b()
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
      if ((paramObject instanceof FilterRenderData))
      {
        paramObject = (FilterRenderData)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    int k = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a);
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterRenderData(index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", filterModel=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", parentId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.FilterRenderData
 * JD-Core Version:    0.7.0.1
 */
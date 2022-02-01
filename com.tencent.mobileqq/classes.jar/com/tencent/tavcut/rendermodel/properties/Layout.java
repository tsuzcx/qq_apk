package com.tencent.tavcut.rendermodel.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/properties/Layout;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/tavcut/rendermodel/properties/Layout;", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Layout
{
  @Nullable
  private final Integer height;
  @Nullable
  private final Integer width;
  
  public Layout()
  {
    this(null, null, 3, null);
  }
  
  public Layout(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    this.width = paramInteger1;
    this.height = paramInteger2;
  }
  
  @Nullable
  public final Integer component1()
  {
    return this.width;
  }
  
  @Nullable
  public final Integer component2()
  {
    return this.height;
  }
  
  @NotNull
  public final Layout copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    return new Layout(paramInteger1, paramInteger2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Layout))
      {
        paramObject = (Layout)paramObject;
        if ((Intrinsics.areEqual(this.width, paramObject.width)) && (Intrinsics.areEqual(this.height, paramObject.height))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final Integer getHeight()
  {
    return this.height;
  }
  
  @Nullable
  public final Integer getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.width;
    int j = 0;
    int i;
    if (localInteger != null) {
      i = localInteger.hashCode();
    } else {
      i = 0;
    }
    localInteger = this.height;
    if (localInteger != null) {
      j = localInteger.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Layout(width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.properties.Layout
 * JD-Core Version:    0.7.0.1
 */
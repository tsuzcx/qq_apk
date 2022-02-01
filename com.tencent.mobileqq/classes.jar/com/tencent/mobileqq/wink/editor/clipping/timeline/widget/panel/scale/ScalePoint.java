package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScalePoint;", "", "position", "", "type", "(II)V", "getPosition", "()I", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ScalePoint
{
  private final int a;
  private final int b;
  
  public ScalePoint(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a()
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
      if ((paramObject instanceof ScalePoint))
      {
        paramObject = (ScalePoint)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b)) {}
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
    return .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScalePoint(position=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScalePoint
 * JD-Core Version:    0.7.0.1
 */
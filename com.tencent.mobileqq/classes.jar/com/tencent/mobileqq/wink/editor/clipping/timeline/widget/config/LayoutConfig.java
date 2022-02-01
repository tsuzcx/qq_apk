package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;", "", "panelStartOffset", "", "courseTopMargin", "", "courseWidth", "courseElevation", "courseColor", "(IFFFI)V", "getCourseColor", "()I", "getCourseElevation", "()F", "getCourseTopMargin", "getCourseWidth", "getPanelStartOffset", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LayoutConfig
{
  private final int a;
  private final float b;
  private final float c;
  private final float d;
  private final int e;
  
  public LayoutConfig()
  {
    this(0, 0.0F, 0.0F, 0.0F, 0, 31, null);
  }
  
  public LayoutConfig(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.e = paramInt2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final LayoutConfig a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    return new LayoutConfig(paramInt1, paramFloat1, paramFloat2, paramFloat3, paramInt2);
  }
  
  public final float b()
  {
    return this.b;
  }
  
  public final float c()
  {
    return this.c;
  }
  
  public final float d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LayoutConfig))
      {
        paramObject = (LayoutConfig)paramObject;
        if ((this.a == paramObject.a) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0) && (Float.compare(this.d, paramObject.d) == 0) && (this.e == paramObject.e)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float f()
  {
    return this.c;
  }
  
  public final float g()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return (((.r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.b)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.c)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.d)) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayoutConfig(panelStartOffset=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", courseTopMargin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", courseWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", courseElevation=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", courseColor=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig
 * JD-Core Version:    0.7.0.1
 */
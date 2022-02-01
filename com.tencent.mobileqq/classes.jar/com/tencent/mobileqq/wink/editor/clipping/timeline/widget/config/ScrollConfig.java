package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config;

import .r8.java8methods.utility.Float.hashCode.IF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/ScrollConfig;", "", "flingFactor", "", "(F)V", "getFlingFactor", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ScrollConfig
{
  private final float a;
  
  public ScrollConfig()
  {
    this(0.0F, 1, null);
  }
  
  public ScrollConfig(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public final float a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ScrollConfig))
      {
        paramObject = (ScrollConfig)paramObject;
        if (Float.compare(this.a, paramObject.a) == 0) {}
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
    return .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.a);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScrollConfig(flingFactor=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.ScrollConfig
 * JD-Core Version:    0.7.0.1
 */
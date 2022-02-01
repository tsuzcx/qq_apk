package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import .r8.java8methods.utility.Float.hashCode.IF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackConfig;", "", "trackHeight", "", "trackMargin", "contentTopMargin", "(FFF)V", "getContentTopMargin", "()F", "getTrackHeight", "getTrackMargin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TrackConfig
{
  private final float a;
  private final float b;
  private final float c;
  
  public TrackConfig()
  {
    this(0.0F, 0.0F, 0.0F, 7, null);
  }
  
  public TrackConfig(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public final float a()
  {
    return this.a;
  }
  
  public final float b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TrackConfig))
      {
        paramObject = (TrackConfig)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0)) {}
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
    return (.r8.java8methods.utility.Float.hashCode.IF.hashCode(this.a) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.b)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.c);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TrackConfig(trackHeight=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", trackMargin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", contentTopMargin=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TrackConfig
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TransitionData;", "", "overlapTimeUs", "", "(J)V", "getOverlapTimeUs", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionData
{
  private final long a;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TransitionData))
      {
        paramObject = (TransitionData)paramObject;
        if (this.a == paramObject.a) {}
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
    return .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.a);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransitionData(overlapTimeUs=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TransitionData
 * JD-Core Version:    0.7.0.1
 */
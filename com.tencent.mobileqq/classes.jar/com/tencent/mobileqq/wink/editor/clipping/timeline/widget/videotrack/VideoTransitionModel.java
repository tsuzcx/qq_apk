package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTransitionModel;", "", "uuid", "", "position", "", "data", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TransitionData;", "drawData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "(Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TransitionData;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;)V", "getData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TransitionData;", "getDrawData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "getPosition", "()I", "getUuid", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTransitionModel
{
  @NotNull
  private final String a;
  private final int b;
  @Nullable
  private final TransitionData c;
  @NotNull
  private final DrawData d;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoTransitionModel))
      {
        paramObject = (VideoTransitionModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int m = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((i * 31 + m) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoTransitionModel(uuid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", drawData=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTransitionModel
 * JD-Core Version:    0.7.0.1
 */
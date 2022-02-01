package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackData;", "", "videoTrackModelList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "transitionModelList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTransitionModel;", "(Ljava/util/List;Ljava/util/List;)V", "getTransitionModelList", "()Ljava/util/List;", "getVideoTrackModelList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackData
{
  @NotNull
  private final List<ClipModel> a;
  @NotNull
  private final List<VideoTransitionModel> b;
  
  public VideoTrackData()
  {
    this(null, null, 3, null);
  }
  
  public VideoTrackData(@NotNull List<ClipModel> paramList, @NotNull List<VideoTransitionModel> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  @NotNull
  public final List<ClipModel> a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<VideoTransitionModel> b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoTrackData))
      {
        paramObject = (VideoTrackData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    List localList = this.a;
    int j = 0;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    localList = this.b;
    if (localList != null) {
      j = localList.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoTrackData(videoTrackModelList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", transitionModelList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData
 * JD-Core Version:    0.7.0.1
 */
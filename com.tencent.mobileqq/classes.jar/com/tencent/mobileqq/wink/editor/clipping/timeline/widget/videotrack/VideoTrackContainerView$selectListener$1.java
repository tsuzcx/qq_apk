package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$selectListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$ContentSelectListener;", "onSelected", "", "id", "", "selectedStatus", "", "isClickStartClipRegion", "", "isClickEndClipRegion", "view", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackContainerView$selectListener$1
  implements VideoTrackTimelineView.ContentSelectListener
{
  @RequiresApi(17)
  public void a(@NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, @NotNull VideoTrackTimelineView paramVideoTrackTimelineView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Intrinsics.checkParameterIsNotNull(paramVideoTrackTimelineView, "view");
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      paramVideoTrackTimelineView = VideoTrackContainerView.b(this.a);
      if (paramVideoTrackTimelineView != null) {
        paramVideoTrackTimelineView.a(paramString, paramInt);
      }
    }
    else
    {
      int i = VideoTrackContainerView.d(this.a).indexOf(paramVideoTrackTimelineView);
      if (paramBoolean1) {
        paramVideoTrackTimelineView = (VideoTrackTimelineView)CollectionsKt.getOrNull(VideoTrackContainerView.d(this.a), i - 1);
      } else {
        paramVideoTrackTimelineView = (VideoTrackTimelineView)CollectionsKt.getOrNull(VideoTrackContainerView.d(this.a), i + 1);
      }
      if (paramVideoTrackTimelineView == null)
      {
        paramVideoTrackTimelineView = VideoTrackContainerView.b(this.a);
        if (paramVideoTrackTimelineView != null) {
          paramVideoTrackTimelineView.a(paramString, paramInt);
        }
      }
      else
      {
        paramVideoTrackTimelineView.c(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView.selectListener.1
 * JD-Core Version:    0.7.0.1
 */
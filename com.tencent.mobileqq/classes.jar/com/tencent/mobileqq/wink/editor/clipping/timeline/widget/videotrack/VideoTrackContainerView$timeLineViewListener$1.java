package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TimelineViewListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$timeLineViewListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TimelineViewListener;", "onTimeSliderMoveEnd", "", "dragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "isLeft", "", "onTimelinePositionChanged", "onTimelineViewSelected", "selected", "view", "Landroid/view/View;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackContainerView$timeLineViewListener$1
  implements TimelineViewListener
{
  public void a(@NotNull DragModel paramDragModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragModel, "dragModel");
  }
  
  @RequiresApi(17)
  public void a(@NotNull DragModel paramDragModel, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramDragModel, "dragModel");
    VideoTrackController localVideoTrackController = VideoTrackContainerView.b(this.a);
    if (localVideoTrackController != null) {
      localVideoTrackController.a(paramDragModel.f(), paramBoolean);
    }
    VideoTrackContainerView.c(this.a);
  }
  
  public void a(boolean paramBoolean, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView.timeLineViewListener.1
 * JD-Core Version:    0.7.0.1
 */
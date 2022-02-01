package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ClipItemLongClickListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$refreshVideoClip$1$1$1", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$$special$$inlined$let$lambda$1"}, k=3, mv={1, 1, 16})
final class VideoTrackContainerView$refreshVideoClip$$inlined$forEachIndexed$lambda$1
  implements View.OnLongClickListener
{
  VideoTrackContainerView$refreshVideoClip$$inlined$forEachIndexed$lambda$1(ClipItemLongClickListener paramClipItemLongClickListener, VideoTrackTimelineView paramVideoTrackTimelineView, VideoTrackModel paramVideoTrackModel, VideoTrackContainerView paramVideoTrackContainerView, ScaleCalculator paramScaleCalculator, List paramList) {}
  
  public final boolean onLongClick(View paramView)
  {
    this.a.onLongClick(this.c.b(), VideoTrackContainerView.a(this.d));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView.refreshVideoClip..inlined.forEachIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */
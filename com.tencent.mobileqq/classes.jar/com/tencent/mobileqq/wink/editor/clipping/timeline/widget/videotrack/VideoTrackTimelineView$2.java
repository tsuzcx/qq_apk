package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class VideoTrackTimelineView$2
  implements View.OnTouchListener
{
  VideoTrackTimelineView$2(VideoTrackTimelineView paramVideoTrackTimelineView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    if (paramMotionEvent.getActionMasked() == 0) {
      VideoTrackTimelineView.a(this.a, TuplesKt.to(Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY())));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel$onScaleGestureListener$1", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimelinePanel$onScaleGestureListener$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  public boolean onScale(@NotNull ScaleGestureDetector paramScaleGestureDetector)
  {
    Intrinsics.checkParameterIsNotNull(paramScaleGestureDetector, "detector");
    TimelinePanelViewController localTimelinePanelViewController = TimelinePanel.a(this.a);
    if (localTimelinePanelViewController != null) {
      localTimelinePanelViewController.a(paramScaleGestureDetector.getScaleFactor());
    }
    return true;
  }
  
  public boolean onScaleBegin(@NotNull ScaleGestureDetector paramScaleGestureDetector)
  {
    Intrinsics.checkParameterIsNotNull(paramScaleGestureDetector, "detector");
    return true;
  }
  
  public void onScaleEnd(@NotNull ScaleGestureDetector paramScaleGestureDetector)
  {
    Intrinsics.checkParameterIsNotNull(paramScaleGestureDetector, "detector");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel.onScaleGestureListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TimelineViewListener;", "", "onTimeSliderMoveEnd", "", "dragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "isLeft", "", "onTimelinePositionChanged", "onTimelineViewSelected", "selected", "view", "Landroid/view/View;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface TimelineViewListener
{
  public abstract void a(@NotNull DragModel paramDragModel);
  
  public abstract void a(@NotNull DragModel paramDragModel, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, @NotNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TimelineViewListener
 * JD-Core Version:    0.7.0.1
 */
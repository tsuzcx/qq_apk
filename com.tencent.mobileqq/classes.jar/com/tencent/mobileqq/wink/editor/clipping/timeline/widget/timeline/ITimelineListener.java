package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/ITimelineListener;", "", "onSliderDown", "", "rawX", "", "onSliderMoveEnd", "isLeft", "", "onSliderMoving", "startEvent", "Landroid/view/MotionEvent;", "endEvent", "left", "moveX", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ITimelineListener
{
  public abstract void a(float paramFloat, boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.ITimelineListener
 * JD-Core Version:    0.7.0.1
 */
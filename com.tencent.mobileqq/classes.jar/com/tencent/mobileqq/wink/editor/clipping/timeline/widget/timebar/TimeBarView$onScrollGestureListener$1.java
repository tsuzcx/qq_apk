package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.TimeBarClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView$onScrollGestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onScroll", "distanceX", "distanceY", "onSingleTapUp", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimeBarView$onScrollGestureListener$1
  extends GestureDetector.SimpleOnGestureListener
{
  public boolean onDown(@Nullable MotionEvent paramMotionEvent)
  {
    paramMotionEvent = TimeBarView.a(this.a);
    if (paramMotionEvent != null)
    {
      paramMotionEvent = paramMotionEvent.f();
      if (paramMotionEvent != null) {
        paramMotionEvent.b();
      }
    }
    return true;
  }
  
  public boolean onFling(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent1 = TimeBarView.a(this.a);
    if (paramMotionEvent1 != null)
    {
      paramMotionEvent1 = paramMotionEvent1.f();
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.a(-paramFloat1, this.a.getScrollX(), TimeBarView.b(this.a), TimeBarView.c(this.a));
      }
    }
    return false;
  }
  
  public boolean onScroll(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent1 = TimeBarView.a(this.a);
    if (paramMotionEvent1 != null)
    {
      paramMotionEvent1 = paramMotionEvent1.f();
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.b();
      }
    }
    int j = this.a.getScrollX() + (int)paramFloat1;
    int i;
    if (j < 0)
    {
      i = 0;
    }
    else
    {
      i = j;
      if (j > TimeBarView.b(this.a)) {
        i = TimeBarView.b(this.a);
      }
    }
    paramMotionEvent1 = TimeBarView.a(this.a);
    if (paramMotionEvent1 != null) {
      paramMotionEvent1.b(i);
    }
    return false;
  }
  
  public boolean onSingleTapUp(@Nullable MotionEvent paramMotionEvent)
  {
    TimeBarViewController localTimeBarViewController = TimeBarView.a(this.a);
    if (localTimeBarViewController != null) {
      localTimeBarViewController.c().a((PanelEvent)new TimeBarClickEvent());
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView.onScrollGestureListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.ActiveChangedEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$positionChangedHandler$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler;", "onMoveEnd", "", "positionOffset", "", "isUp", "", "view", "Landroid/view/View;", "isLeft", "onSliderDown", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackController$positionChangedHandler$1
  extends PositionChangedHandler
{
  VideoTrackController$positionChangedHandler$1(IDragDropScrollView paramIDragDropScrollView)
  {
    super(localIDragDropScrollView);
  }
  
  public void a(int paramInt, boolean paramBoolean1, @NotNull View paramView, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.a(paramInt, paramBoolean1, paramView, paramBoolean2);
    if (paramBoolean1) {
      this.b.c().a((PanelEvent)new ActiveChangedEvent(false));
    }
  }
  
  public void c()
  {
    super.c();
    this.b.c().a((PanelEvent)new ActiveChangedEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController.positionChangedHandler.1
 * JD-Core Version:    0.7.0.1
 */
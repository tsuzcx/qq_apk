package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackEmptyClickEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoTrackContainerView$1
  implements View.OnClickListener
{
  VideoTrackContainerView$1(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public final void onClick(View paramView)
  {
    VideoTrackController localVideoTrackController = VideoTrackContainerView.b(this.a);
    if (localVideoTrackController != null) {
      localVideoTrackController.c().a((PanelEvent)new VideoTrackEmptyClickEvent());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LiveRoomDisplayView$bindEvent$5
  implements View.OnClickListener
{
  LiveRoomDisplayView$bindEvent$5(LiveRoomDisplayView paramLiveRoomDisplayView) {}
  
  public final void onClick(View paramView)
  {
    LiveRoomDisplayView.LiveViewListener localLiveViewListener = LiveRoomDisplayView.b(this.a);
    if (localLiveViewListener != null) {
      localLiveViewListener.a(false);
    }
    LiveRoomDisplayView.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.bindEvent.5
 * JD-Core Version:    0.7.0.1
 */
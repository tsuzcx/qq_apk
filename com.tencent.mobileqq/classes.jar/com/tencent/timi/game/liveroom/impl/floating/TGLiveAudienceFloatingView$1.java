package com.tencent.timi.game.liveroom.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$1
  implements View.OnClickListener
{
  TGLiveAudienceFloatingView$1(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView) {}
  
  public final void onClick(View paramView)
  {
    TGLiveFloatManager.a.a(this.a.getRoomId());
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new AudienceFloatCloseEvent(this.a.getRoomId()));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.1
 * JD-Core Version:    0.7.0.1
 */
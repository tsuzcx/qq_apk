package com.tencent.timi.game.gift.impl.timi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGiftController$onReceiveEvent$1
  implements Runnable
{
  TimiGiftController$onReceiveEvent$1(TimiGiftController paramTimiGiftController, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public final void run()
  {
    long l = TimiGiftController.a(this.this$0);
    Long localLong = ((GiftPanelControlEvent)this.a).getRoomId();
    if (localLong == null) {
      return;
    }
    if (l != localLong.longValue()) {
      return;
    }
    if (((GiftPanelControlEvent)this.a).getShow())
    {
      this.this$0.a();
      TimiGiftController.a(this.this$0, ((GiftPanelControlEvent)this.a).getChosenUid());
      this.this$0.a(((GiftPanelControlEvent)this.a).getSubSceneId());
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.onReceiveEvent.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.gift.impl.timi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGiftPanelFragment$onSendGiftSuccess$2
  implements Runnable
{
  TimiGiftPanelFragment$onSendGiftSuccess$2(TimiGiftPanelFragment paramTimiGiftPanelFragment, GiftMessage paramGiftMessage) {}
  
  public final void run()
  {
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new TimiGiftEvent(this.a, TimiGiftPanelFragment.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment.onSendGiftSuccess.2
 * JD-Core Version:    0.7.0.1
 */
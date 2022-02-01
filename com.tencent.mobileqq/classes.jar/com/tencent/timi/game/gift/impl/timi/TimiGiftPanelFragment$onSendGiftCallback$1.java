package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGiftPanelFragment$onSendGiftCallback$1
  implements Runnable
{
  TimiGiftPanelFragment$onSendGiftCallback$1(TimiGiftPanelFragment paramTimiGiftPanelFragment, GiftServiceData paramGiftServiceData) {}
  
  public final void run()
  {
    TimiGiftPanelFragment localTimiGiftPanelFragment = this.this$0;
    int i = this.a.a;
    String str = this.a.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "data.giftName");
    TimiGiftPanelFragment.a(localTimiGiftPanelFragment, i, str, this.a.g, this.a.e, this.a.d, this.a.h, this.a.m, this.a.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment.onSendGiftCallback.1
 * JD-Core Version:    0.7.0.1
 */
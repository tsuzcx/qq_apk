package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.timi.game.liveroom.impl.util.GiftAnimDataUtilKt;

class TimiAnchorView$3
  implements ReceiveGiftMessageListener
{
  TimiAnchorView$3(TimiAnchorView paramTimiAnchorView) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(GiftMessage paramGiftMessage)
  {
    paramGiftMessage = GiftAnimDataUtilKt.a(paramGiftMessage);
    if (TimiAnchorView.b(this.a) != null) {
      TimiAnchorView.b(this.a).b(paramGiftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.3
 * JD-Core Version:    0.7.0.1
 */
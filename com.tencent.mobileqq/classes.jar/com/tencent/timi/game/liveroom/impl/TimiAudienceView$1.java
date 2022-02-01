package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.util.GiftAnimDataUtilKt;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$1
  implements ReceiveGiftMessageListener
{
  TimiAudienceView$1(TimiAudienceView paramTimiAudienceView) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(GiftMessage paramGiftMessage)
  {
    LiveUserInfo localLiveUserInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f();
    if (localLiveUserInfo == null)
    {
      Logger.c("TimiAudienceView", "none self userInfo");
      return;
    }
    if (paramGiftMessage.sender == localLiveUserInfo.uid) {
      return;
    }
    paramGiftMessage = GiftAnimDataUtilKt.a(paramGiftMessage);
    if (TimiAudienceView.a(this.a) != null) {
      TimiAudienceView.a(this.a).b(paramGiftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.1
 * JD-Core Version:    0.7.0.1
 */
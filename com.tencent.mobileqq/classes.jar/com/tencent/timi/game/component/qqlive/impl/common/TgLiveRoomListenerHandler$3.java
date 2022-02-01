package com.tencent.timi.game.component.qqlive.impl.common;

import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

class TgLiveRoomListenerHandler$3
  implements ReceiveGiftMessageListener
{
  TgLiveRoomListenerHandler$3(TgLiveRoomListenerHandler paramTgLiveRoomListenerHandler) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, new Object[] { "onError,", Integer.valueOf(paramInt), "+ msg: ", paramString });
    }
  }
  
  public void a(GiftMessage paramGiftMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGiftMessageReceive,");
      localStringBuilder.append(paramGiftMessage.toString());
      QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, localStringBuilder.toString());
    }
    TgLiveRoomListenerHandler.a(this.a, paramGiftMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler.3
 * JD-Core Version:    0.7.0.1
 */
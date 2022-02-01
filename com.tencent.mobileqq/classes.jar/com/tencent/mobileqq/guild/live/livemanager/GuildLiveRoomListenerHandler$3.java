package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

class GuildLiveRoomListenerHandler$3
  implements ReceiveGiftMessageListener
{
  GuildLiveRoomListenerHandler$3(GuildLiveRoomListenerHandler paramGuildLiveRoomListenerHandler) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGL.GuildLiveRoomListenerHandler", 1, new Object[] { "onError,", Integer.valueOf(paramInt), "+ msg: ", paramString });
    }
  }
  
  public void a(GiftMessage paramGiftMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGiftMessageReceive,");
      localStringBuilder.append(paramGiftMessage.toString());
      QLog.d("QGL.GuildLiveRoomListenerHandler", 1, localStringBuilder.toString());
    }
    GuildLiveRoomListenerHandler.a(this.a, paramGiftMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler.3
 * JD-Core Version:    0.7.0.1
 */
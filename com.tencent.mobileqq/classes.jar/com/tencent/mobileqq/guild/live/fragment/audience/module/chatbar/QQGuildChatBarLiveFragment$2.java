package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;

class QQGuildChatBarLiveFragment$2
  implements Observer<GiftMessage>
{
  QQGuildChatBarLiveFragment$2(QQGuildChatBarLiveFragment paramQQGuildChatBarLiveFragment) {}
  
  public void a(GiftMessage paramGiftMessage)
  {
    if (paramGiftMessage != null) {
      QQGuildChatBarLiveFragment.a(this.a, paramGiftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.2
 * JD-Core Version:    0.7.0.1
 */
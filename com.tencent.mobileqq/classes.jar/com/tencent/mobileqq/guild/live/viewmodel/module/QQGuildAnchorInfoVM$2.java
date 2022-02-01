package com.tencent.mobileqq.guild.live.viewmodel.module;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;

class QQGuildAnchorInfoVM$2
  implements Observer<LiveChannelRoomInfo>
{
  QQGuildAnchorInfoVM$2(QQGuildAnchorInfoVM paramQQGuildAnchorInfoVM) {}
  
  public void a(LiveChannelRoomInfo paramLiveChannelRoomInfo)
  {
    if ((QQGuildAnchorInfoVM.b(this.a)) && (paramLiveChannelRoomInfo != null)) {
      QQGuildAnchorInfoVM.b(this.a, paramLiveChannelRoomInfo.getAnchorNick());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM.2
 * JD-Core Version:    0.7.0.1
 */
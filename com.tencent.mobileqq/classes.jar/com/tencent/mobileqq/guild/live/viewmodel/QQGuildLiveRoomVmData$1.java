package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;

class QQGuildLiveRoomVmData$1
  implements Observer<QQGuildLiveGiftMsgModel>
{
  QQGuildLiveRoomVmData$1(QQGuildLiveRoomVmData paramQQGuildLiveRoomVmData, BetterLiveData paramBetterLiveData1, BetterLiveData paramBetterLiveData2) {}
  
  public void a(QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel)
  {
    if (paramQQGuildLiveGiftMsgModel != null)
    {
      this.a.setValue(paramQQGuildLiveGiftMsgModel);
      this.b.removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData.1
 * JD-Core Version:    0.7.0.1
 */
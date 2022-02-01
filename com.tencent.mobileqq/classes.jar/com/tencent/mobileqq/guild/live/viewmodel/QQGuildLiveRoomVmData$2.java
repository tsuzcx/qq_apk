package com.tencent.mobileqq.guild.live.viewmodel;

import android.util.Pair;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QQGuildLiveRoomVmData$2
  implements Observer<Pair<Boolean, Boolean>>
{
  QQGuildLiveRoomVmData$2(QQGuildLiveRoomVmData paramQQGuildLiveRoomVmData, GiftAnimData paramGiftAnimData, QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel) {}
  
  public void a(Pair<Boolean, Boolean> paramPair)
  {
    if ((paramPair.first != Boolean.FALSE) && (paramPair.second != Boolean.FALSE))
    {
      if ((paramPair.first == Boolean.TRUE) && (paramPair.second == Boolean.TRUE))
      {
        paramPair = (BetterLiveData)QQGuildLiveRoomVmData.a(this.c).get(this.a);
        if (paramPair != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mapGiftData2GiftMsgModel suc. model:");
          localStringBuilder.append(this.b.toString());
          QLog.i("QGL.QQGuildLiveRoomVmData", 1, localStringBuilder.toString());
          paramPair.setValue(this.b);
        }
      }
      return;
    }
    QLog.e("QGL.QQGuildLiveRoomVmData", 1, "mapGiftData2GiftMsgModel failed!");
    QQGuildLiveRoomVmData.a(this.c).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData.2
 * JD-Core Version:    0.7.0.1
 */
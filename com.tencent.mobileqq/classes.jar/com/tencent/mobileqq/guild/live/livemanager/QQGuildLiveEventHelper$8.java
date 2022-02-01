package com.tencent.mobileqq.guild.live.livemanager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveEventHelper$8
  implements Observer<Boolean>
{
  QQGuildLiveEventHelper$8(QQGuildLiveEventHelper paramQQGuildLiveEventHelper, LiveData paramLiveData, long paramLong) {}
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("autoEnterLiveRoom onChanged isInitSuc=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" mAutoInitSDKStart=");
    localStringBuilder.append(this.c.a);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    if (this.c.a) {
      this.a.removeObserver(this);
    }
    if (paramBoolean == Boolean.TRUE) {
      QQGuildLiveAudienceRoomMgr.a().a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.8
 * JD-Core Version:    0.7.0.1
 */
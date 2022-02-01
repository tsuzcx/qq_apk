package com.tencent.mobileqq.guild.live.livemanager;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.qphone.base.util.QLog;

class GuildLiveRoomListenerHandler$1
  implements LiveRoomStatusListener
{
  GuildLiveRoomListenerHandler$1(GuildLiveRoomListenerHandler paramGuildLiveRoomListenerHandler) {}
  
  public void onRoomClose(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRoomClose, closeType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" closeReason:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, ((StringBuilder)localObject).toString());
    localObject = QQGuildLiveRoomUiData.a().c();
    LiveData localLiveData = QQGuildLiveRoomUiData.a().b();
    Boolean localBoolean = Boolean.valueOf(false);
    if (((Boolean)LiveDataExtKt.a(localLiveData, localBoolean)).booleanValue())
    {
      if (!TextUtils.isEmpty(paramString)) {
        GuildLiveToast.b(paramString);
      }
      QQGuildLiveAnchorRoomMgr.a().a(true);
      return;
    }
    if (((Boolean)LiveDataExtKt.a((LiveData)localObject, localBoolean)).booleanValue())
    {
      QQGuildLiveAudienceRoomMgr.a().c();
      QQGuildLiveEventHelper.a().f();
    }
  }
  
  public void onRoomOpen()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomOpen");
  }
  
  public void onRoomPause()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomPause");
  }
  
  public void onRoomResume()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.guild.live.livemanager.audience.listener.QQGuildAudienceRoomPlayerListener;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.qphone.base.util.QLog;

class GuildLiveRoomListenerHandler$4
  extends QQGuildAudienceRoomPlayerListener
{
  GuildLiveRoomListenerHandler$4(GuildLiveRoomListenerHandler paramGuildLiveRoomListenerHandler) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudienceRoomPlayerListener onError,errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.e("QGL.GuildLiveRoomListenerHandler", 1, localStringBuilder.toString());
    QQGuildLiveRoomUiData.a().c(true);
  }
  
  public void onFirstFrameCome()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
  }
  
  public void onPlayCompleted()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
  }
  
  public void onResume()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onResume.");
    QQGuildLiveRoomUiData.a().c(false);
  }
  
  public void onStartBuffer()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStartBuffer");
  }
  
  public void onStopBuffer()
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudienceRoomPlayerListener onVideoSizeChanged,w:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" h:");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, (String)localObject);
    localObject = QQGuildLiveRoomUiData.a();
    if (paramInt1 < paramInt2) {
      bool = false;
    }
    ((QQGuildLiveRoomUiData)localObject).a(Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler.4
 * JD-Core Version:    0.7.0.1
 */
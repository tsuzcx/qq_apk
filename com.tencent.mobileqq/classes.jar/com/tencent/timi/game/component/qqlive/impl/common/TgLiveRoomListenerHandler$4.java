package com.tencent.timi.game.component.qqlive.impl.common;

import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.component.qqlive.impl.audience.listener.TgSimpleAudienceRoomPlayerListener;

class TgLiveRoomListenerHandler$4
  extends TgSimpleAudienceRoomPlayerListener
{
  TgLiveRoomListenerHandler$4(TgLiveRoomListenerHandler paramTgLiveRoomListenerHandler) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudienceRoomPlayerListener onError,errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.e("TgLiveTag_TgLiveRoomListenerHandler", 1, localStringBuilder.toString());
  }
  
  public void onFirstFrameCome()
  {
    QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
  }
  
  public void onPlayCompleted()
  {
    QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
  }
  
  public void onStartBuffer()
  {
    QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStartBuffer");
  }
  
  public void onStopBuffer()
  {
    QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
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
    QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, (String)localObject);
    localObject = TgLiveRoomUIData.a();
    if (paramInt1 < paramInt2) {
      bool = false;
    }
    ((TgLiveRoomUIData)localObject).a(Boolean.valueOf(bool));
    TgLiveAnchorRoomManager.a().a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler.4
 * JD-Core Version:    0.7.0.1
 */
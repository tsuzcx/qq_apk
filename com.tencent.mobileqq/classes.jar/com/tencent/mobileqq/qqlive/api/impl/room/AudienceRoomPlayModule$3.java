package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.player.AsyncMediaPlayerManager;
import com.tencent.mobileqq.qqlive.player.DefaultPlayerStatusChangeListener;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class AudienceRoomPlayModule$3
  extends DefaultPlayerStatusChangeListener
{
  AudienceRoomPlayModule$3(AudienceRoomPlayModule paramAudienceRoomPlayModule) {}
  
  public void onBufferEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AudienceRoomPlayModule", 1, "onBufferEnd");
    }
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onStopBuffer();
    }
  }
  
  public void onComplete()
  {
    AudienceRoomPlayModule.access$702(this.this$0, 0);
    AudienceRoomPlayModule.access$402(this.this$0, 3);
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onPlayCompleted();
    }
  }
  
  public void onError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("player error ");
    localStringBuilder.append(paramInt);
    QLog.e("AudienceRoomPlayModule", 1, localStringBuilder.toString());
    AudienceRoomPlayModule.access$702(this.this$0, 0);
    this.this$0.playerView.blackScreen(true);
    AudienceRoomPlayModule.access$600(this.this$0).f();
    AudienceRoomPlayModule.access$600(this.this$0).a();
    AudienceRoomPlayModule.access$800(this.this$0).onError(paramInt);
    AudienceRoomPlayModule.access$402(this.this$0, 0);
  }
  
  public void onFirstFrameRender()
  {
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onFirstFrameCome();
    }
  }
  
  public void onPause()
  {
    AudienceRoomPlayModule.access$402(this.this$0, 2);
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onPause();
    }
  }
  
  public void onPrepared()
  {
    this.this$0.playerView.blackScreen(false);
    if (AudienceRoomPlayModule.access$500(this.this$0))
    {
      AudienceRoomPlayModule.access$502(this.this$0, false);
      AudienceRoomPlayModule.access$600(this.this$0).b();
    }
    AudienceRoomPlayModule.access$702(this.this$0, 2);
    AudienceRoomPlayModule.access$800(this.this$0).onPrepared();
  }
  
  public void onStart()
  {
    AudienceRoomPlayModule.access$402(this.this$0, 1);
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onPlay();
    }
  }
  
  public void onStartBuffer()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AudienceRoomPlayModule", 1, "onStartBuffer");
    }
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onStartBuffer();
    }
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.this$0.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((AudienceRoomPlayerListener)localIterator.next()).onVideoSizeChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule.3
 * JD-Core Version:    0.7.0.1
 */
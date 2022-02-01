package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveAudienceFloatingView$roomPlayerListener$1", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "onError", "", "errorCode", "", "msg", "", "onFirstFrameCome", "onPause", "onPlay", "onPlayCompleted", "onResume", "onStartBuffer", "onStopBuffer", "onVideoSizeChanged", "width", "height", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAudienceFloatingView$roomPlayerListener$1
  implements AudienceRoomPlayerListener
{
  public void onError(int paramInt, @Nullable String paramString)
  {
    String str = TGLiveAudienceFloatingView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudienceRoomPlayerListener onError:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,msg:");
    localStringBuilder.append(paramString);
    Logger.a(str, localStringBuilder.toString());
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onError.1(this));
  }
  
  public void onFirstFrameCome()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onFirstFrameCome");
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onFirstFrameCome.1(this));
  }
  
  public void onPause()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onPause");
  }
  
  public void onPlay()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onPlay");
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onPlay.1(this));
  }
  
  public void onPlayCompleted()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onPlayCompleted");
  }
  
  public void onResume()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onResume");
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onResume.1(this));
  }
  
  public void onStartBuffer()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onStartBuffer");
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onStartBuffer.1(this));
  }
  
  public void onStopBuffer()
  {
    Logger.a(TGLiveAudienceFloatingView.d(this.a), "AudienceRoomPlayerListener onStopBuffer");
    ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.roomPlayerListener.1.onStopBuffer.1(this));
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2)
  {
    String str = TGLiveAudienceFloatingView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudienceRoomPlayerListener onVideoSizeChanged widyh:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" , height:");
    localStringBuilder.append(paramInt2);
    Logger.a(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.roomPlayerListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.live.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/IGameLiveView;", "Lcom/tencent/timi/game/live/api/IDanmaku;", "getPlayerStatus", "", "getView", "Landroid/view/View;", "isMiniWindow", "", "", "mutePlay", "mute", "pause", "url", "", "play", "release", "removeStatusListener", "liveStatusListener", "Lcom/tencent/timi/game/live/api/IGameLiveStatusListener;", "requestSizeChange", "resume", "setGameLiveEventListener", "gameLiveEventListener", "Lcom/tencent/timi/game/live/api/IGameLiveEventListener;", "setGameLiveGestureListener", "liveGestureListener", "Lcom/tencent/timi/game/live/api/ILiveGestureListener;", "setLiveVolume", "volume", "setPlayerShouldHoldTouchEvent", "holderByPlayer", "setStatus", "status", "setStatusListener", "setVideoPlayer", "player", "Lcom/tencent/timi/game/live/api/IVideoPlayer;", "setVideoRotation", "degree", "stop", "takeSnapshot", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IGameLiveView
  extends IDanmaku
{
  public abstract void a(@Nullable IGameLiveStatusListener paramIGameLiveStatusListener);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(@Nullable String paramString);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d(@Nullable String paramString);
  
  public abstract void e(@Nullable String paramString);
  
  public abstract void f(@Nullable String paramString);
  
  @NotNull
  public abstract View getView();
  
  public abstract void setGameLiveEventListener(@Nullable IGameLiveEventListener paramIGameLiveEventListener);
  
  public abstract void setGameLiveGestureListener(@Nullable ILiveGestureListener paramILiveGestureListener);
  
  public abstract void setLiveVolume(int paramInt);
  
  public abstract void setPlayerShouldHoldTouchEvent(boolean paramBoolean);
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setStatusListener(@Nullable IGameLiveStatusListener paramIGameLiveStatusListener);
  
  public abstract void setVideoPlayer(@NotNull IVideoPlayer paramIVideoPlayer);
  
  public abstract void setVideoRotation(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.IGameLiveView
 * JD-Core Version:    0.7.0.1
 */
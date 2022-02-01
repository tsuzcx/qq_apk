package com.tencent.timi.game.live.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/IVideoPlayer;", "", "mutePlay", "", "url", "", "mute", "", "pause", "play", "view", "Landroid/view/View;", "release", "resume", "setLiveVolume", "volume", "", "setVideoRotation", "degree", "stop", "takeSnapshot", "callback", "Lcom/tencent/timi/game/live/api/TakeSnapshotCallback;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPlayer
{
  public abstract void a(int paramInt);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@Nullable String paramString, int paramInt);
  
  public abstract void a(@Nullable String paramString, @Nullable View paramView);
  
  public abstract void a(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract void c(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.IVideoPlayer
 * JD-Core Version:    0.7.0.1
 */
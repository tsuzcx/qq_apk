package com.tencent.timi.game.live.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/IGameLiveEventListener;", "", "onEventConnectFailed", "", "lastStatus", "", "onEventConnected", "onEventDisconnect", "onEventFirstFrameRendered", "onEventFirstPacketReceived", "mediType", "onSnapshotReady", "bitmap", "Landroid/graphics/Bitmap;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IGameLiveEventListener
{
  public abstract void a(@NotNull Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.IGameLiveEventListener
 * JD-Core Version:    0.7.0.1
 */
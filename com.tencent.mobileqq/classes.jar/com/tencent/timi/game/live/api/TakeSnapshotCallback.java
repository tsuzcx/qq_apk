package com.tencent.timi.game.live.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/TakeSnapshotCallback;", "", "onSnapshot", "", "bitmap", "Landroid/graphics/Bitmap;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface TakeSnapshotCallback
{
  public abstract void a(@Nullable Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.TakeSnapshotCallback
 * JD-Core Version:    0.7.0.1
 */
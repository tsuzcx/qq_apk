package com.tencent.timi.game.live.impl.video.minisdk;

import android.graphics.Bitmap;
import com.tencent.timi.game.live.api.IGameLiveEventListener;
import com.tencent.timi.game.live.api.TakeSnapshotCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/video/minisdk/MiniSdkLiveView$takeSnapshot$1", "Lcom/tencent/timi/game/live/api/TakeSnapshotCallback;", "onSnapshot", "", "bitmap", "Landroid/graphics/Bitmap;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MiniSdkLiveView$takeSnapshot$1
  implements TakeSnapshotCallback
{
  public void a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      IGameLiveEventListener localIGameLiveEventListener = this.a.getEventListener();
      if (localIGameLiveEventListener != null) {
        localIGameLiveEventListener.a(paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.minisdk.MiniSdkLiveView.takeSnapshot.1
 * JD-Core Version:    0.7.0.1
 */
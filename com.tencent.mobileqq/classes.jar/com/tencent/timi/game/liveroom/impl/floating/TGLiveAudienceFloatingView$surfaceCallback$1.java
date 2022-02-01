package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveAudienceFloatingView$surfaceCallback$1", "Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "onSurfaceChanged", "", "surfaceOrHolder", "", "onSurfaceCreated", "onSurfaceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAudienceFloatingView$surfaceCallback$1
  implements ITPPlayerVideoView.IVideoSurfaceCallback
{
  public void onSurfaceChanged(@Nullable Object paramObject)
  {
    String str = TGLiveAudienceFloatingView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IVideoSurfaceCallback onSurfaceChanged:");
    localStringBuilder.append(paramObject);
    Logger.a(str, localStringBuilder.toString());
  }
  
  public void onSurfaceCreated(@Nullable Object paramObject)
  {
    String str = TGLiveAudienceFloatingView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IVideoSurfaceCallback onSurfaceCreated:");
    localStringBuilder.append(paramObject);
    Logger.a(str, localStringBuilder.toString());
    TGLiveAudienceFloatingView.c(this.a);
  }
  
  public void onSurfaceDestroy(@Nullable Object paramObject)
  {
    String str = TGLiveAudienceFloatingView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IVideoSurfaceCallback onSurfaceDestroy:");
    localStringBuilder.append(paramObject);
    Logger.a(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.surfaceCallback.1
 * JD-Core Version:    0.7.0.1
 */
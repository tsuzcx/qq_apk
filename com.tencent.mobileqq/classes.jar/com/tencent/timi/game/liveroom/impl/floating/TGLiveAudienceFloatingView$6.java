package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveAudienceFloatingView$6", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "onRoomClose", "", "closeType", "", "closeReason", "", "onRoomOpen", "onRoomPause", "onRoomResume", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAudienceFloatingView$6
  implements LiveRoomStatusListener
{
  public void onRoomClose(int paramInt, @Nullable String paramString)
  {
    TGLiveFloatManager.a.a(this.a.getRoomId());
  }
  
  public void onRoomOpen() {}
  
  public void onRoomPause() {}
  
  public void onRoomResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.6
 * JD-Core Version:    0.7.0.1
 */
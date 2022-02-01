package com.tencent.timi.game.liveroom.impl.live;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/LiveEndViewUtil$checkFollowStatus$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "isFollow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveEndViewUtil$checkFollowStatus$1
  implements IQQLiveCheckFollowCallback
{
  LiveEndViewUtil$checkFollowStatus$1(IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback) {}
  
  public void a(int paramInt)
  {
    IQQLiveCheckFollowCallback localIQQLiveCheckFollowCallback = this.a;
    if (localIQQLiveCheckFollowCallback != null) {
      localIQQLiveCheckFollowCallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    IQQLiveCheckFollowCallback localIQQLiveCheckFollowCallback = this.a;
    if (localIQQLiveCheckFollowCallback != null) {
      localIQQLiveCheckFollowCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.LiveEndViewUtil.checkFollowStatus.1
 * JD-Core Version:    0.7.0.1
 */
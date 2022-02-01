package com.tencent.timi.game.liveroom.impl.observable;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/observable/FollowStatusWrapper$fetchFollowStateFromNetwork$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "isFollow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FollowStatusWrapper$fetchFollowStateFromNetwork$1
  implements IQQLiveCheckFollowCallback
{
  FollowStatusWrapper$fetchFollowStateFromNetwork$1(long paramLong1, long paramLong2) {}
  
  public void a(int paramInt)
  {
    if (FollowStatusWrapper.a(this.a) == this.b)
    {
      if (FollowStatusWrapper.b(this.a) != this.c) {
        return;
      }
      FollowStatusWrapper localFollowStatusWrapper = this.a;
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      FollowStatusWrapper.a(localFollowStatusWrapper, bool);
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Logger localLogger = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkFollowAnchor# errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; errMsg: ");
    localStringBuilder.append(paramString);
    localLogger.e(new String[] { "FollowStatusObservable", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper.fetchFollowStateFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */
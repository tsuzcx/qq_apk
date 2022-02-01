package com.tencent.timi.game.liveroom.impl.view.head;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$mFollowMsgListener$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "onFail", "", "errCode", "", "errMsg", "", "onFollowReceive", "followPushMessage", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$mFollowMsgListener$1
  implements IQQLiveReceiveFollowListener
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@Nullable FollowPushMessage paramFollowPushMessage)
  {
    paramFollowPushMessage = AnchorTopHeadView.e(this.a);
    if ((paramFollowPushMessage != null) && (!AnchorTopHeadView.f(this.a))) {
      AnchorTopHeadView.a(this.a, paramFollowPushMessage, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.mFollowMsgListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveReceiveFollowListener$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "onFail", "", "errCode", "", "errMsg", "", "onFollowReceive", "followPushMessage", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$iQQLiveReceiveFollowListener$1
  implements IQQLiveReceiveFollowListener
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull FollowPushMessage paramFollowPushMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramFollowPushMessage, "followPushMessage");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFollowReceive ");
    localStringBuilder.append(paramFollowPushMessage.nick);
    Logger.b("AnchorMessageLayout", localStringBuilder.toString());
    if (paramFollowPushMessage.type == 1) {
      this.a.a(paramFollowPushMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.iQQLiveReceiveFollowListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$followMsgListener$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "onFail", "", "errCode", "", "errMsg", "", "onFollowReceive", "followPushMessage", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceOperationBarView$followMsgListener$1
  implements IQQLiveReceiveFollowListener
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@Nullable FollowPushMessage paramFollowPushMessage)
  {
    ILiveRoom localILiveRoom = AudienceOperationBarView.d(this.a);
    if (localILiveRoom != null)
    {
      BaseAnchorInfo localBaseAnchorInfo = localILiveRoom.getAnchorInfo();
      Intrinsics.checkExpressionValueIsNotNull(localBaseAnchorInfo, "it.anchorInfo");
      long l = localBaseAnchorInfo.getAnchorUid();
      int i;
      if ((paramFollowPushMessage != null) && (l == paramFollowPushMessage.toUid)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramFollowPushMessage = localILiveRoom;
      } else {
        paramFollowPushMessage = null;
      }
      if (paramFollowPushMessage != null) {
        AudienceOperationBarView.b(this.a, paramFollowPushMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.followMsgListener.1
 * JD-Core Version:    0.7.0.1
 */
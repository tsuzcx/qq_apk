package com.tencent.timi.game.liveroom.impl.view.message;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveSysMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"msgType", "", "msg", "", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class AnchorMsgRegistryKt
{
  public static final int a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "msg");
    boolean bool = paramObject instanceof ILiveMsg;
    int i = 1;
    int j = 1;
    if (bool)
    {
      paramObject = ((ILiveMsg)paramObject).d();
      if (paramObject != null)
      {
        paramObject = paramObject.msg_type;
        if (paramObject != null)
        {
          i = paramObject.get();
          break label52;
        }
      }
      i = 0;
      label52:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 70) {
            return 102;
          }
          return 101;
        }
        j = 100;
      }
      return j;
    }
    if ((paramObject instanceof FollowPushMessage)) {
      return 2;
    }
    if ((paramObject instanceof LiveMessageData.SpeakerInfo)) {
      return 3;
    }
    if ((paramObject instanceof AnnouncePushMessage)) {
      return 4;
    }
    if ((paramObject instanceof AnchorLiveSysMsg)) {
      return 6;
    }
    if ((paramObject instanceof GiftMessage)) {
      i = 5;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorMsgRegistryKt
 * JD-Core Version:    0.7.0.1
 */
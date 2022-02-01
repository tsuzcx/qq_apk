package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$roomAudienceInfoListener$1", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "onAudienceEnterRoom", "", "audienceInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "onRecAudienceInfo", "info", "Lcom/tencent/mobileqq/qqlive/data/room/RoomAudienceInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$roomAudienceInfoListener$1
  implements RoomAudienceInfoListener
{
  public void a(@NotNull LiveMessageData.SpeakerInfo paramSpeakerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramSpeakerInfo, "audienceInfo");
    long l = paramSpeakerInfo.mSpeakId;
    TgLiveAnchorUserInfo localTgLiveAnchorUserInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).i(AnchorMessageLayout.k(this.a));
    if ((localTgLiveAnchorUserInfo != null) && (l == localTgLiveAnchorUserInfo.a)) {
      return;
    }
    if ((CollectionsKt.lastOrNull(AnchorMessageLayout.c(this.a)) instanceof LiveMessageData.SpeakerInfo))
    {
      int i = AnchorMessageLayout.c(this.a).size() - 1;
      AnchorMessageLayout.c(this.a).set(i, paramSpeakerInfo);
      this.a.a(i);
      return;
    }
    this.a.a(paramSpeakerInfo);
  }
  
  public void a(@Nullable RoomAudienceInfo paramRoomAudienceInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.roomAudienceInfoListener.1
 * JD-Core Version:    0.7.0.1
 */
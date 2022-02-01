package com.tencent.timi.game.team.impl.chat;

import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$listener$1", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "onSpeakingPosChanged", "", "speakingPosInfoList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$listener$1
  extends SimpleYoloRoomCommonListener
{
  public void a(@NotNull List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "speakingPosInfoList");
    super.a(paramList);
    TeamChatView.a(this.a, paramList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.listener.1
 * JD-Core Version:    0.7.0.1
 */
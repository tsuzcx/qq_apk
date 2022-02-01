package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingView$commonListener$1", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "onGameRouteStatusUpdate", "", "isStatusChanged", "", "gameStatus", "", "gameRouteInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGameRouteInfo;", "onRemindStartGame", "isRemindOwner", "onSpeakingPosChanged", "speakingPosInfoList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView$commonListener$1
  extends SimpleYoloRoomCommonListener
{
  public void a(@Nullable List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    super.a(paramList);
    TeamFloatingView.d(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    TeamFloatingView.a(this.a, "求发车", true);
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo)
  {
    super.a(paramBoolean, paramInt, paramYoloGameRouteInfo);
    TeamFloatingView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.commonListener.1
 * JD-Core Version:    0.7.0.1
 */
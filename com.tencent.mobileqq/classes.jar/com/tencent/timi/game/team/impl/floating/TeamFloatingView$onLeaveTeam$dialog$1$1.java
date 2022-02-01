package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingView$onLeaveTeam$dialog$1$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomLeaveRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView$onLeaveTeam$dialog$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    this.a.a.setVisibility(0);
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.onLeaveTeam.dialog.1.1
 * JD-Core Version:    0.7.0.1
 */
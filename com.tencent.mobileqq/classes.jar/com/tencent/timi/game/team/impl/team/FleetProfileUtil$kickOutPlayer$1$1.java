package com.tencent.timi.game.team.impl.team;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/team/FleetProfileUtil$kickOutPlayer$1$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FleetProfileUtil$kickOutPlayer$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMessage");
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    CustomToastView.a("踢出车队成功");
    paramYoloRoomCmdRsp = this.a.c;
    if (paramYoloRoomCmdRsp != null) {
      paramYoloRoomCmdRsp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.FleetProfileUtil.kickOutPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */
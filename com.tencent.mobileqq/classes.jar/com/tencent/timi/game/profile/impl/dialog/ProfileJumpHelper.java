package com.tencent.timi.game.profile.impl.dialog;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/dialog/ProfileJumpHelper;", "", "()V", "TAG", "", "joinYoloRoomFromTeamView", "", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "roomId", "", "context", "Landroid/content/Context;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileJumpHelper
{
  public static final ProfileJumpHelper a = new ProfileJumpHelper();
  private static final String b = "ProfileJumpHelper_";
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId, long paramLong, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof Activity))
    {
      int i;
      if (paramQQUserId.user_from.get() == 2) {
        i = 2;
      } else {
        i = 1;
      }
      GuildShequnParams localGuildShequnParams = (GuildShequnParams)null;
      Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
      paramQQUserId = localGuildShequnParams;
      if (localObject != null)
      {
        localObject = ((IExpandHall)localObject).b();
        paramQQUserId = localGuildShequnParams;
        if (localObject != null) {
          paramQQUserId = new HallReportHelper((ExpandHallLaunchParam)localObject).u();
        }
      }
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(true, (Activity)paramContext, paramLong, i, 1, 1, 0, 0, (List)new ArrayList(), false, paramQQUserId, 0L, (IResultListener)new ProfileJumpHelper.joinYoloRoomFromTeamView.2());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileJumpHelper
 * JD-Core Version:    0.7.0.1
 */
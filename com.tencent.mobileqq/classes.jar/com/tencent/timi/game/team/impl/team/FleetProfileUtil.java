package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.timi.game.profile.api.IProfileDialogService;
import com.tencent.timi.game.profile.api.listener.FleetProfileClickListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/team/FleetProfileUtil;", "", "()V", "kickOutPlayer", "", "kickedUid", "", "kickOutListener", "Lcom/tencent/timi/game/team/impl/team/FleetProfileUtil$KickOutListener;", "roomId", "showFleetProfileDialog", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isCaptain", "", "KickOutListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FleetProfileUtil
{
  public static final FleetProfileUtil a = new FleetProfileUtil();
  
  public final void a(long paramLong1, @Nullable FleetProfileUtil.KickOutListener paramKickOutListener, long paramLong2)
  {
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = DialogUtil.a((Context)localObject, 230);
      ((QQCustomDialog)localObject).setMessage((CharSequence)"确认踢出该玩家吗？");
      ((QQCustomDialog)localObject).setPositiveButton("确认", (DialogInterface.OnClickListener)new FleetProfileUtil.kickOutPlayer.1(paramLong2, paramLong1, paramKickOutListener));
      ((QQCustomDialog)localObject).setNegativeButton("再考虑下", (DialogInterface.OnClickListener)FleetProfileUtil.kickOutPlayer.2.a);
      ((QQCustomDialog)localObject).show();
    }
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "qqUserId");
    Object localObject2 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong2);
    Object localObject1 = null;
    CommonOuterClass.QQUserId localQQUserId;
    if (localObject2 != null) {
      localQQUserId = ((IRoomGetDataService)localObject2).n();
    } else {
      localQQUserId = null;
    }
    if (localQQUserId != null)
    {
      localObject3 = localQQUserId.uid;
      if ((localObject3 != null) && (((PBUInt64Field)localObject3).get() == paramQQUserId.uid.get()))
      {
        i = 1;
        break label94;
      }
    }
    int i = 0;
    label94:
    if (localObject2 != null) {
      localObject1 = ((IRoomGetDataService)localObject2).b();
    }
    localObject1 = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject1);
    if (i == 0) {
      ((ConcurrentHashMap)localObject1).put("yes_to_uid", String.valueOf(paramQQUserId.uid.get()));
    }
    localObject2 = (IProfileDialogService)ServiceCenter.a(IProfileDialogService.class);
    Object localObject3 = (FleetProfileClickListener)new FleetProfileUtil.showFleetProfileDialog.1(paramLong1, paramLong2, paramQQUserId, paramQBaseActivity);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "reportParam");
    ((IProfileDialogService)localObject2).a(paramQBaseActivity, localQQUserId, paramQQUserId, paramBoolean, (FleetProfileClickListener)localObject3, (Map)localObject1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.FleetProfileUtil
 * JD-Core Version:    0.7.0.1
 */
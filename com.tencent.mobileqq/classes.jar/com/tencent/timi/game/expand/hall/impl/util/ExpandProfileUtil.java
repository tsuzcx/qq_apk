package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.profile.api.IProfileDialogService;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.listener.CommunityClickListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/util/ExpandProfileUtil;", "", "()V", "TAG", "", "showCPDDProfileDialog", "", "isMaster", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "roomIdFromServer", "", "clickListener", "Lcom/tencent/timi/game/profile/api/listener/CPDDProfileClickListener;", "showCommunityDialog", "Lcom/tencent/timi/game/profile/api/listener/CommunityClickListener;", "showProfileDialog", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandProfileUtil
{
  public static final ExpandProfileUtil a = new ExpandProfileUtil();
  
  private final void a(boolean paramBoolean, QBaseActivity paramQBaseActivity, CommonOuterClass.QQUserId paramQQUserId, long paramLong, CPDDProfileClickListener paramCPDDProfileClickListener)
  {
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("yes_room_id", String.valueOf(paramLong));
    localMap.put("yes_room_type", String.valueOf(5));
    localMap.put("yes_to_uid", String.valueOf(paramQQUserId.uid.get()));
    ((IProfileDialogService)ServiceCenter.a(IProfileDialogService.class)).a(paramQBaseActivity, paramQQUserId, false, paramCPDDProfileClickListener, localMap, paramLong);
  }
  
  private final void a(boolean paramBoolean, QBaseActivity paramQBaseActivity, CommonOuterClass.QQUserId paramQQUserId, long paramLong, CommunityClickListener paramCommunityClickListener)
  {
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong);
    if (localObject != null) {
      localObject = ((IRoomGetDataService)localObject).b();
    } else {
      localObject = null;
    }
    localObject = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject);
    ((ConcurrentHashMap)localObject).put("yes_to_uid", String.valueOf(paramQQUserId.uid.get()));
    IProfileDialogService localIProfileDialogService = (IProfileDialogService)ServiceCenter.a(IProfileDialogService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "reportParam");
    localIProfileDialogService.a(paramQBaseActivity, paramQQUserId, paramCommunityClickListener, (Map)localObject, paramLong);
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
    ExpandProfileUtil.showProfileDialog.clickListener.1 local1 = new ExpandProfileUtil.showProfileDialog.clickListener.1(paramQQUserId, paramQBaseActivity, paramLong);
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    boolean bool;
    if (((ILoginCoreService)localObject).a() == paramQQUserId.uid.get()) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null)
    {
      localObject = ((IExpandHall)localObject).b();
      if ((localObject != null) && (((ExpandHallLaunchParam)localObject).a == 2))
      {
        a(bool, paramQBaseActivity, paramQQUserId, paramLong, (CommunityClickListener)local1);
        return;
      }
    }
    a(bool, paramQBaseActivity, paramQQUserId, paramLong, (CPDDProfileClickListener)local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.ExpandProfileUtil
 * JD-Core Version:    0.7.0.1
 */
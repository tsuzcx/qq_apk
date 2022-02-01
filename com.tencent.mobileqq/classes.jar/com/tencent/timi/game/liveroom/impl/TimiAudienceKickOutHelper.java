package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/TimiAudienceKickOutHelper;", "", "()V", "addKickedOutOfRoomListener", "", "listener", "Lcom/tencent/mobileqq/qqlive/listener/supervision/OnKickedOutOfRoomListener;", "removeKickedOutOfRoomListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiAudienceKickOutHelper
{
  public static final TimiAudienceKickOutHelper a = new TimiAudienceKickOutHelper();
  
  public final void a(@NotNull OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnKickedOutOfRoomListener, "listener");
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getKickOutModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveModuleKickOut)localObject).addKickedOutOfRoomListener(paramOnKickedOutOfRoomListener);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addKickedOutOfRoomListener ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramOnKickedOutOfRoomListener);
    Logger.a("TimiAudienceKickOutHelper ", localStringBuilder.toString());
  }
  
  public final void b(@NotNull OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnKickedOutOfRoomListener, "listener");
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getKickOutModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveModuleKickOut)localObject).removeKickedOutOfRoomListener(paramOnKickedOutOfRoomListener);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeKickedOutOfRoomListener ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramOnKickedOutOfRoomListener);
    Logger.a("TimiAudienceKickOutHelper ", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceKickOutHelper
 * JD-Core Version:    0.7.0.1
 */
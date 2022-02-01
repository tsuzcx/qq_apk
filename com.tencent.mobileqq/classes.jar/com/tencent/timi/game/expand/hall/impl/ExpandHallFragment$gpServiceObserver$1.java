package com.tencent.timi.game.expand.hall.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$gpServiceObserver$1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onChannelInfoUpdated", "", "channelUin", "", "onPushChannelDestroy", "guildId", "channelIds", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$gpServiceObserver$1
  extends GPServiceObserver
{
  protected void a(@Nullable String paramString, @Nullable List<String> paramList)
  {
    super.a(paramString, paramList);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPushChannelDestroy guildId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", channelIds=");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", channelUin=");
    ((StringBuilder)localObject).append(ExpandHallFragment.b(this.a).f);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (Intrinsics.areEqual(paramString, String.valueOf(ExpandHallFragment.b(this.a).c))) && (paramList != null) && (paramList.contains(ExpandHallFragment.b(this.a).f)))
    {
      paramString = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
      if (paramString != null) {
        ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramString.room_id.get(), true, 0, null, false);
      }
      Logger.a("ExpandHallFragment_", "auto finish by ChannelDestroy");
      this.a.a(4);
    }
  }
  
  protected void e(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onChannelInfoUpdated channelUin:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", param=");
    ((StringBuilder)localObject).append(ExpandHallFragment.b(this.a).f);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (Intrinsics.areEqual(paramString, ExpandHallFragment.b(this.a).f))) {
      ExpandHallFragment.a(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.gpServiceObserver.1
 * JD-Core Version:    0.7.0.1
 */
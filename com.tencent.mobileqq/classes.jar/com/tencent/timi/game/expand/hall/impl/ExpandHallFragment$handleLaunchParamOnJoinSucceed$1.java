package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$handleLaunchParamOnJoinSucceed$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$handleLaunchParamOnJoinSucceed$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    ExpandHallListener localExpandHallListener = ExpandHallFragment.a(this.a);
    if (localExpandHallListener != null) {
      localExpandHallListener.b(ExpandHallFragment.b(this.a).g, ExpandHallFragment.b(this.a), paramInt, paramString);
    }
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    paramYoloRoomInfo = ExpandHallFragment.a(this.a);
    if (paramYoloRoomInfo != null) {
      paramYoloRoomInfo.a(ExpandHallFragment.b(this.a).g, ExpandHallFragment.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.handleLaunchParamOnJoinSucceed.1
 * JD-Core Version:    0.7.0.1
 */
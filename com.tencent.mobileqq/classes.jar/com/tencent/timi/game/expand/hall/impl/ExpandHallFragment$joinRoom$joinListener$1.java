package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import com.tencent.timi.game.expand.hall.api.ExpandRoomListener;
import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo;
import com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$joinRoom$joinListener$1", "Lcom/tencent/timi/game/expand/hall/api/ExpandRoomListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onGMInfoSuccess", "info", "Lcom/tencent/timi/game/expand/hall/api/data/GMChangeRoomInfo;", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$joinRoom$joinListener$1
  implements ExpandRoomListener<YoloRoomOuterClass.YoloRoomInfo>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    this.a.dL_();
    ExpandHallFragment.a(this.a, paramInt, paramString);
  }
  
  public void a(@Nullable GMChangeRoomInfo paramGMChangeRoomInfo)
  {
    if (!this.a.isDetached())
    {
      ExpandHallGMManager localExpandHallGMManager = ExpandHallFragment.c(this.a);
      View localView = ExpandHallFragment.d(this.a);
      if (localView != null) {
        localView = localView.findViewById(2131434289);
      } else {
        localView = null;
      }
      localExpandHallGMManager.a(localView, ExpandHallFragment.b(this.a), paramGMChangeRoomInfo);
    }
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.a.dL_();
    if (paramYoloRoomInfo == null)
    {
      ExpandHallFragment.a(this.a, 0, "");
      return;
    }
    ExpandHallFragment.a(this.a, paramYoloRoomInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.joinRoom.joinListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.expand.hall.impl;

import android.widget.ImageView;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAllRoomLifeCycleListener$1", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomLifecycleListener;", "onEnterRoom", "", "roomId", "", "roomType", "", "onExitRoom", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$mAllRoomLifeCycleListener$1
  implements YoloRoomInterface.YoloRoomLifecycleListener
{
  public void a(long paramLong, int paramInt)
  {
    if ((paramInt == 1) && (ExpandHallFragment.m(this.a)))
    {
      ImageView localImageView = (ImageView)this.a.c(2131431496);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "createTeamView");
      localImageView.setVisibility(8);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (paramInt == 1)
    {
      ImageView localImageView = (ImageView)this.a.c(2131431496);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "createTeamView");
      localImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.mAllRoomLifeCycleListener.1
 * JD-Core Version:    0.7.0.1
 */
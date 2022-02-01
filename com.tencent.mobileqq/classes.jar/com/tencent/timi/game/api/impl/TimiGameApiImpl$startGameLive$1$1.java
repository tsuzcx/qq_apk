package com.tencent.timi.game.api.impl;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.timi.game.api.live.GameLiveResultListener;
import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/api/impl/TimiGameApiImpl$startGameLive$1$1", "Lcom/tencent/timi/game/component/qqlive/api/SimpleTgLiveAnchorStartListener;", "onFinalError", "", "step", "", "errorCode", "errorDisplayMsg", "", "onFinalLiveStreamResult", "isSuccess", "", "result", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataBase;", "videoView", "Landroid/view/View;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameApiImpl$startGameLive$1$1
  extends SimpleTgLiveAnchorStartListener
{
  public void a(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    GameLiveResultListener localGameLiveResultListener = this.a.c;
    if (localGameLiveResultListener != null) {
      localGameLiveResultListener.a(paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, @Nullable QQLiveAnchorDataBase paramQQLiveAnchorDataBase, @Nullable View paramView)
  {
    if (paramBoolean)
    {
      ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).a(this.a.b, true);
      paramQQLiveAnchorDataBase = this.a.c;
      if (paramQQLiveAnchorDataBase != null) {
        paramQQLiveAnchorDataBase.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.startGameLive.1.1
 * JD-Core Version:    0.7.0.1
 */
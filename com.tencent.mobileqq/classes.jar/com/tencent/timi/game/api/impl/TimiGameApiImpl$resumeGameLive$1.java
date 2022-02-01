package com.tencent.timi.game.api.impl;

import android.content.Context;
import com.tencent.timi.game.api.live.GameLiveResultListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$resumeGameLive$1
  implements InitCallback
{
  TimiGameApiImpl$resumeGameLive$1(long paramLong, String paramString, Context paramContext, GameLiveResultListener paramGameLiveResultListener) {}
  
  public final void a(boolean paramBoolean)
  {
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(this.a, this.b, (SimpleTgLiveAnchorStartListener)new TimiGameApiImpl.resumeGameLive.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.resumeGameLive.1
 * JD-Core Version:    0.7.0.1
 */
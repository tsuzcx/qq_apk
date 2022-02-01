package com.tencent.timi.game.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.timi.game.api.live.GameLiveResultListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$startGameLive$1
  implements InitCallback
{
  TimiGameApiImpl$startGameLive$1(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, Context paramContext, GameLiveResultListener paramGameLiveResultListener) {}
  
  public final void a(boolean paramBoolean)
  {
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(this.a, true, (TgLiveAnchorStartListener)new TimiGameApiImpl.startGameLive.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.startGameLive.1
 * JD-Core Version:    0.7.0.1
 */
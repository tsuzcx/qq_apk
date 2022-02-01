package com.tencent.timi.game.component.qqlive.impl.anchor;

import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveAnchorRoomManager$2
  implements ExitRoomCallback
{
  TgLiveAnchorRoomManager$2(TgLiveAnchorRoomManager paramTgLiveAnchorRoomManager, long paramLong, IResultListener paramIResultListener, IQQLiveAnchorRoom paramIQQLiveAnchorRoom) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorExitRoom_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onComplete ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
    if (this.b != null)
    {
      TgLiveRoomCommonManager.a(this.c, new TgLiveAnchorRoomManager.2.1(this));
      return;
    }
    this.c.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager.2
 * JD-Core Version:    0.7.0.1
 */
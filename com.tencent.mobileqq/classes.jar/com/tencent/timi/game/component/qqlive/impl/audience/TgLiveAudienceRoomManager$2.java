package com.tencent.timi.game.component.qqlive.impl.audience;

import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveAudienceRoomManager$2
  implements ExitRoomCallback
{
  TgLiveAudienceRoomManager$2(TgLiveAudienceRoomManager paramTgLiveAudienceRoomManager, long paramLong, IResultListener paramIResultListener, IAudienceRoom paramIAudienceRoom) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audienceExitRoom_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onComplete ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveAudienceRoomManager", localStringBuilder.toString());
    if (this.b != null)
    {
      TgLiveRoomCommonManager.a(this.c, new TgLiveAudienceRoomManager.2.1(this));
      return;
    }
    this.c.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager.2
 * JD-Core Version:    0.7.0.1
 */
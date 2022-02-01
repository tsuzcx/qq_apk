package com.tencent.timi.game.component.qqlive.impl.common;

import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

final class TgLiveRoomCommonManager$2
  implements GetRoomInfoCallback
{
  TgLiveRoomCommonManager$2(IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRealTimeInfo fail. code=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg=");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("TgLiveTag_TgLiveRoomCommonManager", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    Logger.a("TgLiveTag_TgLiveRoomCommonManager", "getRealTimeInfo suc.");
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramLiveRealTimeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager.2
 * JD-Core Version:    0.7.0.1
 */
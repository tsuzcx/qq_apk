package com.tencent.timi.game.liveroom.impl.test;

import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveRoomTestFragment$5$1
  implements IResultListener<LiveRealTimeInfo>
{
  TgLiveRoomTestFragment$5$1(TgLiveRoomTestFragment.5 param5) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStopLive LiveRealTimeInfo onError - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    Logger.c("TgLiveRoomTestFragment", localStringBuilder.toString());
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStopLive LiveRealTimeInfo - ");
    localStringBuilder.append(paramLiveRealTimeInfo);
    Logger.a("TgLiveRoomTestFragment", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.5.1
 * JD-Core Version:    0.7.0.1
 */
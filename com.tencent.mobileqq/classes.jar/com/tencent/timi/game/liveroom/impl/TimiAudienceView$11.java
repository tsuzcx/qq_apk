package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$11
  implements IResultListener<LiveRealTimeInfo>
{
  TimiAudienceView$11(TimiAudienceView paramTimiAudienceView) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exit room failed: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    Logger.a("TimiAudienceView", localStringBuilder.toString());
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    Logger.a("TimiAudienceView", "exit room success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.11
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$12
  implements IResultListener<LiveRealTimeInfo>
{
  TimiAudienceView$12(TimiAudienceView paramTimiAudienceView, String paramString, LiveAnchorInfo paramLiveAnchorInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    Logger.a("TimiAudienceView", "exitRoom failed");
    TimiAudienceView.a(this.c, this.a, this.b, null);
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    Logger.a("TimiAudienceView", "exitRoom success");
    TimiAudienceView.a(this.c, this.a, this.b, paramLiveRealTimeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.12
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.more;

import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorMoreSettingUtil
{
  public static ConcurrentHashMap a(long paramLong)
  {
    return a(paramLong, null);
  }
  
  public static ConcurrentHashMap a(long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    if (((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d(paramLong) != null) {
      return TGReportUtil.a.a();
    }
    return TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorMoreSettingUtil
 * JD-Core Version:    0.7.0.1
 */
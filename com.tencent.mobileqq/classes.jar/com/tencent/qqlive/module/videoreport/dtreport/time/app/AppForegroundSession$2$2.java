package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import java.util.HashMap;
import java.util.Map;

class AppForegroundSession$2$2
  implements Runnable
{
  AppForegroundSession$2$2(AppForegroundSession.2 param2, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("dt_app_sessionid", this.val$sessionId);
    ((Map)localObject).put("dt_app_foreground_heartbeat_duration", Long.valueOf(this.val$foregroundDuration));
    localObject = JsonUtils.getJsonFromMap((Map)localObject);
    AppHeartBeatSpUtils.saveSessionLastHeartBeat(this.val$sessionId, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2.2
 * JD-Core Version:    0.7.0.1
 */
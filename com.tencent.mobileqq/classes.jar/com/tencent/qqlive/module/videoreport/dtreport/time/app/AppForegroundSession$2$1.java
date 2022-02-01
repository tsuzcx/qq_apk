package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import java.util.HashMap;
import java.util.Map;

class AppForegroundSession$2$1
  implements Runnable
{
  AppForegroundSession$2$1(AppForegroundSession.2 param2, String paramString, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_app_sessionid", this.val$sessionId);
    localHashMap.put("dt_app_foreground_heartbeat_duration", Long.valueOf(this.val$foregroundDuration));
    AppHeartBeatSpUtils.saveLastHeartBeat(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2.1
 * JD-Core Version:    0.7.0.1
 */
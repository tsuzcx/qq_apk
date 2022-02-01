package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

class AppForegroundSession$2
  implements HeartBeatProcessor.IHeartBeatCallback
{
  AppForegroundSession$2(AppForegroundSession paramAppForegroundSession) {}
  
  public void reportHeartBeat(String paramString, long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_app_sessionid", paramString);
    localHashMap.put("dt_app_foreground_heartbeat_duration", Long.valueOf(paramLong1));
    AppForegroundSession.access$100(localHashMap);
    ThreadUtils.execTask(new AppForegroundSession.2.1(this, paramString));
  }
  
  public void saveHeartBeatInfo(String paramString, long paramLong1, long paramLong2)
  {
    ThreadUtils.execTask(new AppForegroundSession.2.2(this, paramString, paramLong1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2
 * JD-Core Version:    0.7.0.1
 */
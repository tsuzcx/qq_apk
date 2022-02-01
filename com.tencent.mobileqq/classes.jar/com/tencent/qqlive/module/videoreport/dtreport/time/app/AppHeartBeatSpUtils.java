package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatSpUtils;
import java.util.Map;

public class AppHeartBeatSpUtils
{
  public static void clearLastHeartBeat()
  {
    HeartBeatSpUtils.clearLastHeartBeat("last_app_heart_beat");
  }
  
  public static Map<String, Object> getLastHeartBeat()
  {
    return HeartBeatSpUtils.getLastHeartBeat("last_app_heart_beat");
  }
  
  public static void saveLastHeartBeat(Map<String, Object> paramMap)
  {
    HeartBeatSpUtils.saveLastHeartBeat("last_app_heart_beat", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppHeartBeatSpUtils
 * JD-Core Version:    0.7.0.1
 */
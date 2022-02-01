package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import java.util.Map;

public class DTNewsAppEventMapHandler
  extends DTAppEventMapHandler
{
  private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  private void formatAppHeartParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_app_sessionid");
    transferIfExist(paramMap1, paramMap2, "dt_app_foreground_heartbeat_duration");
  }
  
  private void formatAppinParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_app_starttime");
    transferIfExist(paramMap1, paramMap2, "dt_sys_elapsed_realtime");
    transferIfExist(paramMap1, paramMap2, "dt_app_heartbeat_interval");
    transferIfExist(paramMap1, paramMap2, "dt_app_file_interval");
    transferIfExist(paramMap1, paramMap2, "dt_app_sessionid");
  }
  
  private void formatAppoutParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_app_stoptime");
    transferIfExist(paramMap1, paramMap2, "dt_sys_elapsed_realtime");
    transferIfExist(paramMap1, paramMap2, "dt_app_foreground_duration");
    transferIfExist(paramMap1, paramMap2, "dt_app_sessionid");
  }
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if ((!isValidMap(paramMap1)) || (!isValidMap(paramMap2))) {}
    do
    {
      return;
      if ("appout".equals(paramString))
      {
        this.mFlattenHelper.flattenPageParams(paramMap1, paramMap2);
        formatAppoutParams(paramMap1, paramMap2);
        return;
      }
      if ("appin".equals(paramString))
      {
        formatAppinParams(paramMap1, paramMap2);
        return;
      }
    } while (!"dt_app_heartbeat".equals(paramString));
    formatAppHeartParams(paramMap1, paramMap2);
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return this.mFlattenHelper.getOrRemove(paramMap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewsAppEventMapHandler
 * JD-Core Version:    0.7.0.1
 */
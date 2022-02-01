package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import java.util.Map;

class DTNewsAudioEventMapHandler
  extends DTBaseEventMapHandler
{
  private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  private void formatAudioEndParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_audio_stoptime");
    transferIfExist(paramMap1, paramMap2, "dt_audio_sessionid");
    transferIfExist(paramMap1, paramMap2, "dt_audio_duration_foreground");
    transferIfExist(paramMap1, paramMap2, "dt_audio_duration_background");
    transferIfExist(paramMap1, paramMap2, "dt_audio_contentid");
  }
  
  private void formatAudioHeartParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_audio_heartbeat_interval");
    transferIfExist(paramMap1, paramMap2, "dt_audio_sessionid");
    transferIfExist(paramMap1, paramMap2, "dt_audio_duration_foreground");
    transferIfExist(paramMap1, paramMap2, "dt_audio_duration_background");
    transferIfExist(paramMap1, paramMap2, "dt_audio_contentid");
  }
  
  private void formatAudioStartParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    transferIfExist(paramMap1, paramMap2, "dt_audio_starttime");
    transferIfExist(paramMap1, paramMap2, "dt_audio_sessionid");
    transferIfExist(paramMap1, paramMap2, "dt_audio_heartbeat_interval");
    transferIfExist(paramMap1, paramMap2, "dt_audio_file_interval");
    transferIfExist(paramMap1, paramMap2, "dt_play_type");
    transferIfExist(paramMap1, paramMap2, "dt_audio_player_type");
    transferIfExist(paramMap1, paramMap2, "dt_audio_contentid");
  }
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if ((!isValidMap(paramMap1)) || (!isValidMap(paramMap2))) {}
    do
    {
      return;
      if ("dt_audio_start".equals(paramString))
      {
        formatAudioStartParams(paramMap1, paramMap2);
        return;
      }
      if ("dt_audio_end".equals(paramString))
      {
        formatAudioEndParams(paramMap1, paramMap2);
        return;
      }
    } while (!"dt_audio_heartbeat".equals(paramString));
    formatAudioHeartParams(paramMap1, paramMap2);
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return this.mFlattenHelper.getOrRemove(paramMap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewsAudioEventMapHandler
 * JD-Core Version:    0.7.0.1
 */
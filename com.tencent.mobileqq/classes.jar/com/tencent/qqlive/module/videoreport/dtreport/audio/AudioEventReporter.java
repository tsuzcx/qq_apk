package com.tencent.qqlive.module.videoreport.dtreport.audio;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AudioEventReporter
  extends DefaultEventListener
{
  private static final String TAG = "AudioEventReporter";
  private boolean mFirstActivityResumed = true;
  
  private static void addAudioPublicParams(AudioEntity paramAudioEntity, Map<String, Object> paramMap)
  {
    if (paramAudioEntity != null)
    {
      if (paramMap == null) {
        return;
      }
      paramMap.put("dt_audio_contentid", paramAudioEntity.getContentId());
      paramAudioEntity = paramAudioEntity.getAudioCustomParams();
      if (paramAudioEntity != null)
      {
        paramAudioEntity = paramAudioEntity.entrySet().iterator();
        while (paramAudioEntity.hasNext())
        {
          Object localObject = (Map.Entry)paramAudioEntity.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = ((Map.Entry)localObject).getValue();
          if (str != null) {
            paramMap.put(str, localObject);
          }
        }
      }
    }
  }
  
  public static AudioEventReporter getInstance()
  {
    return AudioEventReporter.InstanceHolder.access$000();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private static Map<String, Object> prepareAudioEndReportData(Object paramObject, AudioSession paramAudioSession)
  {
    HashMap localHashMap = new HashMap();
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return localHashMap;
      }
      localHashMap.put("dt_audio_stoptime", Long.valueOf(System.currentTimeMillis()));
      localHashMap.put("dt_audio_sessionid", paramAudioSession.getAudioSessionId());
      localHashMap.put("dt_audio_duration_foreground", Long.valueOf(paramAudioSession.getForegroundDuration()));
      localHashMap.put("dt_audio_duration_background", Long.valueOf(paramAudioSession.getBackgroundDuration()));
      addAudioPublicParams(paramAudioSession.getAudioEntity(), localHashMap);
    }
    return localHashMap;
  }
  
  private static Map<String, Object> prepareAudioHeartBeatReportData(Object paramObject, String paramString, AudioSession paramAudioSession, long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return localHashMap;
      }
      localHashMap.put("dt_audio_heartbeat_interval", Long.valueOf(paramAudioSession.getHeartBeatInterval() / 1000L));
      localHashMap.put("dt_audio_sessionid", paramString);
      localHashMap.put("dt_audio_duration_foreground", Long.valueOf(paramLong1));
      localHashMap.put("dt_audio_duration_background", Long.valueOf(paramLong2));
      addAudioPublicParams(paramAudioSession.getAudioEntity(), localHashMap);
    }
    return localHashMap;
  }
  
  private static Map<String, Object> prepareAudioStartReportData(Object paramObject, AudioSession paramAudioSession)
  {
    HashMap localHashMap = new HashMap();
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return localHashMap;
      }
      localHashMap.put("dt_audio_starttime", Long.valueOf(System.currentTimeMillis()));
      localHashMap.put("dt_audio_sessionid", paramAudioSession.getAudioSessionId());
      localHashMap.put("dt_audio_heartbeat_interval", Long.valueOf(paramAudioSession.getHeartBeatInterval() / 1000L));
      localHashMap.put("dt_audio_file_interval", Long.valueOf(paramAudioSession.getTimePinInterval() / 1000L));
      AudioEntity localAudioEntity = paramAudioSession.getAudioEntity();
      if (localAudioEntity != null) {
        localHashMap.put("dt_play_type", localAudioEntity.getPlayType());
      }
      if ((paramObject instanceof IAudioPlayer)) {
        localHashMap.put("dt_audio_player_type", Integer.valueOf(((IAudioPlayer)paramObject).getPlayerType__()));
      }
      addAudioPublicParams(paramAudioSession.getAudioEntity(), localHashMap);
    }
    return localHashMap;
  }
  
  public static void reportAudioEnd(Object paramObject, AudioSession paramAudioSession)
  {
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return;
      }
      FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
      localFinalData.setEventKey("dt_audio_end");
      localFinalData.putAll(prepareAudioEndReportData(paramObject, paramAudioSession));
      paramAudioSession = VideoReportInner.getInstance().getEventDynamicParams();
      if (paramAudioSession != null) {
        paramAudioSession.setEventDynamicParams("dt_audio_end", localFinalData.getEventParams());
      }
      FinalDataTarget.handle(paramObject, localFinalData);
    }
  }
  
  public static void reportAudioHeartBeat(Object paramObject, String paramString, AudioSession paramAudioSession, long paramLong1, long paramLong2)
  {
    ThreadUtils.execTask(new AudioEventReporter.1(paramObject, paramString, paramAudioSession, paramLong1, paramLong2));
  }
  
  public static void reportAudioStart(Object paramObject, AudioSession paramAudioSession)
  {
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return;
      }
      FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
      localFinalData.setEventKey("dt_audio_start");
      localFinalData.putAll(prepareAudioStartReportData(paramObject, paramAudioSession));
      paramAudioSession = VideoReportInner.getInstance().getEventDynamicParams();
      if (paramAudioSession != null) {
        paramAudioSession.setEventDynamicParams("dt_audio_start", localFinalData.getEventParams());
      }
      FinalDataTarget.handle(paramObject, localFinalData);
    }
  }
  
  public static void reportLastAudioHeartBeat()
  {
    ThreadUtils.execTask(new AudioEventReporter.2());
  }
  
  public static void saveLastAudioHeartBeat(Object paramObject, String paramString, AudioSession paramAudioSession, long paramLong1, long paramLong2)
  {
    if (paramObject != null)
    {
      if (paramAudioSession == null) {
        return;
      }
      paramObject = prepareAudioHeartBeatReportData(paramObject, paramString, paramAudioSession, paramLong1, paramLong2);
      paramAudioSession = VideoReportInner.getInstance().getEventDynamicParams();
      if (paramAudioSession != null) {
        paramAudioSession.setEventDynamicParams("dt_audio_heartbeat", paramObject);
      }
      ThreadUtils.execTask(new AudioEventReporter.3(paramObject, paramString));
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    if (this.mFirstActivityResumed)
    {
      this.mFirstActivityResumed = false;
      reportLastAudioHeartBeat();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter
 * JD-Core Version:    0.7.0.1
 */
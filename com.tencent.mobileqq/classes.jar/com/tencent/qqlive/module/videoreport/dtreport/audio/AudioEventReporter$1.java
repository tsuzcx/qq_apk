package com.tencent.qqlive.module.videoreport.dtreport.audio;

import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioHeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

final class AudioEventReporter$1
  implements Runnable
{
  AudioEventReporter$1(Object paramObject, String paramString, AudioSession paramAudioSession, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_audio_heartbeat");
    localFinalData.putAll(AudioEventReporter.access$200(this.val$audioPlayer, this.val$sessionId, this.val$audioSession, this.val$foregroundDuration, this.val$backgroundDuration));
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("dt_audio_heartbeat", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(this.val$audioPlayer, localFinalData);
    AudioHeartBeatSpUtils.saveAudioSessionLastHeartBeat(this.val$sessionId, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter.1
 * JD-Core Version:    0.7.0.1
 */
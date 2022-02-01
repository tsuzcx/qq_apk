package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback;

class AudioSession$2
  implements HeartBeatProcessor.IHeartBeatCallback
{
  AudioSession$2(AudioSession paramAudioSession) {}
  
  public void reportHeartBeat(String paramString, long paramLong1, long paramLong2)
  {
    AudioEventReporter.reportAudioHeartBeat(AudioSession.access$100(this.this$0), paramString, this.this$0, paramLong1, paramLong2);
  }
  
  public void saveHeartBeatInfo(String paramString, long paramLong1, long paramLong2)
  {
    AudioEventReporter.saveLastAudioHeartBeat(AudioSession.access$100(this.this$0), paramString, this.this$0, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession.2
 * JD-Core Version:    0.7.0.1
 */
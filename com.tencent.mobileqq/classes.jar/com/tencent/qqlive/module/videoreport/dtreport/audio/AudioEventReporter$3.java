package com.tencent.qqlive.module.videoreport.dtreport.audio;

import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioHeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import java.util.Map;

final class AudioEventReporter$3
  implements Runnable
{
  AudioEventReporter$3(Map paramMap, String paramString) {}
  
  public void run()
  {
    String str = JsonUtils.getJsonFromMap(this.val$audioParams);
    AudioHeartBeatSpUtils.saveAudioSessionLastHeartBeat(this.val$sessionId, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter.3
 * JD-Core Version:    0.7.0.1
 */
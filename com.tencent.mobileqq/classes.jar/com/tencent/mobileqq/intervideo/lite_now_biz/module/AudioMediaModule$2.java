package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioVolumeListener;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AudioMediaModule$2
  implements IAudioVolumeListener
{
  AudioMediaModule$2(AudioMediaModule paramAudioMediaModule) {}
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      AudioMediaModule.a(this.a).i("AudioMediaModule", "startSpeakingEvent uin[%s] ", new Object[] { paramList.toString() });
    }
    this.a.getEvent().post(new AudioChangeEvent(201, paramList));
  }
  
  public void b(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      AudioMediaModule.a(this.a).i("AudioMediaModule", "stopSpeakingEvent uin[%s] ", new Object[] { paramList.toString() });
    }
    this.a.getEvent().post(new AudioChangeEvent(202, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.2
 * JD-Core Version:    0.7.0.1
 */
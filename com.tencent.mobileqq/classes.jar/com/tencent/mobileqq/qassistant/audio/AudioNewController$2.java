package com.tencent.mobileqq.qassistant.audio;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.listener.IRecordEventListener;
import java.util.concurrent.atomic.AtomicLong;

class AudioNewController$2
  implements IRecordEventListener
{
  AudioNewController$2(AudioNewController paramAudioNewController) {}
  
  public int a()
  {
    return 1920000;
  }
  
  public void a(long paramLong)
  {
    AssistantUtils.a("AudioNewController", "onRecordFinish, Duration:" + paramLong + ", CacheSize:" + this.a.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a());
    if (paramLong > 0L) {
      this.a.b.set(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    AssistantUtils.a("AudioNewController", paramString);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong > 0L) {
      this.a.b.set(paramLong);
    }
    int i = this.a.a(paramArrayOfByte);
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, i);
  }
  
  public int b()
  {
    return 60000;
  }
  
  public void b(long paramLong)
  {
    AssistantUtils.a("AudioNewController", "IRecordEventListener, onRecordStart:" + paramLong);
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewController.2
 * JD-Core Version:    0.7.0.1
 */
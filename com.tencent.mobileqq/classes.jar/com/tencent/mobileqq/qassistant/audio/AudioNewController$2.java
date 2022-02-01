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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordFinish, Duration:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", CacheSize:");
    localStringBuilder.append(this.a.e.d());
    AssistantUtils.a("AudioNewController", localStringBuilder.toString());
    if (paramLong > 0L) {
      this.a.h.set(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    AssistantUtils.a("AudioNewController", paramString);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong > 0L) {
      this.a.h.set(paramLong);
    }
    int i = this.a.a(paramArrayOfByte);
    paramArrayOfByte = this.a;
    paramArrayOfByte.a(paramArrayOfByte.f, i);
  }
  
  public int b()
  {
    return 60000;
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IRecordEventListener, onRecordStart:");
    ((StringBuilder)localObject).append(paramLong);
    AssistantUtils.a("AudioNewController", ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((AudioNewController)localObject).b(((AudioNewController)localObject).f, b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewController.2
 * JD-Core Version:    0.7.0.1
 */
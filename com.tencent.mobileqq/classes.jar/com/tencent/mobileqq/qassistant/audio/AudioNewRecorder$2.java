package com.tencent.mobileqq.qassistant.audio;

import android.media.AudioRecord;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.listener.IRecordEventListener;
import java.util.concurrent.atomic.AtomicLong;

class AudioNewRecorder$2
  implements Runnable
{
  AudioNewRecorder$2(AudioNewRecorder paramAudioNewRecorder) {}
  
  public void run()
  {
    int i = 0;
    if ((AudioNewRecorder.a(this.this$0) == null) || (AudioNewRecorder.a(this.this$0).getState() != 1))
    {
      AssistantUtils.a("AudioNewRecorder", "session, doRecord, stateError");
      return;
    }
    for (;;)
    {
      try
      {
        if (AudioNewRecorder.a(this.this$0) != null) {
          AudioNewRecorder.a(this.this$0).b(System.currentTimeMillis());
        }
        AudioNewRecorder.a(this.this$0).startRecording();
        if (AudioNewRecorder.a(this.this$0) == null) {
          break label216;
        }
        j = AudioNewRecorder.a(this.this$0).a();
        i = AudioNewRecorder.a(this.this$0).b();
        AudioNewRecorder.a(this.this$0, j, i);
      }
      catch (InterruptedException localInterruptedException)
      {
        AudioNewRecorder.a(this.this$0).a(localInterruptedException.getMessage());
        localInterruptedException.printStackTrace();
        this.this$0.a();
        this.this$0.b();
        continue;
      }
      finally
      {
        this.this$0.a();
        this.this$0.b();
      }
      if (AudioNewRecorder.a(this.this$0) == null) {
        break;
      }
      AudioNewRecorder.a(this.this$0).a(this.this$0.a.get());
      return;
      label216:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.2
 * JD-Core Version:    0.7.0.1
 */
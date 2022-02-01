package com.tencent.mobileqq.qassistant.audio;

import android.media.AudioRecord;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;
import java.util.concurrent.atomic.AtomicBoolean;

class AudioNewRecorder$1
  implements Runnable
{
  AudioNewRecorder$1(AudioNewRecorder paramAudioNewRecorder, IRecordStreamListener paramIRecordStreamListener) {}
  
  public void run()
  {
    if ((AudioNewRecorder.a(this.this$0) == null) || (AudioNewRecorder.a(this.this$0).getState() != 1))
    {
      AssistantUtils.a("AudioNewRecorder", "wakeService, doRecord, stateError");
      return;
    }
    try
    {
      AudioNewRecorder.a(this.this$0).startRecording();
      byte[] arrayOfByte = new byte[AudioNewRecorder.a(this.this$0)];
      int i = 0;
      int j;
      do
      {
        int k;
        for (;;)
        {
          if (!this.this$0.a.get()) {
            break label148;
          }
          k = AudioNewRecorder.a(this.this$0).read(arrayOfByte, 0, AudioNewRecorder.a(this.this$0));
          if (k <= 0) {
            break;
          }
          this.a.a(arrayOfByte, 0, arrayOfByte.length);
          i = 0;
        }
        j = i + 1;
        AssistantUtils.a("HelloQQWake", "AudioNewRecorder doRecord readsize：" + k);
        i = j;
      } while (j < 5);
      label148:
      return;
    }
    catch (Exception localException)
    {
      AssistantUtils.a("HelloQQWake", "AudioNewRecorder doRecord error：" + localException.getMessage());
      return;
    }
    finally
    {
      this.this$0.a();
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.1
 * JD-Core Version:    0.7.0.1
 */
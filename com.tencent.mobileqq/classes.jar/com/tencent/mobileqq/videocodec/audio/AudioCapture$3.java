package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$3
  implements Runnable
{
  AudioCapture$3(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    if (this.this$0.e == null) {
      return;
    }
    AudioCapture.a(this.this$0, false);
    AudioCapture.b(this.this$0, false);
    if (AudioCapture.g(this.this$0) != null)
    {
      AudioCapture.g(this.this$0).a = false;
      AudioCapture.g(this.this$0).b = true;
      AudioCapture.h(this.this$0).interrupt();
      try
      {
        AudioCapture.h(this.this$0).join();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    try
    {
      if (AudioCapture.f(this.this$0) != null) {
        AudioCapture.f(this.this$0).onAudioUnInit();
      }
      this.this$0.e.stop();
    }
    catch (Exception localException1)
    {
      QLog.e("AudioCapture", 2, localException1, new Object[0]);
      if (AudioCapture.f(this.this$0) != null) {
        AudioCapture.f(this.this$0).onAudioError(-5);
      }
    }
    try
    {
      this.this$0.e.release();
    }
    catch (Exception localException2)
    {
      QLog.e("AudioCapture", 2, localException2, new Object[0]);
      if (AudioCapture.f(this.this$0) != null) {
        AudioCapture.f(this.this$0).onAudioError(-5);
      }
    }
    this.this$0.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture.3
 * JD-Core Version:    0.7.0.1
 */
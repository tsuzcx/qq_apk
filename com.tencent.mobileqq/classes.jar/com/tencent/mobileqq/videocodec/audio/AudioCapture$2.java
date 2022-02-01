package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$2
  implements Runnable
{
  AudioCapture$2(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.e != null) {
        return;
      }
      AudioCapture.a(this.this$0);
      this.this$0.e = new AudioRecord(AudioCapture.b(this.this$0), AudioCapture.c(this.this$0), AudioCapture.d(this.this$0), AudioCapture.e(this.this$0), this.this$0.g);
      try
      {
        this.this$0.e.startRecording();
        this.this$0.a(true);
        if (AudioCapture.f(this.this$0) != null) {
          AudioCapture.f(this.this$0).onAudioInit();
        }
        if (this.this$0.e.getState() == 0)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openMic,audio state");
            localStringBuilder.append(this.this$0.e.getState());
            QLog.d("AudioCapture", 2, localStringBuilder.toString());
          }
          if (AudioCapture.f(this.this$0) != null) {
            AudioCapture.f(this.this$0).onAudioError(-4);
          }
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("AudioCapture", 2, localIllegalStateException, new Object[0]);
        try
        {
          this.this$0.e.release();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        if (AudioCapture.f(this.this$0) != null) {
          AudioCapture.f(this.this$0).onAudioError(-4);
        }
        return;
      }
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("AudioCapture", 2, localException2, new Object[0]);
      if (AudioCapture.f(this.this$0) != null) {
        AudioCapture.f(this.this$0).onAudioError(-4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture.2
 * JD-Core Version:    0.7.0.1
 */
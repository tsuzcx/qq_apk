package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$RecordRunnable
  implements Runnable
{
  boolean a;
  boolean b;
  boolean c = false;
  boolean d;
  Object e = new Object();
  
  public AudioCapture$RecordRunnable(AudioCapture paramAudioCapture)
  {
    this.d = (AudioCapture.i(paramAudioCapture) ^ true);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable run");
    }
    this.b = false;
    AudioCapture.a(this.this$0);
    Process.setThreadPriority(-19);
    while ((!this.c) || (AudioCapture.j(this.this$0)) || (AudioCapture.k(this.this$0)))
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "RecordRunnable exit before record");
        }
        return;
      }
      if (this.d)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "RecordRunnable pause");
        }
        try
        {
          synchronized (this.e)
          {
            if (this.d) {
              this.e.wait();
            }
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          QLog.e("AudioCapture", 1, "RecordRunnable wait exception:", localException2);
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("RecordRunnable resume, startrecord:");
        ((StringBuilder)???).append(this.c);
        ((StringBuilder)???).append(" interrupt:");
        ((StringBuilder)???).append(this.b);
        ((StringBuilder)???).append(" pause:");
        ((StringBuilder)???).append(this.d);
        QLog.d("AudioCapture", 2, ((StringBuilder)???).toString());
        continue;
        throw localException2;
      }
      else
      {
        if ((this.this$0.e == null) || (this.this$0.f == null)) {
          break label1029;
        }
        i = this.this$0.e.read(this.this$0.f, 0, this.this$0.g);
        if (AudioCapture.f(this.this$0) != null) {
          AudioCapture.f(this.this$0).onAudioFrames(this.this$0.f, 0, i);
        }
        if ((this.c) && ((AudioCapture.j(this.this$0)) || (AudioCapture.k(this.this$0)))) {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, new Object[] { "RecordRunnable mIsVoiceRecognizerStat: ", Boolean.valueOf(AudioCapture.j(this.this$0)), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.k(this.this$0)), "start record" });
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable record run");
    }
    this.a = true;
    ??? = this.this$0;
    ((AudioCapture)???).l = new AudioDataCache(AudioCapture.l((AudioCapture)???));
    this.this$0.l.a();
    int i = 0;
    for (;;)
    {
      try
      {
        if (((this.a) || (AudioCapture.j(this.this$0)) || (AudioCapture.k(this.this$0))) && (!this.b))
        {
          if ((this.this$0.e == null) || (this.this$0.f == null) || (this.this$0.i == null)) {
            continue;
          }
          if (this.this$0.g >= this.this$0.h)
          {
            if ((this.this$0.e == null) || (this.this$0.f == null)) {
              break label1044;
            }
            j = this.this$0.e.read(this.this$0.f, 0, this.this$0.h);
            this.this$0.a(j);
            this.this$0.a(this.this$0.f, j);
            continue;
          }
          if ((this.this$0.e == null) || (this.this$0.f == null)) {
            break label1049;
          }
          j = this.this$0.e.read(this.this$0.f, 0, this.this$0.g);
          this.this$0.a(j);
          if (j <= 0) {
            continue;
          }
          int k = i + j;
          if (k > this.this$0.h)
          {
            System.arraycopy(this.this$0.f, 0, this.this$0.i, i, this.this$0.h - i);
            this.this$0.a(this.this$0.i, this.this$0.h);
            k = this.this$0.h - i;
            i = j - k;
            System.arraycopy(this.this$0.f, k, this.this$0.i, 0, i);
            continue;
          }
          System.arraycopy(this.this$0.f, 0, this.this$0.i, i, j);
          i = k;
          continue;
        }
        this.this$0.l.c();
        if (this.this$0.m != null) {
          this.this$0.m.c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, new Object[] { "audio, run out, isRecording:", Boolean.valueOf(this.a), " mIsVoiceRecognizerStat:", Boolean.valueOf(AudioCapture.j(this.this$0)), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.k(this.this$0)) });
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("isRecording");
        ((StringBuilder)???).append(this.a);
        ((StringBuilder)???).append(" listener");
        ((StringBuilder)???).append(AudioCapture.f(this.this$0));
        AEQLog.a("AudioCapture", ((StringBuilder)???).toString());
        if ((!this.a) && (AudioCapture.f(this.this$0) != null)) {
          AudioCapture.f(this.this$0).onAudioCaptured(this.this$0.l.d());
        }
        AudioCapture.m(this.this$0);
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("AudioCapture", 1, "audio, run exception: ", localException1);
        this.this$0.l.c();
        return;
      }
      label1029:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "RecordRunnable exit, error param");
      }
      return;
      label1044:
      int j = 0;
      continue;
      label1049:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture.RecordRunnable
 * JD-Core Version:    0.7.0.1
 */
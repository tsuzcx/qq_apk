package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$RecordRunnable
  implements Runnable
{
  Object jdField_a_of_type_JavaLangObject = new Object();
  boolean jdField_a_of_type_Boolean;
  boolean b;
  boolean c = false;
  boolean d;
  
  public AudioCapture$RecordRunnable(AudioCapture paramAudioCapture)
  {
    this.d = (AudioCapture.b(paramAudioCapture) ^ true);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable run");
    }
    this.b = false;
    AudioCapture.a(this.this$0);
    Process.setThreadPriority(-19);
    while ((!this.c) || (AudioCapture.c(this.this$0)) || (AudioCapture.d(this.this$0)))
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
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (this.d) {
              this.jdField_a_of_type_JavaLangObject.wait();
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
        if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
          break label1071;
        }
        i = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);
        if (AudioCapture.a(this.this$0) != null) {
          AudioCapture.a(this.this$0).onAudioFrames(this.this$0.jdField_a_of_type_ArrayOfByte, 0, i);
        }
        if ((this.c) && ((AudioCapture.c(this.this$0)) || (AudioCapture.d(this.this$0)))) {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, new Object[] { "RecordRunnable mIsVoiceRecognizerStat: ", Boolean.valueOf(AudioCapture.c(this.this$0)), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.d(this.this$0)), "start record" });
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable record run");
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = this.this$0;
    ((AudioCapture)???).jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache = new AudioDataCache(AudioCapture.a((AudioCapture)???));
    this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache.a();
    int i = 0;
    label1071:
    label1086:
    label1091:
    label1096:
    for (;;)
    {
      try
      {
        if (((this.jdField_a_of_type_Boolean) || (AudioCapture.c(this.this$0)) || (AudioCapture.d(this.this$0))) && (!this.b))
        {
          if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.b == null)) {
            continue;
          }
          if (this.this$0.e >= this.this$0.f)
          {
            if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
              break label1086;
            }
            j = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.f);
            this.this$0.a(j);
            this.this$0.a(this.this$0.jdField_a_of_type_ArrayOfByte, j);
            continue;
          }
          if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
            break label1091;
          }
          j = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);
          this.this$0.a(j);
          if (j <= 0) {
            continue;
          }
          int k = i + j;
          if (k > this.this$0.f)
          {
            System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.b, i, this.this$0.f - i);
            k = this.this$0.a(this.this$0.b, this.this$0.f);
            int m = this.this$0.f - k;
            this.this$0.a(this.this$0.b, m);
            if (k > 0) {
              System.arraycopy(this.this$0.b, m, this.this$0.b, 0, k);
            }
            i = this.this$0.f - i;
            j -= i;
            System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, i, this.this$0.b, k, j);
            i = k + j;
            break label1096;
          }
          System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.b, i, j);
          i = k;
          break label1096;
        }
        if (AudioCapture.e(this.this$0))
        {
          j = this.this$0.a(this.this$0.b, i);
          this.this$0.a(this.this$0.b, i - j);
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache.b();
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, new Object[] { "audio, run out, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean), " mIsVoiceRecognizerStat:", Boolean.valueOf(AudioCapture.c(this.this$0)), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.d(this.this$0)) });
        }
        if ((!this.jdField_a_of_type_Boolean) && (AudioCapture.a(this.this$0) != null)) {
          AudioCapture.a(this.this$0).onAudioCaptured(this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache.c());
        }
        AudioCapture.a(this.this$0);
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("AudioCapture", 1, "audio, run exception: ", localException1);
        this.this$0.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache.b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "RecordRunnable exit, error param");
      }
      return;
      int j = 0;
      continue;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture.RecordRunnable
 * JD-Core Version:    0.7.0.1
 */
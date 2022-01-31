package com.tencent.mobileqq.richmedia.capture.audio;

import android.media.AudioRecord;
import android.os.Process;
import axjq;
import axjs;
import axrg;
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
    if (!AudioCapture.b(paramAudioCapture)) {
      bool = true;
    }
    this.d = bool;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable run");
    }
    this.b = false;
    AudioCapture.a(this.this$0);
    Process.setThreadPriority(-19);
    while ((!this.c) || (AudioCapture.c(this.this$0)))
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
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          try
          {
            if (this.d) {
              this.jdField_a_of_type_JavaLangObject.wait();
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AudioCapture", 2, "RecordRunnable resume, startrecord:" + this.c + " interrupt:" + this.b + " pause:" + this.d);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.e("AudioCapture", 1, "RecordRunnable wait exception:", localException2);
            }
          }
        }
      }
      else
      {
        if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
          break label529;
        }
        i = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);
        if (AudioCapture.a(this.this$0) != null) {
          AudioCapture.a(this.this$0).a(this.this$0.jdField_a_of_type_ArrayOfByte, 0, i);
        }
        if ((this.c) && (AudioCapture.c(this.this$0))) {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "RecordRunnable mIsVoiceRecognizerStat true, start record");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable record run");
    }
    this.jdField_a_of_type_Boolean = true;
    this.this$0.jdField_a_of_type_Axjs = new axjs(AudioCapture.a(this.this$0));
    this.this$0.jdField_a_of_type_Axjs.a();
    int i = 0;
    label529:
    label544:
    label960:
    label965:
    for (;;)
    {
      try
      {
        if (((!this.jdField_a_of_type_Boolean) && (!AudioCapture.c(this.this$0))) || (this.b)) {
          break label785;
        }
        if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.b == null)) {
          continue;
        }
        if (this.this$0.e < this.this$0.f) {
          break label544;
        }
        if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
          break label960;
        }
        j = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.f);
        this.this$0.a(j);
        this.this$0.a(this.this$0.jdField_a_of_type_ArrayOfByte, j);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException1)
      {
        QLog.e("AudioCapture", 1, "audio, run exception: ", localException1);
        this.this$0.jdField_a_of_type_Axjs.a();
        return;
      }
      QLog.d("AudioCapture", 2, "RecordRunnable exit, error param");
      return;
      if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.this$0.jdField_a_of_type_ArrayOfByte != null)) {}
      for (int j = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);; j = 0)
      {
        this.this$0.a(j);
        if (j <= 0) {
          break;
        }
        if (i + j > this.this$0.f)
        {
          System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.b, i, this.this$0.f - i);
          int k = this.this$0.a(this.this$0.b, this.this$0.f);
          int m = this.this$0.f - k;
          this.this$0.a(this.this$0.b, m);
          if (k > 0) {
            System.arraycopy(this.this$0.b, m, this.this$0.b, 0, k);
          }
          i = this.this$0.f - i;
          j -= i;
          System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, i, this.this$0.b, k, j);
          i = j + k;
          break label965;
        }
        System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.b, i, j);
        i = j + i;
        break label965;
        if (AudioCapture.d(this.this$0))
        {
          j = this.this$0.a(this.this$0.b, i);
          this.this$0.a(this.this$0.b, i - j);
        }
        this.this$0.jdField_a_of_type_Axjs.a();
        if (this.this$0.jdField_a_of_type_Axrg != null) {
          this.this$0.jdField_a_of_type_Axrg.c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, new Object[] { "audio, run out, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean), " mIsVoiceRecognizerStat:", Boolean.valueOf(AudioCapture.c(this.this$0)) });
        }
        if ((!this.jdField_a_of_type_Boolean) && (AudioCapture.a(this.this$0) != null)) {
          AudioCapture.a(this.this$0).b(this.this$0.jdField_a_of_type_Axjs.b());
        }
        AudioCapture.a(this.this$0);
        return;
      }
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.RecordRunnable
 * JD-Core Version:    0.7.0.1
 */
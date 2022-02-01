package com.tencent.mobileqq.shortvideo.mediadevice;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$RecordThread2
  extends Thread
{
  AudioCapture$RecordThread2(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    this.this$0.b();
    for (;;)
    {
      int i = 0;
      if (!this.this$0.jdField_a_of_type_Boolean) {
        break label684;
      }
      try
      {
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          this.this$0.jdField_a_of_type_JavaLangObject.wait();
          if (!this.this$0.jdField_a_of_type_Boolean) {
            break;
          }
          int j = 1;
          this.this$0.jdField_a_of_type_Long = System.currentTimeMillis();
          this.this$0.jdField_b_of_type_Long = System.currentTimeMillis();
          Process.setThreadPriority(-19);
          while (Lock.jdField_a_of_type_Boolean) {
            if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.this$0.jdField_a_of_type_ArrayOfByte != null) && (this.this$0.jdField_b_of_type_ArrayOfByte != null))
            {
              this.this$0.jdField_b_of_type_Long = System.currentTimeMillis();
              int k;
              if (this.this$0.e >= this.this$0.f)
              {
                if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.this$0.jdField_a_of_type_ArrayOfByte != null)) {
                  k = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.f);
                } else {
                  k = 0;
                }
                this.this$0.b(k);
                if (j == 0) {}
              }
              do
              {
                j = 0;
                break;
                ??? = this.this$0;
                ((AudioCapture)???).c(((AudioCapture)???).jdField_a_of_type_ArrayOfByte, k, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, true, 4);
                break;
                if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.this$0.jdField_a_of_type_ArrayOfByte != null)) {
                  k = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);
                } else {
                  k = 0;
                }
                this.this$0.b(k);
                if (k <= 0) {
                  break;
                }
              } while (j != 0);
              int m = i + k;
              if (m > this.this$0.f)
              {
                System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.jdField_b_of_type_ArrayOfByte, i, this.this$0.f - i);
                ??? = this.this$0;
                m = AudioCapture.a((AudioCapture)???, ((AudioCapture)???).jdField_b_of_type_ArrayOfByte, this.this$0.f);
                int n = this.this$0.f - m;
                ??? = this.this$0;
                ((AudioCapture)???).c(((AudioCapture)???).jdField_b_of_type_ArrayOfByte, n, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, true, 4);
                if (m > 0) {
                  System.arraycopy(this.this$0.jdField_b_of_type_ArrayOfByte, n, this.this$0.jdField_b_of_type_ArrayOfByte, 0, m);
                }
                i = this.this$0.f - i;
                k -= i;
                System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, i, this.this$0.jdField_b_of_type_ArrayOfByte, m, k);
                i = m + k;
              }
              else
              {
                System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.jdField_b_of_type_ArrayOfByte, i, k);
                i = m;
              }
            }
          }
          ??? = this.this$0;
          j = AudioCapture.a((AudioCapture)???, ((AudioCapture)???).jdField_b_of_type_ArrayOfByte, i);
          i -= j;
          ??? = this.this$0;
          ((AudioCapture)???).c(((AudioCapture)???).jdField_b_of_type_ArrayOfByte, i, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, false, 9);
          if (j > 0)
          {
            System.arraycopy(this.this$0.jdField_b_of_type_ArrayOfByte, i, this.this$0.jdField_b_of_type_ArrayOfByte, 0, j);
            i = j;
            break;
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("AudioNoiseSuppression[QQ]: leftLen=");
            ((StringBuilder)???).append(j);
            QLog.d("AudioCapture", 2, ((StringBuilder)???).toString());
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    throw localInterruptedException;
    label684:
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.RecordThread2
 * JD-Core Version:    0.7.0.1
 */
package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.media.AudioRecord;
import android.os.Process;
import bqhu;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$RecordThread2
  extends Thread
{
  AudioCapture$RecordThread2(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    this.this$0.b();
    int i = 0;
    int j;
    label86:
    int m;
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      for (;;)
      {
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          try
          {
            this.this$0.jdField_a_of_type_JavaLangObject.wait();
            if (!this.this$0.jdField_a_of_type_Boolean) {
              break;
            }
            this.this$0.jdField_a_of_type_Long = System.currentTimeMillis();
            this.this$0.jdField_b_of_type_Long = System.currentTimeMillis();
            Process.setThreadPriority(-19);
            k = 1;
            j = i;
            i = k;
            if (!bqhu.jdField_a_of_type_Boolean) {
              break label542;
            }
            if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null)) {
              continue;
            }
            this.this$0.jdField_b_of_type_Long = System.currentTimeMillis();
            if (this.this$0.e < this.this$0.f) {
              break label273;
            }
            m = 0;
            k = m;
            if (this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null)
            {
              k = m;
              if (this.this$0.jdField_a_of_type_ArrayOfByte != null) {
                k = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.f);
              }
            }
            this.this$0.b(k);
            if (i != 0)
            {
              i = 0;
              continue;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        this.this$0.c(this.this$0.jdField_a_of_type_ArrayOfByte, k, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, true, 4);
      }
      label273:
      if ((this.this$0.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.this$0.jdField_a_of_type_ArrayOfByte == null)) {
        break label662;
      }
    }
    label662:
    for (int k = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.e);; k = 0)
    {
      this.this$0.b(k);
      if (k <= 0) {
        break label86;
      }
      if (i != 0)
      {
        i = 0;
        break label86;
      }
      if (j + k > this.this$0.f)
      {
        System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.jdField_b_of_type_ArrayOfByte, j, this.this$0.f - j);
        m = AudioCapture.a(this.this$0, this.this$0.jdField_b_of_type_ArrayOfByte, this.this$0.f);
        int n = this.this$0.f - m;
        this.this$0.c(this.this$0.jdField_b_of_type_ArrayOfByte, n, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, true, 4);
        if (m > 0) {
          System.arraycopy(this.this$0.jdField_b_of_type_ArrayOfByte, n, this.this$0.jdField_b_of_type_ArrayOfByte, 0, m);
        }
        j = this.this$0.f - j;
        k -= j;
        System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, j, this.this$0.jdField_b_of_type_ArrayOfByte, m, k);
        j = m + k;
      }
      for (;;)
      {
        break;
        System.arraycopy(this.this$0.jdField_a_of_type_ArrayOfByte, 0, this.this$0.jdField_b_of_type_ArrayOfByte, j, k);
        j += k;
      }
      label542:
      i = AudioCapture.a(this.this$0, this.this$0.jdField_b_of_type_ArrayOfByte, j);
      j -= i;
      this.this$0.c(this.this$0.jdField_b_of_type_ArrayOfByte, j, System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long, false, 9);
      if (i > 0)
      {
        System.arraycopy(this.this$0.jdField_b_of_type_ArrayOfByte, j, this.this$0.jdField_b_of_type_ArrayOfByte, 0, i);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: leftLen=" + i);
      }
      i = 0;
      break;
      this.this$0.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.RecordThread2
 * JD-Core Version:    0.7.0.1
 */
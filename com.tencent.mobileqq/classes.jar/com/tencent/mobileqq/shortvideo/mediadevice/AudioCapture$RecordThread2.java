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
    this.this$0.c();
    for (;;)
    {
      int i = 0;
      if (!this.this$0.o) {
        break label684;
      }
      try
      {
        synchronized (this.this$0.n)
        {
          this.this$0.n.wait();
          if (!this.this$0.o) {
            break;
          }
          int j = 1;
          this.this$0.w = System.currentTimeMillis();
          this.this$0.x = System.currentTimeMillis();
          Process.setThreadPriority(-19);
          while (Lock.b) {
            if ((this.this$0.e != null) && (this.this$0.h != null) && (this.this$0.k != null))
            {
              this.this$0.x = System.currentTimeMillis();
              int k;
              if (this.this$0.i >= this.this$0.j)
              {
                if ((this.this$0.e != null) && (this.this$0.h != null)) {
                  k = this.this$0.e.read(this.this$0.h, 0, this.this$0.j);
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
                ((AudioCapture)???).c(((AudioCapture)???).h, k, System.currentTimeMillis() - this.this$0.w, true, 4);
                break;
                if ((this.this$0.e != null) && (this.this$0.h != null)) {
                  k = this.this$0.e.read(this.this$0.h, 0, this.this$0.i);
                } else {
                  k = 0;
                }
                this.this$0.b(k);
                if (k <= 0) {
                  break;
                }
              } while (j != 0);
              int m = i + k;
              if (m > this.this$0.j)
              {
                System.arraycopy(this.this$0.h, 0, this.this$0.k, i, this.this$0.j - i);
                ??? = this.this$0;
                m = AudioCapture.a((AudioCapture)???, ((AudioCapture)???).k, this.this$0.j);
                int n = this.this$0.j - m;
                ??? = this.this$0;
                ((AudioCapture)???).c(((AudioCapture)???).k, n, System.currentTimeMillis() - this.this$0.w, true, 4);
                if (m > 0) {
                  System.arraycopy(this.this$0.k, n, this.this$0.k, 0, m);
                }
                i = this.this$0.j - i;
                k -= i;
                System.arraycopy(this.this$0.h, i, this.this$0.k, m, k);
                i = m + k;
              }
              else
              {
                System.arraycopy(this.this$0.h, 0, this.this$0.k, i, k);
                i = m;
              }
            }
          }
          ??? = this.this$0;
          j = AudioCapture.a((AudioCapture)???, ((AudioCapture)???).k, i);
          i -= j;
          ??? = this.this$0;
          ((AudioCapture)???).c(((AudioCapture)???).k, i, System.currentTimeMillis() - this.this$0.w, false, 9);
          if (j > 0)
          {
            System.arraycopy(this.this$0.k, i, this.this$0.k, 0, j);
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
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.RecordThread2
 * JD-Core Version:    0.7.0.1
 */
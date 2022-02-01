package com.tencent.mobileqq.qassistant.audio;

import android.media.AudioRecord;
import baja;
import bakl;
import balq;
import java.util.concurrent.atomic.AtomicLong;

public class AudioNewRecorder$2
  implements Runnable
{
  public AudioNewRecorder$2(baja parambaja) {}
  
  public void run()
  {
    int i = 0;
    if ((baja.a(this.this$0) == null) || (baja.a(this.this$0).getState() != 1))
    {
      bakl.a("AudioNewRecorder", "session, doRecord, stateError");
      return;
    }
    for (;;)
    {
      try
      {
        if (baja.a(this.this$0) != null) {
          baja.a(this.this$0).b(System.currentTimeMillis());
        }
        baja.a(this.this$0).startRecording();
        if (baja.a(this.this$0) == null) {
          break label216;
        }
        j = baja.a(this.this$0).a();
        i = baja.a(this.this$0).b();
        baja.a(this.this$0, j, i);
      }
      catch (InterruptedException localInterruptedException)
      {
        baja.a(this.this$0).a(localInterruptedException.getMessage());
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
      if (baja.a(this.this$0) == null) {
        break;
      }
      baja.a(this.this$0).a(this.this$0.a.get());
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
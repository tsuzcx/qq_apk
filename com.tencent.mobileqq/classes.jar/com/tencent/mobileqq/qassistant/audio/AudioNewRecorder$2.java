package com.tencent.mobileqq.qassistant.audio;

import android.media.AudioRecord;
import azdl;
import azeu;
import azfz;
import java.util.concurrent.atomic.AtomicLong;

public class AudioNewRecorder$2
  implements Runnable
{
  public AudioNewRecorder$2(azdl paramazdl) {}
  
  public void run()
  {
    int i = 0;
    if ((azdl.a(this.this$0) == null) || (azdl.a(this.this$0).getState() != 1))
    {
      azeu.a("AudioNewRecorder", "session, doRecord, stateError");
      return;
    }
    azeu.a("AudioNewRecorder", "start consumer, start record:" + azdl.a(this.this$0).getState());
    for (;;)
    {
      try
      {
        if (azdl.a(this.this$0) != null) {
          azdl.a(this.this$0).b(System.currentTimeMillis());
        }
        azdl.a(this.this$0).startRecording();
        if (azdl.a(this.this$0) == null) {
          break label249;
        }
        j = azdl.a(this.this$0).a();
        i = azdl.a(this.this$0).b();
        azdl.a(this.this$0, j, i);
      }
      catch (InterruptedException localInterruptedException)
      {
        azdl.a(this.this$0).a(localInterruptedException.getMessage());
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
      if (azdl.a(this.this$0) == null) {
        break;
      }
      azdl.a(this.this$0).a(this.this$0.a.get());
      return;
      label249:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.2
 * JD-Core Version:    0.7.0.1
 */
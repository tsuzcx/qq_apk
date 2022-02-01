package com.tencent.sharp.jni;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class TraeAudioManager$EarphoneSwitchThread
  extends TraeAudioManager.SwitchThread
{
  TraeAudioManager$EarphoneSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_EARPHONE";
  }
  
  public void a()
  {
    this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), false);
    c();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if ((TraeAudioManager.a(this.this$0)) && (a())) {
          this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), false);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label84:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label84;
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (!this.c) {
      return true;
    }
    SessionInfo localSessionInfo = VideoController.a().a();
    if ((localSessionInfo != null) && ((localSessionInfo.d == 1) || (localSessionInfo.d == 2))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!VideoController.a().b())) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.EarphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */
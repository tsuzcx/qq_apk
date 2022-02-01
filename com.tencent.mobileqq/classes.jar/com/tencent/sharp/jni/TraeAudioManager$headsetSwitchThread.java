package com.tencent.sharp.jni;

import android.media.AudioManager;
import lbj;

class TraeAudioManager$headsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$headsetSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void a()
  {
    this.this$0.a(this.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_AndroidContentContext, false);
    this.this$0.jdField_a_of_type_AndroidMediaAudioManager.setWiredHeadsetOn(true);
    e();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (TraeAudioManager.a(this.this$0)) {
          this.this$0.a(this.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_AndroidContentContext, false);
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
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            lbj.e(this.jdField_a_of_type_JavaLangString, localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.headsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */
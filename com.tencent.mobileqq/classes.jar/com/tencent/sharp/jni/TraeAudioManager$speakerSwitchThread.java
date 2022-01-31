package com.tencent.sharp.jni;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lga;

class TraeAudioManager$speakerSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$speakerSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void a()
  {
    int i = 0;
    this.this$0.a(this.jdField_a_of_type_Long, this.this$0.a, true);
    e();
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (TraeAudioManager.a(this.this$0) == true) {
          break label126;
        }
        if ((this.b) && (i > 4))
        {
          lga locallga = VideoController.a().a();
          if (!locallga.N) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 1, "_run, 不需要打开扬声器, sessionInfo[" + locallga + "]");
          }
        }
      }
      else
      {
        return;
      }
      this.this$0.a(this.jdField_a_of_type_Long, this.this$0.a, true);
      label126:
      long l;
      if (i < 5) {
        l = 1000L;
      }
      try
      {
        for (;;)
        {
          Thread.sleep(l);
          label139:
          i += 1;
          break;
          l = 4000L;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label139;
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.speakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */